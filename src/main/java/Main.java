import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException {

        ToDoList list = new ToDoList();

        list.addCase("Дело 1", "20.03", "A", 1);
        list.addCase("Дело 1", "21.03", "A", 2);
        list.addCase("Дело 1", "20.03", "A", 1);
        list.addCase("Дело 1", "23.03", "B", 2);
        list.addCase("Дело 1", "20.03", "B", 1);
        list.addCase("dw", "22.03", "A", 3);
        list.addCase("dw", "20.03", "A", 1);

        /*
        list.printToDoList();
        list.deleteCase(3);
        list.deleteCase(6);
        list.deleteCase(9)
        System.out.println("-------");
        list.printToDoList()
        list.saveTodoList("xml");
         */

        list.saveTodoList("json");
    }
}
