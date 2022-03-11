public class Book  implements IPublishingArtifact{
    private int ID;
    private String name;
    private String subtitle;
    private String ISBN;
    private int pageCount;
    private String keywords;
    private int languageID;
    private String createdOn;
    private Author[] authors;

    public Book(int ID, String name, String subtitle, String ISBN, int pageCount, String keywords, int languageID, String createdOn) {
        this.ID = ID;
        this.name = name;
        this.subtitle = subtitle;
        this.ISBN = ISBN;
        this.pageCount = pageCount;
        this.keywords = keywords;
        this.languageID = languageID;
        this.createdOn = createdOn;
    }

    public int getID() {
        return ID;
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

    public String getCreatedOn() {
        return createdOn;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    //returns the string that contains all the authors for a book
    public String AuthorsString() {
        String s = null;
        if(this.authors[0].getFirstName() != null) {
            s = this.authors[0].getFirstName() + " " + this.authors[0].getLastName();
        }
        else {
            s = this.authors[0].getLastName();
        }
        for(int i = 1; i < this.authors.length; i++) {
            if(this.authors[i].getFirstName() != null) {
                s = s + ", " + this.authors[i].getFirstName() + " " + this.authors[i].getLastName();
            }
            else {
                s = s + ", " + this.authors[i].getLastName();
            }
        }
        return s;
    }

    @Override
    public String Publish() {
        String s = "<xml>\n\t<title>" + this.name + "</title>\n\t"
                + "<subtitle>" + this.subtitle + "</subtitle>\n\t"
                + "<isbn>" + this.ISBN + "</isbn>\n\t"
                + "<pageCount>" + this.pageCount + "</pageCount>\n\t"
                + "<keywords>" + this.keywords + "</keywords>\n\t"
                + "<languageID>" + this.languageID + "</languageID>\n\t"
                + "<createdOn>" + this.createdOn + "</createdOn>\n\t"
                + "<authors>" + this.AuthorsString() + "</authors>\n</xml>";
        return s;
    }
}
