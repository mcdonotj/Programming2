import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonReader {

    public static List<Person> readPersonsFromFile(String filePath) {
        List<Person> persons = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String IDNum = parts[0].trim();
                    String firstName = parts[1].trim();
                    String lastName = parts[2].trim();
                    int YOB = Integer.parseInt(parts[3].trim());
                    String Title = parts[4].trim();


                    persons.add(new Person(IDNum, firstName, lastName, YOB, Title));
                } else {
                    System.err.println("Invalid format on line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return persons;
    }

    public static void main(String[] args) {
        String filePath = "person_records.txt";
        List<Person> persons = readPersonsFromFile(filePath);


        for (Person person : persons) {
            System.out.println("Name: " + person.getFullName() + ", Age: " + person.calculateAge());
        }
    }
}
