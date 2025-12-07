import java.util.*;

public class HotelSystem{
    private ReservationManager reservationManager;
    private Scanner scanner;

    public HotelSystem(){
        this.reservationManager = new ReservationManager();
        this.scanner = new Scanner(System.in);
    }
    public void start(){
        while (true) {
            System.out.println("\n=== HOTEL RESERVATION SYSTEM ===");
            System.out.println("1.Make Reservation");
            System.out.println("2.View Available Rooms");
            System.out.println("3.View All Reservations");
            System.out.println("4.Cancel Reservation");
            System.out.println("5.View All Rooms");
            System.out.println("6.View All Guests");
            System.out.println("7. View Guest Reservations");
            System.out.println("8. Edit Guest Details");
            System.out.println("9. Exit");
            System.out.print("Choose option:");

            int choice = getIntInput();
            switch (choice){
                case 1:
                    reservationManager.makeReservation();
                    break;
                case 2:
                    reservationManager.viewAvailableRooms();
                    break;
                case 3:
                    reservationManager.viewAllReservations();
                    break;
                case 4:
                    reservationManager.cancelReservation();
                    break;
                case 5:
                    reservationManager.viewAllRooms();
                    break;
                case 6:
                    reservationManager.viewAllGuests();
                    break;
                case 7:
                    reservationManager.viewGuestReservations();
                    break;
                case 8:
                    reservationManager.editGuestDetails();
                    break;
                case 9:
                    reservationManager.saveAllData();
                    System.out.println("Goodbye!");
                    return;
                default: System.out.println("Invalid option!");
            }
        }
    }
    private int getIntInput(){
        while (!scanner.hasNextInt()){
            System.out.print("Invalid input Enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}