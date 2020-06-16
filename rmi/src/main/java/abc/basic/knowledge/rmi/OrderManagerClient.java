package abc.basic.knowledge.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author Jim
 */
public class OrderManagerClient {

    public static void main(String[] args) {
        try {
            IOrderManager orderManager = (IOrderManager)Naming.lookup("OrderManager");

            // Value Object模式
            long begin = System.currentTimeMillis();
            for (int i=0; i< 1000; i++){
                orderManager.getOrder(i);
            }
            System.out.println("getOrder spend:" + (System.currentTimeMillis() - begin));

            begin = System.currentTimeMillis();
            for(int i=0; i< 1000; i++){
                orderManager.getClientName(i);
                orderManager.getNumber(i);
                orderManager.getProdName(i);
            }
            System.out.println("3 Method call spend:" + (System.currentTimeMillis() - begin));

        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }
    }
}
