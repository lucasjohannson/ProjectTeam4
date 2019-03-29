import java.util.PriorityQueue;

public class Bank {

	private PriorityQueue<Customer> queuedCustomers = new PriorityQueue<>();
	
	
	public void queueCustomer(Customer qCustomer) {
	queuedCustomers.add(qCustomer);
	}



	public Customer nextCustomer() {

		
		return queuedCustomers.poll();
	}
 }
