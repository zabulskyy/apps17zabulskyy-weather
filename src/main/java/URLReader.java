import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLReader {
    private String urlAddress;

    URLReader(String APPID, String address, String city) {
        this.urlAddress = address + "?q=" + city + "&APPID=" + APPID;

    }

    public Data getData() {
        String data;
        try {

            URL url = new URL(this.urlAddress);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream())
            );

            data = in.readLine();

        } catch (IOException e) {
            e.printStackTrace();
            return new Data(new JSONObject());
        }

        JSONParser jsonParser = new JSONParser();
        JSONObject parsedData;
        try {
            parsedData = (JSONObject) jsonParser.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Data(new JSONObject());
        }
        return new Data(parsedData);

    }

    public static void main(String[] args) {
        String APPID = "5496614f4ca95e6dcc0445c1e7f3916d";
        String address = "http://api.openweathermap.org/data/2.5/weather";
        String city = "Lviv";

        URLReader urlReader = new URLReader(APPID, address, city);
        System.out.println(urlReader.getData());
    }
}