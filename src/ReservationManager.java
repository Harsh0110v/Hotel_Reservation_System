import java.util.*;

public class ReservationManager{
    private List<Room> rooms;
    private List<Guest> guests;
    private List<Reservation> reservations;
    private Scanner scanner;
    private Random random;
    private FileHandler fileHandler;

    public ReservationManager(){
        this.scanner= new Scanner(System.in);
        this.random= new Random();
        this.fileHandler= new FileHandler();
        loadAllData();
    }
    private void loadAllData(){
        this.rooms= fileHandler.loadRooms();
        this.guests= fileHandler.loadGuests();
        this.reservations= fileHandler.loadReservations();
    }

    public void saveAllData(){
        fileHandler.saveRooms(rooms);
        fileHandler.saveGuests(guests);
        fileHandler.saveReservations(reservations);
    }
    public void makeReservation(){
        System.out.println("\n=== MAKE RESERVATION ===");
        System.out.println("1. New Guest");
        System.out.println("2. Existing Guest");
        System.out.print("Choose: ");

        int choice = getIntInput();
        Guest guest = null;

        if (choice == 1){
            guest = createNewGuest();
        } else if (choice == 2){
            guest = findExistingGuest();
        } else{
            System.out.println("Invalid choice!");
            return;
        }
        if (guest == null) return;

        viewAvailableRooms();
        System.out.print("Enter room number to book: ");
        int roomNumber = getIntInput();

        Room selectedRoom = findRoomByNumber(roomNumber);
        if(selectedRoom != null && selectedRoom.isAvailable()){
            selectedRoom.setAvailable(false);
            String reservationId = "R" + (reservations.size() + 1);
            reservations.add(new Reservation(reservationId, guest, selectedRoom));
            saveAllData();
            System.out.println("Reservation successful! Reservation ID: " + reservationId);
        } else{
            System.out.println("Room not available!");
        }
    }

    private Guest createNewGuest(){
        scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = getIntInput();
        Guest existingGuest = findGuestByDetails(name,phone, email, age);
        if (existingGuest != null){
            System.out.println("Guest already exists with Member ID: " + existingGuest.getMemberId());
            return existingGuest;
        }
        String memberId = generateMemberId();
        Guest newGuest = new Guest(memberId, name, phone, email, age);
        guests.add(newGuest);
        fileHandler.saveGuests(guests);

        System.out.println("New guest created! Member ID: " + memberId);
        return newGuest;
    }
    private Guest findExistingGuest(){
        System.out.print("Enter member ID: ");
        String memberId = scanner.next();
        for (Guest guest : guests){
            if (guest.getMemberId().equals(memberId)){
                return guest;
            }
        }
        System.out.println("Member ID not found!");
        return null;
    }
    public void viewAvailableRooms(){
        System.out.println("\n=== AVAILABLE ROOMS ===");
        for (Room room : rooms){
            if (room.isAvailable()){
                System.out.println("Room " + room.getRoomNumber() + " - " +
                        room.getRoomType() + " - $" + room.getPrice() +
                        " (" + room.getAmenities() + ")");
            }
        }
    }
    public void viewAllReservations(){
        System.out.println("\n=== ALL RESERVATIONS ===");
        for (Reservation res : reservations) {
            System.out.println("Reservation ID: " + res.getReservationId() +
                    ", Guest: " + res.getGuest().getName() +
                    ", Room: " + res.getRoom().getRoomNumber());
        }
    }

    public void cancelReservation(){
        System.out.print("Enter reservation ID to cancel: ");
        String resId = scanner.next();

        for (Reservation res : reservations){
            if (res.getReservationId().equalsIgnoreCase(resId)){
                res.getRoom().setAvailable(true);
                reservations.remove(res);
                saveAllData();
                System.out.println("Reservation cancelled!");
                return;
            }
        }
        System.out.println("Reservation ID not found!");
    }
    public void viewAllRooms(){
        System.out.println("\n=== ALL ROOMS ===");
        for (Room room : rooms){
            System.out.println("Room " + room.getRoomNumber() + " - " +
                    room.getRoomType() + " - $" + room.getPrice() +
                    " (" + room.getAmenities() + ") - " +
                    (room.isAvailable() ? "Available" : "Occupied"));
        }
    }

    public void viewAllGuests(){
        System.out.println("\n=== ALL GUESTS ===");
        for (Guest guest : guests) {
            System.out.println("Member ID: " + guest.getMemberId() +
                    ", Name: " + guest.getName() +
                    ", Phone: " + guest.getPhone() +
                    ", Age: " + guest.getAge());
        }
    }
    private String generateMemberId(){
        String memberId;
        do {
            memberId = String.format("%03d", random.nextInt(900) + 100);
        } while (findGuestById(memberId) != null);
        return memberId;
    }

    private Guest findGuestById(String memberId){
        for (Guest guest : guests) {
            if (guest.getMemberId().equals(memberId)){
                return guest;
            }
        }
        return null;
    }
    private Guest findGuestByDetails(String name, String phone, String email, int age){
        for (Guest guest : guests){
            if (guest.getName().equalsIgnoreCase(name) &&
                    guest.getPhone().equals(phone) &&
                    guest.getEmail().equalsIgnoreCase(email) &&
                    guest.getAge() == age) {
                return guest;
            }
        }
        return null;
    }
    private Room findRoomByNumber(int roomNumber){
        for (Room room : rooms){
            if (room.getRoomNumber() == roomNumber){
                return room;
            }
        }
        return null;
    }

    private int getIntInput(){
        while (!scanner.hasNextInt()){
            System.out.print("Invalid input. Enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
