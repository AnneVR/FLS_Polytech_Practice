package com.beta.backend.Repositories.Dicts;

import com.beta.backend.Models.Dicts.ContractTypeDict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractTypeDictRepository extends JpaRepository<ContractTypeDict, Long> {
}
