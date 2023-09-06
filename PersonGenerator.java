import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonGenerator {

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", "Doe", "12345678", 1980, "Mr."));
        persons.add(new Person("Jane", "Smith", "90123456", 1990, "Mrs."));



        String filePath = "person_records.csv";


        writePersonsToFile(persons, filePath);

        System.out.println("Data written to file: " + filePath);
    }

    public static void writePersonsToFile(List<Person> persons, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {



            for (Person person : persons) {
                writer.write(person.toCSVString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}