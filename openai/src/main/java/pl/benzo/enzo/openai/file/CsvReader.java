package pl.benzo.enzo.openai.file;

import lombok.AllArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import pl.benzo.enzo.openai.model.User;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



public class CsvReader {

    public static List<User> readUserCsv(String filePath) {
        List<User> users = new ArrayList<>();

        try (CSVParser csvParser = new CSVParser(new FileReader(filePath), CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase())) {
            for (CSVRecord csvRecord : csvParser) {
                String name = csvRecord.get("name");
                String lastName = csvRecord.get("lastName");
                BigDecimal pesel = new BigDecimal(csvRecord.get("pesel"));
                BigDecimal phoneNumber = new BigDecimal(csvRecord.get("phoneNumber"));
                String mail = csvRecord.get("mail");
                String password = csvRecord.get("password");
                Integer age = Integer.parseInt(csvRecord.get("age"));
                BigDecimal salary = new BigDecimal(csvRecord.get("salary"));

                User user = new User(name, lastName, pesel, phoneNumber, mail, password, age, salary);
                users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }
}
