public class EditorialGroup implements IPublishingArtifact{
    private int ID;
    private String name;
    private Book[] books;

    public EditorialGroup(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return this.ID;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    //returns the string that contains a book
    private String BookString(Book book) {
        String s = "<title>" + book.getName() + "</title>\n\t\t\t"
                + "<subtitle>" + book.getSubtitle() + "</subtitle>\n\t\t\t"
                + "<isbn>" + book.getISBN() + "</isbn>\n\t\t\t"
                + "<pageCount>" + book.getPageCount() + "</pageCount>\n\t\t\t"
                + "<keywords>" + book.getKeywords() + "</keywords>\n\t\t\t"
                + "<languageID>" + book.getLanguageID() + "</languageID>\n\t\t\t"
                + "<createdOn>" + book.getCreatedOn() + "</createdOn>\n\t\t\t"
                + "<authors>" + book.AuthorsString() + "</authors>\n\t\t";
        return s;
    }

    //returns the string that contains all books from an editorial group
    private String Books() {
        String s = "<book>\n\t\t\t" + this.BookString(books[0]) + "</book>\n";
        for(int i = 1; i < this.books.length; i++) {
            s = s + "\t\t<book>\n\t\t\t" + this.BookString(books[i]) + "</book>\n";
        }
        return s;
    }

    @Override
    public String Publish() {
        String s = "<xml>\n\t<editorialGroup>\n\t\t"
                + "<ID>" + this.ID + "</ID>\n\t\t"
                + "<Name>" + this.name + "</Name>\n\t</editorialGroup>\n"
                +"\t<books>\n\t\t" + this.Books() + "\t</books>\n</xml>";
        return s;
    }
}
