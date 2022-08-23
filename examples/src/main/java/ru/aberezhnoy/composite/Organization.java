package ru.aberezhnoy.composite;

import java.util.ArrayList;
import java.util.List;

public class Organization {

    private List<Employee> employees = new ArrayList<>();

    public void sddEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public float getNetSalaries() {
        float netSalary = 0;

        for (Employee e : employees) {
            netSalary += e.getSalary();
        }
        return netSalary;
    }
}
