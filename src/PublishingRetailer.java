public class PublishingRetailer {
    private int ID;
    private String name;
    IPublishingArtifact[] publishingArtifacts;
    Country[] countries;
    private int index = 0;

    public PublishingRetailer(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setCountries(Country[] countries_array) {
        this.countries = countries_array;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
