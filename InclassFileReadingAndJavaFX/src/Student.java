
/**
 * Class: Student
 * 
 * @author Agapitus Iboro
 * @version 1.0 Course : ITEC 3150 Spring 2018 Written: March 8, 2018
 * 
 * 
 *          This class describes a subclass of Person called Student
 * 
 *          Purpose: contains the attributes specific to a type of Person called
 *          Student.
 *
 */

public class Student extends Person {

	// attributes of student
	private double gpa;

	/**
	 * @return the gpa
	 */
	public double getGpa() {
		return gpa;
	}

	/**
	 * @param gpa
	 *            the gpa to set
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
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

	/**
	 * @param fullName
	 * @param type
	 * @param id
	 * @param gpa
	 */
	public Student(String fullName, String type, int id, double gpa) {
		super(fullName, type, id);
		this.gpa = gpa;
	}

}
