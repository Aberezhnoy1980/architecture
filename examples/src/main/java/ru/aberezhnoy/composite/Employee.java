package ru.aberezhnoy.composite;

import java.util.List;

public interface Employee {

    String getName();

    float getSalary();

    void setSalary(float salary);

    List<String> getRoles();

    void getInfo();
}
