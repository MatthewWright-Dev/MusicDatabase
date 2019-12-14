/**
 * Review.java is a class representing an instance of an album review.
 *
 * @author Matt Wright (mattmyth@gmail.com)
 * @version 12-13-19
 */

public class Review {

    private String artist, album, label, genre, critic, description, bandLink, albumLink, rating;


    public Review(String artist, String album, String label, String genre, String critic, String description, String bandLink, String albumLink, String rating) {
        this.artist = artist;
        this.album = album;
        this.label = label;
        this.genre = genre;
        this.critic = critic;
        this.description = description;
        this.bandLink = bandLink;
        this.albumLink = albumLink;
        this.rating = rating;
    }

    public String toString () {
        return artist + ", \n" +
               album + ", \n" +
               label + ", \n" +
               genre + ", \n" +
               critic + ", \n" +
               description + ", \n" +
               bandLink + " \n" +
               albumLink + "\n" +
               rating + "\n*********************\n";
    }
}
