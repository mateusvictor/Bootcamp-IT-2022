package interfaces.exercise2;

public class Report implements File {
    private String text;
    private int pageNumber;
    private Person author;
    private Person reviewer;

    public Report(String text, int pageNumber, Person author, Person reviewer) {
        this.text = text;
        this.pageNumber = pageNumber;
        this.author = author;
        this.reviewer = reviewer;
    }

    @Override
    public String toString() {
        return "Report{" +
                "text='" + text + '\'' +
                ", pageNumber=" + pageNumber +
                ", author=" + author +
                ", reviewer=" + reviewer +
                '}';
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }
}
