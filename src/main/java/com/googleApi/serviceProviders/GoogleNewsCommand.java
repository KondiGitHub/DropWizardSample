package com.googleApi.serviceProviders;

import com.googleApi.model.dto.google_news.GoogleResponse;
import com.googleApi.services.GoogleNewsService;
import com.yammer.tenacity.core.TenacityCommand;

import static com.googleApi.tenacity.GoogleDepedencyKeys.GOOGLE_NEWS_SERVICE;

public class GoogleNewsCommand extends TenacityCommand<GoogleResponse> {

    private GoogleNewsService googleService;
    public GoogleNewsCommand(GoogleNewsService googleService) {
        super(GOOGLE_NEWS_SERVICE);
        this.googleService = googleService;
    }

    @Override
    protected GoogleResponse run() throws Exception {
        return googleService.getGoogleNews();
    }
}
