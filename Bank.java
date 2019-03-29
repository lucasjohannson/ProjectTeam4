import java.util.*;

public class Bank {
	private TreeSet<Customer> customers;

	public Bank(){
		customers = new TreeSet<Customer>();
	}

	public void addCustomer(Customer c) {
		customers.add(c);
	}


	public Customer[] getCustomers() {
		int customersSize = customers.size();
		Customer[] listToReturn = new Customer[customersSize];
		for (int i = 0; i < customersSize; i++){
			listToReturn[i] = customers.pollFirst();

		}

		return listToReturn;
	}

}
