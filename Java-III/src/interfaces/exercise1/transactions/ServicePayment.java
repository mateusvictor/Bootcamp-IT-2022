package interfaces.exercise1.transactions;

import java.math.BigDecimal;

public class ServicePayment implements Transaction {
    private String serviceNumber;
    private String accountNumber;
    private BigDecimal accountBalance;

    public ServicePayment(String accountNumber, BigDecimal accountBalance, String serviceNumber) {
        this.accountBalance = accountBalance;
        this.serviceNumber = serviceNumber;
        this.accountNumber = accountNumber;
    }

    @Override
    public void execute() {
        System.out.println("Realizando pagamento..");
        transactionOk();
    }

    @Override
    public void transactionOk() {
        System.out.println("Servico " + serviceNumber + " pago com sucesso!");
    }

    @Override
    public void transactionNotOk() {
        System.out.println("Erro no pagamento do servico! Contate seu gerente!");
    }
}
