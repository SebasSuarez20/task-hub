package com.sales.franchise.application.usecase;

import com.sales.franchise.application.dto.ApiResponseDTO;
import com.sales.franchise.application.dto.FranchiseResponseDTO;
import com.sales.franchise.domain.exception.FranchiseNotFoundException;
import com.sales.franchise.domain.model.Franchise;
import com.sales.franchise.domain.port.FranchiseRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FranchiseUseCaseTest {

    @Mock
    private FranchiseRepositoryPort franchiseRepository;

    @InjectMocks
    private FranchiseUseCase franchiseUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveFranchiseSuccessfully() {
        FranchiseResponseDTO request = new FranchiseResponseDTO(1L, "Franchise 1", "Description 1");
        Franchise franchise = new Franchise();
        franchise.setIdFranchise(1L);
        franchise.setName("Franchise 1");
        franchise.setDescription("Description 1");

        when(franchiseRepository.save(any(Franchise.class))).thenReturn(franchise);

        ApiResponseDTO<FranchiseResponseDTO> response = franchiseUseCase.save(request);

        assertTrue(response.isSuccess());
        assertEquals("Franchise 1", response.getData().name());
        verify(franchiseRepository, times(1)).save(any(Franchise.class));
    }

    @Test
    void saveFranchiseWithNullRequestThrowsException() {
        assertThrows(FranchiseNotFoundException.class, () -> franchiseUseCase.save(null));
    }

    @Test
    void updateFranchiseWithInvalidNameThrowsException() {
        FranchiseResponseDTO request = new FranchiseResponseDTO(1L, "", "Description 1");

        assertThrows(FranchiseNotFoundException.class, () -> franchiseUseCase.updateFranchiseForName(request));
    }
}