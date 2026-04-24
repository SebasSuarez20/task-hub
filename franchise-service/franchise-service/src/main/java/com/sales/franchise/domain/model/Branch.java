
package com.sales.franchise.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.util.List;

@Entity
@Table(
    name = "branch",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "idFranchise"})
    }
)
public class Branch extends BaseEntity{

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBranch;
     
    @Column(nullable = false)
    private String name;
    
    private String address;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_franchise", nullable = false)
    private Franchise franchise;

    @OneToMany(mappedBy = "branch", fetch = FetchType.LAZY)
     private List<Product> products;
    
       public Long getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(Long IdBranch) {
        this.idBranch = IdBranch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Franchise getFranchise() {
        return franchise;
    }

    public void setFranchise(Franchise franchise) {
        this.franchise = franchise;
    }
    
       public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
}
