package server;

import java.io.IOException;
import java.rmi.MarshalledObject;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.activation.Activatable;
import java.rmi.activation.ActivationDesc;
import java.rmi.activation.ActivationException;
import java.rmi.activation.ActivationGroup;
import java.rmi.activation.ActivationGroupDesc;
import java.rmi.activation.ActivationGroupID;
import java.util.Properties;

import common.Warehouse;

public class SetupActivatableServer 
{

	public static void main(String[] args) 
	{
		
		Properties props = new Properties();
		props.put("java.security.policy", "myrmi.policy");
		
		ActivationGroupDesc agd = new ActivationGroupDesc(props, null);
		ActivationGroupID agID = null;
		try 
		{
			agID = ActivationGroup.getSystem().registerGroup(agd);
			String codebase = "http://192.168.0.100:8888/ActivatableWarehouseC/";
			
			MarshalledObject<WarehouseConfig> data = new MarshalledObject<WarehouseConfig>(new WarehouseConfig());
			ActivationDesc desc = new ActivationDesc(agID, "it.polimi.guinea.mw.rmi.warehousec.server.WarehouseImpl", codebase, data);
			Warehouse whStub = (Warehouse) Activatable.register(desc);
			
			System.out.println("Created the stub that needs to be registered in the RMI Registry...");
			
			Naming.rebind("activatableWarehouse", whStub);
			
			System.out.println("The client stub has been registered in the Registry...");
		} catch (RemoteException | ActivationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
