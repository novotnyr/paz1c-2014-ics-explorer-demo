package sk.upjs.ics.ics.explorer;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.IOUtils;


public class WebPageUtils {
    public static String downloadWebPage(String urlString) throws MalformedURLException, IOException {
        URL url = new URL(urlString);
        return IOUtils.toString(url);
    }
}
