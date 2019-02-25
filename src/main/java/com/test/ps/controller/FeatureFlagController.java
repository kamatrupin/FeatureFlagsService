package com.test.ps.controller;

import com.test.ps.dto.FeatureFlagDto;
import com.test.ps.service.FeatureFlagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/featureflags")
public class FeatureFlagController {

    @Autowired
    private FeatureFlagService featureFlagService;

    @RequestMapping(method = RequestMethod.GET)
    public List<FeatureFlagDto> getFeatureFlags() {
        return featureFlagService.getFeatureFlags();
    }

    @RequestMapping(method = RequestMethod.POST)
    public FeatureFlagDto updateFeatureFlag(@Valid @RequestBody FeatureFlagDto featureFlagDto) {
        return featureFlagService.updateFeatureFlag(featureFlagDto);
    }
}
