package com.googleApi.tenacity;

import com.google.common.collect.ImmutableMap;
import com.googleApi.GoogleApiConfiguration;
import com.yammer.tenacity.core.bundle.BaseTenacityBundleConfigurationFactory;
import com.yammer.tenacity.core.config.TenacityConfiguration;
import com.yammer.tenacity.core.properties.TenacityPropertyKey;
import com.yammer.tenacity.core.properties.TenacityPropertyKeyFactory;

import java.util.Map;

public class TenacityConfigurationFactory extends BaseTenacityBundleConfigurationFactory<GoogleApiConfiguration> {

    public TenacityPropertyKeyFactory getTenacityPropertyKeyFactory(final GoogleApiConfiguration googleTenacityConfiguration){
        return new KeyFactory() ;
    }

    @Override
    public Map<TenacityPropertyKey, TenacityConfiguration> getTenacityConfigurations(GoogleApiConfiguration applicationConfiguration) {
        final ImmutableMap.Builder<TenacityPropertyKey, TenacityConfiguration> builder = ImmutableMap.builder();
        GoogleTenacityConfiguration tenacityConfiguration = applicationConfiguration.getTenacity();
        builder.put(GoogleDepedencyKeys.GOOGLE_NEWS_SERVICE, tenacityConfiguration.getGoogleSvcCommand());
        builder.put(GoogleDepedencyKeys.GOOGLE_SEARCH_SERVICE, tenacityConfiguration.getGoogleSvcCommand());
        return builder.build();
    }
}
