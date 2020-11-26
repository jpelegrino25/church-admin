package com.julioluis.churchadmin.dto;

public class RequestDto<T> {

    private T entity;

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }
}
