package ru.aberezhnoy.persist.repository;

import org.springframework.data.jpa.domain.Specification;
import ru.aberezhnoy.domine.Statuses;
import ru.aberezhnoy.persist.entity.PullRequest;

import java.util.Arrays;

public class PullRequestSpecification {

    public static Specification<PullRequest> byNumber(Integer number) {
        return (root, query, builder) -> builder.equal(root.get("homeWorkNumber"), number);
    }

    public static Specification<PullRequest> byStatus(Statuses statusName) {
        return (root, query, builder) -> builder.equal(root.get("status"), statusName);
    }
}
