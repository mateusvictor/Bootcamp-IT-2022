package br.com.meli.usingdtos.services;

import br.com.meli.usingdtos.dtos.PersonDTO;

import java.util.List;

public interface CRUD<T>{
    T create(T t);
}
