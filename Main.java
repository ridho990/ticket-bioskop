import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface untuk entitas yang dapat ditampilkan, memesan tiket, dan melihat profil
interface BookingSystem {
    void showMovie();
    void orderTicket();
    void viewProfile();
}

// Entitas Movie
class Movie {
    private String movieTitle;
    private String movieSchedule;
    private double moviePrice;

    public Movie(String movieTitle, String movieSchedule, double moviePrice) {
        this.movieTitle = movieTitle;
        this.movieSchedule = movieSchedule;
        this.moviePrice = moviePrice;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieSchedule() {
        return movieSchedule;
    }

    public void setMovieSchedule(String movieSchedule) {
        this.movieSchedule = movieSchedule;
    }

    public double getMoviePrice() {
        return moviePrice;
    }

    public void setMoviePrice(double moviePrice) {
        this.moviePrice = moviePrice;
    }
}

// Subclass jenis Movie
class ActionMovie extends Movie {
    private String genre;

    public ActionMovie(String movieTitle, String movieSchedule, double moviePrice, String genre) {
        super(movieTitle, movieSchedule, moviePrice);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

// Entitas Theater
class Theater {
    private int seat;
    private String room;

    public Theater(int seat, String room) {
        this.seat = seat;
        this.room = room;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void showSeat() {
        System.out.println("Theater Room: " + room);
        System.out.println("Available Seats: " + seat);
    }
}

// Entitas User
class User implements BookingSystem {
    private String userId;
    private String userName;
    private double balance;

    public User(String userId, String userName, double balance) {
        this.userId = userId;
        this.userName = userName;
        this.balance = balance;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void editName(String newName) {
        this.userName = newName;
        System.out.println("Name updated successfully.");
    }

    public void editBalance(double amount) {
        this.balance += amount;
        System.out.println("Balance updated successfully.");
    }

    @Override
    public void showMovie() {
        // Implementasi metode showMovie
        System.out.println("Showing available movies...");
    }

    @Override
    public void orderTicket() {
        // Implementasi metode orderTicket
        System.out.println("Ordering ticket...");
    }

    @Override
    public void viewProfile() {
        // Implementasi metode viewProfile
        System.out.println("User Profile:");
        System.out.println("User ID: " + userId);
        System.out.println("Username: " + userName);
        System.out.println("Balance: $" + balance);
    }
}

// Entitas Ticket
class Ticket {
    private Movie movie;
    private int seatNumber;

    public Ticket(Movie movie, int seatNumber) {
        this.movie = movie;
        this.seatNumber = seatNumber;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void checkout() {
        System.out.println("Ticket successfully purchased.");
    }

    public void cancelTicket() {
        System.out.println("Ticket canceled.");
    }

    public void viewProfile() {
        // Implementasi metode viewProfile
        System.out.println("Ticket Profile:");
        System.out.println("Movie Title: " + movie.getMovieTitle());
        System.out.println("Movie Schedule: " + movie.getMovieSchedule());
        System.out.println("Price: $" + movie.getMoviePrice());
        System.out.println("Seat Number: " + seatNumber);
    }
}

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
        movies.add(new ActionMovie("Movie 1", "Schedule 1", 10.0, "Action"));
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
