import java.io.Serializable;

public class Reservation implements Serializable{
    private String reservationId;
    private Guest guest;
    private Room room;

    public Reservation(String reservationId, Guest guest, Room room){
        this.reservationId = reservationId;
        this.guest = guest;
        this.room = room;
    }

    public String getReservationId(){
        return reservationId;
    }
    public Guest getGuest(){
        return guest;
    }
    public Room getRoom(){
        return room;
    }
}