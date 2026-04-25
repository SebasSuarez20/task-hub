package com.sales.franchise.application.usecase;

import com.sales.franchise.application.dto.ApiResponseDTO;
import com.sales.franchise.application.dto.BranchResponseDTO;
import com.sales.franchise.application.dto.ProductResponseDTO;
import com.sales.franchise.application.dto.ProductTopResponseDTO;
import com.sales.franchise.domain.exception.BranchNotFoundException;
import com.sales.franchise.domain.exception.FranchiseNotFoundException;
import com.sales.franchise.domain.model.Branch;
import com.sales.franchise.domain.model.Franchise;
import com.sales.franchise.domain.model.Product;
import com.sales.franchise.domain.port.BranchRepositoryPort;
import com.sales.franchise.domain.port.FranchiseRepositoryPort;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BranchUseCase {

    private final BranchRepositoryPort repository;
    private final FranchiseRepositoryPort repositoryfranchise;
   
    private Branch toEntity(BranchResponseDTO req) {
        Branch branch = new Branch();
        branch.setName(req.name());
        branch.setAddress(req.address());
        branch.setEnabled(true);

        // Solo la referencia con el ID, JPA hace el resto
        Franchise franchise = new Franchise();
        franchise.setIdFranchise(req.id_franchise());
        branch.setFranchise(franchise);

        return branch;
    }

    private ApiResponseDTO<BranchResponseDTO> toResponse(Branch saved) {
        var response = new ApiResponseDTO<>(true, "Sucess information to Branch",
                new BranchResponseDTO(saved.getIdBranch(),saved.getName(), saved.getAddress(), saved.getFranchise().getIdFranchise()));
        return response;
    }

    public ApiResponseDTO<BranchResponseDTO> save(BranchResponseDTO request) {
        
        if(request == null)  throw new BranchNotFoundException("Error: modelBranch not incompatible");
        boolean isCreateFranchise = repositoryfranchise.ValidatorIfExists(request.id_franchise());
        if(!isCreateFranchise) throw new BranchNotFoundException(request.id_franchise());
        
        return Optional.of(request)
                .map(this::toEntity)
                .map(repository::save)
                .map(this::toResponse)
                .orElseThrow(() -> new BranchNotFoundException("Error creating franchise"));
    }

    public ApiResponseDTO<BranchResponseDTO> updateBranchForName(BranchResponseDTO model){
        
        if(model.name().isBlank()) throw new FranchiseNotFoundException("Params name not valid");
        
        repository.GetAllBranchForId(model.id_branch())
                  .map(s -> {
                      s.setName(model.name());
                     return s;
                    })
                   .map(repository::save)
                   .orElseThrow(() -> new BranchNotFoundException("Error updated Branch"));
        
        return new ApiResponseDTO<>(true,"Branch update for column name",model);
    }
    
   public ApiResponseDTO<List<ProductTopResponseDTO>> getTopProductsByFranchise(Long id){
       
       var response = repository.GetAllBranchForFranchise(id);
       
       if (response == null || response.isEmpty()) {
           return new ApiResponseDTO<>(false, "No branches found for this franchise", List.of());
       }
       
       List<ProductTopResponseDTO> maxForBranch = response.stream()
               .map(branch -> branch.getProducts().stream()
               .max(Comparator.comparing(Product::getStock))
               .map(p->{ return new ProductTopResponseDTO(p.getName(),p.getStock(),p.getBranch().getName());})
               .orElse(null)
               )
               .filter(Objects::nonNull)
               .toList();
       
        return new ApiResponseDTO<>(true,"Top products retrieved successfully",maxForBranch);
    }
}
