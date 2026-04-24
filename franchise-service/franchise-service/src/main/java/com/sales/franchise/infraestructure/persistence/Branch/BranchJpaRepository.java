
package com.sales.franchise.infraestructure.persistence.Branch;

import com.sales.franchise.domain.model.Branch;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BranchJpaRepository extends JpaRepository<Branch, Long>{
    List<Branch> findByFranchise_IdFranchise(Long idFranchise);
}
    

