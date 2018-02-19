package com.googleApi.services;

import com.googleApi.model.dto.google_news.GoogleResponse;

import java.io.IOException;

public interface GoogleNewsSearchService {
    public GoogleResponse getGoogleSearchResults(String searchStr) throws IOException;
}
