package com.test.ps.service;

import com.test.ps.dto.FeatureFlagDto;
import com.test.ps.exception.ResourceNotFoundException;

import java.util.List;

public interface FeatureFlagService {
    List<FeatureFlagDto> getFeatureFlags();
    FeatureFlagDto updateFeatureFlag(FeatureFlagDto featureFlagDto) throws ResourceNotFoundException;
}
