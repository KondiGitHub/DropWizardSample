package com.googleApi.serviceProviders;

import com.googleApi.model.dto.google_news.GoogleResponse;
import com.googleApi.services.GoogleNewsSearchService;
import com.googleApi.tenacity.GoogleDepedencyKeys;
import com.yammer.tenacity.core.TenacityCommand;

public class GoogleNewsSearchCommand extends TenacityCommand<GoogleResponse> {

    private GoogleNewsSearchService googleService;
    private String searchStr;
    public GoogleNewsSearchCommand(GoogleNewsSearchService googleService, String searchStr) {
        super(GoogleDepedencyKeys.GOOGLE_SEARCH_SERVICE);
        this.googleService = googleService;
        this.searchStr = searchStr;
    }

    @Override
    protected GoogleResponse run() throws Exception {
        return googleService.getGoogleSearchResults(searchStr);
    }
}
