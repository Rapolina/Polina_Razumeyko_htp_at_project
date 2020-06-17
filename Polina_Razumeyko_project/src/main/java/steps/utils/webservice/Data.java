package steps.utils.webservice;

import java.util.List;

public class Data {
    public String code;
    public List<Users> data;

    public Data(String code, List<Users> usersList) {
        this.code = code;
        this.data = usersList;
    }
}
