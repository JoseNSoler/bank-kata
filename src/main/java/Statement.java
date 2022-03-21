public class Statement {
    private final PersonalDate personalDate;
    private final Money balance;

    public Statement(PersonalDate personalDate, Money balance) {
        this.personalDate = personalDate;
        this.balance = balance;
    }

    // Saber valor final en dado caso de una transaccion
    public Money AfterBalanceTransaction(Money operation) {
        return balance.adition(operation);
    }


    // String representacion para la declaracion-historial
    public String toString(Money currentBalance) {
        Money zero = Money.of(0, null);

        return (balance.isGreaterThan(zero)) ?
                debitString(currentBalance) :
                creditString(currentBalance);
    }

    // string Balance actual
    public String personalDate() {
        return personalDate.toString() + "\t|";
    }

    // string Balance actual
    public String balance() {
        return balance.toString();
    }

    //string personalizado para logica debito
    public String debitString(Money currentBalance) {
        return personalDate() +
                balance() + "\t\t|\t\t\t\t|" +
                currentBalance.toString();
    }

    //string personalizado para logica credito
    public String creditString(Money currentBalance) {
        return personalDate() + "\t\t\t\t|" +
                balance() + "\t\t|" +
                currentBalance.toString();
    }

}
