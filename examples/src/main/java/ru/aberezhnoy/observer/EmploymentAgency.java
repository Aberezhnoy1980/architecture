package ru.aberezhnoy.observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmploymentAgency {
    private final List<JobSeeker> observers = new ArrayList<>();

    private void notify(JobPost jobPosting) {
        for (JobSeeker observer : observers) {
            observer.onJobPosted(jobPosting);
        }
    }

    public void attach(JobSeeker observer) {
        observers.add(observer);
    }

    public void addJob(JobPost jobPosting) {
        notify(jobPosting);
    }
}
