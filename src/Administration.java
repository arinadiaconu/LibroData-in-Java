import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;

public class Administration{
    private LibroData libroData;

    public Administration() {
        //initializes the LibroData
        this.libroData = new LibroData();
        this.libroData.InitLibroData();
    }

    Book[] getBooksForPublishingRetailerID(int publishingRetailerID) {
        Book[] books_array = null;
        for(int i = 0; i < libroData.publishingRetailers.length; i++) {
            //finds the given retailer ID
            if(libroData.publishingRetailers[i].getID() == publishingRetailerID) {
                //for each book from that retailer
                for(int j = 0; j < libroData.publishingRetailers[i].publishingArtifacts.length; j++) {
                    //if it's the first book
                    if(books_array == null) {
                        books_array = new Book[1];
                        books_array[0] = new Book(((Book)libroData.publishingRetailers[i].publishingArtifacts[j]).getID(), ((Book)libroData.publishingRetailers[i].publishingArtifacts[j]).getName(), ((Book)libroData.publishingRetailers[i].publishingArtifacts[j]).getSubtitle(), ((Book)libroData.publishingRetailers[i].publishingArtifacts[j]).getISBN(), ((Book)libroData.publishingRetailers[i].publishingArtifacts[j]).getPageCount(), ((Book)libroData.publishingRetailers[i].publishingArtifacts[j]).getKeywords(), ((Book)libroData.publishingRetailers[i].publishingArtifacts[j]).getLanguageID(), ((Book)libroData.publishingRetailers[i].publishingArtifacts[j]).getCreatedOn());
                        books_array[0].setAuthors(((Book)libroData.publishingRetailers[i].publishingArtifacts[j]).getAuthors());
                    }
                    else {
                        //verifies if the book wasn't already
                        int unique = 1;
                        for(int k = 0; k < books_array.length; k++) {
                            if(books_array[k].getID() == ((Book)libroData.publishingRetailers[i].publishingArtifacts[j]).getID()) {
                                unique = 0;
                                break;
                            }
                        }
                        //if it is unique, it adds it to the book list
                        if(unique == 1) {
                            books_array = Arrays.copyOf(books_array, books_array.length + 1);
                            books_array[books_array.length - 1] = new Book(((Book)libroData.publishingRetailers[i].publishingArtifacts[j]).getID(), ((Book)libroData.publishingRetailers[i].publishingArtifacts[j]).getName(), ((Book)libroData.publishingRetailers[i].publishingArtifacts[j]).getSubtitle(), ((Book)libroData.publishingRetailers[i].publishingArtifacts[j]).getISBN(), ((Book)libroData.publishingRetailers[i].publishingArtifacts[j]).getPageCount(), ((Book)libroData.publishingRetailers[i].publishingArtifacts[j]).getKeywords(), ((Book)libroData.publishingRetailers[i].publishingArtifacts[j]).getLanguageID(), ((Book)libroData.publishingRetailers[i].publishingArtifacts[j]).getCreatedOn());
                            books_array[books_array.length - 1].setAuthors(((Book)libroData.publishingRetailers[i].publishingArtifacts[j]).getAuthors());
                        }
                    }
                }
                break;
            }
        }
        return books_array;
    }

    Language[] getLanguagesForPublishingRetailerID(int publishingRetailerID) {
        Language[] languages_array = null;
        for(int i = 0; i < libroData.publishingRetailers.length; i++) {
            //finds the given retailer ID
            if(libroData.publishingRetailers[i].getID() == publishingRetailerID) {
                //for each book from that retailer
                for(int j = 0; j < libroData.publishingRetailers[i].publishingArtifacts.length; j++) {
                    //if it's the first language
                    if(languages_array == null) {
                        languages_array = new Language[1];
                        languages_array[0] = new Language(((Book)libroData.publishingRetailers[i].publishingArtifacts[j]).getLanguageID());
                        for(int k = 0; k < libroData.languages.length; k++) {
                            if(languages_array[0].getID() == libroData.languages[k].getID()) {
                                languages_array[0].setCode(libroData.languages[k].getCode());
                                languages_array[0].setName(libroData.languages[k].getName());
                            }
                        }
                    }
                    else {
                        //verifies if the language wasn't already found
                        int unique = 1;
                        for(int k = 0; k < languages_array.length; k++) {
                            if(languages_array[k].getID() == ((Book)libroData.publishingRetailers[i].publishingArtifacts[j]).getLanguageID()) {
                                unique = 0;
                                break;
                            }
                        }
                        //if it is unique, it adds it to the language list
                        if(unique == 1) {
                            languages_array = Arrays.copyOf(languages_array, languages_array.length + 1);
                            languages_array[languages_array.length - 1] = new Language(((Book)libroData.publishingRetailers[i].publishingArtifacts[j]).getLanguageID());
                            for(int k = 0; k < libroData.languages.length; k++) {
                                if(languages_array[languages_array.length - 1].getID() == libroData.languages[k].getID()) {
                                    languages_array[languages_array.length - 1].setCode(libroData.languages[k].getCode());
                                    languages_array[languages_array.length - 1].setName(libroData.languages[k].getName());
                                }
                            }
                        }
                    }
                }
                break;
            }
        }
        return languages_array;
    }

