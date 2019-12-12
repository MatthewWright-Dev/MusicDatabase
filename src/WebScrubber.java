import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * WebScrubber.java utilizes the jsoup java library to scrape and parse HTML
 * from a URL.
 *
 */

public class WebScrubber {

    private String url;

    public WebScrubber(String site) {
        url = site;
    }

    public void getPage()   throws IOException {
        Document doc = Jsoup.connect("http://en.wikipedia.org/").get();

        //Element body = doc.createElement();

    }

}
