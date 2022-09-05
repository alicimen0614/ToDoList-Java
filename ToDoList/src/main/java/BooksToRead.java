
public class BooksToRead {
    private int id;
    private String bookname;
    private String author;
    private int numberofpages;
    private boolean done;

    public BooksToRead(int id, String bookname, String author , int numberofpages , boolean done) {
        this.id = id;
        this.bookname = bookname;
        this.author = author;
        this.numberofpages = numberofpages;
        this.done = done;
    }
   

    public int getNumberofpages() {
        return numberofpages;
    }

    public void setNumberofpages(int numberofpages) {
        this.numberofpages = numberofpages;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getNumberOfPages() {
        return numberofpages;
    }

    public void setNumberOfPages(int NumberOfPages) {
        this.numberofpages = NumberOfPages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
}
