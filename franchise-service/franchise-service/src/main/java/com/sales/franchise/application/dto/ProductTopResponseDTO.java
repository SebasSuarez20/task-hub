
package com.sales.franchise.application.dto;

import java.math.BigDecimal;


public record ProductTopResponseDTO(
    String name,
    Integer stock,
    String nameBranch
) {}