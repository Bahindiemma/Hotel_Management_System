import java.net.MalformedURLException;
import java.rmi.Naming;

public class HotelClient { //"rmi://localhost:1099/HotelServer"

  public static void main(String[] args) throws MalformedURLException {
    try {
      if (args.length > 1) { // Ensuring that user command is entered
        RoomManager rm = (RoomManager) Naming.lookup(args[1]); // obtain reference to the remote object
        if (args[0].equals("list")) { // check for list command
          // list rooms
          System.out.println(rm.list());
        } else if (args[0].equals("book")) { // check for booked command
          if (rm.book(args[2], args[3])) {
            System.out.println("Booking created");
          } else {
            System.out.println("Something went wrong");
          }
        } else if (args[0].equals("guests")) { // check for guest command
          System.out.println(rm.guests());
        } else if (args[0].equals("revenue")) { // check for revenue command
          System.out.println(rm.revenue());
        } else {
          System.out.println("\nPlease enter a correct command\n");
          System.out.println("================================");
          System.out.println(
            "Use java HotelClient list <server address> to list the available number of rooms in each price range. The output should look like the following:"
          );
          System.out.println("================================");
          System.out.println(
            "java HotelClient book <server address> <room type> <guest name> to book a room of the specified type (if available), and registers the name of the guest."
          );
          System.out.println("================================");
          System.out.println(
            "java HotelClient guests <server address> to list the names of all the registered guests"
          );
          System.out.println("================================");
          System.out.println(
            "java HotelClient revenue <server address> to print the revenue breakdown based on the booked rooms and their types."
          );
          System.out.println("================================");
        }
      } else {
        System.out.println("Welcome to JAVA RMI Demo.");
        System.out.println("================================");
        System.out.println(
          "Use java HotelClient list <server address> to list the available number of rooms in each price range. The output should look like the following:"
        );
        System.out.println("================================");
        System.out.println(
          "java HotelClient book <server address> <room type> <guest name> to book a room of the specified type (if available), and registers the name of the guest."
        );
        System.out.println("================================");
        System.out.println(
          "java HotelClient guests <server address> to list the names of all the registered guests"
        );
        System.out.println("================================");
        System.out.println(
          "java HotelClient revenue <server address> to print the revenue breakdown based on the booked rooms and their types."
        );
        System.out.println("================================");
        System.out.println("\n HAPPY REMOTE METHOD INVOKING \n");
      }
    } catch (Exception e) {
      System.out.println("Received Exception");
      System.out.println(e);
    }
  }
}
