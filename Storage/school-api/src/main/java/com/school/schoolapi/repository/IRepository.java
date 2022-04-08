package com.school.schoolapi.repository;

import java.util.List;

public interface IRepository<U extends Number, T> {
    List<T> findAll();
    T findById(U id);
    T insert(T t);
}
