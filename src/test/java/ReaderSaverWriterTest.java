import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReaderSaverWriterTest {
    URLReader urlReader;
    Data data;
    Writer writer;

    @Test
    public void test() throws Exception {
//        http://api.openweathermap.org/data/2.5/weather?q=Lviv&APPID=5496614f4ca95e6dcc0445c1e7f3916d
        String APPID = "5496614f4ca95e6dcc0445c1e7f3916d";
        String address = "http://api.openweathermap.org/data/2.5/weather";
        String city = "Lviv";

        urlReader = new URLReader(APPID, address, city);
        data = urlReader.getData();
        writer = new Writer(data.getJsonData(), "data.txt");

        writer.writeJsonData();


        double lon = 24.03;
        double lat = 49.84;

        assertEquals(lon, urlReader.getData().getLon(), 0.01d);
        assertEquals(lat, urlReader.getData().getLat(), 0.01d);
        assertEquals("Lviv", urlReader.getData().get("name"));




    }

}