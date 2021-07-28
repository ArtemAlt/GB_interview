package builder.entity;

public class Person {
    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private String gender;

    public static class Builder {
        private final Person newPerson;

        public Builder() {
            this.newPerson = new Person();
        }

        public Person build() {
            return newPerson;
        }

        public Builder setFirstName(String name) {
            newPerson.firstName = name;
            return this;
        }

        public Builder setLastName(String name) {
            newPerson.lastName = name;
            return this;
        }

        public Builder setMiddleName(String name) {
            newPerson.middleName = name;
            return this;
        }

        public Builder setCountry(String country) {
            newPerson.country = country;
            return this;
        }
        public Builder setAddress(String address){
            newPerson.address=address;
            return this;
        }
        public Builder setPhone(String phone){
            newPerson.phone=phone;
            return this;
        }
        public Builder setGender(String gender){
            newPerson.gender=gender;
            return this;
        }
    }
}
