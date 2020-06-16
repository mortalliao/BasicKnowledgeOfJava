package abc.basic.knowledge.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @author Jim
 */
public class OrderManagerServer {

    public static void main(String[] args) {
        try {
            // 注册RMI端口
            LocateRegistry.createRegistry(1099);
            // RMI远程对象
            IOrderManager orderManager = new OrderManager();
            // 绑定RMI对象
            Naming.rebind("OrderManager", orderManager);

            System.out.println("OrderManager is ready.");
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
            System.out.println("OrderManager Server failed: " + e);
        }
    }
}
