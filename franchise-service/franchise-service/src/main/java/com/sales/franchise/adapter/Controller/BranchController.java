
package com.sales.franchise.adapter.Controller;

import com.sales.franchise.application.dto.ApiResponseDTO;
import com.sales.franchise.application.dto.BranchResponseDTO;
import com.sales.franchise.application.dto.ProductResponseDTO;
import com.sales.franchise.application.dto.ProductTopResponseDTO;
import com.sales.franchise.application.usecase.BranchUseCase;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/branch/")
public class BranchController {
    
    
    private final BranchUseCase service;
    
      public BranchController(BranchUseCase service) {
        this.service = service;
    }
      
    @GetMapping("{idFranchise}/top-products")
    public ApiResponseDTO<List<ProductTopResponseDTO>> create(@PathVariable Long idFranchise) {
        var response = service.getTopProductsByFranchise(idFranchise);
        return response;
    }
    
       @PostMapping
    public ApiResponseDTO<BranchResponseDTO> create(@RequestBody BranchResponseDTO model) {
        var response = service.save(model);
        return response;
    }
    
     @PutMapping("updateBranchForName")
    public ApiResponseDTO<BranchResponseDTO> update(@RequestBody BranchResponseDTO model) {
        return service.updateBranchForName(model);
    }
    
    
}
