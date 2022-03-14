package interfaces.exercise2;

import java.util.ArrayList;

public class Curriculum implements File {
    private Person pessoa;
    private ArrayList<String> skills = new ArrayList<String>();

    public Curriculum(Person pessoa, ArrayList<String> skills) {
        this.pessoa = pessoa;
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "pessoa=" + pessoa +
                ", skills=" + skills +
                '}';
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }
}
