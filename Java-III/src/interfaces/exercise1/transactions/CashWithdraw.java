package interfaces.exercise1.transactions;

import java.math.BigDecimal;

public class CashWithdraw implements Transaction {
    private BigDecimal quantity;
    private String accountNumber;
    private BigDecimal accountBalance;

    public CashWithdraw(String accountNumber, BigDecimal accountBalance, BigDecimal quantity) {
        this.accountBalance = accountBalance;
        this.quantity = quantity;
        this.accountNumber = accountNumber;
    }

    @Override
    public void execute() {
        System.out.println("Retirando dinheiro...");
        if (accountBalance.compareTo(quantity) > -1)
            transactionOk();
        else
            transactionNotOk();
    }

    @Override
    public void transactionOk() {
        System.out.println("Saque da conta " + accountNumber + " de R$ " + quantity + " finalizado com sucesso!");
    }

    @Override
    public void transactionNotOk() {
        System.out.println("Erro! Saldo insuficiente!");
    }


}
