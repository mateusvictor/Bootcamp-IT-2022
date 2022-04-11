package br.meli.movies_db_orm.service;

import java.util.List;

public interface IService<T, U>{
    List<T> findAll();
    T findById(U id);
    T create(T t);
    T updateById(U id, T t);
    void deleteById(U id);
}
