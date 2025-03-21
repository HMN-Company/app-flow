package org.example.flow.services;

import java.util.Collection;

public interface BaseService<T> {
    void save(T entity);
    void update(T entity);
    void delete(T entity);
    T get(Long id);
    Collection<T> getAll();
}
