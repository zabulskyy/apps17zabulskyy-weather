import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    private JSONObject jsonObject;
    private String fileName;

    public Writer(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public Writer(JSONObject jsonObject, String fileName) {
        this.jsonObject = jsonObject;
        this.fileName = fileName;
    }
    public void writeJsonData() {
        if (this.fileName == null){
            return;
        }
        try {
            FileWriter fileWriter = new FileWriter(this.fileName);
            fileWriter.write(this.jsonObject.toJSONString());
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFileName() {
        return fileName;
    }

    public Writer setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }
}
