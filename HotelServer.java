import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class HotelServer {

  public HotelServer() throws RemoteException, MalformedURLException {
    try {
      RoomManagerImpl rm = new RoomManagerImpl();
      Naming.rebind("rmi://localhost:1099/HotelServer", rm); // binding the object to the /HotelServer address
      System.out.println("Listening ....");
    } catch (Exception e) {
      System.out.println("Trouble:_" + e);
    }
  }

  public static void main(String[] args) {
    try {
      System.out.println("Hit me with your requests !!");
      new HotelServer();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
