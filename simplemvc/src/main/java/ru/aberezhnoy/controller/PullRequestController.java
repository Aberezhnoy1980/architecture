package ru.aberezhnoy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.aberezhnoy.domine.Statuses;
import ru.aberezhnoy.service.PullRequestService;
import ru.aberezhnoy.service.dto.PullRequestDto;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/pr")
public class PullRequestController {

    private final PullRequestService pullRequestService;

    @Autowired
    public PullRequestController(PullRequestService pullRequestService) {
        this.pullRequestService = pullRequestService;
    }

    @GetMapping
    public String listPage(Model model,
                           @RequestParam("numberFilter") Optional<Integer> numberFilter,
                           @RequestParam("statusName") Optional<Statuses> statusName,
                           @RequestParam("page") Optional<Integer> page,
                           @RequestParam("size") Optional<Integer> size,
                           @RequestParam("sort") Optional<String> sort) {

        model.addAttribute("statuses", Statuses.values());
        model.addAttribute("pull_requests", pullRequestService.findAll(
                numberFilter,
                statusName,
                page.orElse(1) - 1,
                size.orElse(4),
                sort.filter(s -> !s.isBlank()).orElse("id")
        ));
        return "pr";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("statuses", Statuses.values());
        model.addAttribute("pr", pullRequestService.findById(id)
                .orElseThrow(() -> new NotFoundException("Pull request not found")));
        return "pr_form";
    }

    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("pr", new PullRequestDto());
        model.addAttribute("statuses", Statuses.values());
        return "pr_form";
    }

    @PostMapping
    public String save(@Valid PullRequestDto pullRequest, BindingResult result) {
        if (result.hasErrors()) {
            return "pr_form";
        }
        pullRequestService.save(pullRequest);
        return "redirect:/pr";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        pullRequestService.deleteById(id);
        return "redirect:/pr";
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFoundExceptionHandler(NotFoundException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "not_found";
    }
}
