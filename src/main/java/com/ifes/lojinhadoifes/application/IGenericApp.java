package com.ifes.lojinhadoifes.application;

import com.ifes.lojinhadoifes.exception.NotFoundException;

import java.io.IOException;
import java.util.List;

public interface IGenericApp<T>  {
    List<T> getAll() throws IOException ;
    T create(T entity) throws IOException ;
    T getById(long id) throws IOException, NotFoundException;
    void deleteById(long id) throws IOException;
}
