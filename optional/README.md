# Optional in Java

https://winterbe.com/posts/2015/03/15/avoid-null-checks-in-java/

Řetězení přes funkci map - vypíše kód company pokud company a kód není null:

```java
Optional.of(workspace)
    .map(DciWorkspace::getCurrentCompany)
    .map(Company::getCode)
    .ifPresent(System.out::println);
```

TODO: Připravit vlastní příklad