import java.util.ArrayList;

public class EditorialGroup implements IPublishArtifact{
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

    public EditorialGroup(int ID, String name) {
        this.ID = ID;
        this.name = name;
        this.books = new ArrayList<>();
    }

    public EditorialGroup(int ID) {
        this.ID = ID;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof EditorialGroup))
            return false;
        return (this.getID() == ((EditorialGroup) o).getID());
    }

    @Override
    public String Publish() {
        String s;
        s = "<xml>\n" +
                "\t<editorialGroup>\n" +
                "\t\t<ID>" + this.getID() + "</ID>\n" +
                "\t\t<Name>" + this.getName() + "</Name>\n" +
                "\t</editorialGroup>\n" +
                "\t<books>\n";
        for(int i = 0; i < this.getBooks().size(); i++){//Parcurge toata lista de carti a EG
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
