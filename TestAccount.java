public class TestAccount {

    public static void main(String[] args) {
        System.out.println("=== Activity 2: Test Account Suite ===");

        Account account = new Account("ACC1001", "Rajesh Sharma", 28, 5000.0, "SAVINGS", "ACTIVE");

        printResult("Test 1 (Initial Balance 5000.0)", account.getBalance() == 5000.0);

        boolean depositResult = account.deposit(2000.0);
        printResult("Test 2 (Deposit 2000.0 -> Balance 7000.0)",
                depositResult && account.getBalance() == 7000.0);

        boolean negativeDepositResult = account.deposit(-500.0);
        printResult("Test 3 (Negative Deposit -> Rejected)",
                !negativeDepositResult && account.getBalance() == 7000.0);

        boolean withdrawResult = account.withdraw(3000.0);
        printResult("Test 4 (Withdraw 3000.0 -> Balance 4000.0)",
                withdrawResult && account.getBalance() == 4000.0);

        boolean exceedingWithdrawResult = account.withdraw(10000.0);
        printResult("Test 5 (Exceeding Withdrawal -> Rejected)",
                !exceedingWithdrawResult && account.getBalance() == 4000.0);

        boolean negativeWithdrawResult = account.withdraw(-100.0);
        printResult("Test 6 (Negative Withdrawal -> Rejected)",
                !negativeWithdrawResult && account.getBalance() == 4000.0);

        System.out.println("All Account tests completed successfully!");
    }

    private static void printResult(String testName, boolean passed) {
        System.out.println(testName + ": " + (passed ? "[PASS]" : "[FAIL]"));
    }

    private static class Account {

        private String accountNumber;
        private String name;
        private int age;
        private double balance;
        private String accountType;
        private String status;

        public Account(String accountNumber, String name, int age, double balance, String accountType, String status) {
            this.accountNumber = accountNumber;
            this.name = name;
            this.age = age;
            this.balance = balance;
            this.accountType = accountType;
            this.status = status;
        }

        public boolean deposit(double amount) {
            if (amount > 0) {
                this.balance += amount;
                return true;
            }

            return false;
        }

        public boolean withdraw(double amount) {
            if (amount > 0 && amount <= this.balance) {
                this.balance -= amount;
                return true;
            }

            return false;
        }

        public double getBalance() {
            return balance;
        }
    }
}
