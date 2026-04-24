package com.sales.franchise.domain.port;

import com.sales.franchise.domain.model.Branch;
import java.util.List;
import java.util.Optional;

public interface BranchRepositoryPort {
    Branch save(Branch branch);
    Boolean ValidatorIfExists(Long id);
    Optional<Branch> GetAllBranchForId(Long id);
    List<Branch> GetAllBranchForFranchise(Long id);
}
