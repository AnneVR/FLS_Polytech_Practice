package com.beta.backend.Repositories.Dicts;

import com.beta.backend.Models.Dicts.DayOfWeekAppliedDict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayOfWeekAppliedDictRepository extends JpaRepository<DayOfWeekAppliedDict, Long> {
}
