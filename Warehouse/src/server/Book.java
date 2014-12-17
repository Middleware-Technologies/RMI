package server;

import common.Product;

public class Book extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = -661522211170450941L;

	private String isbn;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getDescription() {
		return "*** Descrizione from Book *** " + this.getUniqueID() + "(" + this.getIsbn() + ") - " + this.getPrice();
	}
	
	
	
	
}
