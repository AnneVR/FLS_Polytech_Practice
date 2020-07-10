package com.beta.backend.Repositories.Dicts;

import com.beta.backend.Models.Dicts.EducationTypeDict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationTypeDictRepository extends JpaRepository<EducationTypeDict, Long> {
}
