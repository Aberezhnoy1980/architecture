package ru.aberezhnoy.composite;

import java.util.ArrayList;
import java.util.List;

public class Developer extends RequiredConstructor implements Employee {

    private final List<String> roles = new ArrayList<>();
    private float salary;
    private String name;

    private Developer() {
    }

    private Developer(String name, float salary) {
        super(name, salary);
    }

    public static DevBuilder createDevBuilder() {
        return new DevBuilder();
    }

    @Override
    public void getInfo() {
        super.getInfo(this);
    }

    public Developer newDeveloper(String name, float salary) {
        return new Developer(name, salary);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getSalary() {
        return this.salary;
    }

    @Override
    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public List<String> getRoles() {
        return this.roles;
    }

    @Override
    public String toString() {
        return "Employee: \n" +
                name +
                salary +
                roles;
    }

    public static class DevBuilder {

        private final Developer developer;

        public DevBuilder() {
            this.developer = new Developer();
        }

        public DevBuilder setName(String name) {
            this.developer.name = name;
            return this;
        }

        public DevBuilder setSalary(float salary) {
            this.developer.salary = salary;
            return this;
        }

        public DevBuilder setRoles(String role) {
            this.developer.roles.add(role);
            return this;
        }

        public Developer build() {
            return developer;
        }
    }
}
