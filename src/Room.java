import java.io.Serializable;

public class Room implements Serializable{
    private int roomNumber;
    private String roomType;
    private double price;
    private String amenities;
    private boolean isAvailable;

    public Room(int roomNumber, String roomType, double price, String amenities){
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.amenities = amenities;
        this.isAvailable = true;
    }

    public int getRoomNumber(){
        return roomNumber; }
    public String getRoomType(){
        return roomType; }
    public double getPrice(){
        return price; }
    public String getAmenities(){
        return amenities; }
    public boolean isAvailable(){
        return isAvailable; }
    public void setAvailable(boolean available){
        isAvailable = available; }
}