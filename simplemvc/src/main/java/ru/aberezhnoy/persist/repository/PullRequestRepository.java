package ru.aberezhnoy.persist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.aberezhnoy.persist.entity.PullRequest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface PullRequestRepository extends JpaRepository<PullRequest, Long>, JpaSpecificationExecutor<PullRequest> {

    @Query("select pr " +
            "from PullRequest pr " +
            "where (pr.homeWorkNumber = :pattern or :pattern is null)")
    List<PullRequest> findByFilter(@Param("pattern") Integer number);
}
