public class Test {
    public static void main(String[] args) {
        Administration administration = new Administration();

        //tests the functions
        //first test
        Book[] books = administration.getBooksForPublishingRetailerID(10);
        for(Book b : books) {
            System.out.println(b.Publish());
        }

        Language[] languages = administration.getLanguagesForPublishingRetailerID(10);
        for(Language l : languages) {
            System.out.println(l.Print());
        }

        Country[] countries = administration.getCountriesForBookID(14419);
        for(Country c : countries) {
            System.out.println(c.Print());
        }

        Book[] books1 = administration.getCommonBooksForRetailerIDs(1, 12);
        if(books1 != null) {
            for(Book b : books1) {
                System.out.println(b.Publish());
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();

        Book[] books2 = administration.getAllBooksForRetailerIDs(1, 12);
        for(Book b : books2) {
            System.out.println(b.Publish());
        }

        //second test
        books = administration.getBooksForPublishingRetailerID(19);
        for(Book b : books) {
            System.out.println(b.Publish());
        }

        languages = administration.getLanguagesForPublishingRetailerID(19);
        for(Language l : languages) {
            System.out.println(l.Print());
        }

        countries = administration.getCountriesForBookID(14404);
        for(Country c : countries) {
            System.out.println(c.Print());
        }

        books1 = administration.getCommonBooksForRetailerIDs(5, 15);
        if(books1 != null) {
            for(Book b : books1) {
                System.out.println(b.Publish());
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();

        books2 = administration.getAllBooksForRetailerIDs(5, 15);
        for(Book b : books2) {
            System.out.println(b.Publish());
        }

        //third test
        books = administration.getBooksForPublishingRetailerID(5);
        for(Book b : books) {
            System.out.println(b.Publish());
        }

        languages = administration.getLanguagesForPublishingRetailerID(5);
        for(Language l : languages) {
            System.out.println(l.Print());
        }

        countries = administration.getCountriesForBookID(440);
        for(Country c : countries) {
            System.out.println(c.Print());
        }

        books1 = administration.getCommonBooksForRetailerIDs(25, 33);
        if(books1 != null) {
            for(Book b : books1) {
                System.out.println(b.Publish());
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();

        books2 = administration.getAllBooksForRetailerIDs(25, 33);
        for(Book b : books2) {
            System.out.println(b.Publish());
        }

        //fourth test
        books = administration.getBooksForPublishingRetailerID(1);
        for(Book b : books) {
            System.out.println(b.Publish());
        }

        languages = administration.getLanguagesForPublishingRetailerID(1);
        for(Language l : languages) {
            System.out.println(l.Print());
        }

        countries = administration.getCountriesForBookID(1329);
        for(Country c : countries) {
            System.out.println(c.Print());
        }

        books1 = administration.getCommonBooksForRetailerIDs(1, 2);
        if(books1 != null) {
            for(Book b : books1) {
                System.out.println(b.Publish());
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();

        books2 = administration.getAllBooksForRetailerIDs(1, 2);
        for(Book b : books2) {
            System.out.println(b.Publish());
        }

        //fifth test
        books = administration.getBooksForPublishingRetailerID(9);
        for(Book b : books) {
            System.out.println(b.Publish());
        }

        languages = administration.getLanguagesForPublishingRetailerID(9);
        for(Language l : languages) {
            System.out.println(l.Print());
        }

        countries = administration.getCountriesForBookID(10278);
        for(Country c : countries) {
            System.out.println(c.Print());
        }

        books1 = administration.getCommonBooksForRetailerIDs(8, 21);
        if(books1 != null) {
            for(Book b : books1) {
                System.out.println(b.Publish());
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();

        books2 = administration.getAllBooksForRetailerIDs(8, 21);
        for(Book b : books2) {
            System.out.println(b.Publish());
        }
    }
}
