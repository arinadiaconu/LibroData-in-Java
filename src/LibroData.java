import java.util.*;
import java.io.*;

//this class contains the initialisation of the LibroData
public class LibroData {
    Book[] books;
    Language[] languages;
    Author[] authors;
    EditorialGroup[] editorialGroups;
    PublishingBrand[] publishingBrands;
    PublishingRetailer[] publishingRetailers;
    Country[] countries;

    public LibroData() {
    }

    private void readBooks() {
        this.books = new Book[1000];
        //reads from the given file
        try (BufferedReader br = new BufferedReader(new FileReader("init/books.in"))) {
            String line;
            int ok = 0, i = 0;
            while ((line = br.readLine()) != null) {
                //skips the first line of the file
                if(ok == 0) {
                    ok = 1;
                    continue;
                }
                //breaks the line into elements
                StringTokenizer string = new StringTokenizer(line, "###");
                int ID, pageCount, languageID;
                String title, subtitle = null, ISBN, keywords, createdOn;
                ID = Integer.parseInt(string.nextToken());
                title = string.nextToken();
                if(string.countTokens() == 6) {
                    subtitle = string.nextToken();
                }
                ISBN = string.nextToken();
                pageCount = Integer.parseInt(string.nextToken());
                keywords = string.nextToken();
                languageID = Integer.parseInt(string.nextToken());
                createdOn = string.nextToken();

                //initializes each book
                this.books[i++] = new Book(ID, title, subtitle, ISBN, pageCount, keywords, languageID, createdOn);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void readLanguages() {
        this.languages = new Language[4];
        //reads from the given file
        try (BufferedReader br = new BufferedReader(new FileReader("init/languages.in"))) {
            String line;
            int ok = 0, i = 0;
            while ((line = br.readLine()) != null) {
                //skips the first line of the file
                if(ok == 0) {
                    ok = 1;
                    continue;
                }
                //breaks the line into elements
                StringTokenizer string = new StringTokenizer(line, "###");
                int ID;
                String code, name;
                ID = Integer.parseInt(string.nextToken());
                code = string.nextToken();
                name = string.nextToken();

                //initializes each language
                this.languages[i++] = new Language(ID, code, name);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void readAuthors() {
        this.authors = new Author[2381];
        //reads from the given file
        try (BufferedReader br = new BufferedReader(new FileReader("init/authors.in"))) {
            String line;
            int ok = 0, i = 0;
            while ((line = br.readLine()) != null) {
                //skips the first line of the file
                if(ok == 0) {
                    ok = 1;
                    continue;
                }
                //breaks the line into elements
                StringTokenizer string = new StringTokenizer(line, "###");
                int ID;
                String firstName = null, lastName;
                ID = Integer.parseInt(string.nextToken());
                if(string.countTokens() == 2) {
                    firstName = string.nextToken();
                }
                lastName = string.nextToken();

                //initializes each author
                this.authors[i++] = new Author(ID, firstName, lastName);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        //reads from the given file
        try (BufferedReader br = new BufferedReader(new FileReader("init/books-authors.in"))) {
            String line;
            int ok = 0, i = 0;
            while ((line = br.readLine()) != null) {
                //skips the first line of the file
                if(ok == 0) {
                    ok = 1;
                    continue;
                }
                //breaks the line into elements
                StringTokenizer string = new StringTokenizer(line, "###");
                int bookID, authorID;
                bookID = Integer.parseInt(string.nextToken());
                authorID = Integer.parseInt(string.nextToken());

                //for each book, it sets the given author
                for(int j = 0; j < this.authors.length; j++) {
                    if(this.authors[j].getID() == authorID) {
                        Author[] a = new Author[1];
                        a[0] = new Author(this.authors[j].getID(), this.authors[j].getFirstName(), this.authors[j].getLastName());
                        this.books[i++].setAuthors(a);
                        break;
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void readEditorialGroups() {
        this.editorialGroups = new EditorialGroup[264];
        //reads from the given file
        try (BufferedReader br = new BufferedReader(new FileReader("init/editorial-groups.in"))) {
            String line;
            int ok = 0, i = 0;
            while ((line = br.readLine()) != null) {
                //skips the first line of the file
                if(ok == 0) {
                    ok = 1;
                    continue;
                }
                //breaks the line into elements
                StringTokenizer string = new StringTokenizer(line, "###");
                int ID;
                String name;
                ID = Integer.parseInt(string.nextToken());
                name = string.nextToken();

                //initializes each editorial group
                this.editorialGroups[i++] = new EditorialGroup(ID, name);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        //reads from the given file
        try (BufferedReader br = new BufferedReader(new FileReader("init/editorial-groups-books.in"))) {
            String line;
            int ok = 0, i = 0;
            while ((line = br.readLine()) != null) {
                //skips the first line of the file
                if(ok == 0) {
                    ok = 1;
                    continue;
                }
                //breaks the line into elements
                StringTokenizer string = new StringTokenizer(line, "###");
                int groupID, bookID;
                groupID = Integer.parseInt(string.nextToken());
                bookID = Integer.parseInt(string.nextToken());
                //for each editorial group, it sets the given book
                for (int j = 0; j < this.books.length; j++) {
                    if (this.books[j].getID() == bookID) {
                        Book[] b = new Book[1];
                        b[0] = new Book(this.books[j].getID(), this.books[j].getName(), this.books[j].getSubtitle(), this.books[j].getISBN(), this.books[j].getPageCount(), this.books[j].getKeywords(), this.books[j].getLanguageID(), this.books[j].getCreatedOn());
                        b[0].setAuthors(books[j].getAuthors());
                        this.editorialGroups[i++].setBooks(b);
                        break;
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void readPublishingBrands() {
        this.publishingBrands = new PublishingBrand[317];
        //reads from the given file
        try (BufferedReader br = new BufferedReader(new FileReader("init/publishing-brands.in"))) {
            String line;
            int ok = 0, i = 0;
            while ((line = br.readLine()) != null) {
                //skips the first line of the file
                if(ok == 0) {
                    ok = 1;
                    continue;
                }
                //breaks the line into elements
                StringTokenizer string = new StringTokenizer(line, "###");
                int ID;
                String name;
                ID = Integer.parseInt(string.nextToken());
                name = string.nextToken();

                //initializes each publishing brand
                this.publishingBrands[i++] = new PublishingBrand(ID, name);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        //reads from the given file
        try (BufferedReader br = new BufferedReader(new FileReader("init/publishing-brands-books.in"))) {
            String line;
            int ok = 0, i = 0;
            while ((line = br.readLine()) != null) {
                //skips the first line of the file
                if(ok == 0) {
                    ok = 1;
                    continue;
                }
                //breaks the line into elements
                StringTokenizer string = new StringTokenizer(line, "###");
                int publisherID, bookID;
                publisherID = Integer.parseInt(string.nextToken());
                bookID = Integer.parseInt(string.nextToken());
                //for each publishing brand, it sets the given book
                for (int j = 0; j < this.books.length; j++) {
                    if (this.books[j].getID() == bookID) {
                        Book[] b = new Book[1];
                        b[0] = new Book(this.books[j].getID(), this.books[j].getName(), this.books[j].getSubtitle(), this.books[j].getISBN(), this.books[j].getPageCount(), this.books[j].getKeywords(), this.books[j].getLanguageID(), this.books[j].getCreatedOn());
                        b[0].setAuthors(this.books[j].getAuthors());
                        this.publishingBrands[i++].setBooks(b);
                        break;
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void readPublishingRetailers() {
        this.publishingRetailers = new PublishingRetailer[31];
        //reads from the given file
        try (BufferedReader br = new BufferedReader(new FileReader("init/publishing-retailers.in"))) {
            String line;
            int ok = 0, i = 0;
            while ((line = br.readLine()) != null) {
                //skips the first line of the file
                if(ok == 0) {
                    ok = 1;
                    continue;
                }
                //breaks the line into elements
                StringTokenizer string = new StringTokenizer(line, "###");
                int ID;
                String name;
                ID = Integer.parseInt(string.nextToken());
                name = string.nextToken();

                //initializes each publishing retailer
                this.publishingRetailers[i++] = new PublishingRetailer(ID, name);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        //reads from the given file
        try (BufferedReader br = new BufferedReader(new FileReader("init/publishing-retailers-books.in"))) {
            String line;
            int ok = 0, i = 0;
            while ((line = br.readLine()) != null) {
                //skips the first line of the file
                if(ok == 0) {
                    ok = 1;
                    continue;
                }
                //breaks the line into elements
                StringTokenizer string = new StringTokenizer(line, "###");
                int retailerID, bookID;
                retailerID = Integer.parseInt(string.nextToken());
                bookID = Integer.parseInt(string.nextToken());
                //for each publishing retailer, it sets the given books
                for (int j = 0; j < this.publishingRetailers.length; j++) {
                    if (this.publishingRetailers[j].getID() == retailerID) {
                        for(int k = 0; k < this.books.length; k++) {
                            if(this.books[k].getID() == bookID) {
                                if(this.publishingRetailers[j].getIndex() == 0) {
                                    this.publishingRetailers[j].publishingArtifacts = new IPublishingArtifact[1];
                                }
                                else {
                                    this.publishingRetailers[j].publishingArtifacts = Arrays.copyOf(this.publishingRetailers[j].publishingArtifacts, this.publishingRetailers[j].publishingArtifacts.length + 1);
                                }
                                this.publishingRetailers[j].publishingArtifacts[this.publishingRetailers[j].getIndex()] = this.books[k];
                                this.publishingRetailers[j].setIndex(this.publishingRetailers[j].getIndex() + 1);
                            }
                        }
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        //reads from the given file
        try (BufferedReader br = new BufferedReader(new FileReader("init/publishing-retailers-editorial-groups.in"))) {
            String line;
            int ok = 0, i = 0;
            while ((line = br.readLine()) != null) {
                //skips the first line of the file
                if(ok == 0) {
                    ok = 1;
                    continue;
                }
                //breaks the line into elements
                StringTokenizer string = new StringTokenizer(line, "###");
                int retailerID, groupID;
                retailerID = Integer.parseInt(string.nextToken());
                groupID = Integer.parseInt(string.nextToken());
                //for each publishing retailer, it sets the given editorial groups
                for (int j = 0; j < this.publishingRetailers.length; j++) {
                    if (this.publishingRetailers[j].getID() == retailerID) {
                        for(int k = 0; k < this.editorialGroups.length; k++) {
                            if(this.editorialGroups[k].getID() == groupID) {
                                if(this.publishingRetailers[j].getIndex() == 0) {
                                    this.publishingRetailers[j].publishingArtifacts = new IPublishingArtifact[1];
                                }
                                else {
                                    this.publishingRetailers[j].publishingArtifacts = Arrays.copyOf(this.publishingRetailers[j].publishingArtifacts, this.publishingRetailers[j].publishingArtifacts.length + 1);
                                }
                                this.publishingRetailers[j].publishingArtifacts[this.publishingRetailers[j].getIndex()] = this.editorialGroups[k].getBooks()[0];
                                this.publishingRetailers[j].setIndex(this.publishingRetailers[j].getIndex() + 1);
                            }
                        }
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        //reads from the given file
        try (BufferedReader br = new BufferedReader(new FileReader("init/publishing-retailers-publishing-brands.in"))) {
            String line;
            int ok = 0, i = 0;
            while ((line = br.readLine()) != null) {
                //skips the first line of the file
                if(ok == 0) {
                    ok = 1;
                    continue;
                }
                //breaks the line into elements
                StringTokenizer string = new StringTokenizer(line, "###");
                int retailerID, brandID;
                retailerID = Integer.parseInt(string.nextToken());
                brandID = Integer.parseInt(string.nextToken());
                //for each publishing retailer, it sets the given publishing brands
                for (int j = 0; j < this.publishingRetailers.length; j++) {
                    if (this.publishingRetailers[j].getID() == retailerID) {
                        for(int k = 0; k < this.publishingBrands.length; k++) {
                            if(this.publishingBrands[k].getID() == brandID) {
                                if(this.publishingRetailers[j].getIndex() == 0) {
                                    this.publishingRetailers[j].publishingArtifacts = new IPublishingArtifact[1];
                                }
                                else {
                                    this.publishingRetailers[j].publishingArtifacts = Arrays.copyOf(this.publishingRetailers[j].publishingArtifacts, this.publishingRetailers[j].publishingArtifacts.length + 1);
                                }
                                this.publishingRetailers[j].publishingArtifacts[this.publishingRetailers[j].getIndex()] = this.publishingBrands[k].getBooks()[0];
                                this.publishingRetailers[j].setIndex(this.publishingRetailers[j].getIndex() + 1);
                            }
                        }
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void readCountries() {
        this.countries = new Country[249];
        //reads from the given file
        try (BufferedReader br = new BufferedReader(new FileReader("init/countries.in"))) {
            String line;
            int ok = 0, i = 0;
            while ((line = br.readLine()) != null) {
                //skips the first line of the file
                if(ok == 0) {
                    ok = 1;
                    continue;
                }
                //breaks the line into elements
                StringTokenizer string = new StringTokenizer(line, "###");
                int ID;
                String code;
                ID = Integer.parseInt(string.nextToken());
                code = string.nextToken();

                //initializes each country
                this.countries[i++] = new Country(ID, code);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        //reads from the given file
        try (BufferedReader br = new BufferedReader(new FileReader("init/publishing-retailers-countries.in"))) {
            String line;
            int ok = 0;
            while ((line = br.readLine()) != null) {
                //skips the first line of the file
                if(ok == 0) {
                    ok = 1;
                    continue;
                }
                //breaks the line into elements
                StringTokenizer string = new StringTokenizer(line, "###");
                int retailerID, countryID;
                retailerID = Integer.parseInt(string.nextToken());
                countryID = Integer.parseInt(string.nextToken());
                //for each publishing retailer, it sets the given countries
                for(int i = 0; i < this.publishingRetailers.length; i++) {
                    if(this.publishingRetailers[i].getID() == retailerID) {
                        for(int j = 0; j < this.countries.length; j++) {
                            if(this.countries[j].getID() == countryID) {
                                Country[] c = new Country[1];
                                c[0] = new Country(this.countries[j].getID(), this.countries[j].getCountryCode());
                                this.publishingRetailers[i].setCountries(c);
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void InitLibroData() {
        this.readBooks();
        this.readLanguages();
        this.readAuthors();
        this.readEditorialGroups();
        this.readPublishingBrands();
        this.readPublishingRetailers();
        this.readCountries();
    }
}
