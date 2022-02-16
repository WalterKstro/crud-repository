package gt.walterkstro.implementations;

import gt.walterkstro.model.BaseComon;
import gt.walterkstro.repository.*;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractImplementation<T extends BaseComon> implements RootInterface<T> {
    protected List<T> dataSourceCustomers;

    public AbstractImplementation() {
        this.dataSourceCustomers = new ArrayList<>();
    }

    @Override
    public T getById(T t) {
        T elementToFind = dataSourceCustomers.stream()
                .filter(elementFinded -> elementFinded.getId() == t.getId())
                .findFirst()
                .orElse(null);
        return elementToFind;
    }

    @Override
    public List<T> getAll() {
        return this.dataSourceCustomers;
    }

    @Override
    public void addNew(T t) {
        if(t != null) {
            dataSourceCustomers.add(t);
        }
    }

    @Override
    public List<T> getAll(int startPagination, int endPagination) {
        return dataSourceCustomers.subList(startPagination, endPagination);
    }


    @Override
    public int countCustomers() {
        return dataSourceCustomers.size();
    }
}
