
package com.sales.franchise.adapter.Controller;

import com.sales.franchise.application.dto.ApiResponseDTO;
import com.sales.franchise.application.dto.BranchResponseDTO;
import com.sales.franchise.application.usecase.BranchUseCase;
import com.sales.franchise.domain.Exception.BranchNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/branch")
public class BranchController {
    
    
    private final BranchUseCase service;
    
      public BranchController(BranchUseCase service) {
        this.service = service;
    }
      
       @PostMapping
    public ApiResponseDTO<BranchResponseDTO> create(@RequestBody BranchResponseDTO model) {
        var response = service.save(model);
        return response;
    }
}
