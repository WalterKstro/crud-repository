package gt.walterkstro.repository;

import gt.walterkstro.model.Customer;

import java.util.List;

public interface RepositoryInterface {
    List<Customer> getAll();
    Customer getById(Customer customer);
    void newCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int id);
}
