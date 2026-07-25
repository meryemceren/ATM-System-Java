import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[]args){
       
        Scanner scanner=new Scanner(System.in);
        System.out.println("Welcome to the ATM System.");
        Account account1=new Account("Meryem","123456","8765",2000);
        Account account2=new Account("Ceren","654321","1234",6000);
        
        ArrayList<Account>accounts=new ArrayList<>();
        accounts.add(account1);
        accounts.add(account2);
        Account loggedInAccount=null; //No one has logged in ATM system yet.
        System.out.println("Card Number:");
        String cardNumber=scanner.nextLine();
        Account cardAccount=null;
        for(int i=0;i<accounts.size();i++){
            Account account=accounts.get(i);
            if(account.getCardNumber().equals(cardNumber)){
                cardAccount=account;
                break;
            }
        }
        if(cardAccount==null){
            System.out.println("This account could not be found.Invalid card number or pin.");
        }
        else{
        int attempt=0;
        while(attempt<3&&loggedInAccount==null){
            System.out.println("Pin:");
            String pin=scanner.nextLine();
           
                if(cardAccount.getPin().equals(pin)){
                   loggedInAccount=cardAccount;
                   System.out.println("Login successfully!");
                   System.out.println("Welcome to the ATM System "+ loggedInAccount.getUserName());
        }       
                else{
                    attempt++;
                    System.out.println("Wrong pin.");
                    if (attempt < 3) {
                    System.out.println("Remaining attempts: " + (3 - attempt));
        }
                    else {
                    System.out.println("Too many incorrect attempts.\nAccess denied.");
        } 
        }
        }
    }
        if(loggedInAccount!=null){
                     
        int option=0;
        while(option!=4){
            System.out.println("1)View Balance");
            System.out.println("2)Deposit Money");
            System.out.println("3)Withdraw Money");
            System.out.println("4)Exit");
            System.out.println("Your option: ");
            option=scanner.nextInt();
            
            if(option==1){
              System.out.println("Your balance: "+"$ "+loggedInAccount.getBalance());
            }
            if(option==2){
                System.out.println("Amount to be deposit: ");
                double amount=scanner.nextDouble();
                loggedInAccount.deposit(amount);
                System.out.println("Deposit successful.");
                System.out.println("New balance: "+"$ "+loggedInAccount.getBalance());
            }
            if(option==3){
               System.out.println("Amount to be draw: "); 
               double amount=scanner.nextDouble();
               loggedInAccount.withdraw(amount);
            }
            if(option==4){
                System.out.println("Thank you for using ATM System.\nGoodbye.");
            }}
         
    scanner.close();
        }}}
