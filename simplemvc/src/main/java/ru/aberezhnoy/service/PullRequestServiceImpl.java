package ru.aberezhnoy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.aberezhnoy.domine.Statuses;
import ru.aberezhnoy.persist.entity.PullRequest;
import ru.aberezhnoy.persist.repository.PullRequestRepository;
import ru.aberezhnoy.persist.repository.PullRequestSpecification;
import ru.aberezhnoy.service.dto.PullRequestDto;

import java.util.Optional;

@Service
public class PullRequestServiceImpl implements PullRequestService {

    private final PullRequestRepository pullRequestRepository;

    @Autowired
    public PullRequestServiceImpl(PullRequestRepository pullRequestRepository) {
        this.pullRequestRepository = pullRequestRepository;
    }

    private static PullRequestDto convertToDto(PullRequest pullRequest) {
        return new PullRequestDto(
                pullRequest.getId(),
                pullRequest.getReference(),
                pullRequest.getHomeWorkNumber(),
                pullRequest.getDescription(),
                pullRequest.getStatus());
    }

    @Override
    public Page<PullRequestDto> findAll(Optional<Integer> numberFilter, Optional<Statuses> statusName, Integer page, Integer size, String sort) {
        Specification<PullRequest> spec = Specification.where(null);
        if (numberFilter.isPresent()) {
            spec = spec.and(PullRequestSpecification.byNumber(numberFilter.get()));
        }
        if (statusName.isPresent()) {
            spec = spec.and(PullRequestSpecification.byStatus(statusName.get()));
        }
        return pullRequestRepository.findAll(spec, PageRequest.of(page, size, Sort.by(sort)))
                .map(PullRequestServiceImpl::convertToDto);
    }

    @Override
    public Optional<PullRequestDto> findById(Long id) {
        return pullRequestRepository.findById(id)
                .map(PullRequestServiceImpl::convertToDto);
    }

    @Override
    public PullRequestDto save(PullRequestDto pullRequestDto) {
        PullRequest pullRequest = new PullRequest(
                pullRequestDto.getId(),
                pullRequestDto.getReference(),
                pullRequestDto.getHomeWorkNumber(),
                pullRequestDto.getDescription(),
                pullRequestDto.getStatus());
        PullRequest saved = pullRequestRepository.save(pullRequest);
        return convertToDto(saved);
    }

    @Override
    public void deleteById(Long id) {
        pullRequestRepository.deleteById(id);
    }
}
