package gt.walterkstro.model;

public class Product extends BaseComon{
    private String name;
    private String description;
    private double price;

    public Product(String name, String description, double price) {
        super();
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Product{");
        sb.append("id=").append(id);
        sb.append(", description='").append(name).append('\'').
                append(", description='").append(description).append('\'').
                append(", price='").append(price).append('\'')
                .append('}');
        return sb.toString();
    }
}
