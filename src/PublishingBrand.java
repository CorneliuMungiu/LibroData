import java.util.ArrayList;

public class PublishingBrand implements IPublishArtifact{
    private int ID;
    private String name;
    private ArrayList<Book> books;

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
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

    public ArrayList<Book> getBooks() {
        return books;
    }

    public PublishingBrand(int ID, String name) {
        this.ID = ID;
        this.name = name;
        this.books = new ArrayList<>();
    }

    public PublishingBrand(int ID) {
        this.ID = ID;
    }

    /**
     * @param o Obiect de tip PublishingBrand.
     * @return Returneaza true daca ID-ul obiectului "o" este egal cu ID-ului obiectului care apeleaza metoda si false in
     * caz contrar.
     */
    @Override
    public boolean equals(Object o){
        if(!(o instanceof PublishingBrand))
            return false;
        return (this.getID() == ((PublishingBrand) o).getID());
    }

    /**
     * @return Returneaza un String in format "XML" care pastreaza toata informatia despre PublishingBrand.
     */
    @Override
    public String Publish() {
        String s;
        s = "<xml>\n" +
                "\t<publishingBrand>\n" +
                "\t\t<ID>" + this.getID() + "</ID>\n" +
                "\t\t<Name>" + this.getName() + "</Name>\n" +
                "\t</publishingBrand>\n" +
                "\t<books>\n";
        for(int i = 0; i < this.getBooks().size(); i++){//Parcurge toata lista de carti a PB
            s += "\t\t<book>\n" +
                    "\t\t\t<title>" + this.getBooks().get(i).getName() + "</title>\n" +
                    "\t\t\t<subtitle>" + this.getBooks().get(i).getSubtitle() + "</subtitle>\n" +
                    "\t\t\t<isbn>" + this.getBooks().get(i).getISBN() + "</isbn>\n" +
                    "\t\t\t<pageCount>" + this.getBooks().get(i).getPageCount() + "</pageCount>\n" +
                    "\t\t\t<keywords>" + this.getBooks().get(i).getKeywords() + "</keywords>\n" +
                    "\t\t\t<languageID>" + this.getBooks().get(i).getLanguageID() + "</languageID>\n" +
                    "\t\t\t<createdOn>" + this.getBooks().get(i).getCreatedOn() + "</createdOn>\n" +
                    "\t\t\t<authors>";
            for(int j = 0; j < this.getBooks().get(i).getAuthors().size(); j++){//Scrie toti autorii unei carti i
                s += this.getBooks().get(i).getAuthors().get(j).getFirstName() + " " + this.getBooks().get(i).getAuthors().get(j).getLastName();
            }
            s += "</authors>\n" + "<\t\t</book>\n";
        }
        s += "\t</books>\n" + "</xml>";
        return s;
    }
}
