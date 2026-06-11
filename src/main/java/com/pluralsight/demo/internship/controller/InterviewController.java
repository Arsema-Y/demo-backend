package com.pluralsight.demo.internship.controller;

import com.pluralsight.demo.internship.model.Interview;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// TODO: Task 1 - Make this class a REST Controller and map it to "/api/interviews"
@RestController
@RequestMapping("/api/interviews")
@CrossOrigin(origins = "*")
public class InterviewController {

    private final List<Interview> interviews = new ArrayList<>();

    // Constructor seeds some initial mock data
    public InterviewController() {
        interviews.add(new Interview(1L, "Alice Smith", "Java Developer Intern", "Scheduled"));
        interviews.add(new Interview(2L, "Bob Jones", "React Front-End Intern", "Completed"));
        interviews.add(new Interview(3L, "Charlie Brown", "DevOps Intern", "Scheduled"));
    }

    // TODO: Task 2 - Map this method to GET requests at "/api/interviews"

    // BONUS Task 6 - Modify this method to filter by an optional "status" query parameter
    @GetMapping
    public List<Interview> getAllInterviews() {
        return interviews;
    }

    // TODO: Task 3 - Map this method to GET requests for a specific ID (e.g., /api/interviews/1)
    @GetMapping("/{id}")
    public Interview getInterviewById(@PathVariable Long id) {
        return interviews.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // TODO: Task 4 - Map this method to POST requests to schedule a new interview
    @PostMapping
    public Interview scheduleInterview(@RequestBody Interview newInterview) {
        // Simple ID generation logic for our in-memory list
        Long nextId = interviews.stream().mapToLong(Interview::getId).max().orElse(0L) + 1;
        newInterview.setId(nextId);
        interviews.add(newInterview);
        return newInterview;
    }

    // TODO: Task 5 - Map this method to DELETE requests for a specific ID
    @DeleteMapping("/{id}")
    public String cancelInterview(@PathVariable Long id) {
        boolean removed = interviews.removeIf(i -> i.getId().equals(id));
        return removed ? "Interview canceled and removed successfully." : "Interview not found.";
    }
}
