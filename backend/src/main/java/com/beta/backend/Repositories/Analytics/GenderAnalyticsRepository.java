package com.beta.backend.Repositories.Analytics;

import com.beta.backend.Models.Analytics.GenderAnalytics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderAnalyticsRepository extends JpaRepository<GenderAnalytics, Long>
{
}