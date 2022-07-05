import java.util.ArrayList;

public class Administration {
    ArrayList<PublishingRetailer> retailers;
    ArrayList<Language> languages;

    public Administration(ArrayList<PublishingRetailer> retailers, ArrayList<Language> languages) {
        this.retailers = retailers;
        this.languages = languages;
    }

    //Cauta un PublishingRetailer dupa ID si reintoarce acel PublishingRetailer.
    public static PublishingRetailer returnRetailer(ArrayList<PublishingRetailer> retailers, int publishingRetailerID){
        PublishingRetailer retailer = null;
        for (PublishingRetailer publishingRetailer : retailers) {
            if (publishingRetailer.getID() == publishingRetailerID) {
                retailer = publishingRetailer;
            }
        }
        return retailer;
    }

    //Intoarce toate cartile unui PublishingRetailer dupa ID
    public ArrayList<Book> getBooksForPublishingRetailerID(int publishingRetailerID){
        PublishingRetailer retailer = returnRetailer(this.retailers,publishingRetailerID);//Retailerul cu ID-ul publishingRetailerID
        ArrayList<Book> allBooks = new ArrayList<>();//Lista de carti a retailerului care va fi returnata la final
        for(int i = 0; i < retailer.getPublishingArtifacts().size(); i++){//parcurge PublishingArtifacts a retailerului
            if(retailer.getPublishingArtifacts().get(i) instanceof Book){//Daca PublishingArtifact(i) este instanta a lui Book
               if(!allBooks.contains((Book)retailer.getPublishingArtifacts().get(i))){//Verific daca cartea nu este deja adaugata in lista
                   allBooks.add((Book)retailer.getPublishingArtifacts().get(i));//adaug cartea in caz in care ea nu este deja in lista
               }
            }
            if(retailer.getPublishingArtifacts().get(i) instanceof EditorialGroup){//Daca este instanta de EditorialGroup
                //Intoarce toate cartile unui editorialGroup din PublishingArtifacts(i)
                ArrayList<Book> editorialGroupsBooks = ((EditorialGroup)retailer.getPublishingArtifacts().get(i)).getBooks();
                for (Book editorialGroupsBook : editorialGroupsBooks) {//parcurg toate cartile
                    if (!allBooks.contains(editorialGroupsBook)) {//verifica daca cartea j nu este deja in lista
                        allBooks.add(editorialGroupsBook);//adauga cartea in caz ca nu exista in lista
                    }
                }
            }
            if(retailer.getPublishingArtifacts().get(i) instanceof PublishingBrand){//Daca este instanta de PublishingBrand
                //Intoarce toate cartile unui publishingBrand din PublishingArtifacts(i)
                ArrayList<Book> publishingBrandBooks = ((PublishingBrand)retailer.getPublishingArtifacts().get(i)).getBooks();
                for (Book publishingBrandBook : publishingBrandBooks) {//parcurge toate cartile
                    if (!allBooks.contains(publishingBrandBook)) {//verifica daca cartea j nu este deja in lista
                        allBooks.add(publishingBrandBook);//adauga cartea in caz ca nu exista in lista
                    }
                }
            }
        }
        return allBooks;
    }

    //Returneaza limbile in care sunt publicate cartile unui retailer
    public ArrayList<Language> getLanguagesForPublishingRetailerID(int publishingRetailerID){
        ArrayList<Language> allLanguages = new ArrayList<>();//Lista de limbi care va fi returnata la final
        ArrayList<Book> allBooks = getBooksForPublishingRetailerID(publishingRetailerID);//returneaza toate cartile retailerului
        for (Book allBook : allBooks) {//parcurge fiecare carte
            for (Language language : languages) {//parcurg lista de limbi
                if (language.getID() == allBook.getLanguageID()) {//Caut limba in care este scrisa cartea dupa getLanguageID
                    if (!allLanguages.contains(language)) {//verific daca limba j nu este deja in lista
                        allLanguages.add(language);//daca nu este atunci o adaug
                    }
                }
            }
        }
        return allLanguages;
    }

    //Reintoarce tarile in care a ajuns o carte
    public ArrayList<Countries> getCountriesForBookID(int bookID){
        ArrayList<Countries> allCountries = new ArrayList<>();//lista de tari care va fi returnata la sfarsit
        for (PublishingRetailer retailer : retailers) {//parcurg toti retailerii
            ArrayList<Book> allBooks = getBooksForPublishingRetailerID(retailer.getID());//intoarce toate cartile retailerului i
            for (Book allBook : allBooks) {//parcurg toate cartile retailerului i
                if (allBook.getID() == bookID) {//Daca gasesc o carte cu acelasi ID ca si bookID
                    for (int z = 0; z < retailer.getCountries().size(); z++) {//Parcurg toate tarile retailerului
                        if (!allCountries.contains(retailer.getCountries().get(z))) {//verific daca deja nu exista asa tara in lista
                            allCountries.add(retailer.getCountries().get(z));//adaug tara daca nu exista in lista
                        }
                    }
                }
            }
        }
        return allCountries;
    }

    //Reintoarce o lista de carti comune a 2 retaileri
    public ArrayList<Book> getCommonBooksForRetailerIDs(int retailerID1, int retailerID2){
        ArrayList<Book> bookRetailer1 = getBooksForPublishingRetailerID(retailerID1);//Returneaza toate cartile retailerului 1
        ArrayList<Book> bookRetailer2 = getBooksForPublishingRetailerID(retailerID2);//Returneaza toate cartile retailerului 2
        ArrayList<Book> allBooks = new ArrayList<>();
        for (Book book : bookRetailer2) {//Parcurg toate cartile retailerului 2
            if (bookRetailer1.contains(book)) {//daca cartea i din lista de carti a retailerului 1 se contine in lista de carti a retailerului 2
                allBooks.add(book);//adauga cartea in lista de carti comune
            }
        }
        return allBooks;
    }

    //Reintoarce o lista de carti a celor 2 retaileri(fara repetari)
    public ArrayList<Book> getAllBooksForRetailerIDs(int retailerID1, int retailerID2){
        ArrayList<Book> allBooks = getBooksForPublishingRetailerID(retailerID1);//Atribui listei finale toate cartile retailerului 1
        ArrayList<Book> bookRetailer2 = getBooksForPublishingRetailerID(retailerID2);//Cartile retailerului 2
        for (Book book : bookRetailer2) {//parcurg cartile retailerului 2
            if (!allBooks.contains(book)) {//daca cartea i din lista cartilor retailerului 2 nu se contine in lista
                allBooks.add(book);//adaug in lista cartea
            }
        }
        return allBooks;
    }
}
