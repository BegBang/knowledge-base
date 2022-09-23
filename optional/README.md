# Optional in Java

https://winterbe.com/posts/2015/03/15/avoid-null-checks-in-java/

Řetězení přes funkci map:

```java
Optional.of(new Outer())
    .map(Outer::getNested)
    .map(Nested::getInner)
    .map(Inner::getFoo)
    .ifPresent(System.out::println);
```