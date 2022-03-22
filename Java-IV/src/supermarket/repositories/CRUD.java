package supermarket.repositories;

import java.util.List;

public interface CRUD<T>{
    T create(T t);
    T read(Integer id);
    List<T> readAll();
    void delete(Integer id);
}
