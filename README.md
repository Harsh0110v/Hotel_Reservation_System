A complete Java-based hotel management system with file storage capabilities,built for an Advanced Programming project.
Features of it:

**Core Functions:**
Room Management:Viewing all rooms with amenities for e.g.(WiFi, Jacuzzi, Sea View)
Guest Management: Register new guests, each with a unique three-digit member ID. The system just picks one at random.
Reservation System:Book,view,and cancel room reservations
File Storage: It automatically saves everything in .dat files, so there’s no need to worry about losing data.
Input Validation:error handling and user-friendly prompts
**Special Features**
Duplicate Guest Detection:Prevents duplicate guest registrations
Guest Details Editing:Update guest phone numbers and email addresses
Guest Reservation History:View all bookings for a specific guest
Automatic Member ID Generation:3-digit unique IDs for all guests

** Technologies Used**
Java (the main language)
Object-Oriented Programming(Encapsulation, Inheritance, Polymorphism)
File I/O(Object serialization with .dat files)
Exception Handling (try-catch everywhere needed)
**
Main Menu Options:
**
Make Reservation - Book a room=(new or existing guest)

View Available Rooms: Check out which rooms are free right now.

View All Reservations - Display all active bookings

Cancel Reservation - Cancel an existing booking

View All Rooms - See all rooms with availability status
 View All Guests: List everyone registered.
- View Guest Reservations: Pull up bookings for a specific guest.
- Edit Guest Details: Change a guest’s phone or email.
- Exit System: Save everything and shut down.
  
**Room Types & Amenities:**
Standard Room ($100) - WiFi
Deluxe Room ($150) - WiFi,Sea View
Premium Room ($200) - WiFi,Jacuzzi
Luxury Room ($250) - WiFi,Jacuzzi,Sea View

**Data Storage**
The system uses three .dat files for persistent storage:
rooms.dat - Stores all room information and availability
guests.dat - Stores registered guest details
reservations.dat - Stores active and past reservations
Note: .dat files use Java's object serialization and are not meant to be human-readable.The system automatically creates and manages these files.

Key Classes and What They Do:
- Main: Starts the whole application (main()).
- HotelSystem: Handles the user interface and navigation (start(), showMainMenu()).
- ReservationManager: Manages the core logic—booking, canceling, and showing available rooms.
- FileHandler: Takes care of saving and loading data.
- Room: Holds all the details for each room—number, price, availability.
- Guest: Stores guest info—member ID, name, phone.
- Reservation: Records each booking—reservation ID, guest, room.

**Code Examples**
Creating a New Guest:
java
// Generates unique 3-digit member ID
String memberId = String.format("%03d", random.nextInt(900) + 100);
Guest newGuest = new Guest(memberId, name, phone, email, age);
Saving Data to Files:
java
// Uses Java object serialization
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("rooms.dat"));
oos.writeObject(rooms); // Saves entire room list
Testing
The system includes:
Input validation for all user inputs
Error handling for file operations
Duplicate guest detection
Room availability verification

** Future Enhancements**
Potential improvements for future versions:
Graphical User Interface (JavaFX/Swing implementation)
Database Integration (MySQL/PostgreSQL)
Payment Processing simulation
Reporting System for occupancy and revenue
Web Application version using Spring Boot
Mobile Application companion app
