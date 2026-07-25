public class Account {
    private String userName;
    private String cardNumber;
    private String pin;
    private double balance;
    public Account(String userName, String cardNumber, String pin, double balance){
        this.userName = userName;
        this.cardNumber=cardNumber;
        this.pin=pin;
        this.balance=balance;
        this.failedAttempts=0;
        this.locked=false;}  
    public String getUserName(){
        return userName;
    }  
    public String getCardNumber(){
        return cardNumber;
    }
    public String getPin(){
        return pin;
    }
    public double getBalance(){
        return balance;
    }
    private int failedAttempts;
    private boolean locked;
    public boolean isLocked(){
        return locked;
    }
    public void increaseFailedAttempts(){
        failedAttempts++;
        if(failedAttempts>=3){
            locked=true;
        }
    }
    public void resetFailedAttempts(){
        failedAttempts=0;
    }
    public void deposit(double amount){
        balance+=amount; //Amount to be deposit.It will be added to the current balance.
    }
    public void withdraw(double amount){
        if(amount>0 && amount<=balance){
            balance-=amount;
            System.out.println("Withdrawal successful.");
        }
        else{
            System.out.println("Invalid amount or insufficient balance for withdraw.");
        }   
    }
    }
