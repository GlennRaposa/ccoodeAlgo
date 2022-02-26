package com.timeup.checkout;

import java.util.HashMap;
import java.util.Objects;

public class Person {

    private String surname;
    private String name;


    public Person(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

    public static void main(String args[]){
        HashMap<Person, String> personMap = new HashMap<>();
        Person person1 = new Person("Smith", "John");
        Person person2 = new Person("Smith", "John");

        personMap.put(person1, "person1");
        System.out.println("boom-------"+personMap.get(person2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return surname.equals(person.surname) &&
                name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name);
    }
}
