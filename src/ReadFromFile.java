import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ReadFromFile {

    //Creeaza lista cu toate:
    //Book,Language,Author,EditorialGroup,PublishingBrand,PublishingRetailer,Country
    public static ArrayList<Object> InitLists(File file, String type) {
        ArrayList<Object> obj = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            br.readLine();//nu citeste prima linie
            while((line = br.readLine()) != null){
                String[] s = line.split("###");//Pune intr-un array de stringuri datele citite din fisier
                if(type.equals("authors")){//Citeste din authors.in
                    Author author = new Author(Integer.parseInt(s[0]),s[1],s[2]);//Creeaza un nou autor
                    obj.add(author);//adauga autorul in lista
                    continue;
                }

                if(type.equals("books")){//Citeste din books.in
                    SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");//Formatul pentru createdOn
                    Date date = format1.parse(s[7]);//createdOn
                    //Initializeaza celelalte campuri a cartii
                    Book book = new Book(Integer.parseInt(s[0]),s[1],s[2],s[3],Integer.parseInt(s[4]),s[5],Integer.parseInt(s[6]),date);
                    obj.add(book);//adauga cartea in lista de carti
                    continue;
                }

                if(type.equals("languages")){//Citeste din languages.in
                    Language language = new Language(Integer.parseInt(s[0]),s[1],s[2]);//Initializeaza campurile languages
                    obj.add(language);//adauga limba in lista de limbi
                    continue;
                }

                if(type.equals("editorial-groups")){//Citeste din editorialGroups.in
                    EditorialGroup editorialGroup = new EditorialGroup(Integer.parseInt(s[0]),s[1]);//Initializeaza campurile editorialGroup
                    obj.add(editorialGroup);//Adauga un editorialGroup in lista de editorialGroups
                    continue;
                }

                if(type.equals("publishing-brands")){//Citeste din publishingBrands.in
                    PublishingBrand publishingBrand = new PublishingBrand(Integer.parseInt(s[0]), s[1]);//Initializeaza campurile publishingBrand
                    obj.add(publishingBrand);//Adauga un publishingBrand in lista de publishingBrands
                    continue;
                }

                if(type.equals("publishing-retailers")){//Citeste din publishingRetailer.in
                    PublishingRetailer publishingRetailer = new PublishingRetailer(Integer.parseInt(s[0]),s[1]);//Initializeaza campurile publishinRetailer
                    obj.add(publishingRetailer);//Adauga un publishingRetailer in lista de publishingRetailers
                    continue;
                }

                if(type.equals("countries")){//Citeste din countries.in
                    Countries countries = new Countries(Integer.parseInt(s[0]),s[1]);//Initializeaza campurile unei tari
                    obj.add(countries);//adauga tara in lista de tari
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return obj;
    }

    //Adauga autori unei carti
    public static void addAuthorsToBook(File file, ArrayList<Book> books, ArrayList<Author> authors){
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] s = line.split("###");
                Book aux1 = new Book(Integer.parseInt(s[0]));//Creeaza o noua carte cu un ID
                Author aux2 = new Author(Integer.parseInt(s[1]));//Creeaza un nou autor cu un ID
                //Gaseste cartea care are acelasi index ca si cartea noua creata si adauga autorul cu acelsi index ca si autorul nou creat
                books.get(books.indexOf(aux1)).getAuthors().add(authors.get(authors.indexOf(aux2)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Adauga carti unui EditorialGroup
    public static void addBooksToEG(File file, ArrayList<Book> books, ArrayList<EditorialGroup> editorialGroups){
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            br.readLine();
            while((line = br.readLine()) != null){
                String[] s = line.split("###");
                EditorialGroup aux1 = new EditorialGroup(Integer.parseInt(s[0]));//Creeaza un nou EditorialGroup cu un ID
                Book aux2 = new Book(Integer.parseInt(s[1]));//Creeaza o noua carte cu un ID
                //Gaseste EG care are acelasi index ca si EG nou creat si adauga cartea cu acelsi index ca si cartea nou creata
                editorialGroups.get(editorialGroups.indexOf(aux1)).getBooks().add(books.get(books.indexOf(aux2)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Adauga carti unui PublishingBrand
    public static void addBooksToPB(File file, ArrayList<Book> books, ArrayList<PublishingBrand> publishingBrands){
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            br.readLine();
            while((line = br.readLine()) != null){
                String[] s = line.split("###");
                PublishingBrand aux1 = new PublishingBrand(Integer.parseInt(s[0]));//Creeaza un nou PublishingBrand cu un ID
                Book aux2 = new Book(Integer.parseInt(s[1]));//Creeaza o noua carte cu un ID
                //Gaseste PB care are acelasi index ca si PB nou creat si adauga cartea cu acelsi index ca si cartea nou creata
                publishingBrands.get(publishingBrands.indexOf(aux1)).getBooks().add(books.get(books.indexOf(aux2)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Initializeaza campurile PublishingRetailer
    public static void addListsToPR(File file, ArrayList<PublishingRetailer> publishingRetailers,
                                    ArrayList<Countries> countries,ArrayList<Book> books ,ArrayList<EditorialGroup> editorialGroups,
                                    ArrayList<PublishingBrand> publishingBrands ,String type){
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            br.readLine();
            while((line = br.readLine()) != null){
                String[] s = line.split("###");
                PublishingRetailer aux1 = new PublishingRetailer(Integer.parseInt(s[0]));//Creeaza un nou retailer cu un ID
                if (type.equals("Countries")) {//Citeste din publishing-retailers-countries.in
                    Countries aux2 = new Countries(Integer.parseInt(s[1]));//Creeaza o noua tara cu un ID
                    //Gaseste PR care are acelasi index ca si PR nou creat si adauga tara cu acelsi index ca si tara nou creata
                    publishingRetailers.get(publishingRetailers.indexOf(aux1)).getCountries().add(countries.get(countries.indexOf(aux2)));
                    continue;
                }

                if(type.equals("Books")){//Citeste din publishing-retailers-books.in
                    IPublishArtifact aux2 = new Book(Integer.parseInt(s[1]));//Creeaza o noua carte cu un ID
                    //Gaseste PR care are acelasi index ca si PR nou creat si adauga cartea cu acelsi index ca si cartea nou creata in lista de Artefacte
                    publishingRetailers.get(publishingRetailers.indexOf(aux1)).getPublishingArtifacts().add(books.get(books.indexOf(aux2)));
                    continue;
                }

                if(type.equals("EditorialGroups")){//Citeste din publishing-retailers-editorial-groups.in
                    IPublishArtifact aux2 = new EditorialGroup(Integer.parseInt(s[1]));//Creeaza un editorialGroup cu un ID
                    //Gaseste PR care are acelasi index ca si PR nou creat si adauga EG cu acelsi index ca si EG nou creat in lista de Artefacte
                    publishingRetailers.get(publishingRetailers.indexOf(aux1)).getPublishingArtifacts().add(editorialGroups.get(editorialGroups.indexOf(aux2)));
                    continue;
                }

                if(type.equals("PublishingBrands")){//Citeste din publishing-retailers-publishing-brands.in
                    IPublishArtifact aux2 = new PublishingBrand(Integer.parseInt(s[1]));//Creeaza un publishingBrand cu un ID
                    //Gaseste PR care are acelasi index ca si PR nou creat si adauga PB cu acelsi index ca si PB nou creat in lista de Artefacte
                    publishingRetailers.get(publishingRetailers.indexOf(aux1)).getPublishingArtifacts().add(publishingBrands.get(publishingBrands.indexOf(aux2)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
