
package com.sales.franchise.application.dto;


public record BranchResponseDTO(
    Long id_branch,
    String name,
    String address,
    Long id_franchise
) {}