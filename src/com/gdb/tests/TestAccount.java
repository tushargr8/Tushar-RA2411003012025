package com.gdb.tests;

import com.gdb.domain.Account;

public class TestAccount {

    public static void main(String[] args) {
        System.out.println("=== Activity 4: Enhanced Account Test Suite ===");

        boolean underageRejected = false;
        try {
            new Account("ACC1000", "Amit Kumar", 16, 5000.0,
                    "SAVINGS", "ACTIVE", "1234");
        } catch (IllegalArgumentException exception) {
            underageRejected = true;
        }
        printResult("Test 1 (Underage Customer Rejection)", underageRejected);

        Account account = new Account("ACC1001", "Rajesh Sharma", 28, 5000.0,
                "SAVINGS", "ACTIVE", "1234");

        boolean wrongPinWithdraw = account.withdraw(1000.0, "9999");
        printResult("Test 2 (Wrong PIN Rejection)",
                !wrongPinWithdraw && account.getBalance() == 5000.0);

        boolean correctPinWithdraw = account.withdraw(1000.0, "1234");
        printResult("Test 3 (Correct PIN Withdrawal)",
                correctPinWithdraw && account.getBalance() == 4000.0);

        boolean pinChanged = account.changePin("1234", "5678");
        boolean oldPinWithdraw = account.withdraw(500.0, "1234");
        boolean newPinWithdraw = account.withdraw(500.0, "5678");
        printResult("Test 4 (PIN Change & Old PIN Invalidation)",
                pinChanged && !oldPinWithdraw && newPinWithdraw && account.getBalance() == 3500.0);

        account.suspend();
        boolean suspendedWithdraw = account.withdraw(500.0, "5678");
        printResult("Test 5 (Suspended Account Block)",
                !suspendedWithdraw && account.getBalance() == 3500.0);

        account.activate();
        boolean reactivatedWithdraw = account.withdraw(500.0, "5678");
        printResult("Test 6 (Reactivation & Success)",
                reactivatedWithdraw && account.getBalance() == 3000.0);

        System.out.println("All Enhanced Account tests passed!");
    }

    private static void printResult(String testName, boolean passed) {
        System.out.println(testName + ": " + (passed ? "[PASS]" : "[FAIL]"));
    }
}
