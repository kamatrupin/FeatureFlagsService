package com.test.ps.service;

import com.test.ps.dao.FeatureFlagDao;
import com.test.ps.dto.FeatureFlagDto;
import com.test.ps.entity.FeatureFlag;
import com.test.ps.exception.ResourceNotFoundException;
import com.test.ps.util.FeatureFlagConvertor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.*;

@Service
public class FeatureFlagServiceImpl implements FeatureFlagService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeatureFlagServiceImpl.class);

    @Autowired
    private FeatureFlagDao featureFlagDao;

    @Override
    public List<FeatureFlagDto> getFeatureFlags() {
        return featureFlagDao.findAll().stream().map(FeatureFlagConvertor::entityToDto).collect(Collectors.toList());
    }

    @Override
    public FeatureFlagDto updateFeatureFlag(FeatureFlagDto featureFlagDto) throws ResourceNotFoundException {
        try {
            FeatureFlag featureFlag = featureFlagDao.getOne(featureFlagDto.getId());
            featureFlag.setValue(featureFlagDto.getValue());
            return FeatureFlagConvertor.entityToDto(featureFlagDao.save(featureFlag));
        } catch(EntityNotFoundException e) {
            LOGGER.error("Feature Flag not found with id=" + featureFlagDto.getId(), e);
            throw new ResourceNotFoundException("Feature Flag not found with id=" + featureFlagDto.getId(), e);
        }
    }
}
