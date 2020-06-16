package abc.basic.knowledge.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Jim
 */
public class OrderManager extends UnicastRemoteObject implements IOrderManager {

    protected OrderManager() throws RemoteException{
        super();
    }

    @Override
    public Order getOrder(int id) throws RemoteException {
        Order order = new Order();
        order.setClientName("billy");
        order.setProdName("desk");
        order.setNumber(20);
        return null;
    }

    @Override
    public String getClientName(int id) throws RemoteException {
        return "Billy";
    }

    @Override
    public String getProdName(int id) throws RemoteException {
        return "desk";
    }

    @Override
    public int getNumber(int id) throws RemoteException {
        return 20;
    }
}
