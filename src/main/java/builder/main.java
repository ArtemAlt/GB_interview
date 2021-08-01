package builder;

import builder.entity.Person;

public class main {
    public static void main(String[] args) {
        Person p = new Person.Builder()
                .setFirstName("Vasya")
                .setLastName("Petrovich")
                .setMiddleName("Ivanov")
                .setAddress("Moscow")
                .setPhone("99999999")
                .setGender("male")
                .setCountry("Russia")
                .build();
    }
}
