/**
 * Class: Video
 *
 * @author Agapitus Iboro
 * @version 1.0 Course : ITEC 3150 Spring 2012 Written: March 9, 2018
 *
 *
 *          This class � This class describes a subclass of MediaDevices called
 *          Video
 *
 *          Purpose: contains the attributes specific to a type of media device
 *          called Video.
 *
 */
public class Video extends MediaDevices {
    private String director;
    private String genre;
    private String platform;

    /**
     * @return concatenation of objects
     */
    @Override
    public String toString() {
        return super.toString() + " " + "Video [director=" + director + ", genre=" + genre + ", platform=" + platform
                + "]";
    }

    /**
     * default constructor
     */
    public Video(String category, String name, int itemNumber, String director, String genre, String platform) {
        super(category, name, itemNumber);
        this.director = director;
        this.genre = genre;
        this.platform = platform;
    }

    /**
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @return the platform
     */
    public String getPlatform() {
        return platform;
    }
}
