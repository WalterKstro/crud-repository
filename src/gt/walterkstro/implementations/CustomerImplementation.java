package gt.walterkstro.implementations;

import gt.walterkstro.exceptions.ReadException;
import gt.walterkstro.exceptions.WriteException;
import gt.walterkstro.model.Customer;
import gt.walterkstro.repository.Order;

import java.util.ArrayList;
import java.util.List;


public class CustomerImplementation extends AbstractImplementation<Customer>{

    @Override
    public void update(Customer customer) throws ReadException {
        Customer result = getById(customer);

        if(result != null) {
            result.setFirst(customer.getFirst());
            result.setLast(customer.getLast());
        }
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

    private int OrderingNow(String orderByField, Customer customerOne, Customer customerTwo) {
        int result = 0;
        switch (orderByField) {
            case "id"-> result = customerOne.getId() - customerTwo.getId();
            case "first"-> result = customerOne.getFirst().compareTo(customerTwo.getFirst());
            case "last"-> result = customerOne.getLast().compareTo(customerTwo.getLast());
        }
        return result;
    }

    @Override
    public void delete(int id) throws WriteException{
        boolean isRemoved = dataSourceCustomers.removeIf(customer -> customer.getId() == id);
        if(!isRemoved) {
            throw new WriteException("Customer with id " + id + " not found");
        }
    }

}
