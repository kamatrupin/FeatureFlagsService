package com.test.ps.dao;

import com.test.ps.entity.FeatureFlag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureFlagDao extends JpaRepository<FeatureFlag, Integer> {
}
