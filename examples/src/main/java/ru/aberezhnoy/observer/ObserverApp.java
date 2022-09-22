package ru.aberezhnoy.observer;

public class ObserverApp {
    public static void main(String[] args) {
        JobSeeker john_doe = new JobSeeker("John Doe");
        JobSeeker jane_doe = new JobSeeker("Jane Doe");

        EmploymentAgency jobPostings = new EmploymentAgency();
        jobPostings.attach(john_doe);
        jobPostings.attach(jane_doe);

        jobPostings.addJob(new JobPost("Software Engineer"));

    }
}
