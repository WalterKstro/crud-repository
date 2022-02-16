package gt.walterkstro.repository;


import java.util.List;

public interface RepositoryInterface <T> {
    List<T> getAll();
    T getById(T t);
    void addNew(T t);
    void update(T t);
    void delete(int id);
}
