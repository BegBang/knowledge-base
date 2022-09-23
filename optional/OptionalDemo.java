import java.util.Optional;

class Building {
    Address address;
    String owner;

    public Address getAddress() {
        return address;
    }

    public String getOwner() {
        return owner;
    }
}

class Address {
    String city;
    String firstLine;

    public String getCity() {
        return city;
    }

    public String getFirstLine() {
        return firstLine;
    }
}

class OptionalDemo {
    public static void main(String [] args) {
        Building building = new Building();

        // No city because address instance is null
        printCity(building);

        Address address = new Address();
        building.address = address;

        // Still no city because city in the address instance is null
        printCity(building);

        address.city = "Pilsen";

        // Finally, Pilsen city available
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