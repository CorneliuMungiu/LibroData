import java.io.File;
import java.util.ArrayList;


public class Main {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    //Afiseaza numele tuturor cartilor dintr-o lista de carti
    public static void  AfiBooks(ArrayList<Book> books){
        for (Book book : books) {
            System.out.println(book.getName());
        }
    }

    //Afiseaza toate numele limbilor dintr-o lista de limbi
    public static void AfiLanguages(ArrayList<Language> languages){
        for (Language language : languages) {
            System.out.println(language.getName());
        }
    }

    //Afiseaza numele tuturor tarilor dintr-o lista de tari
    public static void AfiCountries(ArrayList<Countries> countries){
        for (Countries country : countries) {
            System.out.println(country.getCountryCode());
        }
    }

    public static void main(String[] args) {
        ArrayList<Object> obj;

        //Citeste din fisier authors.in
        File authorFile = new File("./init/authors.in");
        obj = ReadFromFile.InitLists(authorFile,"authors");
        ArrayList<Author> authors = new ArrayList<>();
        for (Object o : obj) {//cast la Author
            Author aux = (Author) o;
            authors.add(aux);
        }

        //Citeste din fisier books.in
        File booksFile = new File("./init/books.in");
        obj = ReadFromFile.InitLists(booksFile,"books");
        ArrayList<Book> books = new ArrayList<>();
        for (Object o : obj) {//Cast la Book
            Book aux = (Book) o;
            books.add(aux);
        }

        //Citeste din fisier languages.in
        File languagesFile = new File("./init/languages.in");
        obj = ReadFromFile.InitLists(languagesFile,"languages");
        ArrayList<Language> languages = new ArrayList<>();
        for (Object o : obj) {
            Language aux = (Language) o;
            languages.add(aux);
        }

        //Citeste din fisier editorial-groups.in
        File editorialGroupsFile = new File("./init/editorial-groups.in");
        obj = ReadFromFile.InitLists(editorialGroupsFile,"editorial-groups");
        ArrayList<EditorialGroup> editorialGroups = new ArrayList<>();
        for(Object o : obj){
            EditorialGroup aux = (EditorialGroup) o;
            editorialGroups.add(aux);
        }

        //Citeste din fisier publishing-brands.in
        File publishingBrandsFile = new File("./init/publishing-brands.in");
        obj = ReadFromFile.InitLists(publishingBrandsFile,"publishing-brands");
        ArrayList<PublishingBrand> publishingBrands = new ArrayList<>();
        for(Object o : obj){
            PublishingBrand aux = (PublishingBrand) o;
            publishingBrands.add(aux);
        }

        //Citeste din fisier publishing-retailer.in
        File publishingRetailersFile = new File("./init/publishing-retailers.in");
        obj = ReadFromFile.InitLists(publishingRetailersFile,"publishing-retailers");
        ArrayList<PublishingRetailer> publishingRetailers = new ArrayList<>();
        for(Object o : obj){
            PublishingRetailer aux = (PublishingRetailer) o;
            publishingRetailers.add(aux);
        }

        //Citeste din fisier countries.in
        File countriesFile = new File("./init/countries.in");
        obj = ReadFromFile.InitLists(countriesFile,"countries");
        ArrayList<Countries> countries = new ArrayList<>();
        for(Object o : obj){
            Countries aux = (Countries) o;
            countries.add(aux);
        }

        //Citeste din books-authors.in
        File booksAuthorFile = new File("./init/books-authors.in");
        ReadFromFile.addAuthorsToBook(booksAuthorFile,books,authors);

        //Citeste din editorial-groups-books.in
        File editorialGroupsBooksFile = new File("./init/editorial-groups-books.in");
        ReadFromFile.addBooksToEG(editorialGroupsBooksFile,books,editorialGroups);

        //Citeste din publishing-brands-books.in
        File publishingBrandsBooksFile = new File("./init/publishing-brands-books.in");
        ReadFromFile.addBooksToPB(publishingBrandsBooksFile,books,publishingBrands);

        //Citeste din publishing-retailers-****.in
        File publishingRetailersCountriesFile = new File("./init/publishing-retailers-countries.in");
        File publishingRetailersBooksFile = new File("./init/publishing-retailers-books.in");
        File publishingRetailersEGFile = new File("./init/publishing-retailers-editorial-groups.in");
        File publishingRetailersPBFile = new File("./init/publishing-retailers-publishing-brands.in");
        ReadFromFile.addListsToPR(publishingRetailersCountriesFile,publishingRetailers,countries,books,editorialGroups,publishingBrands,"Countries");
        ReadFromFile.addListsToPR(publishingRetailersBooksFile,publishingRetailers,countries,books,editorialGroups,publishingBrands,"Books");
        ReadFromFile.addListsToPR(publishingRetailersEGFile,publishingRetailers,countries,books,editorialGroups,publishingBrands,"EditorialGroups");
        ReadFromFile.addListsToPR(publishingRetailersPBFile,publishingRetailers,countries,books,editorialGroups,publishingBrands,"PublishingBrands");

        //Test 1
        Administration test = new Administration(publishingRetailers,languages);
        System.out.println(ANSI_RED + "Test 1.1" + ANSI_RESET);
        ArrayList<Book> bookTest = test.getBooksForPublishingRetailerID(1);
        AfiBooks(bookTest);

        System.out.println();
        System.out.println(ANSI_RED + "Test 1.2" + ANSI_RESET);
        bookTest = test.getBooksForPublishingRetailerID(2);
        AfiBooks(bookTest);

        System.out.println();
        System.out.println(ANSI_RED + "Test 1.3" + ANSI_RESET);
        bookTest = test.getBooksForPublishingRetailerID(28);
        AfiBooks(bookTest);

        System.out.println();
        System.out.println(ANSI_RED + "Test 1.4" + ANSI_RESET);
        bookTest = test.getBooksForPublishingRetailerID(32);
        AfiBooks(bookTest);

        System.out.println();
        System.out.println(ANSI_RED + "Test 1.5" + ANSI_RESET);
        bookTest = test.getBooksForPublishingRetailerID(14);
        AfiBooks(bookTest);

        //Test 2
        System.out.println();
        System.out.println(ANSI_YELLOW + "Test 2.1" + ANSI_RESET);
        ArrayList<Language> languageTest = test.getLanguagesForPublishingRetailerID(1);
        AfiLanguages(languageTest);

        System.out.println();
        System.out.println(ANSI_YELLOW + "Test 2.2" + ANSI_RESET);
        languageTest = test.getLanguagesForPublishingRetailerID(23);
        AfiLanguages(languageTest);

        System.out.println();
        System.out.println(ANSI_YELLOW + "Test 2.3" + ANSI_RESET);
        languageTest = test.getLanguagesForPublishingRetailerID(32);
        AfiLanguages(languageTest);

        System.out.println();
        System.out.println(ANSI_YELLOW + "Test 2.4" + ANSI_RESET);
        languageTest = test.getLanguagesForPublishingRetailerID(12);
        AfiLanguages(languageTest);

        System.out.println();
        System.out.println(ANSI_YELLOW + "Test 2.5" + ANSI_RESET);
        languageTest = test.getLanguagesForPublishingRetailerID(28);
        AfiLanguages(languageTest);

        //Test 3
        System.out.println();
        System.out.println(ANSI_BLUE + "Test 3.1" + ANSI_RESET);
        ArrayList<Countries> countriesTest = test.getCountriesForBookID(204);
        AfiCountries(countriesTest);

        System.out.println();
        System.out.println(ANSI_BLUE + "Test 3.2" + ANSI_RESET);
        countriesTest = test.getCountriesForBookID(1353);
        AfiCountries(countriesTest);

        System.out.println();
        System.out.println(ANSI_BLUE + "Test 3.3" + ANSI_RESET);
        countriesTest = test.getCountriesForBookID(2456);
        AfiCountries(countriesTest);

        System.out.println();
        System.out.println(ANSI_BLUE + "Test 3.4" + ANSI_RESET);
        countriesTest = test.getCountriesForBookID(4000);
        AfiCountries(countriesTest);

        System.out.println();
        System.out.println(ANSI_BLUE + "Test 3.5" + ANSI_RESET);
        countriesTest = test.getCountriesForBookID(11553);
        AfiCountries(countriesTest);

        //Test 4
        System.out.println();
        System.out.println(ANSI_GREEN + "Test 4.1" + ANSI_RESET);
        bookTest = test.getCommonBooksForRetailerIDs(2,13);
        AfiBooks(bookTest);

        System.out.println();
        System.out.println(ANSI_GREEN + "Test 4.2" + ANSI_RESET);
        bookTest = test.getCommonBooksForRetailerIDs(1,32);
        AfiBooks(bookTest);

        System.out.println();
        System.out.println(ANSI_GREEN + "Test 4.3" + ANSI_RESET);
        bookTest = test.getCommonBooksForRetailerIDs(30,12);
        AfiBooks(bookTest);

        System.out.println();
        System.out.println(ANSI_GREEN + "Test 4.4" + ANSI_RESET);
        bookTest = test.getCommonBooksForRetailerIDs(16,17);
        AfiBooks(bookTest);

        System.out.println();
        System.out.println(ANSI_GREEN + "Test 4.5" + ANSI_RESET);
        bookTest = test.getCommonBooksForRetailerIDs(25,28);
        AfiBooks(bookTest);

        //Test 5
        System.out.println();
        System.out.println(ANSI_PURPLE + "Test 5.1" + ANSI_RESET);
        bookTest = test.getAllBooksForRetailerIDs(1,32);
        AfiBooks(bookTest);

        System.out.println();
        System.out.println(ANSI_PURPLE + "Test 5.2" + ANSI_RESET);
        bookTest = test.getAllBooksForRetailerIDs(30,12);
        AfiBooks(bookTest);

        System.out.println();
        System.out.println(ANSI_PURPLE + "Test 5.3" + ANSI_RESET);
        bookTest = test.getAllBooksForRetailerIDs(16,17);
        AfiBooks(bookTest);

        System.out.println();
        System.out.println(ANSI_PURPLE + "Test 5.4" + ANSI_RESET);
        bookTest = test.getAllBooksForRetailerIDs(25,28);
        AfiBooks(bookTest);

        System.out.println();
        System.out.println(ANSI_PURPLE + "Test 5.5" + ANSI_RESET);
        bookTest = test.getAllBooksForRetailerIDs(13,14);
        AfiBooks(bookTest);
    }
}
