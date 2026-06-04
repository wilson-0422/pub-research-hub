package com.researchhub.dto;

import java.time.LocalDate;

public class PaperDTO {

    private String title;
    private String abstractText;
    private String authors;
    private String keywords;
    private String journal;
    private LocalDate publishDate;
    private String doi;
    private String status;
    private Long projectId;

    public PaperDTO() {}

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAbstractText() { return abstractText; }
    public void setAbstractText(String abstractText) { this.abstractText = abstractText; }
    public String getAuthors() { return authors; }
    public void setAuthors(String authors) { this.authors = authors; }
    public String getKeywords() { return keywords; }
    public void setKeywords(String keywords) { this.keywords = keywords; }
    public String getJournal() { return journal; }
    public void setJournal(String journal) { this.journal = journal; }
    public LocalDate getPublishDate() { return publishDate; }
    public void setPublishDate(LocalDate publishDate) { this.publishDate = publishDate; }
    public String getDoi() { return doi; }
    public void setDoi(String doi) { this.doi = doi; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Long getProjectId() { return projectId; }
    public void setProjectId(Long projectId) { this.projectId = projectId; }
}
