package gt.walterkstro.model;

import java.util.Objects;

public class Customer extends BaseComon{
    private String first;
    private String last;

    public Customer(String first, String last) {
        super();
        this.first = first;
        this.last = last;
    }

    public Customer(int id) {
        this.id = id;
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
        sb.append("id=")
                .append(id).
                append(", first='").append(first).append('\'').
                append(", last='").append(last).append('\'').
                append('}');
        return sb.toString();
    }
}
