package com.googleApi.services;

import com.googleApi.model.dto.google_news.GoogleResponse;
import com.googleApi.services.client.GoolgeClient;

import java.io.IOException;

public class GoogleNewsServiceImpl implements GoogleNewsService {

    private GoolgeClient goolgeClient;

    public GoogleNewsServiceImpl(GoolgeClient goolgeClient) {
         this.goolgeClient = goolgeClient;
    }

    @Override
    public GoogleResponse getGoogleNews() throws IOException {
        return goolgeClient.getGoogleNews();
    }
}
