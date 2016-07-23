package com.dayswideawake.webrobot.core.model;

public class PlainPassword {

    private String value;

    public PlainPassword(String value) {
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
            PlainPassword plainPassword = (PlainPassword) obj;
            if (value.equals(plainPassword.value)) {
                result = true;
            }
        }
        return result;
    }

}
