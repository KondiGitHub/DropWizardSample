package com.googleApi.services;

import com.googleApi.model.dto.google_news.GoogleResponse;
import com.googleApi.services.client.GoolgeClient;

import java.io.IOException;

public class GoogleNewsSearchServiceImpl implements GoogleNewsSearchService {

    private GoolgeClient goolgeClient;
    public GoogleNewsSearchServiceImpl(GoolgeClient goolgeClient){
        this.goolgeClient = goolgeClient;
    }
    @Override
    public GoogleResponse getGoogleSearchResults(String searchStr) throws IOException {
        return goolgeClient.getGoogleSearchResults(searchStr);
    }
}
