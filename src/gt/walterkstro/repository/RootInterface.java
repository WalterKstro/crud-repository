package gt.walterkstro.repository;

public interface RootInterface<T> extends
        RepositoryInterface<T>,
        RepositoryOrder<T>,
        RepositoryCountCustomers,
        RepositoryPagination<T> {
}
