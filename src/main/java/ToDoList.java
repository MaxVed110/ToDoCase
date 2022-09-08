import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;




public class ToDoList extends Storage implements AdditionalFunctions {
    private int id;

    public ToDoList() {
        this.id = 0;
    }

    public void addCase(String name, String deadline, String author, int priority) {
        if (this.storage.containsKey(priority)) {
            this.storage.get(priority).add(new Case(this.id, name, dataTime(), deadline, author));
        } else {
            this.storage.put(priority, new ArrayList<>());
            this.storage.get(priority).add(new Case(this.id, name, dataTime(), deadline, author));
        }
        System.out.println("Add case id " + this.id);
        this.id++;
    }

    public void deleteCase(int idCase) {
        List<Integer> coordinateCase = getCase(idCase);
        if (coordinateCase.size() != 0) {
            this.storage.get(coordinateCase.get(1)).remove((int) (coordinateCase.get(0)));
        } else {
            System.out.println("Такого дела нет");
        }
    }

    public void printToDoList() {
        for (int key : this.storage.keySet()) {
            System.out.println("Приоритет " + key);
            System.out.println("");
            for (Case c : this.storage.get(key)) {
                System.out.println(c.getCase());
            }
        }
    }

    public void saveTodoList(String type) throws ParserConfigurationException, TransformerException, IOException {
        switch (type) {
            case "xml" -> {
                Xml newDoc = new Xml();
                newDoc.printXml(this);
            }
            case "json" -> {
                Json newJson = new Json();
                newJson.saveJson(this);
            }
            case "csv" -> {
                Csv newCsv = new Csv();
                newCsv.saveCsv(this);
            }
            default -> System.out.println("Команда некорректна");
        }
    }
}
