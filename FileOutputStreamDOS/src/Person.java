/**
 *   Class used in binary file I/O question for midterm exam
 *   Fall, 2016
 */

public class Person
{
    private String name;
    private int age;
    private String address;

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge()
    {
        return age;
    }

    /**
     * @param age
     *            the age to set
     */
    public void setAge(int age)
    {
        this.age = age;
    }

    /**
     * @return the address
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * @param address
     *            the address to set
     */
    public void setAddress(String address)
    {
        this.address = address;
    }

    /**
     * @param name
     * @param age
     * @param address
     */
    public Person(String name, int age, String address)
    {

        this.name = name;
        this.age = age;
        this.address = address;
    }

    /**
     * 
     */
    public Person()
    {

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Person [name=" + name + ", age=" + age + ", address=" + address + "]";
    }

}
