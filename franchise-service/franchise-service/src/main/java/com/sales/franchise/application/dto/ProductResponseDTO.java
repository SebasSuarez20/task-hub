
package com.sales.franchise.application.dto;

import java.math.BigDecimal;

public record ProductResponseDTO(
    Long id_product,
    String name,
    String description,
    BigDecimal price,
    Integer Stock,
    Long id_branch
) {}