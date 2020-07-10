package com.beta.backend.Repositories.Analytics;

import com.beta.backend.Models.Analytics.HousingTypeAnalytics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HousingTypeAnalyticsRepository extends JpaRepository<HousingTypeAnalytics, Long>
{
}
