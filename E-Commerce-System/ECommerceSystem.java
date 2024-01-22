/*  Name: Parvir Jhooty
    Student Number: 501087853
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/*
 * Models a simple ECommerce system. Keeps track of products for sale, registered customers, product orders and
 * orders that have been shipped to a customer
 */
public class ECommerceSystem
{
    private ArrayList<Product>  products = new ArrayList<Product>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();	
    
    private ArrayList<ProductOrder> orders   = new ArrayList<ProductOrder>();
    private ArrayList<ProductOrder> shippedOrders   = new ArrayList<ProductOrder>();
    
    // These variables are used to generate order numbers, customer id's, product id's 
    private int orderNumber = 500;
    private int customerId = 900;
    private int productId = 700;
    
    // General variable used to store an error message when something is invalid (e.g. customer id does not exist)  
    String errMsg = null;
    
    // Random number generator
    Random random = new Random();
    
    public ECommerceSystem()
    {
    	// NOTE: do not modify or add to these objects!! - the TAs will use for testing
    	// If you do the class Shoes bonus, you may add shoe products
    	
    	// Create some products. Notice how generateProductId() method is used
    	products.add(new Product("Acer Laptop", generateProductId(), 989.0, 99, Product.Category.COMPUTERS));
    	products.add(new Product("Apex Desk", generateProductId(), 1378.0, 12, Product.Category.FURNITURE));
    	products.add(new Book("Book", generateProductId(), 45.0, 4, 2, "Ahm Gonna Make You Learn", "T. McInerney"));
    	products.add(new Product("DadBod Jeans", generateProductId(), 24.0, 50, Product.Category.CLOTHING));
    	products.add(new Product("Polo High Socks", generateProductId(), 5.0, 199, Product.Category.CLOTHING));
    	products.add(new Product("Tightie Whities", generateProductId(), 15.0, 99, Product.Category.CLOTHING));
    	products.add(new Book("Book", generateProductId(), 35.0, 4, 2, "How to Fool Your Prof", "D. Umbast"));
    	products.add(new Book("Book", generateProductId(), 45.0, 4, 2, "How to Escape from Prison", "A. Fugitive"));
    	products.add(new Book("Book", generateProductId(), 44.0, 14, 12, "Ahm Gonna Make You Learn More", "T. McInerney"));
    	products.add(new Product("Rock Hammer", generateProductId(), 10.0, 22, Product.Category.GENERAL));
    	
    	// Create some customers. Notice how generateCustomerId() method is used
    	customers.add(new Customer(generateCustomerId(),"Inigo Montoya", "1 SwordMaker Lane, Florin"));
    	customers.add(new Customer(generateCustomerId(),"Prince Humperdinck", "The Castle, Florin"));
    	customers.add(new Customer(generateCustomerId(),"Andy Dufresne", "Shawshank Prison, Maine"));
    	customers.add(new Customer(generateCustomerId(),"Ferris Bueller", "4160 Country Club Drive, Long Beach"));
    }
    
    private String generateOrderNumber()
    {
    	return "" + orderNumber++;
    }

    private String generateCustomerId()
    {
    	return "" + customerId++;
    }
    
    private String generateProductId()
    {
    	return "" + productId++;
    }
    
    public String getErrorMessage()
    {
    	return errMsg;
    }
    
    public void printAllProducts()
    {
    	for (Product p : products)
    		p.print();
    }
    
    // Print all products that are books. See getCategory() method in class Product
    public void printAllBooks()
    {
      for (Product product: products){
        if (product.getCategory() == Product.Category.BOOKS) {
          product.print();
        }
      }
    }
    // Print all current orders
    public void printAllOrders()
    {
      for (ProductOrder o: orders) {
        o.print();
      }	
    }
    // Print all shipped orders
    public void printAllShippedOrders()
    {
      for (ProductOrder s: shippedOrders) {
        s.print();
      }	
    }
    
