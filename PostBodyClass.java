package com.codegames.renaissancecoders.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostBodyClass {

    private String authorAccountId;
    private int billableSeconds;
    private String description;
    private long issueId;
    private String startDate;
    private int timeSpentSeconds;

    public String getAuthorAccountId() {
        return authorAccountId;
    }

    public void setAuthorAccountId(String authorAccountId) {
        this.authorAccountId = authorAccountId;
    }

    public int getBillableSeconds() {
        return billableSeconds;
    }

    public void setBillableSeconds(int billableSeconds) {
        this.billableSeconds = billableSeconds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getIssueId() {
        return issueId;
    }

    public  void setIssueId(long issueId) {
        this.issueId = issueId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getTimeSpentSeconds() {
        return timeSpentSeconds;
    }

    public void setTimeSpentSeconds(int timeSpentSeconds) {
        this.timeSpentSeconds = timeSpentSeconds;
    }
}
