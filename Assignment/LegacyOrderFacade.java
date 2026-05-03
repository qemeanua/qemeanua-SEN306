public class LegacyOrderFacade {
    private LegacyOrderProcessor oldProcessor = new LegacyOrderProcessor();

    public void placeOrder(String email, String itemCode, double price, String address) {
        if (email == null || email.isEmpty()) {
            System.out.println("Need a valid email!");
            return;
        }
        if (itemCode == null || itemCode.isEmpty()) {
            System.out.println("Need a product code!");
            return;
        }
        if (price <= 0) {
            System.out.println("Price can't be $0 or negative!");
            return;
        }
        if (address == null || address.isEmpty()) {
            System.out.println("Need a shipping address!");
            return;
        }

        System.out.println("\n--- Using legacy system for order ---");
        oldProcessor.processOrder(email, itemCode, price, address);
    }

    public void quickOrder(String email, String itemCode, double price) {
        placeOrder(email, itemCode, price, "123 Default St, Your City");
    }
}