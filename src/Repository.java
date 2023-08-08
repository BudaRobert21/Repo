

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Repository extends Validator {
    private ArrayList<Book> books;
    private Validator validator;
    private String filename;

    public Repository(String filename) {
        this.filename = filename;
        books = new ArrayList<>(addBook());


    }

    public List<Book> getAll() {
        return books;


    }

    public List<Book> addBook() {
        books = new ArrayList<>();
        Path pathToFile = Paths.get(this.filename);
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {

                String[] attributes = line.split(",");
                try {

                    Book book = new Book(attributes[0], attributes[1], Integer.valueOf(attributes[2]), attributes[3], attributes[4], Boolean.valueOf(attributes[5]));
                    validator(book);
                    books.add(book);

                } catch (Exception e) {

                    System.out.println("I caught: " + e);

                }

                line = br.readLine();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return books;
    }


    public List<Book> sort_by(String symbol) {

        if (symbol.equals("author")) {

            books.sort(Comparator.comparing(Book::getAuthor));
        } else if (symbol == "title") {

            books.sort(Comparator.comparing(Book::getTitle));
        }
        //for(int i=0;i<books.size()-1;i++)
        //{
        /*for(int j=i+1;j<books.size();j++)
        {
            if(String.valueOf(books.get(i).getAuthor()) > String.valueOf(books.get(j).getAuthor()))
            if(books.get(i).getAuthor().compareTo(books.get(j).getAuthor()))
                Collections.swap(books,i,j);


        }*/


        //}

        //   }

        return books;
    }

}
