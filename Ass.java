import java.util.Scanner;

public class Ass{

    Scanner stream = new Scanner(System.in);

    //main
    public static void main(String[] args){
        BIM(150,65);
        population();
        Palindrome(1234554321);
        Palindrome(1235565322);
        ATM atm = new ATM();
    }


    //BIM
    static void BIM(double weight,double height){
        double weight_Kg = weight * 0.45359237;
        double height_m = height * 0.0254;
        
        double bim = weight_Kg/(height_m*height_m);
        System.out.println("bim: " + bim);
        System.out.println("m: " + height_m);
        System.out.println("kg: " + weight_Kg);
        if(bim < 18.5){
            System.out.println("Underweight");
        }else if(18.5 <= bim && bim <25){
            System.out.println("Normal");
        }else if(25 <= bim && bim <30){
            System.out.println("Overweight");
        }else{
            System.out.println("Obese");
        } 
    }
    //Population
    static void population(){
        long current_population = 312032486;
        long year_seconds = 365*24*60*60;
        for(int i = 1; i<6;i++){
            
            current_population += (year_seconds / 7);
            current_population -= (year_seconds / 13);
            current_population -= (year_seconds / 45);

            System.out.println("Year "+ i +" population: " + current_population);
            
        } 
    }

    //palindrome
    static void Palindrome(int num){
        String num_str = Integer.toString(num);
        boolean palindrome = true;
        int num_length = num_str.length();  
        for(int i =0;i<(num_length/2);i++){
            if(num_str.charAt(i) == num_str.charAt(num_length-1-i)){
                palindrome = true;
            }else{
                palindrome = false;
                break;
            }
        }
        if(palindrome){
            System.out.println("Input "+num+" is palindrome");
        }else{
            System.out.println("Input "+num+" is not palindrome");
        }

    }


    //ATM
    public static class ATM {
        private static long balance = 5000;
        private static boolean exitB = false;
        private static Scanner stream = new Scanner(System.in);
    
        public ATM() {
            System.out.println("Welcome our dear User :)");
    
            while (!exitB) {
                System.out.println("Enter 1 for Withdraw\nEnter 2 for Deposit\nEnter 3 for Check Balance\nEnter 4 for EXIT\n=> ");
    
                int userInput = stream.nextInt();
    
                switch (userInput) {
                    case 1:
                        withdraw();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        checkBalance();
                        break;
                    case 4:
                        exit();
                        break;
                    default:
                        System.out.println("Wrong input\nPlease enter a valid choice (from 1 to 4): ");
                }
            }
        }
    
        private static boolean validateMoney(long num) {
            if (num <= 0) {
                System.out.println("Please enter a positive number!");
                return false;
            } else {
                return true;
            }
        }
    
        private static void withdraw() {
            System.out.print("How much do you want to withdraw: ");
            long amount = stream.nextLong();
            System.out.println("");
    
            if (validateMoney(amount)) {
                if(amount > balance){
                    System.out.println("Sorry! You don not have enough money");
                    System.out.println("Your balance is: " + balance);
                }else{
                    balance -= amount;
                    System.out.println("Success! YOUR BALANCE naw is: " + balance);
                }
            } else {
                System.out.println("Wrong number!!!!\nTry again");
            }
            System.out.println("\n");
        }
    
        private static void deposit() {
            System.out.print("How much do you want to deposit: ");
            long money = stream.nextLong();
            System.out.println("");
    
            if (validateMoney(money)) {
                balance += money;
                System.out.println("Success! YOUR BALANCE naw is: " + balance);
            } else {
                System.out.println("Wrong number!!!!\nTry again");
            }
            System.out.println("\n");
        }
    
        private static void checkBalance() {
            System.out.println("Your balance is: " + balance);
            System.out.println("\n");
        }
    
        private static void exit() {
            System.out.println("Exiting.....\nGoodbye :)");
            exitB = true;
            System.out.println("\n");
        }
    }
    
    
}