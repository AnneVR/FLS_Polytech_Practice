package com.beta.backend.Repositories.Dicts;

import com.beta.backend.Models.Dicts.GenderDict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderDictRepository extends JpaRepository<GenderDict, Long> {
}
