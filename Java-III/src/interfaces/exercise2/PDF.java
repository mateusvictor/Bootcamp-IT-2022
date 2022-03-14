package interfaces.exercise2;

public class PDF implements File {
    private int pageNumber;
    private String authorName;
    private String title;
    private String genre;

    public PDF(int pageNumber, String authorName, String title, String genre) {
        this.pageNumber = pageNumber;
        this.authorName = authorName;
        this.title = title;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "PDF{" +
                "pageNumber=" + pageNumber +
                ", authorName='" + authorName + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }
}
