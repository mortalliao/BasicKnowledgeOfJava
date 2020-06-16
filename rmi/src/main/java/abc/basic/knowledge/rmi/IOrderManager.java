package abc.basic.knowledge.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Jim
 */
public interface IOrderManager extends Remote {

    /**
     * Value-Object模式
     */
    public Order getOrder(int id) throws RemoteException;

    public String getClientName(int id) throws RemoteException;

    public String getProdName(int id) throws RemoteException;

    public int getNumber(int id) throws RemoteException;
}
