package com.sales.franchise.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "franchises")
public class Franchise extends BaseEntity{

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id_franchise")
    private Long idFranchise;
    @Column(nullable = false,unique = true)
    private String name;
    private String description;

    public Long getIdFranchise() {
        return idFranchise;
    }

    public void setIdFranchise(Long idFranchise) {
        this.idFranchise = idFranchise;
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
}