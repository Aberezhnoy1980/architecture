package ru.aberezhnoy.builder;

import java.time.LocalDate;

public class Person {
    private String firstname;
    private String lastname;
    private LocalDate birthdate;
    private String gender;
    private String profession;

    private Person() {
    }

    public Person(String firstname, String lastname, LocalDate birthdate, String gender, String profession) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.gender = gender;
        this.profession = profession;
    }

    public Person(String firstname, String lastname, LocalDate birthdate, String gender) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.gender = gender;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String gender() {
        return gender;
    }

    public String profession() {
        return profession;
    }

    public static Builder createBuilder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Person: " +
                "\nfirstname: " + firstname +
                "\nlastname: " + lastname +
                "\nbirthdate: " + birthdate +
                "\ngender: " + gender +
                "\nprofession: " + profession;
    }

    private static class Builder {
        private Person person;

        public Builder() {
            this.person = new Person();
        }

        public Builder withFirstname(String firstname) {
            this.person.firstname = firstname;
            return this;
        }

        public Builder withLastname(String lastname) {
            this.person.lastname = lastname;
            return this;
        }

        public Builder withBirthdate(LocalDate birthdate) {
            this.person.birthdate = birthdate;
            return this;
        }

        public Builder withGender(String gender) {
            this.person.gender = gender;
            return this;
        }

        public Builder withProfession(String profession) {
            this.person.profession = profession;
            return this;
        }

        public Person build() {
            return person;
        }
    }

    public static void main(String[] args) {
        Person person = Person.createBuilder()
                .withFirstname("Ivan")
                .withLastname("Petrov")
                .withBirthdate(LocalDate.now())
                .withGender("Male")
                .withProfession("Coder")
                .build();

        System.out.println(person);
    }
}
