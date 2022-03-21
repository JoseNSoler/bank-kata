import java.util.Date;

public class HistoryLine {

    private Money balance;
    private Statement statement;

    public HistoryLine(Money balance, Statement statement) {
        this.balance = balance;
        this.statement = statement;
    }

    @Override
    public String toString() {
        return statement.toString(balance) + "\n";
    }
}
