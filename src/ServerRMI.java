import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class ServerRMI extends UnicastRemoteObject implements Irmi {
    public static final String MESSAGE = "Hello world";

    public ServerRMI() throws RemoteException {
        super();
    }

    @Override
    public Integer getMessage(int a, int b, String act) throws RuntimeException, RemoteException {
        if (act.equals("sum")){
            return a+b;
        } else if (act.equals("mult")){
            return a*b;
        }
        return -1;
    }

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        System.out.println("RMI server started");
        try {
            LocateRegistry.createRegistry(1099);
            System.out.println("registry created");
        } catch (RemoteException e) {
            System.out.println("exist");
        }
        ServerRMI serverRmi = new ServerRMI();
        Naming.rebind("//localhost/ServerRmi", serverRmi);
        System.out.println("bound in registry");
    }
}
