package gt.walterkstro.repository;

import gt.walterkstro.model.Customer;

import java.util.List;

public interface RepositoryOrder {
    List<Customer> getAll(String orderByField, Order typeOrder);
}
