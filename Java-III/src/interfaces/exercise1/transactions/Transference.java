package interfaces.exercise1.transactions;

import java.math.BigDecimal;

public class Transference implements Transaction {
    private String senderAccount;
    private String receiverAccount;
    private BigDecimal quantity;
    private BigDecimal accountBalance;

    public Transference(String senderAccount, BigDecimal accountBalance, String receiverAccount, BigDecimal quantity) {
        this.accountBalance = accountBalance;
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
        this.quantity = quantity;
    }

    @Override
    public void execute() {
        System.out.println("Executando transferencia...");
        transactionOk();
    }

    @Override
    public void transactionOk() {
        System.out.println("Transferencia de R$ " + quantity + " realizado com sucesso para a conta " + receiverAccount);
    }

    @Override
    public void transactionNotOk() {
        System.out.println("Transferencia mal sucesida! Contate seu gerente!");
    }
}
