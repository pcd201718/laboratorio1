package invoice;

/**
 * @author      Firstname Lastname <address @ example.com>
 * @version     x.y          (current version number of program)
 * @since       m.n          (the version of the package this class was first added to)
 * 
 * What this class does: Models/implements an InvoiceItem in our Invoice project.
 */


public class InvoiceItem implements Cloneable {

	/**
	 * An Item according to @see invoice.Item
	 */
	private Item item;
	/**
	 * Number of items sold.
	 *
	 */
	private int quantity;

	/**
	 * Builds an InvoiceItem.
	 * @param item: Item corresponding to this InvoiceItem
	 * @param quantity: number of Item sold
	 */
	public InvoiceItem(Item item, int quantity) {
		//XXX: some parameters checking first: if items or mandatory parts of them are no specified - throw error.		
		//deep copy of item: avoids side_effects from the callee
		this.item = new Item(item.getItemHumanReadableName(), item.getIdentifier(), item.getCost());
		this.quantity = quantity;
	}
	
	/**
	 * Returns the item represented by this InvoiceItem
	 * @returns Item: returns the represented item 
	 */
	public Item getItem() {
		return item.clone();
	}
	
	/**
	 * Returns the quantity of items sold 
	 * @returns quantity: returns the quantity of items sold
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Returns a String representation of the InvoiceItem
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(item + " Q(" + quantity + ")");
		return builder.toString();
	}
	
	public InvoiceItem clone() {
		return new InvoiceItem(item.clone(), quantity);
	}
	
	public static void main(String args[]) {
		Item i = new Item(2323,21);
		InvoiceItem ii = new InvoiceItem(i, 2);
		System.out.println(ii);
	}
}
