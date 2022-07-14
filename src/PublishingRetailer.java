import java.util.ArrayList;

public class PublishingRetailer {
    private int ID;
    private String name;
    private ArrayList<IPublishArtifact> publishingArtifacts;
    private ArrayList<Countries> countries;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<IPublishArtifact> getPublishingArtifacts() {
        return publishingArtifacts;
    }

    public void setPublishingArtifacts(ArrayList<IPublishArtifact> publishingArtifacts) {
        this.publishingArtifacts = publishingArtifacts;
    }

    public ArrayList<Countries> getCountries() {
        return countries;
    }

    public void setCountries(ArrayList<Countries> countries) {
        this.countries = countries;
    }

    public PublishingRetailer(int ID, String name) {
        this.ID = ID;
        this.name = name;
        this.countries = new ArrayList<>();
        this.publishingArtifacts = new ArrayList<>();
    }

    public PublishingRetailer(int ID) {
        this.ID = ID;
    }

    /**
     * @param o Obiect de tip PublishingRetailer.
     * @return Returneaza true daca ID-ul obiectului "o" este egal cu ID-ului obiectului care apeleaza metoda si false in
     * caz contrar.
     */
    @Override
    public boolean equals(Object o){
        if(!(o instanceof PublishingRetailer))
            return false;
        return (this.getID() == ((PublishingRetailer) o).getID());
    }
}
