package gt.walterkstro.main;

import gt.walterkstro.implementations.CustomerImplementation;
import gt.walterkstro.implementations.ProductImplementation;
import gt.walterkstro.model.Customer;
import gt.walterkstro.model.Product;
import gt.walterkstro.repository.Order;
import gt.walterkstro.repository.RootInterface;

public class Main {
    public static void main(String[] args) {

        RootInterface customerImplementation = new CustomerImplementation();
        RootInterface productImplementation = new ProductImplementation();
        Product product = new Product("Proyector", "BENQ Blanco", 10.0);

        customerImplementation.addNew(new Customer("Walter","Castro"));
        customerImplementation.addNew(new Customer("Juan","Perez"));
        customerImplementation.addNew(new Customer("Anna","Morales"));
        customerImplementation.addNew(new Customer("Jenifer","Gonzalez"));

        productImplementation.addNew(new Product("Monitor","LET Samsung",12000));
        productImplementation.addNew(new Product("Teclado","Logitech",3000));
        productImplementation.addNew(new Product("Mouse","Logitech",3000));
        productImplementation.addNew(new Product("Impresora","HP",5000));
        productImplementation.addNew(product);


        System.out.println("\nAll customers:");
        customerImplementation.getAll().forEach(System.out::println);

        System.out.println("\nPaginacion");
        customerImplementation.getAll(1,3).forEach(System.out::println);

        System.out.println("\nCustomer by id:");
        customerImplementation.getAll("id", Order.DESC).forEach(System.out::println);

        System.out.println("Total customers: "+ customerImplementation.countCustomers());


        System.out.println("\nAll products:");
        productImplementation.getAll().forEach(System.out::println);

        System.out.println("\nPaginacion");
        productImplementation.getAll(1,3).forEach(System.out::println);


        product.setDescription("BENQ Blanco Inalambrico");
        productImplementation.update(product);

        System.out.println("\nOrder Product:");
        productImplementation.getAll("price", Order.ASC).forEach(System.out::println);

        System.out.println("Total products: "+ customerImplementation.countCustomers());

    }
}
