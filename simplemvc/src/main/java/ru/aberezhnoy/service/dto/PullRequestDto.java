package ru.aberezhnoy.service.dto;

import ru.aberezhnoy.domine.Statuses;

import java.util.Optional;

public class PullRequestDto {

    private Long id;

    private String reference;

    private int homeWorkNumber;

    private String description;

    private Statuses status;

    public PullRequestDto() {
    }

    public PullRequestDto(Long id, String reference, int homeWorkNumber, String description, Statuses status) {
        this.id = id;
        this.reference = reference;
        this.homeWorkNumber = homeWorkNumber;
        this.description = description;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getHomeWorkNumber() {
        return homeWorkNumber;
    }

    public void setHomeWorkNumber(int homeWorkNumber) {
        this.homeWorkNumber = homeWorkNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Statuses getStatus() {
        return status;
    }

    public void setStatus(Statuses status) {
        this.status = status;
    }
}
