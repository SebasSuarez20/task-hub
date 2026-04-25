
package com.sales.franchise.adapter.Controller;

import com.sales.franchise.application.dto.ApiResponseDTO;
import com.sales.franchise.application.dto.ProductResponseDTO;
import com.sales.franchise.application.usecase.ProductUseCase;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/product/")
public class ProductController {
    
    
    private final ProductUseCase service;
    
      public ProductController(ProductUseCase service) {
        this.service = service;
    }
    
       @PostMapping
    public ApiResponseDTO<ProductResponseDTO> create(@RequestBody ProductResponseDTO model) {
        var response = service.save(model);
        return response;
    }
    
    @PutMapping("updateForStock")
    public ApiResponseDTO<ProductResponseDTO> update(@RequestBody ProductResponseDTO model) {
        return service.updateProductForStock(model);
    }
    
    @DeleteMapping("{idProduct}/{idBranch}")
    public ApiResponseDTO<Void> delete(@PathVariable Long idProduct,@PathVariable Long idBranch) {
        return service.deleteProduct(idProduct,idBranch);
    }
    
     @PutMapping("updateForProductName")
    public ApiResponseDTO<ProductResponseDTO> updateForName(@RequestBody ProductResponseDTO model) {
        return service.updateProductForName(model);
    }
}
