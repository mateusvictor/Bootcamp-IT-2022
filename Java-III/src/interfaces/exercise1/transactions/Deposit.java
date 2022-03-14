package interfaces.exercise1.transactions;

import java.math.BigDecimal;

public class Deposit implements Transaction {
    private String senderAccount;
    private String receiverAccount;
    private BigDecimal quantity;
    private BigDecimal accountBalance;

    public Deposit(String senderAccount, BigDecimal accountBalance, String receiverAccount, BigDecimal quantity) {
        this.accountBalance = accountBalance;
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
        this.quantity = quantity;
    }

    @Override
    public void execute() {
        System.out.println("Executando deposito...");
        transactionOk();
    }

    @Override
    public void transactionOk() {
        System.out.println("Deposito de R$ " + quantity + " realizado com sucesso para a conta " + receiverAccount);
    }

    @Override
    public void transactionNotOk() {
        System.out.println("Deposito mal sucesido! Contate seu gerente!");
    }
}
