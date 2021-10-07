package pac;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/*

     this class is responsible for handling the data-feeds
 */
public class FeedHandler {

    //our HTML string param
       private static String parsedFeed="<table>"+"<tr align=\"right\">"
        +"<th>כותרת</th>"
        + "<th>תיאור ותמונה</th>"
        +"<th>תאריך</th>"
        +"<th>מעבר לכתבה</th>"
        +" </tr>";

       /*
       this function:
        1-reads the Xml RSS Feeds from the URL .
        2-calls the parsefeeds method to change the context from xml to html.
        3-returns the html string.
     * @param givenURL
     * @return parsedFeed
     * @throws FeedException
     * @throws IOException
        */
    public static String ReadFeeds() {


        try {
            URL givenURL = new URL("http://www.ynet.co.il/Integration/StoryRss2.xml");
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(givenURL));
            ParseFeeds(feed);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FeedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return parsedFeed;
        }


    }
    /*
      this function:
       1-gets the feed in xml format
       2-iterates over it and converts the data into parsedFeed param in an HTML format.

    * @param feed
       */
    public static void ParseFeeds(SyndFeed feed) {

        for(Object o: feed.getEntries()) { //iterate over the entries in the RSS feed file
            SyndEntry entry = (SyndEntry) o;
            parsedFeed +=
                    "<tr align=\"right\">"
                            + "<th>" + entry.getTitle() + "</th>"
                            + "<td>" + entry.getDescription().getValue() + "</td>"
                            +"<td>" + entry.getPublishedDate() + "</td>"
                            + "<td>" + "<a href=" + entry.getLink() + ">" + "עוד.." + "</a>" + "</td>";

        }
        parsedFeed+= "</table>";



    }




}
