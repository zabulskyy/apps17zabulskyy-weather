import org.json.simple.JSONObject;

public class Data extends JSONObject {

    private JSONObject jsonObject;
    private JSONObject coord;

    Data(JSONObject jsonObject) {
        super(jsonObject);
        this.jsonObject = jsonObject;
        this.coord = (JSONObject) this.jsonObject.get("coord");
    }


    public Object get(String key) {
        return this.jsonObject.get(key);
    }

    public double getTemp() {
        JSONObject main = (JSONObject) this.get("main");
        return (Double) main.get("temp");
    }

    public JSONObject getJsonData() {
        return this.jsonObject;
    }

    public double getLon() {
        return (Double) this.coord.get("lon");
    }

    public double getLat() {
        return (Double) this.coord.get("lat");
    }

    public JSONObject getWeather() {
        return (JSONObject) this.jsonObject.get("weather");
    }


}

