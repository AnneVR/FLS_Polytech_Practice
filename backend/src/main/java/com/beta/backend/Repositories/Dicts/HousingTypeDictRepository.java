package com.beta.backend.Repositories.Dicts;

import com.beta.backend.Models.Dicts.HousingTypeDict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HousingTypeDictRepository extends JpaRepository<HousingTypeDict, Long> {
}
