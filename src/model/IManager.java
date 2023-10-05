package model;

import java.util.List;

public interface IManager<E> {
    void add(E e);
    void edit(int id , E e);
    void remove(int id);
    E findById(int id);
    public List<E> findAll();
    public List<E> findByName(String name);
    public List<E> findByType(String type);
}
