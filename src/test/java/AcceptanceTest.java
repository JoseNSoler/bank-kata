import org.junit.Test;
import org.junit.jupiter.api.Assertions;


import java.util.Date;
import java.util.Locale;

public class AcceptanceTest {

    @Test
    public void shouldWhatever() {

        Locale local = new Locale("en", "US");

        Account account = new Account(new History(), new Money(0, local));

        account.deposit(Money.of(1000, local), PersonalDate.of("10/01/2021"));
        account.deposit(Money.of(2000, local), PersonalDate.of("13/01/2021"));
        account.withdraw(Money.of(500, local), PersonalDate.of("14/01/2021"));

        account.printStatements(System.out);
    }


    @Test()
    public void badCurrency() {
        Locale local = new Locale("en", "US");
        Locale local2 = Locale.UK;


        Account account = new Account(new History(), new Money(0, local));

        Throwable exception = Assertions.assertThrows(
                IllegalArgumentException.class, () -> {
                    account.deposit(Money.of(1000, local2), PersonalDate.of("10/01/2021"));
                }
        );

        Assertions.assertEquals("_ERROR: No se pueden sumar dos divisas de distinto pais sin convertir\n" +
                "Divisa moneda: Reino Unido - Divisa introducida: Estados Unidos", exception.getMessage());



        account.printStatements(System.out);
    }

}
