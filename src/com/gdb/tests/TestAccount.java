package com.gdb.tests;

import com.gdb.domain.Account;

public class TestAccount {

    public static void main(String[] args) {
        System.out.println("=== Activity 3: Enhanced Account Test ===");

        Account account = new Account("ACC1001", "Rajesh Sharma", 28, 5000.0,
                "SAVINGS", "ACTIVE", "1234");

        System.out.println("Initial Balance: Rs " + account.getBalance()
                + " | Status: " + account.getStatus());

        boolean correctPinWithdraw = account.withdraw(1000.0, "1234");
        System.out.println("Withdraw with correct PIN: " + getResultText(correctPinWithdraw)
                + " | Balance: Rs " + account.getBalance());

        boolean wrongPinWithdraw = account.withdraw(1000.0, "9999");
        System.out.println("Withdraw with wrong PIN: " + getResultText(wrongPinWithdraw)
                + " | Balance: Rs " + account.getBalance());

        account.suspend();
        System.out.println("Account Suspended.");

        boolean suspendedWithdraw = account.withdraw(1000.0, "1234");
        System.out.println("Withdraw on SUSPENDED account: " + getResultText(suspendedWithdraw)
                + " | Balance: Rs " + account.getBalance());

        account.activate();
        System.out.println("Account Re-Activated.");

        boolean pinChanged = account.changePin("1234", "5678");
        if (pinChanged) {
            System.out.println("PIN Changed Successfully.");
        } else {
            System.out.println("PIN Change Failed.");
        }

        boolean newPinWithdraw = account.withdraw(1000.0, "5678");
        System.out.println("Withdraw with new PIN: " + getResultText(newPinWithdraw)
                + " | Balance: Rs " + account.getBalance());
    }

    private static String getResultText(boolean result) {
        return result ? "SUCCESS" : "FAILED";
    }
}
