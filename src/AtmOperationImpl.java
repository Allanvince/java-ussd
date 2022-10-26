import java.util.HashMap;
import java.util.Map;

public class AtmOperationImpl implements AtmOperationInterf{
    Atm atm = new Atm();
    Map<Double, String> mini_state = new HashMap<>();
    @Override
    public void viewBalance() {
        System.out.println("Your balance is: "+ atm.getBalance());

    }

    @Override
    public void depositAmount(double depositAmount) {
        //Stores the information on the Hashmap
        mini_state.put(depositAmount, " was deposited");
        atm.setBalance(atm.getBalance() + depositAmount);
        viewBalance();
    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
        //Stores the information on the Hashmap
        mini_state.put(withdrawAmount, " was withdrawn");
        // checking if there are enough funds to be withdrawn
        if (atm.getBalance() >=withdrawAmount){
            atm.setBalance(atm.getBalance()- withdrawAmount);
            viewBalance();
        }
        else{
            System.out.print("Insufficient funds");
        }
    }

    @Override
    public void viewMini_statement() {
        for (Map.Entry<Double,String> mini:mini_state.entrySet()){
            //displays both the value and string message
            System.out.println(mini.getKey() + mini.getValue());
        }
    }
}
