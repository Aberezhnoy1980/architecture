package ru.aberezhnoy.composite;

public class RequiredConstructor {

    public RequiredConstructor() {
    }

    public RequiredConstructor(String name, float salary) {
    }

    public void getInfo(Employee employee) {
        System.out.println("Employee: \n" +
                employee.getName() + "\n" +
                employee.getSalary() + "\n" +
                employee.getRoles() + "\n");
    }
}
