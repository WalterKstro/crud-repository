package gt.walterkstro.repository;


import gt.walterkstro.exceptions.GeneralException;

import java.util.List;

public interface RepositoryInterface <T> {
    List<T> getAll();
    T getById(T t) throws GeneralException;
    void addNew(T t) throws GeneralException;
    void update(T t) throws GeneralException;
    void delete(int id) throws GeneralException;
}
