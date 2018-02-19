package com.googleApi.tenacity;

import com.yammer.tenacity.core.properties.TenacityPropertyKey;
import com.yammer.tenacity.core.properties.TenacityPropertyKeyFactory;

public class KeyFactory implements TenacityPropertyKeyFactory {
    @Override
    public TenacityPropertyKey from(String value) {
        return GoogleDepedencyKeys.valueOf(value.toUpperCase());
    }
}
