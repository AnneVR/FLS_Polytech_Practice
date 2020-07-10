package com.beta.backend.Repositories.Dicts;

import com.beta.backend.Models.Dicts.IncomeTypeDict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeTypeDictRepository extends JpaRepository<IncomeTypeDict, Long> {
}
