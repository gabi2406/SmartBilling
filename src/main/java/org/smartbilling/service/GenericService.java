package org.smartbilling.service;

import java.util.List;

import org.smartbilling.repository.ProvinceRepository;
import org.smartbilling.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public class GenericService <T, ID>{
    protected final JpaRepository<T,ID> repository;

    public GenericService(JpaRepository <T,ID> repository){
        this.repository = repository;
    }

    public List<T> findAll(){
        return repository.findAll();
    }

    public T findById(ID id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entity not found"));
    }

    public T save(T entity) {
        return repository.save(entity);
    }
}
