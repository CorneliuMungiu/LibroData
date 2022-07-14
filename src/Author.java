public class Author {
    private int ID;
    private String firstName;
    private String lastName;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Author(int ID, String firstName, String lastName) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author(int ID) {
        this.ID = ID;
    }

    /**
     * @param o Obiect de tip Author
     * @return Returneaza true daca ID-ul obiectului "o" este egal cu ID-ului obiectului care apeleaza metoda si false in
     * caz contrar.
     */
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Author))
            return false;
        return (this.getID() == ((Author) o).getID());
    }
}
