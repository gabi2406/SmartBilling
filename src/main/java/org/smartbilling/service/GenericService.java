package org.smartbilling.service;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class GenericService <T, ID>{
    protected final JpaRepository<T,ID> repository;

    public GenericService(JpaRepository <T,ID> repository){
        this.repository = repository;
    }

    public List<T> findAll(){
        return repository.findAll();
    }

    public T findById(ID id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public T update(T entity) {
        return repository.save(entity);
    }

    public void delete(T entity) {
        repository.delete(entity);
    }

}
