public class Book {
    private String title;
    private String author;
    private String edition;
    private String typeBook;

    private int numberPages;

    private Boolean returned;

    public Book() {
        this.title = "";
        this.author = "";
        this.numberPages = 0;
        this.edition = "";
        this.typeBook = "";
        this.returned = false;
    }

    public Book(String title, String author, int numberPages, String edition, String typeBook, Boolean returned) {
        this.title = title;
        this.author = author;
        this.numberPages = numberPages;
        this.edition = edition;
        this.typeBook = typeBook;
        this.returned = returned;


    }

    public void setReturned(Boolean bool) {
        this.returned = bool;

    }

    public boolean getReturned() {
        return this.returned;

    }

    public String getTitle() {
        return this.title;

    }

    public String getAuthor() {
        return this.author;

    }

    public int getNumberPages() {
        return this.numberPages;

    }

    public String getEdition() {
        return this.edition;

    }

    public String getTypeBook() {
        return this.typeBook;

    }

    public String toString() {
        return "Book " + "\n" + "Title: " + this.title + " " +
                "Author: " + this.author + " " +
                "Number of pages: " + this.numberPages + " " +
                "Edition: " + this.edition + " " +
                "Type of Book: " + this.typeBook + "\n";


    }


}
