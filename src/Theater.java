public class Theater {
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
