package com.researchhub.dto;

public class ExperimentDTO {

    private String title;
    private String description;
    private String hypothesis;
    private String methodology;
    private String results;
    private String conclusion;
    private String status;
    private Long projectId;

    public ExperimentDTO() {}

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getHypothesis() { return hypothesis; }
    public void setHypothesis(String hypothesis) { this.hypothesis = hypothesis; }
    public String getMethodology() { return methodology; }
    public void setMethodology(String methodology) { this.methodology = methodology; }
    public String getResults() { return results; }
    public void setResults(String results) { this.results = results; }
    public String getConclusion() { return conclusion; }
    public void setConclusion(String conclusion) { this.conclusion = conclusion; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Long getProjectId() { return projectId; }
    public void setProjectId(Long projectId) { this.projectId = projectId; }
}
