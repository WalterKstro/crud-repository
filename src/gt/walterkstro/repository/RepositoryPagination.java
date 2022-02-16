package gt.walterkstro.repository;

import gt.walterkstro.model.Customer;

import java.util.List;

public interface RepositoryPagination<T> {
    List<T> getAll(int startPagination, int endPagination);
}
