package gt.walterkstro.main;

import gt.walterkstro.implementations.CustomerImplementation;
import gt.walterkstro.model.Customer;
import gt.walterkstro.repository.*;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Walter","Castro");
        Customer customer2 = new Customer("Juan","Perez");
        Customer customer3 = new Customer("Anna","Morales");
        Customer customer4 = new Customer("Jenifer","Gonzalez");

        RootInterface customerImplementation = new CustomerImplementation();
        customerImplementation.newCustomer(customer1);
        customerImplementation.newCustomer(customer2);
        customerImplementation.newCustomer(customer3);
        customerImplementation.newCustomer(customer4);


        System.out.println("\nAll customers:");
        customerImplementation.getAll().forEach(System.out::println);

        System.out.println("\nPaginacion");
        customerImplementation.getAll(1,3).forEach(System.out::println);

        System.out.println("\nCustomer by id:");
        customerImplementation.getAll("last",Order.DESC).forEach(System.out::println);

        System.out.println("Total customers: "+ customerImplementation.countCustomers());
    }
}
