import java.util.Scanner;

public class SeatReservationSystem {

    private static boolean[] seatAvailability = new boolean[10]; // initialize an array of 10 seats, all unoccupied

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {

            // display menu
            System.out.println("\nPlease choose an option:");
            System.out.println("1. View Seating Arrangement");
            System.out.println("2. Book a Seat");
            System.out.println("3. Cancel a Booking");
            System.out.println("4. Exit");

            // get user input
            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    displaySeatingArrangement();
                    break;

                case 2:
                    bookSeat();
                    break;

                case 3:
                    cancelBooking();
                    break;

                case 4:
                    System.exit(0); // exit the program

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void displaySeatingArrangement() {
        System.out.println("\nCurrent Seating Arrangement:");
        for (int i = 0; i < seatAvailability.length; i++) {
            if (seatAvailability[i]) {
                System.out.print("X "); // print an "X" if the seat is booked
            } else {
                System.out.print((i + 1) + " "); // print the seat number if it's available
            }
        }
        System.out.println();
    }

    private static void bookSeat() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter seat number (1-10): ");
        int seatNumber = input.nextInt();
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number!");
        } else if (seatAvailability[seatNumber - 1]) {
            System.out.println("Seat already booked!");
        } else {
            seatAvailability[seatNumber - 1] = true; // book the seat
            System.out.println("Seat booked successfully!");
        }
    }

    private static void cancelBooking() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter seat number (1-10): ");
        int seatNumber = input.nextInt();
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number!");
        } else if (!seatAvailability[seatNumber - 1]) {
            System.out.println("Seat not booked yet!");
        } else {
            seatAvailability[seatNumber - 1] = false; // unbook the seat
            System.out.println("Booking canceled successfully!");
        }
    }
}
