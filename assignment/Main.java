public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(101, "Ravi", 17, 200, "Savings");
        NotificationService notificationService = new NotificationService();
        DataBase dataBase = new DataBase();

        double depositAmount = 1000;
        if (account.deposit(depositAmount)) {
            notificationService.send("Your deposit of Rs. " + depositAmount
                    + " was successful. New balance: " + account.getBalance());
            dataBase.saveToDatabase(account);
        }

        double withdrawalAmount = 500;
        if (account.withdraw(withdrawalAmount)) {
            notificationService.send("Your withdrawal of Rs. " + withdrawalAmount
                    + " was successful. New balance: " + account.getBalance());
            dataBase.saveToDatabase(account);
        }

        account.withdraw(2000);

        System.out.println("Current balance: Rs. " + account.getBalance());
    }
}
