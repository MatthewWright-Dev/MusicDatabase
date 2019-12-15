import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * WebScrubber.java utilizes the jsoup library to scrape and parse HTML
 * from a URL.
 *
 */

public class WebScrubber {

    private String url;
    private Elements body;

    public WebScrubber(String site) {
        url = site;

    }

    public List<Review> reviewScraper()   {

        List<Review> reviews = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(url).timeout(6000).get();
            body = doc.select("div.new-release-items-container");

            List<String> artist = getArtists();
            List<String> albums = getAlbums();
            List<String> label = getLabels();
            List<String> genre = getGenres();
            List<String> critics = getCritic();
            List<String> descriptions = getDescription();
            List<String> bandLinks = getBandLinks();
            List<String> albumLinks = getAlbumLinks();
            List<String> rating = getRatings();
//            List<Boolean> editorsChoice = getEditorsChoice();



            for (int i = 0; i < artist.size(); i++ )    {

                reviews.add(new Review(artist.get(i),albums.get(i),label.get(i),genre.get(i),critics.get(i),
                        descriptions.get(i), bandLinks.get(i), albumLinks.get(i), rating.get(i)));

//                System.out.println(artist.get(i) + ", " +
//                        albums.get(i) + ", " +
//                        label.get(i) + ", " +
//                        genre.get(i) + ", " +
//                        critics.get(i) + "\n " +
//                        "\"" + descriptions.get(i) + "\"\n"
//                        );
            }
//
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }

        return reviews;
    }


    private List<String> getArtists()   {
        List<String> artist = new ArrayList<>();
        for (Element a: body) {
            artist = a.select("div.artist").eachText();
        }
        return artist;
    }

    private List<String> getAlbums()   {
        List<String> album = new ArrayList<>();
        for (Element a: body) {
            album = a.select("div.title").eachText();
        }
        return album;
    }

    private List<String> getLabels()   {
        List<String> label = new ArrayList<>();
        for (Element a: body) {
            label = a.select("div.labels").eachText();
        }
        return label;
    }
    private List<String> getGenres()   {
        List<String> genre = new ArrayList<>();
        for (Element a: body) {
            genre = a.select("div.genres").eachText();
        }
        return genre;
    }

    private List<String> getCritic()   {
        List<String> critic = new ArrayList<>();
        for (Element a: body) {
            critic = a.select("div.author").eachText();
        }
        return critic;
    }

    private List<String> getDescription()   {
        List<String> desc = new ArrayList<>();
        for (Element a: body) {
            desc = a.select("div.headline-review").eachText();
        }
        return desc;
    }

    private List<String> getBandLinks() {
        List<String> links = new ArrayList<>();
        for (Element a: body)  {
            links = a.select("div.artist >a").eachAttr("href");
        }
        return links;
    }

    private List<String> getAlbumLinks() {
        List<String> albLinks = new ArrayList<>();
        for (Element a: body)  {
            albLinks = a.select("div.title >a").eachAttr("href");
        }
        return albLinks;
    }

    private List<String> getRatings()   {
        List<String> rating = new ArrayList<>();
        for (Element a: body) {
            rating = a.select("div.rating-homepage span.allmusic-rating").eachAttr("class");
        }

        List<String> trimmed = new ArrayList<>();
        for (String a: rating)  {
            trimmed.add(Character.toString(a.charAt(a.length()-1)));
        }
        return trimmed;
    }

}
