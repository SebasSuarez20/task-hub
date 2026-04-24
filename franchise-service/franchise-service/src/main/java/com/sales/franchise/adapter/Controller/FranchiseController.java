//
package com.sales.franchise.adapter.Controller;

import com.sales.franchise.application.usecase.FranchiseUseCase;
import com.sales.franchise.application.dto.ApiResponseDTO;
import com.sales.franchise.application.dto.FranchiseResponseDTO;
import com.sales.franchise.application.dto.ProductResponseDTO;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/franchises/")
public class FranchiseController {
    
    private final FranchiseUseCase service;
     
      public FranchiseController(FranchiseUseCase service) {
        this.service = service;
    }
      
    @PostMapping
    public ApiResponseDTO<FranchiseResponseDTO> create(@RequestBody FranchiseResponseDTO franchise) {
        var response = service.save(franchise);
        return response;
    }
    
     @PutMapping("updateForFranchise")
    public ApiResponseDTO<FranchiseResponseDTO> update(@RequestBody FranchiseResponseDTO model) {
        return service.updateFranchiseForName(model);
    }
    
    
      
}
