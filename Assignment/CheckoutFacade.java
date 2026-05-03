class Inventory {
    boolean checkStock(String productId) { return true; }
    void reserve(String productId) { System.out.println("Reserved " + productId); }
    void release(String productId) { System.out.println("Released " + productId); }
}

class Payment {
    boolean charge(String userid, double amount) { return true; }
    void refund(String userid, double amount) { System.out.println("Refunded $" + amount); }
}

class Shipping {
    String createLabel(String address) { return "TRK" + System.currentTimeMillis(); }
    void schedulePickup(String label) { System.out.println("Pickup scheduled for " + label); }
    boolean isAvailable() { return true; }
}

class Email {
    void send(String to, String subject, String body) { 
        System.out.println("Sent email to " + to);
        System.out.println("   Subject: " + subject);
    }
}

class TaxCalculator {
    double calcTax(String userId, double price) {
        if (userId != null && userId.endsWith("_CA")) {
            return price * 0.08;
        }
        return 0.0;
    }
}

class Logger {
    void log(String message) {
        System.out.println(" [" + new java.util.Date() + "] " + message);
    }
}

public class CheckoutFacade {
    private Inventory stock = new Inventory();
    private Payment pay = new Payment();
    private Shipping ship = new Shipping();
    private Email email = new Email();
    private TaxCalculator tax = new TaxCalculator();
    private Logger logger = new Logger();

    public OrderResult checkout(String userId, String productId, double price, String address) {
        logger.log(" " + userId + " trying to buy " + productId + " for $" + price);

        double taxAmount = tax.calcTax(userId, price);
        double total = price + taxAmount;
        
        if (taxAmount > 0) {
            System.out.println("   Tax: $" + taxAmount + " (total: $" + total + ")");
        }

        if (!stock.checkStock(productId)) {
            String errorMsg = "Out of stock! No " + productId + " available";
            logger.log("FAILED - " + errorMsg);
            return new OrderResult(false, null, errorMsg);
        }

        if (!pay.charge(userId, total)) {
            String errorMsg = "Payment didn't go through for " + userId;
            logger.log("FAILED - " + errorMsg);
            return new OrderResult(false, null, errorMsg);
        }
        System.out.println("Payment successful: $" + total);

        stock.reserve(productId);

        if (!ship.isAvailable()) {
            pay.refund(userId, total);
            stock.release(productId);
            String errorMsg = "Shipping service is down, sorry!";
            logger.log("FAILED - " + errorMsg);
            return new OrderResult(false, null, errorMsg);
        }

        String trackingNum = ship.createLabel(address);
        ship.schedulePickup(trackingNum);

        String emailContent = "Yay! Your order is on its way!\n"
                            + "Product: " + productId + "\n"
                            + "Price: $" + price + "\n"
                            + "Tax: $" + taxAmount + "\n"
                            + "Total paid: $" + total + "\n"
                            + "Track your package: " + trackingNum;
        email.send(userId, "Your order is confirmed!", emailContent);

        String successMsg = "✅ Checkout worked! Tracking: " + trackingNum;
        logger.log("SUCCESS - " + successMsg);
        return new OrderResult(true, trackingNum, successMsg);
    }
}