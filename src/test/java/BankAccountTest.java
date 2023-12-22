package test.java;

import main.java.BankAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    @Test
    void testDepositIntoAccount() {
        BankAccount account = new BankAccount();
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance(), 0.01);
        assertEquals("Deposited: $100.0", account.getAccountHistory().trim());
    }

    @Test
    void testWithdrawFromAccountWithSufficientFunds() {
        BankAccount account = new BankAccount();
        account.deposit(200.0);
        account.withdraw(50.0);
        assertEquals(150.0, account.getBalance(), 0.01);
        assertEquals("Deposited: $200.0\nWithdrew: $50.0", account.getAccountHistory().trim());
    }

    @Test
    void testWithdrawFromAccountExceedingBalance() {
        BankAccount account = new BankAccount();
        account.deposit(50.0);
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(100.0);
        });
    }

    @Test
    void testDepositNegativeAmount() {
        BankAccount account = new BankAccount();
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-50.0);
        });
    }

    @Test
    void testWithdrawNegativeAmount() {
        BankAccount account = new BankAccount();
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-30.0);
        });
    }
}