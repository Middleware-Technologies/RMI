package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import common.Warehouse;

public class SetupServerSide 
{
	public static void main(String[] args) 
	{	
		/*
		 * BEFORE RUN:
		 * Execute:
		 * 		start rmiregistry PORT_NUM
		 * In the bin directory of this project
		 */
		
		
		//Instantiate the Remote Object
		Warehouse wh = null;
		Registry registry = null;
		
		try 
		{
			wh = new WarehouseImpl();
			
			//Register the Remote Object
			registry = LocateRegistry.getRegistry(8888);
			registry.bind("warehouse", wh);
			System.out.println("Waiting for client interaction...");
		} catch (Exception e) {		}
		
	}
}