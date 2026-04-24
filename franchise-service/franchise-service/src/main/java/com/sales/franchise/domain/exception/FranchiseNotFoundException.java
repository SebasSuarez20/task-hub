
package com.sales.franchise.domain.Exception;

public class FranchiseNotFoundException extends RuntimeException {

    public FranchiseNotFoundException(Long id) {
        super("Franchise not found with id: " + id);
    }

    public FranchiseNotFoundException(String message) {
        super(message);
    }
}