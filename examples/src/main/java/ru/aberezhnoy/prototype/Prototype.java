package ru.aberezhnoy.prototype;

public class Prototype {

    public static class SomeClass implements Cloneable {

        public String field;

        public SomeClass(String field) {
            this.field = field;
        }

        public SomeClass clone() throws CloneNotSupportedException {
            return (SomeClass) super.clone();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        SomeClass first = new SomeClass("uniq");
        SomeClass second = first.clone();
        System.out.println(second.field);
    }
}
