import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Json {

    public void saveJson(ToDoList list) throws IOException {
        BufferedWriter listCase = Files.newBufferedWriter(Paths.get("toDoList.json"), Charset.forName("Windows-1251"));
        JsonObject todolist = new JsonObject();
        List<JsonObject> buf = new ArrayList<>();
        for (int key : list.storage.keySet()) {
            for (Case c : list.storage.get(key)) {
                JsonObject toDoCase = new JsonObject();
                toDoCase.put("Name case", c.name);
                toDoCase.put("Date add", c.dataTime);
                toDoCase.put("Deadline", c.deadline);
                toDoCase.put("Priority", key);
                toDoCase.put("Author", c.author);
                buf.add(new JsonObject(toDoCase));
            }
        }
        todolist.put("Case", buf);
        Jsoner.serialize(todolist, listCase);
        listCase.close();
    }
}
