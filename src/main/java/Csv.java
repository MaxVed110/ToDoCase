import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Csv {

    public void saveCsv(ToDoList list) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("todolist.csv"));

        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                .withHeader("ID", "Название", "Приоритет", "Добавлено", "Дедлайн", "Автор"));

        for (int key : list.storage.keySet()) {
            for (Case c : list.storage.get(key)) {
                csvPrinter.printRecord(c.getID(), c.name, key, c.dataTime, c.deadline, c.author);
            }
        }
        csvPrinter.flush();
    }
}
