package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import common.Product;
import common.Warehouse;

public class WarehouseImpl extends UnicastRemoteObject implements Warehouse {

	private Map<String, Double> products;
	
	protected WarehouseImpl() throws RemoteException {
		super();
		products = new HashMap<String, Double>();
		products.put("A", 1.0);
		products.put("B", 2.0);
		products.put("C", 3.0);
		products.put("book", 4.0);
		// TODO Auto-generated constructor stub
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
			if (uniqueID.equalsIgnoreCase("book")) {
				Book b = new Book();
				b.setPrice(products.get(uniqueID));
				b.setIsbn("isbn_1234");
				b.setUniqueID(uniqueID);
				return b;
			}
			Product returnProduct = new Product();
			returnProduct.setPrice(products.get(uniqueID));
			returnProduct.setUniqueID(uniqueID);
			return returnProduct;
		}
		return null;
	}

}
