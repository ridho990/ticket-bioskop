public class Movie {
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

