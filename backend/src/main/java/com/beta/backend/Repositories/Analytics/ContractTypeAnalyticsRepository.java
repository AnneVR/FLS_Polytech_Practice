package com.beta.backend.Repositories.Analytics;

import com.beta.backend.Models.Analytics.ContractTypeAnalytics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractTypeAnalyticsRepository extends JpaRepository<ContractTypeAnalytics, Long>
{
}
