package dw.t3;

import org.json.*;

public class Parser {

    /**
     * Parses the needed data from the JSON string.
     * @param json the JSON string to parse the data from.
     */
    public String parseJSON(String json) {
        JSONObject obj = new JSONObject(json);

        JSONArray arr = obj.getJSONArray("data");
        for (int i = 0; i < arr.length(); i++) {
            JSONObject value = arr.getJSONObject(i);
            value.remove("adj_high");
            value.remove("adj_low");
            value.remove("adj_close");
            value.remove("adj_open");
            value.remove("adj_volume");
            value.remove("split_factor");
            value.remove("dividend");
            if (i > 0) {
                value.remove("symbol");
                value.remove("exchange");
            }
        }
        return arr.toString();
    }

}
