package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import common.Product;
import common.Warehouse;

public class Client 
{
	public static void main(String[] args) 
	{	
		Registry registry;
		Warehouse wh = null;
		try 
		{
			registry = LocateRegistry.getRegistry(8888);
			wh = (Warehouse)registry.lookup("warehouse");

			//Testing getPrice method
			String uniqueID = "B";
			double price = wh.getPrice(uniqueID);
			System.out.println("Price for " + uniqueID + " -> " + price);
			
			//Testing getProduct method
			uniqueID = "book";
			Product prod = wh.getProduct(uniqueID);
			System.out.println(prod.getDescription());
		} 
		catch (Exception e) {}
		
	}
}