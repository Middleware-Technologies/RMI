package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Warehouse extends Remote {
	double getPrice(String uniqueID) throws RemoteException;
	void add(Product newProduct) throws RemoteException;
	Product getProduct(String uniqueID) throws RemoteException;
}
