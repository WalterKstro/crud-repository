package gt.walterkstro.implementations;

import gt.walterkstro.model.Product;
import gt.walterkstro.repository.Order;

import java.util.ArrayList;
import java.util.List;

public class ProductImplementation extends AbstractImplementation<Product>{

    @Override
    public void update(Product product) {
        Product result = getById(product);

        if(result != null) {
            result.setName(product.getName());
            result.setPrice(product.getPrice());
            result.setDescription(product.getDescription());
        }
    }

    @Override
    public void delete(int id) {
        dataSourceCustomers.removeIf(product -> product.getId() == id);
    }

    @Override
    public List<Product> getAll(String orderByField, Order typeOrder) {
        List<Product> productOrdered = new ArrayList<>(dataSourceCustomers);

        productOrdered.sort((productOne, productTwo)->{
            int result = 0;
            if(typeOrder == Order.ASC) {
                result = OrderingNow(orderByField, productOne, productTwo);
            }else if (typeOrder == Order.DESC) {
                result = OrderingNow(orderByField, productTwo, productOne);
            }
            return result;
        });
        return productOrdered;
    }

    private int OrderingNow(String orderByField, Product productOne, Product productTwo) {
        int result = 0;
        switch (orderByField) {
            case "id"-> result = productOne.getId() - productTwo.getId();
            case "name"-> result = productOne.getName().compareTo(productTwo.getName());
            case "price"-> result = (int) (productOne.getPrice() - productTwo.getPrice());
            case "description"-> result = productOne.getDescription().compareTo(productTwo.getDescription());
        }
        return result;
    }
}
