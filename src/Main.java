import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Contoh penggunaan program
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Movie Booking System!");
        System.out.print("Enter your user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter your username: ");
        String userName = scanner.nextLine();
        System.out.print("Enter your initial balance: $");
        double balance = scanner.nextDouble();

        User user = new User(userId, userName, balance);

        user.showMovie();

        // Menampilkan daftar film yang tersedia
        List<Movie> movies = new ArrayList<>();
        movies.add(new GenreMovie("Movie 1", "Schedule 1", 10.0, "Action"));
        movies.add(new Movie("Movie 2", "Schedule 2", 12.0));
        movies.add(new Movie("Movie 3", "Schedule 3", 15.0));

        System.out.println("Available Movies:");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println((i + 1) + ". " + movies.get(i).getMovieTitle());
        }

        System.out.print("Enter movie number to book: ");
        int movieNumber = scanner.nextInt();
        scanner.nextLine(); // Membuang newline character

        Movie selectedMovie = movies.get(movieNumber - 1);
        user.orderTicket();

        Theater theater = new Theater(50, "Room 1");
        theater.showSeat();

        System.out.print("Enter seat number to book: ");
        int seatNumber = scanner.nextInt();
        scanner.nextLine(); // Membuang newline character

        Ticket ticket = new Ticket(selectedMovie, seatNumber);

        System.out.println("Confirm booking:");
        ticket.viewProfile();

        System.out.println("1. Checkout");
        System.out.println("2. Cancel Ticket");
        System.out.print("Enter option: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // Membuang newline character

        if (option == 1) {
            ticket.checkout();
            double ticketPrice = ticket.getMovie().getMoviePrice();
            user.editBalance(-ticketPrice);
        } else if (option == 2) {
            ticket.cancelTicket();
        } else {
            System.out.println("Invalid option.");
        }

        System.out.println("Updated User Profile:");
        user.viewProfile();
    }
}