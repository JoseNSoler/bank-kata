import java.io.PrintStream;

public class Account {


    private History history;
    private Money balance;

    public Account(History history, Money balance) {
        this.history = history;
        this.balance = balance;
    }

    public void deposit(Money amount, PersonalDate date) {
        Money zero = Money.of(0, null);
        boolean condition = amount.isGreaterThan(zero);

        if(condition){
            newMovement(amount, date);
        }
        if(!condition){
            throw new IllegalArgumentException();
        }
    }

    public void withdraw(Money amount, PersonalDate date){
        boolean condition = amount.isGreaterThan(balance);
        if(!condition){
            newMovement(amount.negative(), date);
        }
        if(condition){
            throw  new IllegalArgumentException();
        }
    }

    void printStatements(PrintStream printer) {
        printer.println(History.toStringer());
    }

    private void newMovement(Money money, PersonalDate date){
        Statement statement = new Statement(date, money);
        Money balanceAfterMovement = statement.AfterBalanceTransaction(balance);
        balance = balanceAfterMovement;
        history.addHistoryLine(statement, balanceAfterMovement);
    }

}
