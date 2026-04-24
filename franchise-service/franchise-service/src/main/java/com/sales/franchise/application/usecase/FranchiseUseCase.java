    
package com.sales.franchise.application.usecase;

import com.sales.franchise.application.dto.ApiResponseDTO;
import com.sales.franchise.application.dto.FranchiseResponseDTO;
import com.sales.franchise.domain.Exception.FranchiseNotFoundException;
import com.sales.franchise.domain.model.Franchise;
import com.sales.franchise.domain.port.FranchiseRepositoryPort;
import java.util.Optional;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FranchiseUseCase {
    
    private final FranchiseRepositoryPort repository;
 
    private Franchise toEntity(FranchiseResponseDTO req) {
        Franchise model = new Franchise();
        model.setName(req.name());
        if (req.description() != null) {
            model.setDescription(req.description());
        }
        return model;
    }
    
    private ApiResponseDTO<FranchiseResponseDTO> toResponse(Franchise saved) {
        var response = new ApiResponseDTO<>(true,"Sucess information to Franchise",new FranchiseResponseDTO(saved.getName(),saved.getDescription()));
        return response;
    }
 
    public ApiResponseDTO<FranchiseResponseDTO> save(FranchiseResponseDTO request) {
         if(request == null) throw new FranchiseNotFoundException ("Error: modelFranchise not incompatible");
        return Optional.of(request)
            .map(this::toEntity)
            .map(repository::save)
            .map(this::toResponse)
            .orElseThrow(() -> new FranchiseNotFoundException("Error creating franchise"));
    }
    
    public ApiResponseDTO<Void> updateFranchiseForName(Long id,String name){
        
        if(name.isBlank()) throw new FranchiseNotFoundException("Params name not valid");
        
        repository.GetAllFranchiseForId(id)
                  .map(s -> {
                      s.setName(name);
                     return s;
                    })
                   .map(repository::save)
                   .orElseThrow(() -> new FranchiseNotFoundException("Error updated franchise"));
        
        return new ApiResponseDTO<>(true,"Update sucess Franchise",null);
    }
}
