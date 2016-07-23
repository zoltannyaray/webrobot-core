package com.dayswideawake.webrobot.core.model;

public class EmailAddress {

    private String value;

    public EmailAddress(String value) {
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
            EmailAddress email = (EmailAddress) obj;
            if (value.equals(email.value)) {
                result = true;
            }
        }
        return result;
    }
    
    
    
}
