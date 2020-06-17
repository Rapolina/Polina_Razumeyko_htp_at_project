package steps.utils.webservice;

public class Search {
    private String user;
    private Boolean strict;

    public Search(String user, Boolean strict) {
        this.user = user;
        this.strict = strict;
    }

    public Search() {
    }

    public String getUser() {
        return user;
    }

    public Boolean getStrict() {
        return strict;
    }

}
