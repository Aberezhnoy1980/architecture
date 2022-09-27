package ru.aberezhnoy.persist.entity;

import ru.aberezhnoy.domine.Statuses;

import javax.persistence.*;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name = "pull_requests")
public class PullRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ref")
    private String reference;

    @Column(name = "home_work_id")
    private int homeWorkNumber;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private Statuses status;

    public PullRequest() {
    }

    public PullRequest(Long id, String reference, int homeWorkNumber, String description, Statuses status) {
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

    public void setHomeWorkNumber(int homeWorkNumber) {
        this.homeWorkNumber = homeWorkNumber;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PullRequest pullRequest = (PullRequest) o;
        return Objects.equals(id, pullRequest.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reference, homeWorkNumber, description);
    }

    public Statuses getStatus() {
        return status;
    }

    public void setStatus(Statuses status) {
        this.status = status;
    }
}
