import java.util.ArrayList;

public class Commands {
    private ArrayList<String> commands;

    public Commands(){
        commands = new ArrayList<>();
    }

    public void add(String name){
        this.commands.add(name);
    }

    public void remove(String name){
        this.commands.remove(name);
    }

    public ArrayList<String> getValues(){
        return this.commands;
    }
}
