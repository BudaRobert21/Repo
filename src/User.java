import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;

    private List<Book> borrowed;

    private Repository repository;


    public User(String name) {
        this.name = name;
        this.borrowed = new ArrayList<>();

    }

    public List<Book> getAllBorrowed() {
        return this.borrowed;


    }

    public void addBorrowed(Book book) {

        /*for(Book bookx:repository.getAll()) {
            if(bookx.getTitle()==book&&bookx.getReturned()==false) {
*/
        if (book.getReturned() == true)
            throw new RuntimeException("Cartea este deja imprumutata");
        book.setReturned(true);
        borrowed.add(book);
        System.out.println("Cartea a fost imprumutata ");

        //}

    }


    public void returnBorrowed(Book book) {
        //for(Book bookx:borrowed) {
        //  if(bookx.getTitle()==book&&bookx.getReturned()==true) {
        if (!book.getReturned())
            throw new RuntimeException("\"Nu s-a gasit cartea de returnat in imprumuturi\"");
        book.setReturned(false);
        borrowed.remove(book);
        System.out.println("Cartea a fost returnata ");
        //}

    }


    public String getName() {
        return this.name;
    }

}
