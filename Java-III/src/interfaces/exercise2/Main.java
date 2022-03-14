package interfaces.exercise2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PDF pdf = new PDF(18, "Mateus", "Clean Code", "Article");
        Printer.print(pdf);

        ArrayList<String> skills = new ArrayList<String>();
        skills.add("Python");
        skills.add("Java");
        skills.add("Fury");
        Curriculum cv = new Curriculum(
                new Person("Mateus", 17, "123.456.789.10", "11 912346612"),
                skills);
        Printer.print(cv);

        Report report = new Report("As vezes no silencio da noite.", 17,
                new Person("Jorge", 28, "931.231.471-31", "11 91234 5678"),
                new Person("Maria", 93, "712.414.931-30", "11 72313 1237"));
        Printer.print(report);
    }
}
