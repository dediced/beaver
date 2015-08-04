package com.dediced.beaver;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by cvhu on 7/28/15.
 */
public class WebLink {
    public final static String USER_AGENT = "Mozilla/5.0";

    private final long linkId;
    private final String url;
    private final String content;

    public WebLink(long linkId, String url, String content) {
        this.linkId = linkId;
        this.url = url;
        this.content = content;
    }

    public long getLinkId() {
        return linkId;
    }

    public String getUrl() {
        return url;
    }

    public String getContent() {
        return content;
    }

    public String getHttpContent() {

        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            //add request header
            con.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            return getContentBody(response.toString());
        } catch (MalformedURLException e) {
            return "Invalid Url: " + url;
        } catch (ProtocolException e) {
            return "Protocol Exception";
        } catch (IOException e) {
            return "IOException with response";
        }
    }

    public String getContentBody(final String htmlString) {
            Document doc = Jsoup.parse(htmlString);
            return doc.body().text();
    }


}
