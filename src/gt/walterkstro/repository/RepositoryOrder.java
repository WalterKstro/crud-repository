package gt.walterkstro.repository;

import gt.walterkstro.model.Customer;

import java.util.List;

public interface RepositoryOrder<T> {
    List<T> getAll(String orderByField, Order typeOrder);
}
