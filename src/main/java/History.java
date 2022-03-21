import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class History {

    private static final String headerTitle = "Date\t\t|Credit\t\t\t|Debit\t\t\t| Balance\t\n";
    public static List<HistoryLine> historyLines = new LinkedList<HistoryLine>();

    public History() {
    }

    public void addHistoryLine(Statement statement, Money balance){
        historyLines.add(0, new HistoryLine(balance, statement));
    }


    public static String toStringer() {
        StringBuilder builder = new StringBuilder();
        builder.append(headerTitle);
        for(HistoryLine historyLine: historyLines()){
            String lineString = historyLine.toString();
            builder.append(lineString);
        }
        return builder.toString();
    }

    public static List<HistoryLine> historyLines() {
        return historyLines;
    }
}
