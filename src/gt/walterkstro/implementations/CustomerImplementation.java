package gt.walterkstro.implementations;

import gt.walterkstro.model.Customer;
import gt.walterkstro.repository.*;

import java.util.ArrayList;
import java.util.List;

public class CustomerImplementation implements RootInterface {
    List<Customer> dataSourceCustomers;

    public CustomerImplementation() {
        this.dataSourceCustomers = new ArrayList<>();
    }

    @Override
    public List<Customer> getAll() {
        return this.dataSourceCustomers;
    }

    @Override
    public Customer getById(Customer customerToFind) {
        Customer customerById = dataSourceCustomers.stream()
                .filter(customer -> customer.getId() == customerToFind.getId())
                .findFirst()
                .orElse(null);
        return customerById;
    }

    @Override
    public void newCustomer(Customer customer) {
        if(customer != null) {
            dataSourceCustomers.add(customer);
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        Customer result = getById(customer);

        if(result != null) {
            result.setFirst(customer.getFirst());
            result.setLast(customer.getLast());
        }
    }

    @Override
    public void deleteCustomer(int id) {
        dataSourceCustomers.removeIf(customer -> customer.getId() == id);
    }

    @Override
    public List<Customer> getAll(String orderByField, Order typeOrder) {
        List<Customer> customersOrdered = new ArrayList<>(dataSourceCustomers);
        customersOrdered.sort((customerOne, customerTwo)->{
            int result = 0;
            if(typeOrder == Order.ASC) {
                result = OrderingNow(orderByField, customerOne, customerTwo);
            }else if (typeOrder == Order.DESC) {
                result = OrderingNow(orderByField, customerTwo, customerOne);
            }
            return result;
        });
        return customersOrdered;
    }

    private int OrderingNow(String orderByField,Customer customerOne, Customer customerTwo) {
        int result = 0;
        switch (orderByField) {
            case "id"-> result = customerOne.getId() - customerTwo.getId();
            case "first"-> result = customerOne.getFirst().compareTo(customerTwo.getFirst());
            case "last"-> result = customerOne.getLast().compareTo(customerTwo.getLast());
        }
        return result;
    }

    @Override
    public List<Customer> getAll(int startPagination, int endPagination) {
        return dataSourceCustomers.subList(startPagination, endPagination);
    }


    @Override
    public int countCustomers() {
        return dataSourceCustomers.size();
    }
}
