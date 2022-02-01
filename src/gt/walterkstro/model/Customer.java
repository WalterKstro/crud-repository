package gt.walterkstro.model;

import java.util.Objects;

public class Customer {
    private int id;
    private String first;
    private String last;
    public static int counter = 0;

    public Customer(String first, String last) {
        this();
        this.first = first;
        this.last = last;
    }

    public Customer() {
        this.id = Customer.counter++;
    }

    public Customer(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Customer{");
        sb.append("id=").append(id);
        sb.append(", first='").append(first).append('\'');
        sb.append(", last='").append(last).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
