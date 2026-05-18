package bankaccount;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USER
 */
public class OverdraftAccount extends BankAccount {
    
    @Override
    public void withdraw(double amount){
        
        if (amount <= 0){
            System.out.println("Error: Cannot withdraw a negative amount!");
            System.out.println("Transaction logged: Attempted withdrawal of N" + amount);
            return;
        } //this checks if the amount is valid
        
        double newBalance = balance - amount; //direct access to the protected field
        
        //check limits
        if (newBalance < -500) {
            System.out.println("Transaction FAILED: Overdraft limit (-N500) exceeded!");
            System.out.println("Current balance: N" + balance);
            System.out.println("Maximum you can withdraw: N" + (balance + 500));
        } else {
            balance = newBalance;
            System.out.println("Transaction SUCCESSFUL: Withdrawal of N" + amount);
            System.out.println("New balance: N" + balance);
            
        }  
        
        System.out.println("-----");
    
    
 }
    
    }