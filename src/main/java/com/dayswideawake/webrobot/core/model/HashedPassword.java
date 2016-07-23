package com.dayswideawake.webrobot.core.model;

public class HashedPassword {

    private String value;

    public HashedPassword(String value) {
        if (value == null) {
            throw new IllegalArgumentException("value should not be null");
        }
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj == this) {
            result = true;
        } else if (obj != null && getClass() == obj.getClass()) {
            HashedPassword hashedPassword = (HashedPassword) obj;
            if (value.equals(hashedPassword.value)) {
                result = true;
            }
        }
        return result;
    }
    
}
