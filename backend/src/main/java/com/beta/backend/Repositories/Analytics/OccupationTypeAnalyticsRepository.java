package com.beta.backend.Repositories.Analytics;

import com.beta.backend.Models.Analytics.OccupationTypeAnalytics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccupationTypeAnalyticsRepository extends JpaRepository<OccupationTypeAnalytics, Long>
{
}
