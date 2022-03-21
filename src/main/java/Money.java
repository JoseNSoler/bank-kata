import java.text.NumberFormat;
import java.util.Locale;

public class Money {
    private final int amount;
    private final Locale locale;



    public Money(int amount, Locale locale){
        this.amount = amount;
        this.locale = locale;
    }

    public static Money of(int amount, Locale locale){
        return new Money(amount, locale);
    }


    public Money adition(Money otherMoney){
        String newCountry = otherMoney.countryName();

        System.out.println(newCountry.equals(this.countryName()));

        if(newCountry.equals(this.countryName()))
            return of(this.amount + otherMoney.amount, this.locale);
        throw  new IllegalArgumentException("_ERROR: No se pueden sumar dos divisas de distinto pais sin convertir\n" +
                    String.format("Divisa moneda: %s - Divisa introducida: %s",
                            countryName(), otherMoney.countryName())
            );
    }

    // Take me homee...
    public String countryName(){
        return this.locale.getDisplayCountry();
    }


    public boolean isGreaterThan(Money otherMoney) {
        return this.amount > otherMoney.amount;
    }

    public Money negative() {
        return of(-amount, this.locale);
    }

    public Locale locale() {
        return locale;
    }

    @Override
    public String toString() {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        return numberFormat.format(amount);
    }

    @Override
    public boolean equals(Object obj) {
        Money other = (Money) obj;
        if (amount != other.amount)
            return false;
        if (locale != other.locale)
            return false;
        return true;
    }
}
