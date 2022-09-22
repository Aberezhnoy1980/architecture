package ru.aberezhnoy.observer;

public class JobSeeker {
    private final String name;

    public JobSeeker(String name) {
        this.name = name;
    }

    public void onJobPosted(JobPost jobPost) {
        System.out.println("Hi " + this.name + "! Mew job posted: " + jobPost.getTitle());
    }
}
