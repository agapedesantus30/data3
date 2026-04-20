/**
 * Class: Music
 * 
 * @author Agapitus Iboro
 * @version 1.0 Course : ITEC 3150 Spring 2018 Written: March 9, 2018
 * 
 * 
 *          This class � This class describes a subclass of MediaDevices called
 *          Music
 * 
 *          Purpose: contains the attributes specific to a type of media device
 *          called Music.
 *
 */
public class Music extends MediaDevices {
	private String artist;
	private String platform;

	/**
	 * @return concatenation of objects
	 */
	@Override
	public String toString() {
		return super.toString() + " " + "Music [artist=" + artist + ", platform=" + platform + "]";
	}

	/**
	 * default constructor
	 */
	public Music(String category, String name, int itemNumber, String artist, String platform) {
		super(category, name, itemNumber);
		this.artist = artist;
		this.platform = platform;
	}

	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}
}
