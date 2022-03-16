package generics;

import generics.utils.FileUtil;


public class PersonRepository implements Repository<Person>{

    @Override
    public void write(Person person) {
        FileUtil<Person> fileUtil = new FileUtil<Person>(person);
        fileUtil.write("people.txt");
    }
}
