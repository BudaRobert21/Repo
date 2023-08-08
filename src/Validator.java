public class Validator {


    public void validator(Book book) {
        String errors = "";
        if (book.getAuthor() == "")
            errors = errors + "The author must be a valid name\n";

        try {
            Integer.parseInt(book.getTitle());
            /* assert false*/
            ;
            errors = errors + "The author must be a valid name not a number\n";

        } catch (NumberFormatException f) {
            
        }
        /*catch (NumberFormatException f){

        }*/

        if (book.getTitle() == "")
            errors = errors + "The title must have a valid name\n";

        if (book.getNumberPages() < 0)
            errors = errors + "The number of pages must be valid\n";


        if (errors != "")
            throw new RuntimeException(errors);

    }
}
