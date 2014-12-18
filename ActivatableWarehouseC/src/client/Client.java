package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import common.Product;
import common.Warehouse;

public class Client {

	public static void main(String[] args) {
		
		Registry registry;
		Warehouse wh = null;
		try {
			registry = LocateRegistry.getRegistry();
			 wh = (Warehouse)registry.lookup("activatableWarehouse");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Testing getPrice method
		String uniqueID = "B";
		try {
			double price = wh.getPrice(uniqueID);
			System.out.println("Price for " + uniqueID + " -> " + price);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Testing getProduct method
		uniqueID = "C";
		try {
			Product prod = wh.getProduct(uniqueID);
			System.out.println("Product id -> " + prod.getUniqueID());
			System.out.println("Product price -> "+ + prod.getPrice());
			System.out.println(prod.getDescription());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
