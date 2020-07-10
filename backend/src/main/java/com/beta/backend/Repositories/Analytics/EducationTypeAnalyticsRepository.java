package com.beta.backend.Repositories.Analytics;

import com.beta.backend.Models.Analytics.EducationTypeAnalytics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationTypeAnalyticsRepository extends JpaRepository<EducationTypeAnalytics, Long>
{
}
