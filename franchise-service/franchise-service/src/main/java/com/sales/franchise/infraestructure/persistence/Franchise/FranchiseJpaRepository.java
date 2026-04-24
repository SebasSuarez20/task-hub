
package com.sales.franchise.infraestructure.persistence.Franchise;

import com.sales.franchise.domain.model.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FranchiseJpaRepository extends JpaRepository<Franchise, Long>{}
