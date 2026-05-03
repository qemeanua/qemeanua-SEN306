public class Main {
    public static void main(String[] args) {
        System.out.println("===== TESTING CHECKOUT SYSTEM =====\n");

        CheckoutFacade checkout = new CheckoutFacade();

        System.out.println("--- TEST 1: Normal checkout ---");
        OrderResult result1 = checkout.checkout("alex@email.com", "Nike Shoes", 99.99, "123 Main St");
        System.out.println("Result: " + result1.getMessage() + "\n");

        System.out.println("--- TEST 2: CA user (tax test) ---");
        OrderResult result2 = checkout.checkout("sarah_CA@email.com", "iPhone Case", 29.99, "456 LA Blvd");
        System.out.println("Result: " + result2.getMessage() + "\n");

        System.out.println("===== TESTING LEGACY WRAPPER =====");
        LegacyOrderFacade legacyWrapper = new LegacyOrderFacade();
        legacyWrapper.placeOrder("bob@email.com", "OldGame123", 49.99, "789 Retro Ave");
        
        System.out.println("\n--- Quick order test ---");
        legacyWrapper.quickOrder("jane@email.com", "VintageRecord", 24.99);
    }
}