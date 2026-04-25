package com.sales.franchise.application.usecase;

import com.sales.franchise.application.dto.ApiResponseDTO;
import com.sales.franchise.application.dto.BranchResponseDTO;
import com.sales.franchise.domain.exception.BranchNotFoundException;
import com.sales.franchise.domain.model.Branch;
import com.sales.franchise.domain.model.Franchise;
import com.sales.franchise.domain.port.BranchRepositoryPort;
import com.sales.franchise.domain.port.FranchiseRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BranchUseCaseTest {

    @Mock
    private BranchRepositoryPort branchRepository;

    @Mock
    private FranchiseRepositoryPort franchiseRepository;

    @InjectMocks
    private BranchUseCase branchUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveBranchSuccessfully() {
        BranchResponseDTO request = new BranchResponseDTO(1L, "Branch 1", "Address 1", 1L);
        Branch branch = new Branch();
        branch.setIdBranch(1L);
        branch.setName("Branch 1");
        branch.setAddress("Address 1");
        Franchise franchise = new Franchise();
        franchise.setIdFranchise(1L);
        branch.setFranchise(franchise);

        when(branchRepository.save(any(Branch.class))).thenReturn(branch);

        ApiResponseDTO<BranchResponseDTO> response = branchUseCase.save(request);

        assertTrue(response.isSuccess());
        assertEquals("Branch 1", response.getData().name());
        verify(branchRepository, times(1)).save(any(Branch.class));
    }

    @Test
    void saveBranchWithNullRequestThrowsException() {
        assertThrows(BranchNotFoundException.class, () -> branchUseCase.save(null));
    }

    @Test
    void saveBranchWithInvalidFranchiseThrowsException() {
        BranchResponseDTO request = new BranchResponseDTO(1L, "Branch 1", "Address 1", null);

        assertThrows(BranchNotFoundException.class, () -> branchUseCase.save(request));
    }
}