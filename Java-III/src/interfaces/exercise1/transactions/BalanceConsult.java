package interfaces.exercise1.transactions;

import java.math.BigDecimal;

public class BalanceConsult implements Transaction {
    private String accountNumber;
    private BigDecimal accountBalance;

    public BalanceConsult(String accountNumber, BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
        this.accountNumber = accountNumber;
    }

    @Override
    public void execute() {
        System.out.println("Consultando saldo...");
        System.out.println("Saldo na conta " + accountNumber + ": R$ " + accountBalance);
        transactionOk();

    }

    @Override
    public void transactionOk() {
        System.out.println("Consulta de saldo finalizada com sucesso.");
    }

    @Override
    public void transactionNotOk() {
        System.out.println("Consulta mal sucedida! Contate seu gerente!");
    }

}
