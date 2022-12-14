# Optional in Java

**Nepoužívat Optional jako argumenty u metod!! Dává smysl pouze jako výstup z metod, kde chceme jasně deklarovat, ze může být prázdný.**
U Optional argumentu metody nastane problém, kdy lze metodu zavolat jako s parametrem null nebo jako Optional.empty(). V samotném kódu metody se musí oba stavy ošetřit a není potom jasné, co který stav znamená.
Nepovinné argumenty lze řešit:
1. @NotNull anotací - IntelliJ zobrazuje porušení jako warning
2. Přetížením metody, kde se metoda zavolá s default hodnotou parametru
3. Logika metody počítá s null hodnotou a ošetří ji

https://www.baeldung.com/java-optional

### Optional.of()

Spadne pokud jako parametr přijde null, v takovém případě lze použít Optional.ofNullable().
```java
Assertions.assertThrows(NullPointerException.class, () -> Optional.of(null));
Assertions.assertFalse(Optional.ofNullable(null).isPresent());
```

### Optional.get()
Pokud se volá get, nesmí být Optional prázdný, jinak vyvolá vyjímku NoSuchElementException (stejně se chová metoda orElseThrow bez uvedeného parametru).
```java
Assertions.assertThrows(NoSuchElementException.class, () -> Optional.ofNullable(null).get());
Assertions.assertEquals("some_string", Optional.of("some_string").get());
```

### Defaulty a podmínky
Rozdíl mezi orElse a orElseGet je ten, že pokud je Optional instance k dispozici (neprázdná), orElse provolá i funkci, ale v případě orElseGet se lambda funkce zavolá jen v případě, že Optinal instance je prázdná
```java
// Give me object or default value.
String name = Optional.ofNullable(null).orElse("john");

// Similar as orElse, but it takes functional interface to get default value.
String name = Optional.ofNullable(null).orElseGet(() -> "john");

// Throws exception when Optional is empty.
// When orElseThrow argument is not specified, it throws NoSuchElementException by default (same as get()).
String name = Optional.ofNullable(null).orElseThrow(IllegalArgumentException::new);

// Relative to if condition where instance is checked against null.
// Alternative is isPresent function, that returns boolean for if statements.
Optional.of("some_string").ifPresent(name -> System.out.println(name.length()));
```

https://winterbe.com/posts/2015/03/15/avoid-null-checks-in-java/

Řetězení přes funkci map - vypíše kód company pokud company a kód není null:

```java
Optional.of(workspace)
    .map(DciWorkspace::getCurrentCompany)
    .map(Company::getCode)
    .ifPresent(System.out::println);
```

