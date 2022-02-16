package gt.walterkstro.model;

import java.util.Objects;

public class BaseComon {
    protected int id;
    public static int counter = 0;

    public BaseComon() {
        this.id = BaseComon.counter++;
    }
    public int getId() {
        return id;
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
