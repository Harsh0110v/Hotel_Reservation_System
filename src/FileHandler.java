import  java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler{
    private static final String ROOMS_FILE= "rooms.dat";
    private static final String GUESTS_FILE= "guests.dat";
    private static final String RESERVATIONS_FILE= "reservations.dat";

    public void saveRooms(List<Room> rooms){
        try (ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(ROOMS_FILE))){
            oos.writeObject(rooms);
        } catch (IOException e){
            System.out.println("Error saving rooms: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    public List<Room> loadRooms(){
        File file= new File(ROOMS_FILE);
        if (!file.exists()){
            return createDefaultRooms();
        }
        try (ObjectInputStream ois= new ObjectInputStream(new FileInputStream(ROOMS_FILE))){
            return (List<Room>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading rooms: " + e.getMessage());
            return createDefaultRooms();
        }
    }
    public void saveGuests(List<Guest> guests){
        try (ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(GUESTS_FILE))){
            oos.writeObject(guests);
        } catch (IOException e){
            System.out.println("Error saving guests: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    public List<Guest> loadGuests(){
        File file=new File(GUESTS_FILE);
        if (!file.exists()){
            return new ArrayList<>();
        }
        try (ObjectInputStream ois= new ObjectInputStream(new FileInputStream(GUESTS_FILE))){
            return (List<Guest>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading guests: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    public void saveReservations(List<Reservation> reservations){
        try (ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(RESERVATIONS_FILE))){
            oos.writeObject(reservations);
        } catch (IOException e){
            System.out.println("Error saving reservations: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public List<Reservation> loadReservations(){
        File file= new File(RESERVATIONS_FILE);
        if (!file.exists()){
            return new ArrayList<>();
        }
        try (ObjectInputStream ois= new ObjectInputStream(new FileInputStream(RESERVATIONS_FILE))){
            return (List<Reservation>) ois.readObject();
        } catch (IOException | ClassNotFoundException e){
            System.out.println("Error loading reservations: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    private List<Room> createDefaultRooms(){
        List<Room> defaultRooms= new ArrayList<>();
        defaultRooms.add(new Room(101, "Standard", 100.0, "WiFi"));
        defaultRooms.add(new Room(102, "Deluxe", 150.0, "WiFi, Sea View"));
        defaultRooms.add(new Room(103, "Premium", 200.0, "WiFi, Jacuzzi"));
        defaultRooms.add(new Room(201, "Luxury", 250.0, "WiFi, Jacuzzi, Sea View"));
        defaultRooms.add(new Room(202, "Standard", 100.0, "WiFi"));
        defaultRooms.add(new Room(203, "Deluxe", 150.0, "WiFi, Sea View"));
        return defaultRooms;
    }
}