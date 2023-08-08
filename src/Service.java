import java.util.List;

public class Service {
    private Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public List<Book> getAllService() {

        return repository.getAll();

    }

    public List<Book> sort_byService(String symbol) {

        return repository.sort_by(symbol);

    }


}
