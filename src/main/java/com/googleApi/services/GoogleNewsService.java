package com.googleApi.services;

import com.googleApi.model.dto.google_news.GoogleResponse;

import java.io.IOException;

public interface GoogleNewsService {

    public GoogleResponse getGoogleNews() throws IOException;

}
