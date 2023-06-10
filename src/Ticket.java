public class Ticket {
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