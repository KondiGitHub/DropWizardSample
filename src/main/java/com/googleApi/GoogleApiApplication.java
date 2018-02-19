package com.googleApi;

import com.googleApi.services.GoogleNewsService;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import com.googleApi.resource.GoogleApiResource;
import com.googleApi.services.GoogleNewsServiceImpl;
import com.googleApi.services.GoogleNewsSearchService;
import com.googleApi.services.GoogleNewsSearchServiceImpl;
import com.googleApi.services.client.GoolgeClient;

import javax.ws.rs.client.ClientBuilder;

public class GoogleApiApplication extends Application<GoogleApiConfiguration> {

    public static void main(String[] args) throws Exception {
        new GoogleApiApplication().run(args);
    }

        public void initialize(Bootstrap<GoogleApiConfiguration> bootstrap) {
            bootstrap.addBundle(new SwaggerBundle<GoogleApiConfiguration>() {
                @Override
                protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(final GoogleApiConfiguration configuration) {
                    return configuration.getSwaggerBundleConfiguration();
                }
            });
//        bootstrap.addBundle(
//                TenacityBundleBuilder
//                        .<~>newBuilder().configurationFactory(new TenacityConfigurationFactory()).build());

    }

    @Override
    public void run(GoogleApiConfiguration configuration, Environment environment) throws Exception {


        GoolgeClient goolgeClient = new GoolgeClient(configuration.getGoogleHeadLineEndpoint(),
                configuration.getGoogleApiKey(), ClientBuilder.newClient());
        GoogleNewsService googleService = new GoogleNewsServiceImpl(goolgeClient);
        GoogleNewsSearchService googleNewsSearchService = new GoogleNewsSearchServiceImpl(goolgeClient);
        GoogleApiResource googleApiResource = new GoogleApiResource(googleService, googleNewsSearchService);


        environment.jersey().register(googleApiResource);
    }
}
