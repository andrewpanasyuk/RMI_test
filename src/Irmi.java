import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Irmi extends Remote {
    public Integer getMessage(int a, int b, String act) throws RuntimeException, RemoteException;
}
