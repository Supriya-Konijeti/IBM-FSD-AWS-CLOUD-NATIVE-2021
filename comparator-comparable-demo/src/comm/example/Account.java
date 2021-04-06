package comm.example;

public class Account {
    private int accountNumber;
    private String accountName;

    public Account() {
    }

    public Account(int accountNumber, String accountName) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", accountName='" + accountName + '\'' +
                '}';
    }

    public String getAccountName() {
        return accountName;
    }
}
