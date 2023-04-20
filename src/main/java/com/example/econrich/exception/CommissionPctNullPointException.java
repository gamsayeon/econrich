package com.example.econrich.exception;

public class CommissionPctNullPointException extends RuntimeException {
    public CommissionPctNullPointException() {
        super("Could not find Department Commission_pct");
    }

}
