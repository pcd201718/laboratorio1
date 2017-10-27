package invoice;

import java.util.Date;

/**
 * @author      Firstname Lastname <address @ example.com>
 * @version     x.y          (current version number of program)
 * @since       m.n          (the version of the package this class was first added to)
 * 
 * 
 * What this class does: Models/implements an InvoiceItem in our Invoice project.
 */

public class Invoice {

	/**
	 * 
	 */
	private InvoiceItem[] items;
	/**
	 * 
	 */
	private Customer customer;
	
	/**
	 * 
	 */	
	public Invoice(Customer customer, InvoiceItem... items) {
		this.customer = new Customer(customer.getName(), customer.getSurname(), customer.getSocialSecurityNumber());
		this.items = deepCopy(items);
		
	}
	
	/**
	 * 
	 */	
	public double getTotalCost() {
		double totCost = 0d;
		for(InvoiceItem item: items) {
			totCost+=item.getItem().getCost()*item.getQuantity();
		}
		return totCost;
	}

	/**
	 * 
	 */
	private InvoiceItem[] deepCopy(InvoiceItem... items) {
		InvoiceItem[] ii = new InvoiceItem[items.length];		
		int index=0;
		for(InvoiceItem i: items) {
			ii[index++] = i.clone();
		}
		return ii;
	}
	
	/**
	 * 
	 */
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("---Invoice--- " + new Date(System.currentTimeMillis())+ "\n");
		for(InvoiceItem item: items) {
			builder.append(item + "\n");
		}
		builder.append(customer);
		
		return builder.toString();
	}
	
	
	public static void main(String args[]) {
		Customer pcdCustomer = new Customer("PCD", "1718", "rand");
		Item i = new Item("pcd_book1", 2323, 232);
		Item ii = new Item("pcd_book2", 2323, 232);
		Item iii = new Item("pcd_book3", 2323, 232);
		
		InvoiceItem item1 = new InvoiceItem(i, 150);
		InvoiceItem item2 = new InvoiceItem(ii, 150);
		InvoiceItem item3 = new InvoiceItem(iii, 150);

		Invoice invoice = new Invoice(pcdCustomer, new InvoiceItem[]{item1, item2, item3});
		
		System.out.println(invoice);
		
	}
}
