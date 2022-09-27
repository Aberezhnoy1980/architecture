package ru.aberezhnoy.service;

import org.springframework.data.domain.Page;
import ru.aberezhnoy.domine.Statuses;
import ru.aberezhnoy.service.dto.PullRequestDto;

import java.util.Optional;

public interface PullRequestService {

    Page<PullRequestDto> findAll(Optional<Integer> numberFilter, Optional<Statuses> statusName, Integer page, Integer size, String sort);

    Optional<PullRequestDto> findById(Long id);

    PullRequestDto save(PullRequestDto pullRequest);

    void deleteById(Long id);
}
