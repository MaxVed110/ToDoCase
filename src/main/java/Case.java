public class Case {
    String name;
    String dataTime;
    String deadline;
    String author;
    private int id;

    public Case(int id, String name, String dataTime, String deadline, String author) {
        this.id = id;
        this.name = name;
        this.dataTime = dataTime;
        this.deadline = deadline;
        this.author = author;
    }

    public Integer getID() {
        return this.id;
    }

    public String getCase() {
        return this.name + " автор - " + this.author + " добавлено - " + this.dataTime + " дедлайн - " + this.deadline;
    }
}
