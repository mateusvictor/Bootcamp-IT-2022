package interfaces.exercise1.clients;

import interfaces.exercise1.transactions.Deposit;
import interfaces.exercise1.transactions.Transference;

import java.math.BigDecimal;

public class Executive extends Client {

    public Executive(String accountNumber, String accountOwnerName, BigDecimal accountBalance) {
        super(accountNumber, accountOwnerName, accountBalance);
    }

    public void performDeposit(String accountReceiver, BigDecimal quantity) {
        Deposit deposit = new Deposit(getAccountNumber(), getAccountBalance(), accountReceiver, quantity);
        deposit.execute();
    }

    public void performTransference(String accountReceiver, BigDecimal quantity) {
        Transference transference = new Transference(getAccountNumber(), getAccountBalance(), accountReceiver, quantity);
        transference.execute();
    }
}
