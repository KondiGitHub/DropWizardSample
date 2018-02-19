package com.googleApi.model.dto.google_news;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GoogleResponse {

    @JsonProperty
    private String status;

    @JsonProperty
    private int totalResults;

    @JsonProperty
    private Article[] articles;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public Article[] getArticles() {
        return articles;
    }

    public void setArticles(Article[] articles) {
        this.articles = articles;
    }
}
