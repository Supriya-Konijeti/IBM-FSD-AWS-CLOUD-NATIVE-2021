package comm.example;

public class CurrentAccount extends Account{
    private double overDraftLimit;

    public CurrentAccount() {
        super();
    }

    public CurrentAccount(int accountNumber, String accountName, double overDraftLimit) {
        super(accountNumber, accountName);
        this.overDraftLimit = overDraftLimit;
    }

    @Override
    public String toString() {
        return super.toString()+"CurrentAccount{" +
                "overDraftLimit=" + overDraftLimit +
                '}';
    }

}
