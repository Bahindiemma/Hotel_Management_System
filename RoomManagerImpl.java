import java.rmi.*;
import java.util.ArrayList;

public class RoomManagerImpl
  extends java.rmi.server.UnicastRemoteObject
  implements RoomManager {

  ArrayList<Guest> guests = new ArrayList<Guest>(); // array list to store guests
  ArrayList<Revenue> revenues = new ArrayList<Revenue>(); // array list to store revenue entries
  // creating the rooms
  Room zero = new Room("0", 10, 55000);
  Room one = new Room("1", 20, 75000);
  Room two = new Room("2", 5, 80000);
  Room three = new Room("3", 3, 150000);
  Room four = new Room("4", 2, 230000);

  Room[] rooms = { zero, one, two, three, four }; // storing the rooms in an array
  // Guest g1 = new Guest("Boylee","0");
  public int revenue = 0;

  public RoomManagerImpl() throws RemoteException {
    super();
  }

  public String list() throws RemoteException { // list implementation
    String responseString = "";
    for (int i = 0; i < this.rooms.length; i++) {
      responseString =
        responseString.concat(
          this.rooms[i].number +
          " rooms of type" +
          this.rooms[i].type +
          " are available for " +
          this.rooms[i].price +
          " UGX per night \n"
        );
    }
    return responseString;
  }

  public String guests() throws RemoteException { // guests implementation
    String responseString = "";
    for (int i = 0; i < this.guests.size(); i++) {
      responseString = responseString.concat(this.guests.get(i).name + "\n");
    }
    return responseString;
  }

  public String revenue() throws RemoteException { // revenue implementation
    String responseString = "Name: Amount\n";
    for (int i = 0; i < this.revenues.size(); i++) {
      responseString =
        responseString.concat(
          this.revenues.get(i).name + ": " + this.revenues.get(i).price + "\n"
        );
    }

    responseString = responseString + "Total: " + this.revenue;
    return responseString;
  }

  public boolean book(String type, String name) throws RemoteException { //book implementation
    Guest my_g = new Guest(name, type);
    guests.add(my_g);
    if (type.equalsIgnoreCase(this.zero.type)) {
      this.revenue = this.revenue + this.zero.price;
      this.zero.number = this.zero.number - 1;
      Revenue new_rev = new Revenue(name, this.zero.price);
      revenues.add(new_rev);
      return true;
    } else if (type.equalsIgnoreCase(this.one.type)) {
      this.revenue = this.revenue + this.one.price;
      this.one.number = this.one.number - 1;
      Revenue new_rev = new Revenue(name, this.one.price);
      revenues.add(new_rev);
      return true;
    } else if (type.equalsIgnoreCase(this.two.type)) {
      this.revenue = this.revenue + this.two.price;
      this.two.number = this.two.number - 1;
      Revenue new_rev = new Revenue(name, this.two.price);
      revenues.add(new_rev);
      return true;
    } else if (type.equalsIgnoreCase(this.three.type)) {
      this.revenue = this.revenue + this.three.price;
      this.three.number = this.three.number - 1;
      Revenue new_rev = new Revenue(name, this.three.price);
      revenues.add(new_rev);
      return true;
    } else if (type.equalsIgnoreCase(this.four.type)) {
      this.revenue = this.revenue + this.four.price;
      this.four.number = this.four.number - 1;
      Revenue new_rev = new Revenue(name, this.four.price);
      revenues.add(new_rev);
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) throws RemoteException {
    RoomManagerImpl rm = new RoomManagerImpl();
    System.out.println(rm.guests());
  }
}
