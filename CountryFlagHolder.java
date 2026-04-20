import javafx.scene.image.ImageView;

/**
 * @author cynthiajohnson
 *
 */
public class CountryFlagHolder 
{
	private String name;
	private ImageView flag;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the flag
	 */
	public ImageView getFlag() {
		return flag;
	}
	/**
	 * @param name
	 * @param flag
	 */
	public CountryFlagHolder(String name, ImageView flag) {
		super();
		this.name = name;
		this.flag = flag;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return  name ;
	}
	

}
