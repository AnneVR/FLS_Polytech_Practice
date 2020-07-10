package com.beta.backend.Repositories.Analytics;

import com.beta.backend.Models.Analytics.DayOfTheWeekAppliedAnalytics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayOfTheWeekAppliedAnalyticsRepository extends JpaRepository<DayOfTheWeekAppliedAnalytics, Long>
{
}
