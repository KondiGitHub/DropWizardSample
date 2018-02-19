package com.googleApi.tenacity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.tenacity.core.config.TenacityConfiguration;

import javax.validation.Valid;

public class GoogleTenacityConfiguration {

    public TenacityConfiguration getGoogleSvcCommand() {
        return googleSvcCommand;
    }

    @Valid
    @JsonProperty
    private TenacityConfiguration googleSvcCommand;
}
