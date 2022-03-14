package interfaces.exercise1.clients;

import interfaces.exercise1.transactions.BalanceConsult;
import interfaces.exercise1.transactions.CashWithdraw;
import interfaces.exercise1.transactions.ServicePayment;

import java.math.BigDecimal;

public class Basic extends Client {
    public Basic(String accountNumber, String accountOwnerName, BigDecimal accountBalance) {
        super(accountNumber, accountOwnerName, accountBalance);
    }

    public void performBalanceConsult(){
        BalanceConsult bc = new BalanceConsult(getAccountNumber(), getAccountBalance());
        bc.execute();
    }

    public void performServicePayment(String serviceNumber){
        ServicePayment servicePayment = new ServicePayment(getAccountNumber(), getAccountBalance(), serviceNumber);
        servicePayment.execute();
    }

    public void performCashWithdraw(BigDecimal quantity) {
        CashWithdraw cashWithdraw = new CashWithdraw(getAccountNumber(), getAccountBalance(), quantity);
        cashWithdraw.execute();
    }

}
