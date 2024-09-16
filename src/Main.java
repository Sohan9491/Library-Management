import Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name");
        String customerName = scanner.nextLine();
        System.out.println("Enter your ID");
        int customerId = scanner.nextInt();
        System.out.println("Enter your email");
        scanner.nextLine();
        String email = scanner.nextLine();
        System.out.println("Enter your phone number");
        Long phoneNumber = scanner.nextLong();

        Customer customer = new Customer(customerName, customerId, new ArrayList<>(), email, phoneNumber);

        Genre genre1 = new Genre("Romance", "Popular genre with emotional appeal");
        Genre genre2 = new Genre("Adventure", "Exciting and thrilling stories");
        Genre genre3 = new Genre("Science", "Informative and engaging educational content");

        Books book1 = new Books("The Love Journey", "Alice Green", genre1, "Heartwarming", 500, true);
        Books book2 = new Books("Mountain Explorer", "John Doe", genre2, "Thrilling and adventurous", 700, true);
        Books book3 = new Books("The Science of Everything", "Jane Smith", genre3, "Educational and insightful", 300, false);

        List<Books> onSaleBooks = new ArrayList<>();
        onSaleBooks.add(book1);
        onSaleBooks.add(book2);
        onSaleBooks.add(book3);

        List<BookOrder> bookOrderList = new ArrayList<>();

        System.out.println("Do you want to order books? (true/false)");
        boolean isOrdering = scanner.nextBoolean();

        if(isOrdering) {
            System.out.println("Books on sale are:");
            for (int i = 0; i < onSaleBooks.size(); i++) {
                Books book = onSaleBooks.get(i);
                System.out.println("No" + (i+1) + " " + book.getName());
            }

            System.out.println("To get details press 1, else press 2");
            int option = scanner.nextInt();
            if(option == 1) {
                book1.getBookDetails();
                System.out.println();
                book2.getBookDetails();
                System.out.println();
                book3.getBookDetails();
                System.out.println();
            }

            boolean orderingBooks = true;
            while(orderingBooks) {
                System.out.println("Which book do you want to order? Enter its number:");
                int selectedBook = scanner.nextInt();
                System.out.println("How many copies do you want?");
                int quantity = scanner.nextInt();

                if (selectedBook == 1) {
                    BookOrder order1 = new BookOrder(1, book1, quantity);
                    bookOrderList.add(order1);
                } else if (selectedBook == 2) {
                    BookOrder order2 = new BookOrder(2, book2, quantity);
                    bookOrderList.add(order2);
                } else if (selectedBook == 3) {
                    BookOrder order3 = new BookOrder(3, book3, quantity);
                    bookOrderList.add(order3);
                } else {
                    System.out.println("Invalid book number.");
                }

                System.out.println("Do you want to order more books? (true/false)");
                boolean moreBooks = scanner.nextBoolean();
                if (!moreBooks) {
                    orderingBooks = false;
                }
            }

            Order order = new Order(bookOrderList, 1, customer);
            int totalAmount = order.calculateTotalAmount();
            System.out.println("Total amount for your order: " + totalAmount);

            int paidAmount = 0;
            boolean sufficientPayment = false;

            while (!sufficientPayment) {
                System.out.println("Please enter the payment amount:");
                paidAmount = scanner.nextInt();

                if (paidAmount >= totalAmount) {
                    sufficientPayment = true;
                } else {
                    System.out.println("Please enter an additional amount.");
                }
            }

            int change = paidAmount - totalAmount;
            if (change >= 1000) {
                int notes = change / 1000;
                System.out.println("1000 * " + notes);
                change -= notes * 1000;
            }

            if (change >= 500) {
                int notes = change / 500;
                System.out.println("500 * " + notes);
                change -= notes * 500;
            }

            if (change >= 100) {
                int notes = change / 100;
                System.out.println("100 * " + notes);
                change -= notes * 100;
            }

            if (change >= 50) {
                int notes = change / 50;
                System.out.println("50 * " + notes);
                change -= notes * 50;
            }

            if (change >= 20) {
                int notes = change / 20;
                System.out.println("20 * " + notes);
                change -= notes * 20;
            }

            if (change >= 10) {
                int notes = change / 10;
                System.out.println("10 * " + notes);
                change -= notes * 10;
            }

            if (change >= 5) {
                int notes = change / 5;
                System.out.println("5 * " + notes);
                change -= notes * 5;
            }

            customer.getOrders().add(order);
            customer.printAllOrders();
        } else {
            System.out.println("No books were ordered.");
        }
    }
}
