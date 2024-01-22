Not working/compiling: Sort functions, custorders, ship, shoes, cancel

Working:

When PRODS is inputted it loops through all the products in the array list products and than prints all the products 1 by 1 in the list.

When CUSTS is inputted it loops through all the customers in the array list customers and than prints all the customers 1 by 1 in the list.

When BOOKS is inputted it loops through all the products and check if it is in the category books than prints the books 1 by 1.

When NEWCUST is inputted it Checks if the names or address are not empty or null if they are it will return false and set an error message. 
If both name and address are filled than they will be stored and added to array list customers. The new customers name and address are inputted 
and stored in the list customers.

When CUSTS is inputted when a new customer is added, the new customer T. McInerney who lives at 1 Park Lane, Toronto is stored in the customers arraylist. 
The customer was issued the ID 904.

When ORDER is inputted Creates a customer object called currentcustomer that is set to null, than loops through the array list customers than checks
if the customer Id’s are the same if they are it sets currentcustomer to customerid than breaks the loop. If currentcustomer is null than an error
message is shown an null is returned. Creates a product object called currentproduct that is set to null, than loops through the arraylist products
if the productIds are the same than currentproduct is set to the productid and  the loop is broken if currentproduct is null than an error message 
is shown and null is returned.
Checks if productOptions is valid if it is an error message is shown and null is returned. Makes sures that there is enough stock of the product if 
there isn’t than an error message is shown and null is returned. Makes a string called ON that strores the generated order number After created a 
new Product Order using ON, currentcustomers, currentproducts, and productOptions. After reduces the stock of the product that is being ordered. 
Than adds the new product order to orders. Than returns the ON.

Stores the productid and customerId that is inputed by the user than a string called success is created to store orderProduct method that is being called. 
If success is null than an error message will be printed else the order number will be printed.

When orders is inputted, for each loop that is used to loop through all the orders and prints them 1 by 1.

When ORDERBOOK is inputted, checks if the user inputs a valid option (Paperback, Hardcover or Ebook) if they do valid options will be true if 
any other option is inputted than it will be set to false since that is not a valid option. Every time it is inputted that product option is 
incremented by 1 than returned.
Sets the stock count for each of the book options. Reduces the stock count when a user orders the book option.

When ship is inputted, Order Number: 901, Not Found