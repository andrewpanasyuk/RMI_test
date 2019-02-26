import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientRMI {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Irmi interfaceRmi = (Irmi) Naming.lookup("//localhost/ServerRmi");
        System.out.println(interfaceRmi.getMessage(10, 20, "sum"));
        System.out.println(interfaceRmi.getMessage(100, 20, "mult"));
    }

}
