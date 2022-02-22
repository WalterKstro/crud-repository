package gt.walterkstro.implementations;

import gt.walterkstro.exceptions.DuplicateException;
import gt.walterkstro.exceptions.ReadException;
import gt.walterkstro.exceptions.WriteException;
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
    public T getById(T t) throws ReadException {
        if(t == null){
            throw new ReadException("The object is null");
        }
        T elementToFind = dataSourceCustomers.stream()
                .filter(elementFinded -> elementFinded.getId() == t.getId())
                .findFirst()
                .orElse(null);

        if(elementToFind == null){
            throw new ReadException("The object is not found");
        }
        return elementToFind;
    }

    @Override
    public List<T> getAll() {
        return this.dataSourceCustomers;
    }

    @Override
    public void addNew(T t) throws WriteException {
        if(t == null) {
            throw new WriteException("The object isn't null");
        }
        boolean foundedT = this.dataSourceCustomers.contains(t);
        if(foundedT){
            throw new DuplicateException("The object with id: " +t.getId()+ " is already in the list");
        }
        dataSourceCustomers.add(t);
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
