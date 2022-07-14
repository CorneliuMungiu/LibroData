import java.util.ArrayList;
import java.util.Date;

public class Book implements IPublishArtifact {
    private int ID;
    private String name;
    private String subtitle;
    String ISBN;
    private int pageCount;
    private String keywords;
    private int languageID;
    private Date createdOn;
    private ArrayList<Author> authors;

    public void setName(String name) {
        this.name = name;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setLanguageID(int languageID) {
        this.languageID = languageID;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getKeywords() {
        return keywords;
    }

    public int getLanguageID() {
        return languageID;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public Book(int ID, String name, String subtitle, String ISBN, int pageCount, String keywords, int languageID, Date createdOn) {
        this.ID = ID;
        this.name = name;
        this.subtitle = subtitle;
        this.ISBN = ISBN;
        this.pageCount = pageCount;
        this.keywords = keywords;
        this.languageID = languageID;
        this.createdOn = createdOn;
        this.authors = new ArrayList<>();
    }

    public Book(int ID) {
        this.ID = ID;
    }

    /**
     * @param o Obiect de tip Book
     * @return Returneaza true daca ID-ul obiectului "o" este egal cu ID-ului obiectului care apeleaza metoda si false in
     * caz contrar.
     */
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Book))
            return false;
        return (this.getID() == ((Book) o).getID());
    }

    /**
     * @return Returneaza un String in format "XML" care pastreaza toata informatia despre carte.
     */
    @Override
    public String Publish() {
        StringBuilder s;
        s = new StringBuilder("<xml>\n" +
                "\t<title>" + this.getName() + "</title>\n" +
                "\t<subtitle>" + this.getSubtitle() + "</subtitle>\n" +
                "\t<isbn>" + this.getISBN() + "</isbn>\n" +
                "\t<pageCount>" + this.getPageCount() + "</pageCount>\n" +
                "\t<keywords>" + this.getKeywords() + "</keywords>\n" +
                "\t<languageID>" + this.getLanguageID() + "</languageID>\n" +
                "\t<createdOn>" + this.getCreatedOn() + "</createdOn>\n" +
                "\t<authors>");
        for(int i = 0; i < this.getAuthors().size(); i++){//Scrie toti autorii (separati prin ;)
            s.append(this.getAuthors().get(i).getFirstName()).append(" ").append(this.getAuthors().get(i).getLastName());
            if (i != this.getAuthors().size() - 1){
                s.append(";");
            }
        }
            s.append("</authors>\n" + "</xml>");
        return s.toString();
    }
}
