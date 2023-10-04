package com.ifes.lojinhadoifes.application.generic;

import com.ifes.lojinhadoifes.exception.NotFoundException;
import com.ifes.lojinhadoifes.repository.generic.IGenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Component
public class ApplicationAbstract <T, W extends IGenericRepository<T>> implements IGenericApp<T> {

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
