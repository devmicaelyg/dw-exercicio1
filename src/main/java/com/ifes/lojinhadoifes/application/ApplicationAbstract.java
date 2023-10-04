package com.ifes.lojinhadoifes.application;

import com.ifes.lojinhadoifes.exception.NotFoundException;
import com.ifes.lojinhadoifes.repository.IGenericRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

public class ApplicationAbstract <T,W extends IGenericRepository<T,Long>> implements IGenericApp<T>{

    @Autowired
    W repository;

    @Override
    public List<T> getAll() throws IOException {
        return repository.findAll();
    }

    @Override
    public T create(T entity) throws IOException {
        return repository.save(entity);
    }

    @Override
    public T getById(long id) throws IOException, NotFoundException {
        return repository.getById(id);
    }

    @Override
    public void deleteById(long id) throws IOException {
        repository.deleteById(id);
    }
}
