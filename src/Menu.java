import java.nio.file.LinkPermission;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Menu {


    private Service service;

    private List<User> Users = new ArrayList<>();

    private User logUser;
    private Scanner scanner = new Scanner(System.in);

    public Menu(Service service) {
        this.service = service;

        mainMenu();
    }

    public void userMenu(User logUser) {


        String choiceUser = "";
        while (true) {
            System.out.println("1.Show Books Borrowed\n" +
                    "2.Borrow Book\n" +
                    "3.Return Book\n" +
                    "4.Exit User Menu\n");
            try {
                choiceUser = scanner.next();
                switch (choiceUser) {

                    case "1":
                        System.out.println(logUser + "...: ");
                        for (Book book : logUser.getAllBorrowed())
                            System.out.println(book);
                        break;

                    case "2":
                        String bookToBorrow = scanner.next();
                        for (Book book : service.getAllService())
                            if (Objects.equals(book.getTitle(), bookToBorrow)) {
                                try {
                                    logUser.addBorrowed(book);
                                    break;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }

                            }

                        break;
                    case "3":
                        String bookToReturn = scanner.next();
                        for (Book book : logUser.getAllBorrowed())
                            if (Objects.equals(book.getTitle(), bookToReturn)/*&& book.getReturned()*/) {
                                try {
                                    logUser.returnBorrowed(book);
                                    break;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }

                            }
//                        try{
//                            throw new RuntimeException("Nu s-a gasit cartea de returnat in imprumuturi");
//                        }
//                        catch(Exception e){
//                            System.out.println(e);
//                        }
                        break;
                    case "4":
                        return;
                }

            } catch (Exception e) {
                System.out.println("Oops! Something went wrong. ");


            }
        }
    }

    public void mainMenu() {

        String choice = "";
        while (true) {
            System.out.println("1.Show Books\n" +
                    "2.Sort Books by author\n" +
                    "3.Sort Books by title\n" +
                    "4.Show all borrowed books\n" +
                    "5.Return book\n" +
                    "6.Create User\n" +
                    "7.Choose User\n" +
                    "8.Show Users\n");

            try {
                choice = scanner.next();
                switch (choice) {

                    case "1":
                        int count = 0;
                        for (Book book : service.getAllService()) {
                            count++;

                            System.out.println(book);
                        }
                        System.out.println(count);
                        break;
                    case "2":
                        System.out.println("Sortare dupa: \n" +
                                "Titlu-> 1\n" +
                                "Autor-> 2\n");
                        String choice2 = scanner.next();
                        switch (choice2) {
                            case "1":
                                for (Book book : service.sort_byService("title")) {
                                    System.out.println(book);
                                }
                                break;

                            case "2":
                                for (Book book : service.sort_byService("author")) {
                                    System.out.println(book);
                                }
                                break;


                        }
                        break;

                    case "3":
                        break;
                    case "4":
                        break;


                    case "5":
                        break;

                    case "6":
                        System.out.println("Add an User: \n");
                        String userName = scanner.next();

                        User user = new User(userName);
                        for (User user1 : Users)
                            if (user1.getName().equals(user.getName()))
                                break;
                        System.out.println("The User has been created successfully\n");
                        Users.add(user);
                        break;
                    case "7":

                        System.out.println("\n");
                        showUsers();
                        String userChoose = scanner.next();
                        for (User user1 : Users) {
                            if (userChoose.equals(user1.getName())) {
                                this.logUser = user1;
                                break;
                            }

                        }
                        System.out.println(logUser + "`s" + "Menu" + "\n");
                        userMenu(this.logUser);
                        break;
                    case "8":
                        showUsers();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Oops! Something went wrong. ");
            }


        }


    }

    public void showUsers() {
        System.out.println("\n");
        System.out.println("The list of Users: ");

        for (User user : Users)
            System.out.println(user.getName());
        System.out.println("\n");
    }

}







