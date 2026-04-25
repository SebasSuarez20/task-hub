package com.sales.franchise.application.usecase;

import com.sales.franchise.application.dto.ApiResponseDTO;
import com.sales.franchise.application.dto.ProductResponseDTO;
import com.sales.franchise.domain.exception.ProductNotFoundException;
import com.sales.franchise.domain.model.Branch;
import com.sales.franchise.domain.model.Product;
import com.sales.franchise.domain.port.BranchRepositoryPort;
import com.sales.franchise.domain.port.ProductRepositoryPort;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductUseCase {

    private final ProductRepositoryPort repository;
    private final BranchRepositoryPort repositoryBranch;
   
    private Product toEntity(ProductResponseDTO req) {
        
        Product product = new Product();
        
        product.setName(req.name());
        product.setDescription(req.description());
        product.setPrice(req.price());
        product.setStock(req.Stock());

        // Solo la referencia con el ID, JPA hace el resto
        Branch branch = new Branch();
       
        branch.setIdBranch(req.id_branch());
        product.setBranch(branch);        

        return product;
    }

    private ApiResponseDTO<ProductResponseDTO> toResponse(Product saved) {
        return new ApiResponseDTO<>(true, "Sucess information to Product",
                new ProductResponseDTO(
                        saved.getIdProduct(),
                        saved.getName(),
                        saved.getDescription(),
                        saved.getPrice(),
                        saved.getStock(),
                        saved.getBranch().getIdBranch()
                ));
    }

    public ApiResponseDTO<ProductResponseDTO> save(ProductResponseDTO request) {
        
        if(request == null) throw new ProductNotFoundException("Error: modelProduct not incompatible");
        boolean isCreateFranchise = repositoryBranch.ValidatorIfExists(request.id_branch());
        if(!isCreateFranchise) throw new ProductNotFoundException(request.id_branch());
        
        return Optional.of(request)
                .map(this::toEntity)
                .map(repository::save)
                .map(this::toResponse)
                .orElseThrow(() -> new ProductNotFoundException("Error: creating product"));
    }
    
    public ApiResponseDTO<ProductResponseDTO> updateProductForStock(ProductResponseDTO model){
        
        if(model.Stock() <= 0 || model.Stock() == null) 
               throw new ProductNotFoundException("Error: range of number not valid.");
        
        if(model.id_product() == null) throw  new ProductNotFoundException(model.id_product());
        
        repository.GetAllProductForId(model.id_product())
                   .map(s -> {
                      if(!s.getEnabled()) throw new ProductNotFoundException("Product not found for modify");
                      s.setStock(model.Stock());
                    return s;
                   })
                   .map(repository::save)
                   .orElseThrow(() -> new ProductNotFoundException("Error: modify product"));
        
        return new ApiResponseDTO<>(true,"Update sucess",model);
    }
    
    public ApiResponseDTO<Void> deleteProduct(long idProduct,Long idBranch){
        
        repository.GetAllProductForId(idProduct)
                  .map(s -> {
                      s.setEnabled(false);
                     return s;
                  })
                  .map(repository::save)
                .orElseThrow(() -> new ProductNotFoundException("Error: delete product"));
        
        return new ApiResponseDTO<>(true,"Product deleted",null);
    }
    
    public ApiResponseDTO<ProductResponseDTO> updateProductForName( ProductResponseDTO model){
        
           if(model.name().isBlank()) throw new ProductNotFoundException("Params name not valid");
        repository.GetAllProductForId(model.id_product())
                  .map(s -> {
                      s.setName(model.name());
                     return s;
                  })
                  .map(repository::save)
                .orElseThrow(() -> new ProductNotFoundException("Error: update product"));
        
        return new ApiResponseDTO<>(true,"Product update for column name",null);
    }
     
    
    

}
