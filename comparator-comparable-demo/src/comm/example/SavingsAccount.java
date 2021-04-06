package comm.example;

public class SavingsAccount extends Account {

    private int balance;

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(int accountNumber, String accountName, int balance) {
        super(accountNumber, accountName);
        this.balance = balance;
    }

    @Override
    public String toString() {
        return super.toString() + "SavingsAccount{" +
                "balance=" + balance +
                '}';
    }
}
