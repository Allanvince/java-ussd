import java.util.Scanner;

public class MainAtm {
    Scanner sc = new Scanner(System.in);

    class Verification{
        int accountNumber = 122770;
        int accountPin = 1270;
        byte count = 1;
        public void log(){
            System.out.println("Welcome to Vince Bank :)\n1:Login");
            System.out.print("Enter choice: ");
            byte ch =sc.nextByte();

            if (ch == 1) {
                System.out.print("Enter account number: ");
                int accNum = sc.nextInt();
                System.out.print("Enter account pin: ");
                int pin =sc.nextInt();

                while (count>0) {
                    count -= 1;
                    if ((accountNumber == accNum) & (accountPin == pin)) {
                        System.out.println("Login successful :)");
                        break;
                    } else if ((accountNumber != accNum) & (accountPin == pin)) {
                        System.out.println("Incorrect account number,attempts left: " + count);
                        System.out.print("Enter account number again!!!: ");
                        accNum = sc.nextInt();
                        if (accountNumber == accNum) {
                            System.out.println("Correct match.\nLogin successful :)");
                        } else {
                            System.out.println("Sorry no more attempts.Contact the bank");
                            System.exit(0);
                        }
                    } else if ((accountNumber == accNum) & (accountPin != pin)) {
                        System.out.println("Incorrect pin,attempts left: " + count);
                        System.out.print("Enter your pin again: ");
                        pin = sc.nextInt();
                        if (accountPin == pin) {
                            System.out.println("Correct match\nLogin successful :)");
                        } else {
                            System.out.print("Sorry no more attempts.Contact the bank");
                            System.exit(0);
                        }
                    }
                    else {
                        System.out.println("Incorrect account details,attempts left: "+count);
                        System.out.print("Enter account number again: ");
                        accNum = sc.nextInt();
                        System.out.print("Enter account pin again: ");
                        pin = sc.nextInt();

                        if ((accountNumber==accNum)&(accountPin==pin)){
                            System.out.println("Login successful :)");
                            break;
                        }
                        else{
                            System.out.println("Sorry no more attempts.Please contact the bank");
                        }
                    }
                }

            }
            else{
                System.out.println("Invalid choice");
            }
        }
    }
    public static void main(String []args){
        Atm op = new Atm();
        AtmOperationInterf vin = new AtmOperationImpl();

        MainAtm obj = new MainAtm();
        //calling the verification class within the main class -> MainAtm
        MainAtm.Verification obj2 = obj.new Verification();
        obj2.log();


            Scanner in = new Scanner(System.in);
            final String password = "a1libranman";

                System.out.print("Enter your password: ");
                op.setPassword(in.nextLine());

                //final security measure of verifying user's password with just one attempt given
                if (password.equals(op.getPassword())){
                    while (true){
                        System.out.println("1:View account balance\n2:Deposit cash\n3:Withdraw cash\n4:View Mini_statement\n5:Exit");
                        System.out.print("Enter choice: ");
                        byte choice = in.nextByte();

                        if (choice==1){
                            vin.viewBalance();
                        }
                        else if (choice==2){
                            System.out.print("How much do you wish to deposit? ");
                            double deposit = in.nextDouble();
                            vin.depositAmount(deposit);
                        }
                        else if (choice==3){
                            System.out.print("How much do you wish to withdraw? ");
                            double withdraw = in.nextDouble();
                            vin.withdrawAmount(withdraw);
                        }
                        else if (choice==4){
                            System.out.println("This is your Mini_statement");
                            vin.viewMini_statement();
                        }
                        else if (choice==5){
                            System.out.println("Thank you for choosing Vince Bank. Collect your card ");
                            System.exit(0);
                        }
                        else{
                            System.out.print("Invalid choice");
                        }
                    }
                }
                else{
                    System.out.print("Wrong password. Contact the bank");
                    System.exit(0);
                }

        }

    }

