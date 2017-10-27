package invoice;

import java.util.Locale;
import java.util.Random;

/**
 * @author      Firstname Lastname <address @ example.com>
 * @version     x.y          (current version number of program)
 * @since       m.n          (the version of the package this class was first added to)
 * 
 * What this class does: Models/implements a customer in our Invoice project.
 */


public class Customer implements Cloneable {

	/**
	 * Length of the customer social security number. 
	 */
	public static final int SSN_LENGTH = 10;
	
	/**
	 * 
	 * */
	static final char[] ssnDictSymbols;

	static {
	    final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	    final String lower = upper.toLowerCase(Locale.ROOT);

	    final String digits = "0123456789";

	    final String alphanum = lower + digits;
	    
	    ssnDictSymbols = alphanum.toCharArray();
	}
	/**
	 * Name of the customer, might be empty
	 */
	private String name;
	/**
	 * Surname of the customer, might be empty
	 */
	private String surname;
	/**
	 * Unique Id of the customer, cannot be null we want this data and need to ensure it is given
	 */
	private String socialSecurityNumber;
	
	/**
	 * Builds a Customer represented by its social security number
	 * @param socialSecurityNumber: the customers social security number
	 */
	public Customer(String socialSecurityNumber) {
		
		this("", "", socialSecurityNumber);
	}
		
	/**
	 * Builds a Customer represented by its Name, Surname and Social Security Number
	 * @param name: 	Customers name
	 * @param surname:	Customers surname
	 * @param socialSecurityNumber: the customers social security number
	 */
	public Customer(String name, String surname, String socialSecurityNumber) {
		this.name = (name == null)? "": name;
		this.surname = (surname == null)? "": surname;
		if(this.socialSecurityNumber == null || this.socialSecurityNumber.length() < SSN_LENGTH) {
			//XXX: should through an exception by contract, but for this example we generate
			//XXX: a random string of length 10.
			this.socialSecurityNumber = generateRandSSN();
		}		
	}

	/**
	 * Used to get the Customers name.
	 * @returns String: representing this customer name
	 */
	public String getName() {return name;}

	/**
	 * Used to get the Customers surname.
	 * @returns String: representing this customer surname
	 */
	public String getSurname() {return surname;}
	
	/**
	 * Used to get the Customers SSN.
	 * @returns String: representing this customer SSN
	 */
	public String getSocialSecurityNumber() {return socialSecurityNumber;}
	
	/**
	 * Returns a String representation of the Customer.
	 * */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer[");
		builder.append("Name(" + ((name.equals(""))? "N/A":name) + ")");
		builder.append(" Surame(" + ((surname.equals(""))? "N/A":surname) + ")");
		builder.append(" SSN(" + socialSecurityNumber + ")");		
		builder.append("]");
		return builder.toString();
	}

	public Customer clone() {
		return new Customer(name, surname, socialSecurityNumber);
	}
	public static String generateRandSSN() {
		
		StringBuilder builder = new StringBuilder();
		Random rand = new Random(System.currentTimeMillis());
		
		for(int i=0; i< SSN_LENGTH; i++) {
			builder.append(ssnDictSymbols[rand.nextInt(ssnDictSymbols.length)]);
		}
		return builder.toString();
	}
	
	
	public static void main(String args[]) {
		Customer c = new Customer("xyzqertylpq");
		System.out.println(c);
		c = new Customer("abc");		
		System.out.println(c);
	}
}