    Country[] getCountriesForBookID(int bookID) {
        Country[] countries_array = null;
        int index = 0;
        //for each publishing retailer
        for(int i = 0; i < libroData.publishingRetailers.length; i++) {
            //for each book
            for(int j = 0; j < libroData.publishingRetailers[i].publishingArtifacts.length; j++) {
                //if the book is the one we're searching for
                if(((Book)libroData.publishingRetailers[i].publishingArtifacts[j]).getID() == bookID) {
                    //if it's the first country
                    if(countries_array == null) {
                        countries_array = new Country[libroData.publishingRetailers[i].countries.length];
                    }
                    else {
                        countries_array = Arrays.copyOf(countries_array, countries_array.length + libroData.publishingRetailers[i].countries.length);
                    }
                    //for each country from a retailer
                    for(int k = 0; k < libroData.publishingRetailers[i].countries.length; k++) {
                        countries_array[index] = new Country(libroData.publishingRetailers[i].countries[k].getID());
                        //for each country it has to complete the code
                        for(int q = 0; q < libroData.countries.length; q++) {
                            if(countries_array[index].getID() == libroData.countries[q].getID()) {
                                countries_array[index].setCountryCode(libroData.countries[q].getCountryCode());
                                index++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return countries_array;
    }

    Book[] getCommonBooksForRetailerIDs(int retailerID1, int retailerID2) {
        Book[] commonBooks = null;
        int index1 = 0, index2 = 0, index = 0;
        //finds the retailers with the given IDs
        for(int i = 0; i < libroData.publishingRetailers.length; i++) {
            if(libroData.publishingRetailers[i].getID() == retailerID1) {
                index1 = i;
            }
            if(libroData.publishingRetailers[i].getID() == retailerID2) {
                index2 = i;
            }
        }
        //uses a hashtable to get the complexity O(n+m)
        Hashtable<String, Book> hashtable = new Hashtable<>(1000);
        //puts in the hashtable the books from the first retailer
        for(int i = 0; i < libroData.publishingRetailers[index1].publishingArtifacts.length; i++) {
            hashtable.put(((Book)libroData.publishingRetailers[index1].publishingArtifacts[i]).getName(), ((Book)libroData.publishingRetailers[index1].publishingArtifacts[i]));
        }

        for(int i = 0; i < libroData.publishingRetailers[index2].publishingArtifacts.length; i++) {
            //if the books from the second retailer are in the hashtable
            if(hashtable.containsKey(((Book)libroData.publishingRetailers[index2].publishingArtifacts[i]).getName())) {
                if(index == 0) {
                    commonBooks = new Book[1];
                }
                else {
                    commonBooks = Arrays.copyOf(commonBooks, commonBooks.length + 1);
                }
                //it adds the book to the list
                commonBooks[index++] = (Book)libroData.publishingRetailers[index2].publishingArtifacts[i];
            }
        }
        return commonBooks;
    }

    Book[] getAllBooksForRetailerIDs (int retailerID1, int retailerID2) {
        Book[] allBooks = null;
        int index1 = 0, index2 = 0, index = 0;
        //finds the retailers with the given IDs
        for(int i = 0; i < libroData.publishingRetailers.length; i++) {
            if(libroData.publishingRetailers[i].getID() == retailerID1) {
                index1 = i;
            }
            if(libroData.publishingRetailers[i].getID() == retailerID2) {
                index2 = i;
            }
        }
        //uses a Hashset to get the complexity O(n+m)
        HashSet<IPublishingArtifact> hashSet = new HashSet<>(1000);
        //puts in the hashset the books from both retailers
        hashSet.addAll(Arrays.asList((libroData.publishingRetailers[index1].publishingArtifacts)));
        hashSet.addAll(Arrays.asList((libroData.publishingRetailers[index2].publishingArtifacts)));
        //for each book, it adds it to the list
        for(IPublishingArtifact a : hashSet) {
            if(index == 0) {
                allBooks = new Book[1];
            }
            else {
                allBooks = Arrays.copyOf(allBooks, allBooks.length + 1);
            }
            allBooks[index++] = (Book)a;
        }
        return allBooks;
    }
}
