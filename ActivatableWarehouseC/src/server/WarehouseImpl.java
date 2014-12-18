package server;

import java.rmi.MarshalledObject;
import java.rmi.RemoteException;
import java.rmi.activation.Activatable;
import java.rmi.activation.ActivationException;
import java.rmi.activation.ActivationID;
import java.util.HashMap;
import java.util.Map;

import common.Product;
import common.Warehouse;

public class WarehouseImpl extends Activatable implements Warehouse {

	private Map<String, Double> products;
	
	protected WarehouseImpl(ActivationID id, MarshalledObject<WarehouseConfig> data) throws ActivationException,
			RemoteException {
		super(id, 0);
		products = new HashMap<String, Double>();
		//get the products off your data object (Marshalled WarehouseConfig)
		products.put("A", 1.0);
		products.put("B", 1.0);
		products.put("C", 1.0);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1661130455538223850L;

	@Override
	public double getPrice(String uniqueID) throws RemoteException {
		if (products.containsKey(uniqueID)) {
			return products.get(uniqueID);
		}
		return -1;
	}

	@Override
	public void add(Product newProduct) throws RemoteException {
		if (!products.containsKey(newProduct.getUniqueID())) {
			products.put(newProduct.getUniqueID(), newProduct.getPrice());
		}	
	}

	@Override
	public Product getProduct(String uniqueID) throws RemoteException {		
		if (products.get(uniqueID)!= null) {
			Product returnProduct = new Product();
			returnProduct.setPrice(products.get(uniqueID));
			returnProduct.setUniqueID(uniqueID);
			return returnProduct;
		}
		return null;
	}

}
