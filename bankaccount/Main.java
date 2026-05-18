package bankaccount;

public class Main {
    public static void main(String[] args) {
        OverdraftAccount myAccount = new OverdraftAccount();
        
        System.out.println("Start balance: N" + myAccount.getBalance());
        
        myAccount.withdraw(150);  // works 
        myAccount.withdraw(200);  // works 
        myAccount.withdraw(300);  // FAILED 
        myAccount.withdraw(-50);  // FAILED 
        
        System.out.println("End balance: N" + myAccount.getBalance());
    }
}