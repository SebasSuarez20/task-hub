
package com.sales.franchise.domain.Exception;

public class BranchNotFoundException extends RuntimeException {

    public BranchNotFoundException(Long id) {
        super("Branch not found with id: " + id);
    }

    public BranchNotFoundException(String message) {
        super(message);
    }
}