package ru.aberezhnoy.composite;

public class CompositeApp {

    public static void main(String[] args) {

        Employee john = Developer
                .createDevBuilder()
                .setName("John Doe")
                .setSalary(12000)
                .setRoles("CEO")
                .setRoles("SEO")
                .build();

        Employee jane = Designer
                .createDesBuilder()
                .setName("Jane Doe")
                .setSalary(15000)
                .build();

        Organization organization = new Organization();
        organization.sddEmployee(john);
        organization.sddEmployee(jane);

        System.out.println("Net salaries: " + organization.getNetSalaries());
        john.getInfo();
        jane.getInfo();
    }

}
