package steps.utils.webservice;


import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.util.Properties;

public class GetDataUtils {
    private static final String PREDICTIONS = "src/test/resources/properties/predictions.json";



    public static Search getDataSearch (Gson gson, int response, Properties properties) throws IOException {
        Search[] searches = gson.fromJson(new JsonReader(new FileReader(PREDICTIONS)), Search[].class);
        return searches[response];
    }

    public static Data getResultData(Gson gson, Search search) throws IOException, URISyntaxException {
        return gson.fromJson(HttpCalls.getResponse(gson, search), (Type) GetDataUtils.class);
    }

    public static Data getResponseData(Gson gson, Properties properties, String response) throws FileNotFoundException {
        return gson.fromJson(new JsonReader(new FileReader(PREDICTIONS)), GetDataUtils.class);
    }

    public static boolean getResult(Data result, Data response) {
        if (result.data.size() != response.data.size()) {
            return false;
        } else {
            for (int i = 0; i < response.data.size(); i++) {
                if (response.data.get(i).username.hashCode() != result.data.get(i).username.hashCode()) {
                    return false;
                }
            }
            return true;
        }
    }
}

