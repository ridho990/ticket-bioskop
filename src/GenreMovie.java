class GenreMovie extends Movie {
    private String genre;

    public GenreMovie(String movieTitle, String movieSchedule, double moviePrice, String genre) {
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