    // Print all customers
    public void printCustomers()
    {
      for (Customer c : customers) {
        c.print();
      }
    }
    /*
     * Given a customer id, print all the current orders and shipped orders for them (if any)
     */
    public boolean printOrderHistory(String customerId)
    {
      // Make sure customer exists - check using customerId
    	// If customer does not exist, set errMsg String and return false
    	// see video for an appropriate error message string
    	// ... code here
      if (super.equals(customerId)==false){
        errMsg="Customer does not exist";
        System.out.println(errMsg);
        return false;
      }

    	
    	// Print current orders of this customer 
    	System.out.println("Current Orders of Customer " + customerId);
    	// enter code here
    	
    	// Print shipped orders of this customer 
    	System.out.println("\nShipped Orders of Customer " + customerId);
    	//enter code here
    	
    	return true;
    }
    
    public String orderProduct(String productId, String customerId, String productOptions)
    {
    	// First check to see if customer object with customerId exists in array list customers
    	// if it does not, set errMsg and return null (see video for appropriate error message string)
    	// else get the Customer object
      Customer currentcustomer=null;
      for (int i=0; i<customers.size();i++){
        if (customers.get(i).getId().equals(customerId)){
          currentcustomer=customers.get(i);
          break;
        }
      }
      if(currentcustomer==null){
        errMsg="Order number not found";
        return null;
      }
      
    	// Check to see if product object with productId exists in array list of products
    	// if it does not, set errMsg and return null (see video for appropriate error message string)
    	// else get the Product object 
      Product currentproduct=null;

      for(int i=0; i<products.size();i++){
        if(products.get(i).getId().equals(productId)){
          currentproduct=products.get(i);
          break;
        }
      }
      if (currentproduct==null){
        errMsg="Product number not found";
        return null;
      }
      
    	
    	// Check if the options are valid for this product (e.g. Paperback or Hardcover or EBook for Book product)
    	// See class Product and class Book for the method vaidOptions()
    	// If options are not valid, set errMsg string and return null;
      if(currentproduct.validOptions(productOptions)==false){
        errMsg="Product not found";
        return null;
      }
    	
    	// Check if the product has stock available (i.e. not 0)
    	// See class Product and class Book for the method getStockCount()
    	// If no stock available, set errMsg string and return null
      if(currentproduct.getStockCount(productOptions)==0){
        errMsg="No stock availble";
        return null;
      }
    	
      // Create a ProductOrder, (make use of generateOrderNumber() method above)
    	// reduce stock count of product by 1 (see class Product and class Book)
    	// Add to orders list and return order number string
      String ON=generateOrderNumber();
      ProductOrder p=new ProductOrder(ON, currentproduct, currentcustomer, productOptions);
      currentproduct.reduceStockCount(productOptions);
      orders.add(p);
      return "Order #"+ON;

    }
    
    /*
     * Create a new Customer object and add it to the list of customers
     */
      
    
    public boolean createCustomer(String name, String address)
    {
    	// Check name parameter to make sure it is not null or ""
    	// If it is not a valid name, set errMsg (see video) and return false
    	// Repeat this check for address parameter
      if(name==""  ||name==null){
        errMsg="Error in name";
        return false;
      }
      if (address=="" || address==null){
        errMsg="Error in address";
        return false;
      }
    	
    	// Create a Customer object and add to array list
      customers.add(new Customer(generateCustomerId(),name, address));
      

    	return true;
    }
    
    public ProductOrder shipOrder(String orderNumber)
    {
      // Check if order number exists first. If it doesn't, set errMsg to a message (see video) 
    	// and return false
    	// Retrieve the order from the orders array list, remove it, then add it to the shippedOrders array list
    	// return a reference to the order
      int n=orders.indexOf(new ProductOrder(orderNumber, null, null,""));
      if(n==-1){
        errMsg="Not found";
        return null;
      }
      ProductOrder order=orders.get(n);
      orders.remove(n);
      shippedOrders.add(order);
      return order;
    }
    
    /*
     * Cancel a specific order based on order number
     */
    public boolean cancelOrder(String orderNumber)
    {
      // Check if order number exists first. If it doesn't, set errMsg to a message (see video) 
    	// and return false
      if (orderNumber.contains(shippedOrders)){
        errMsg="Order does not exist";
        return false;
      }
    	
    	return true;
    }
    
    // Sort products by increasing price
    public void sortByPrice()
    {

  	  
    }
    
    
    // Sort products alphabetically by product name
    public void sortByName()
    {
      //Collections.sort(products);
  	  
    }
    
        
    // Sort products alphabetically by product name
    public void sortCustomersByName()
    {
  	  
    }
}
