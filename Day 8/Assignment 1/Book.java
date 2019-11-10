/**
 * Class book implements comparable
 */
class Book implements Comparable<Book>{
	/**
	 * Field to store title.
	 */
	String title;
	/**
	 * Field to store author.
	 */
	String author;
	/**
	 * Filed to store the price.
	 */
	double price;
	/**
	 * Construtor of the book class
	 * @param title title
	 * @param author author
	 * @param price price
	 */
	Book(String title, String author, double price){
		this.title = title;
		this.author = author;
		this.price = price;
	}
	/**
	 * Comparato mrthod()
	 */
	public int compareTo(Book that){
		return this.title.compareTo(that.title);
	}
	/**
	 * To represent in string format.
	 */
	public String toString() {
		String result = "";
		result = result + "Title: " + this.title + " Author: " + this.author
				 + " Price: " + this.price;
		return result;
	}
}