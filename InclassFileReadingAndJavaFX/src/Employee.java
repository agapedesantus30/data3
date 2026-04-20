
/**
 * Class: Employee
 * 
 * @author Agapitus Iboro
 * @version 1.0 Course : ITEC 3150 Spring 2018 Written: March 8, 2018
 * 
 * 
 *          This class describes a subclass of Person called Employee
 * 
 *          Purpose: contains the attributes specific to a type of Person called
 *          Employee.
 *
 */
public class Employee extends Person {
	// attributes
	private double salary;

	/**
	 * @param fullName
	 * @param type
	 * @param id
	 * @param salary
	 */
	public Employee(String fullName, String type, int id, double salary) {
		super(fullName, type, id);
		this.salary = salary;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString();
	}

}
