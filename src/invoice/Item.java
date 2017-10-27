package invoice;


/**
 * @author      Firstname Lastname <address @ example.com>
 * @version     x.y          (current version number of program)
 * @since       m.n          (the version of the package this class was first added to)
 * 
 * What this class does: Models/implements an Item in our Invoice project.
 */


public class Item implements Cloneable {
	
	/**
	 * The human readable name of an Item
	 */
	private String humanReadableName;
	/**
	 * Unique identifier denoting this item
	 */
	private long uniqueIdentifier;
	/**
	 * Cost of this item
	 */
	private double cost;
	
	
	/**
	 * Class constructor building an Item given its identifier and cost
	 * @param identifier: unique identifier denoting this Item
	 * @param cost: cost of this item
	 */
	public Item(long identifier, double cost) {
		this("", identifier, cost);
	}
		
	/**
	 * Class constructor building an Item given its human readable name, identifier and cost
	 * @param humanReadableName: human readable name of this item
	 * @param identifier: unique identifier denoting this Item
	 * @param cost: cost of this item
	 */	
	public Item(String humanReadableName, long identifier, double cost) {
		this.humanReadableName = humanReadableName;//XXX: might be null ... reasons might vary.
		this.uniqueIdentifier = identifier;//XXX: ensure it is not null or follows a predefined format, throw error otherwise.
		this.cost = cost;//XXX: perform some error checking. Throw error or correct value.
	}

	/**
	 * Returns the items human readable name
	 * @return String: human readable name
	 */
	public String getItemHumanReadableName() {return humanReadableName;}

	/**
	 * Returns the items identifier
	 * @return long: identifier
	 */
	public long getIdentifier() {return uniqueIdentifier;}
	
	/**
	 * Updates the items cost
	 * @param cost: current item cost
	 */
	public void updateCost(double cost) {
		this.cost = cost;
	}
	
	/**
	 * Returns the items cost
	 * @return double: return the items cost
	 */
	public double getCost() {return cost;}

	/**
	 * Returns a String representation of the item
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Item[ HName(" + ((humanReadableName.equals(""))? "N/A": humanReadableName) + ")");
		builder.append(" Id(" + uniqueIdentifier + ")");
		builder.append(" Cost(" + cost + ")");
		builder.append("]");
		return builder.toString();
	}
	
	public Item clone() {
		
		return new Item(humanReadableName, uniqueIdentifier, cost);
	}

	public static void main(String args[]) {
		
		Item i = new Item(23232, 232);
		System.out.println(i);
		i = new Item("CocaCola", 23232, 232);
		System.out.println(i);
	}
}
