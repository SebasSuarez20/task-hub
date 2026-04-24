package com.sales.franchise.application.usecase;

import com.sales.franchise.application.dto.ApiResponseDTO;
import com.sales.franchise.application.dto.BranchResponseDTO;
import com.sales.franchise.domain.Exception.BranchNotFoundException;
import com.sales.franchise.domain.Exception.FranchiseNotFoundException;
import com.sales.franchise.domain.model.Branch;
import com.sales.franchise.domain.model.Franchise;
import com.sales.franchise.domain.port.BranchRepositoryPort;
import com.sales.franchise.domain.port.FranchiseRepositoryPort;
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
                new BranchResponseDTO(saved.getName(), saved.getAddress(), saved.getIdBranch()));
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

    public ApiResponseDTO<Void> updateFranchiseForName(Long id,String name){
        
        if(name.isBlank()) throw new FranchiseNotFoundException("Params name not valid");
        
        repository.GetAllBranchForId(id)
                  .map(s -> {
                      s.setName(name);
                     return s;
                    })
                   .map(repository::save)
                   .orElseThrow(() -> new BranchNotFoundException("Error updated Branch"));
        
        return new ApiResponseDTO<>(true,"Branch update for column name",null);
    }
}
