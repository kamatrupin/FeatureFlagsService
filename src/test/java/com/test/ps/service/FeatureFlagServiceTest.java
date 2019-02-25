package com.test.ps.service;

import com.test.ps.dao.FeatureFlagDao;
import com.test.ps.dto.FeatureFlagDto;
import com.test.ps.entity.FeatureFlag;
import com.test.ps.exception.ResourceNotFoundException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FeatureFlagServiceTest {

    private static FeatureFlagService featureFlagService;

    @BeforeClass
    public static void beforeClass() {
        featureFlagService = new FeatureFlagServiceImpl();
    }

    @Test
    public void testGetFeatureFlags() {
        FeatureFlagDao mockFeatureFlagDao = mock(FeatureFlagDao.class);
        ReflectionTestUtils.setField(featureFlagService, "featureFlagDao", mockFeatureFlagDao);
        List<FeatureFlag> expectedFeatureFlags = new ArrayList<>();
        expectedFeatureFlags.add(new FeatureFlag());

        when(mockFeatureFlagDao.findAll()).thenReturn(expectedFeatureFlags);

        List<FeatureFlagDto> actualList = featureFlagService.getFeatureFlags();

        assertNotNull(actualList);
        assertTrue(!actualList.isEmpty());
        assertEquals(1, actualList.size());
    }

    @Test
    public void testUpdateFeatureFlag() {
        FeatureFlagDao mockFeatureFlagDao = mock(FeatureFlagDao.class);
        ReflectionTestUtils.setField(featureFlagService, "featureFlagDao", mockFeatureFlagDao);

        int testId = 1;
        String testCountry = "test";
        int testValue = 1;
        FeatureFlagDto featureFlagDto = new FeatureFlagDto(testId, testCountry, testValue);
        FeatureFlag featureFlag = new FeatureFlag(testCountry, testValue);
        featureFlag.setId(testId);

        when(mockFeatureFlagDao.getOne(testId)).thenReturn(featureFlag);
        when(mockFeatureFlagDao.save(featureFlag)).thenReturn(featureFlag);

        FeatureFlagDto actualFeatureFlagDto = featureFlagService.updateFeatureFlag(featureFlagDto);

        assertNotNull(actualFeatureFlagDto);
        assertEquals(testId, actualFeatureFlagDto.getId().intValue());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testUpdateFeatureFlagResourceNotFound() {
        FeatureFlagDao mockFeatureFlagDao = mock(FeatureFlagDao.class);
        ReflectionTestUtils.setField(featureFlagService, "featureFlagDao", mockFeatureFlagDao);

        int testId = 1;
        String testCountry = "test";
        int testValue = 1;
        FeatureFlagDto featureFlagDto = new FeatureFlagDto(testId, testCountry, testValue);
        when(mockFeatureFlagDao.getOne(testId)).thenThrow(ResourceNotFoundException.class);
        featureFlagService.updateFeatureFlag(featureFlagDto);
    }
}
