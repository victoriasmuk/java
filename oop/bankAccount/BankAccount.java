public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private static int totalAccounts;
    private static double totalBalance;

    public BankAccount(){
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        totalAccounts++;
        totalBalance += (this.checkingBalance + this.savingsBalance);
    }
    public double getCheckingBalance(){
        return this.checkingBalance;
    }
    public double getSavingsBalance(){
        return this.savingsBalance;
    }
    public double getTotalBalance(){
        return this.checkingBalance + this.savingsBalance;
    }
    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }
    public void setSavingsBalance(double savingsBalance){
        this.savingsBalance = savingsBalance;
    }
    public String depositMoney(String accountType, double depositAmount) {
        if (accountType == "checking") {
            this.checkingBalance += depositAmount;
            totalBalance += depositAmount;
            return "You have made a deposit of $" + depositAmount + " into your checking account.";
        }
        else if (accountType == "savings") {
            this.savingsBalance += depositAmount;
            totalBalance += depositAmount;
            return "You have made a deposit of $" + depositAmount + " into your savings account.";
        }
        else {
            return "Please select either a savings or checking account to make a deposit.";
        }
    }
    public String withdrawMoney(String accountType, double withdrawAmount) {
        if (accountType == "checking") {
            if (withdrawAmount <= this.checkingBalance) {
                this.checkingBalance -= withdrawAmount;
                totalBalance -= withdrawAmount;
                return "You have made a withdraw of $" + withdrawAmount + " from your checking account";
            }
            else {
                return "Your checking account does not have a sufficient balance to make this withdraw.";
            }
        }
        else if (accountType == "savings") {
            if (withdrawAmount <= this.savingsBalance) {
                this.savingsBalance -= withdrawAmount;
                totalBalance -= withdrawAmount;
                return "You have made a withdraw of $" + withdrawAmount + " from your savings account";
            }
            else {
                return "Your savings account does not have a sufficient balance to make this withdraw.";
            }
        }
        else {
            return "Please select either a savings or checking account to make a withdraw.";
        }
    }
    public double getTotalAccounts(){
        return this.totalAccounts;
    }

}