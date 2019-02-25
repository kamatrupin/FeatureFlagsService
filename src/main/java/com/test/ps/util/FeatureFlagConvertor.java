package com.test.ps.util;

import com.test.ps.dto.FeatureFlagDto;
import com.test.ps.entity.FeatureFlag;

public class FeatureFlagConvertor {
    public static FeatureFlagDto entityToDto(FeatureFlag featureFlag) {
        return new FeatureFlagDto(featureFlag.getId(), featureFlag.getCountry(), featureFlag.getValue());
    }
}
