package com.pluralsight.demo.internship.model;

public class Interview {
    private Long id;
    private String candidateName;
    private String position;
    private String status; // e.g., "Scheduled", "Completed", "Canceled"

    // Constructors
    public Interview() {}

    public Interview(Long id, String candidateName, String position, String status) {
        this.id = id;
        this.candidateName = candidateName;
        this.position = position;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCandidateName() { return candidateName; }
    public void setCandidateName(String candidateName) { this.candidateName = candidateName; }
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
