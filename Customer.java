public class Customer implements Comparable<Customer>{
    private String name = "";
    private int customerID = 0;


    public Customer(){
        this.name = "";
        this.customerID = 0;
    }

    public Customer(String myName, int id){
        this.name = myName;
        this.customerID = id;
    }

    public Customer(String myName){
        this.name = myName;
        this.customerID = 0;
    }

    public Customer(int id){
        this.name = "";
        this.customerID = id;
    }
    
    public Customer(Customer old) {
    	this.name = old.getName();
    	this.customerID = old.getID();
    }

    //Getter
    public String getName(){
        return this.name;
    }
    //Getter
    public int getID(){
        return this.customerID;
    }
    //Setter
    public void setName(String newName){
        if(newName.equals("")){
            return;
        }
        this.name = newName;
    }
    //Setter
    public void setID(int newID){
        if(newID <= 0){
            return;
        }
        this.customerID = newID;
    }

    public String toString(){
        return this.getName() + " " + this.getID();
    }

    //IA9 
    public int compareTo(Customer customerToCompare) {
        // Get id and name of customer that is passed as argument (customerTocompare)
        int idToCompare = customerToCompare.getID();
        String nameToCompare = customerToCompare.getName();

        // If same name, use ID to compare
        if (getName().equals(nameToCompare)) {
            if (getID() > idToCompare) {
                return 1;
            } else if (getID() == idToCompare) {
                return 0;
            } else {
                return -1;
            }
        }

        // Otherwise use compareTo(String x) to compare names
        if (getName().compareTo(nameToCompare) < 0) {
            return -1;
        } else {
            return 1;
        }
    }
}
