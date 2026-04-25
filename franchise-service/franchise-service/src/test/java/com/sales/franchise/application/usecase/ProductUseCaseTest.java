package com.sales.franchise.application.usecase;

import com.sales.franchise.application.dto.ApiResponseDTO;
import com.sales.franchise.application.dto.ProductResponseDTO;
import com.sales.franchise.domain.exception.ProductNotFoundException;
import com.sales.franchise.domain.model.Branch;
import com.sales.franchise.domain.model.Product;
import com.sales.franchise.domain.port.BranchRepositoryPort;
import com.sales.franchise.domain.port.ProductRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;

class ProductUseCaseTest {

    @Mock
    private ProductRepositoryPort productRepository;

    @Mock
    private BranchRepositoryPort branchRepository;

    @InjectMocks
    private ProductUseCase productUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveProductSuccessfully() {
        ProductResponseDTO request = new ProductResponseDTO(1L, "Product 1", "Description 1", new BigDecimal("100.0"), 10, 1L);
        Product product = new Product();
        product.setIdProduct(1L);
        product.setName("Product 1");
        product.setDescription("Description 1");
        product.setPrice(new BigDecimal("100.0"));
        product.setStock(10);
        Branch branch = new Branch();
        branch.setIdBranch(1L);
        product.setBranch(branch);

        when(productRepository.save(any(Product.class))).thenReturn(product);

        ApiResponseDTO<ProductResponseDTO> response = productUseCase.save(request);

        assertTrue(response.isSuccess());
        assertEquals("Product 1", response.getData().name());
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    void saveProductWithNullRequestThrowsException() {
        assertThrows(ProductNotFoundException.class, () -> productUseCase.save(null));
    }

    @Test
    void saveProductWithInvalidBranchThrowsException() {
        ProductResponseDTO request = new ProductResponseDTO(1L, "Product 1", "Description 1", new BigDecimal("100.0"), 10, null);

        assertThrows(ProductNotFoundException.class, () -> productUseCase.save(request));
    }
}