package com.julioluis.churchadmin.enums;

public enum StatusEnum {
    ACTIVE(1L),INACTIVE(0L);

    StatusEnum(Long status) {
        this.status=status;
    }

    private Long status;

    public Long getStatus() {
        return status;
    }
}
