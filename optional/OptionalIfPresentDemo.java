import java.util.Optional;

/**
 * The method map automatically checks for optionals and passes it to another call.
 * Null checks are handled under the hood.
 * That enables to pipe multiple map operations in a row.
 *
 * @author Jaroslav Kvapil
 */
class OptionalIfPresentDemo {
    public static void main(String [] args) {
        // No city because address instance is null
        Building building = new Building();
        printCity(building);

        // Still no city because city in the address instance is null
        Address address = new Address();
        building.address = address;
        printCity(building);

        // Finally, Pilsen city available
        address.city = "Pilsen";
        printCity(building);
    }

    private static void printCity(Building building) {
        Optional.of(building)
                .map(Building::getAddress)
                .map(Address::getCity)
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("No city"));
    }
}

class Building {
    Address address;

    public Address getAddress() {
        return address;
    }
}

class Address {
    String city;

    public String getCity() {
        return city;
    }
}