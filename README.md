# Kata de cuenta bancaria (Object Calisthenics)
=================

<p align="center">
  <img src="https://user-images.githubusercontent.com/59320487/158994563-8e3cc93d-1ce5-480b-a460-60b2fcb51543.png"
</p>

<p align="center">
  <img src="https://user-images.githubusercontent.com/59320487/159374738-39611231-a3f0-465b-9b40-85936ef1645e.png"
</p>


Piense en la experiencia de su cuenta bancaria personal. En caso de duda, opte por la solución más sencilla

Requisitos
------------

- Depósito y retiro
- Transferir
- Estado de cuenta (fecha, monto, saldo)
- Impresión de estados de cuenta
- Filtros de estados de cuenta (solo depósitos, retiro, fecha)

```java
public class Account {

    void deposit(Money amount, PersonalDate date) {

    }

    void withdraw(Money amount, PersonalDate date){

    }

    void printStatements(Money amount, PersonalDate date) {

    }

}
```
El objeto Money contiene dos variables conteniendo el valor en *int*, y un atributo de valor *Currency*, el cual contendra la divisa de dicha cuenta, 
permitiendo asi poder hacer transacciones solo con Money del mismo tipo de *Currency*

PersonalDate es solo un encapsulamiento de el formato Date, pero limitandose a crear y mostrar fechas validas en formato "10/01/2021"

## De la siguiente forma se ejecuta:

```java
public class StartApp {
	
	public static void main(String[] args) {
		Account account = new Account(new Statement());
		
		account.deposit(amountOf(1000), date("10/01/2021"));
		account.deposit(amountOf(2000), date("13/01/2021"));
		account.withdrawal(amountOf(500), date("14/01/2021"));
		
		account.printStatement(System.out);
	}

}
```
Las reglas
---------

1. Un nivel de sangría por método
2. No use la palabra clave ELSE
3. Envuelva todas las primitivas y cadenas
4. Colecciones de primera clase
5. Un punto por línea
6. No abrevie
7. Mantenga todas las entidades pequeñas (50 líneas)
8. No hay clases con más de dos variables de instancia.
9. Sin captadores/definidores/propiedades

#### Para más información:

- [Object Calistenia pdf] (http://www.cs.helsinki.fi/u/luontola/tdd-2009/ext/ObjectCalisthenics.pdf)
- Object Calisthenics (libro completo), Jeff Bay en: The ThoughtWorks Anthology.
Estantería pragmática 2008
- Idea original para el kata: ¿Qué tan orientado a objetos te sientes hoy?


### Ejemplo

Dado que un cliente realiza un depósito de 1000 el 10-01-2021
Y un depósito de 2000 el 13-01-2021
Y una retirada de 500 el 14-01-2021
Cuando imprime su extracto bancario
Entonces ella vería:

date       | credit   | debit    | balance  
|---|---|---|---|
14/01/2021 |          | 500.00   | 2500.00   
13/01/2021 | 2000.00  |          | 3000.00  
10/01/2021 | 1000.00  |          | 1000.00   

