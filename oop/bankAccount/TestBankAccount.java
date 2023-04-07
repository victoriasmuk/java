public class TestBankAccount {
    public static void main (String[] args) {
        BankAccount Victoria = new BankAccount();

        System.out.println("Total Balance: $" + Victoria.getTotalBalance());
        System.out.println("Savings Balance $" + Victoria.getSavingsBalance());
        System.out.println("Checking Balance $" + Victoria.getCheckingBalance());

        System.out.println(Victoria.depositMoney("checking", 200));
        System.out.println(Victoria.depositMoney("savings", 500));
        System.out.println("Total Balance: $" + Victoria.getTotalBalance());
        System.out.println("Savings Balance $" + Victoria.getSavingsBalance());
        System.out.println("Checking Balance $" + Victoria.getCheckingBalance());

        System.out.println(Victoria.withdrawMoney("checking", 50));
        System.out.println(Victoria.withdrawMoney("savings", 100));
        System.out.println("Total Balance: $" + Victoria.getTotalBalance());
        System.out.println("Savings Balance $" + Victoria.getSavingsBalance());
        System.out.println("Checking Balance $" + Victoria.getCheckingBalance());

        System.out.println("You have " + Victoria.getTotalAccounts() + " account(s) open.");

    }
}