package org.smartbilling.controller;

import org.smartbilling.service.GenericService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class GenericController <T,ID> {
    protected final GenericService <T,ID> service;
    public GenericController(GenericService <T,ID> service){
        this.service = service;
    }

    public List<T> getAll(){
        return service.findAll();
    }

    public T getById(@PathVariable ID id){
        return service.findById(id);
    }

    public T create(T entity) {
        return service.save(entity);
    }
}
