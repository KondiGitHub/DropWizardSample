package com.googleApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import com.googleApi.tenacity.GoogleTenacityConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class GoogleApiConfiguration extends Configuration {
    @Valid
    @NotNull
    private String googleApiKey;

    @Valid
    @NotNull
    private String googleHeadLineEndpoint;



    @Valid
    @JsonProperty("swagger")
    private SwaggerBundleConfiguration swaggerBundleConfiguration;

    @Valid
    private GoogleTenacityConfiguration tenacity;

    public String getGoogleApiKey() {
        return googleApiKey;
    }

    public String getGoogleHeadLineEndpoint() {
        return googleHeadLineEndpoint;
    }

    public GoogleTenacityConfiguration getTenacity() {
        return tenacity;
    }
    public SwaggerBundleConfiguration getSwaggerBundleConfiguration() {
        return swaggerBundleConfiguration;
    }
}
