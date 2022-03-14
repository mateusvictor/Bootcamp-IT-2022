package interfaces.exercise1.clients;

import interfaces.exercise1.transactions.BalanceConsult;
import interfaces.exercise1.transactions.CashWithdraw;

import java.math.BigDecimal;

public class Collector extends Client {
    public Collector(String accountNumber, String accountOwnerName, BigDecimal accountBalance) {
        super(accountNumber, accountOwnerName, accountBalance);
    }

    public void performBalanceConsult(){
        BalanceConsult bc = new BalanceConsult(getAccountNumber(), getAccountBalance());
        bc.execute();
    }

    public void performCashWithdraw(BigDecimal quantity) {
        CashWithdraw cashWithdraw = new CashWithdraw(getAccountNumber(), getAccountBalance(), quantity);
        cashWithdraw.execute();
    }
}
