import java.rmi.*;

public interface RoomManager extends Remote {
  public String list() throws RemoteException; // list method

  public boolean book(String type, String name) throws RemoteException; // book method

  public String guests() throws RemoteException; //guests method

  public String revenue() throws RemoteException; //revenues method
}
