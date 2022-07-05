public class Countries {
    private int ID;
    private String countryCode;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Countries(int ID, String countryCode) {
        this.ID = ID;
        this.countryCode = countryCode;
    }

    public Countries(int ID) {
        this.ID = ID;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Countries))
            return false;
        return (this.getID() == ((Countries) o).getID());
    }
}
