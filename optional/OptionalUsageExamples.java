import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.Optional;

class OptionalUsageExamples {

    @Test
    void optionalOf() {
        Assertions.assertThrows(NullPointerException.class, () -> Optional.of(null));
        Assertions.assertFalse(Optional.ofNullable(null).isPresent());
    }

    @Test
    void optionalGet() {
        Assertions.assertThrows(NoSuchElementException.class, () -> Optional.ofNullable(null).get());
        Assertions.assertEquals("some_string", Optional.of("some_string").get());
    }

    @Test
    void optionalOfNullable() {
        // Give me object or default value.
        Assertions.assertEquals("john", Optional.ofNullable(null).orElse("john"));

        // Similar as orElse, but it takes functional interface to get default value.
        Assertions.assertEquals("john", Optional.ofNullable(null).orElseGet(() -> "john"));

        // Throws exception when Optional is empty.
        // When orElseThrow argument is not specified, it throws NoSuchElementException by default.
        Assertions.assertThrows(IllegalArgumentException.class, () -> Optional.ofNullable(null).orElseThrow(IllegalArgumentException::new));
    }

    @Test
    void optionalIfPresent() {
        // Relative to if condition where instance is checked against null.
        // Alternative is isPresent function, that returns boolean for if statements.
        Optional.of("some_string").ifPresent(name -> System.out.println(name.length()));
    }

    @Test
    void optionalFilter() {
        Optional<Integer> numberOptional = Optional.of(1000);
        Assertions.assertFalse(numberOptional.filter(n -> n == 999).isPresent());
        Assertions.assertTrue(numberOptional.filter(n -> n == 1000).isPresent());

        // Filter function can be chained with value ranges
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, 01, 01);
        Optional<Calendar> calendarOptional = Optional.of(calendar);

        // Check year is from 2020 to 2025
        Assertions.assertTrue(calendarOptional.map(c -> c.get(Calendar.YEAR)).filter(n -> n > 2020).filter(n -> n < 2025).isPresent());
    }
}
