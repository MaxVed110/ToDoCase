import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class Storage {
    Map<Integer, List<Case>> storage = new TreeMap<>();

    public List<Integer> getCase(int idCase) {
        List<Integer> res = new ArrayList<>();
        for (int key : this.storage.keySet()) {
            for (int i = 0; i < this.storage.get(key).size(); i++) {
                if (this.storage.get(key).get(i).getID() == idCase) {
                    res.add(i);
                    res.add(key);
                    break;
                }
            }
        }
        return res;
    }
}
