package com.beta.backend.Repositories.Analytics;

import com.beta.backend.Models.Analytics.IncomeTypeAnalytics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeTypeAnalyticsRepository extends JpaRepository<IncomeTypeAnalytics, Long>
{
}
