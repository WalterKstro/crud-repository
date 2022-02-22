package gt.walterkstro.main;

import gt.walterkstro.exceptions.DuplicateException;
import gt.walterkstro.exceptions.GeneralException;
import gt.walterkstro.exceptions.ReadException;
import gt.walterkstro.exceptions.WriteException;
import gt.walterkstro.implementations.CustomerImplementation;
import gt.walterkstro.model.Customer;
import gt.walterkstro.repository.Order;
import gt.walterkstro.repository.RootInterface;

public class Main {
    public static void main(String[] args) {

        RootInterface customerImplementation = new CustomerImplementation();
        try {

            Customer findUser = new Customer(2);

            customerImplementation.addNew(new Customer("Walter", "Kstro"));
            customerImplementation.addNew(new Customer("Juan", "Perez"));
            customerImplementation.addNew(new Customer("Anna", "Morales"));
            customerImplementation.addNew(new Customer("Jenifer", "Gonzalez"));
            customerImplementation.addNew(findUser);
            customerImplementation.addNew(findUser);


            // Delete one customer
            customerImplementation.delete(30);

            System.out.println("\nAll customers:");
            customerImplementation.getAll().forEach(System.out::println);

            System.out.println("\nFind One Customer:");
            System.out.println(customerImplementation.getById(findUser));

            System.out.println("\nPaginacion");
            customerImplementation.getAll(1, 3).forEach(System.out::println);

            System.out.println("\nOrder Customer by id:");
            customerImplementation.getAll("id", Order.DESC).forEach(System.out::println);

            System.out.println("Total customers: " + customerImplementation.countCustomers());

        }catch (ReadException | WriteException customException){
            System.out.println("Error: " + customException.getMessage());
            customException.printStackTrace();
        } catch (GeneralException general){
            System.out.println("Error: " + general.getMessage());
            general.printStackTrace();
        }
    }
}
