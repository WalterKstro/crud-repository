package gt.walterkstro.repository;

import gt.walterkstro.model.Customer;

import java.util.List;

public interface RepositoryPagination {
    List<Customer> getAll(int startPagination, int endPagination);
}
