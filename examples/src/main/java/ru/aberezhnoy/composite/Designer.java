package ru.aberezhnoy.composite;

import java.util.ArrayList;
import java.util.List;

public class Designer extends RequiredConstructor implements Employee {

    private final List<String> roles = new ArrayList<>();
    private float salary;
    private String name;

    private Designer() {
        super(); // redundant maybe
    }

    private Designer(String name, float salary) {
        super(name, salary);
    }

    public static DesBuilder createDesBuilder() {
        return new DesBuilder();
    }

    @Override
    public void getInfo() {
        super.getInfo(this);
    }

    public Designer newDesigner(String name, float salary) {
        return new Designer(name, salary);
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

    public static class DesBuilder {

        private Designer designer;

        public DesBuilder() {
            this.designer = new Designer();
        }

        public DesBuilder setName(String name) {
            this.designer.name = name;
            return this;
        }

        public DesBuilder setSalary(float salary) {
            this.designer.salary = salary;
            return this;
        }

        public DesBuilder setRoles(String role) {
            this.designer.roles.add(role);
            return this;
        }

        public Designer build() {
            return designer;
        }
    }
}
