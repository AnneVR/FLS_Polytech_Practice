package com.beta.backend.Repositories.Dicts;

import com.beta.backend.Models.Dicts.OccupationTypeDict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccupationTypeDictRepository extends JpaRepository<OccupationTypeDict, Long> {
}
