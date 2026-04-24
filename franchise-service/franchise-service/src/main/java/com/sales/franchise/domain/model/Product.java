
package com.sales.franchise.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product extends BaseEntity{

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdProduct;
    
    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false,precision = 10,scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer stock;

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
    
     @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idBranch", nullable = false)
    private Branch branch;

    public Long getIdProduct() {
        return IdProduct;
    }

    public void setIdProduct(Long IdProduct) {
        this.IdProduct = IdProduct;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
      public Integer getStock() {
        return stock;
    }

    public void setStock(Integer Stock) {
        this.stock = Stock;
    }
    
}
