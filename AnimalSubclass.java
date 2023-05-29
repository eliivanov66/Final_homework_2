import java.util.ArrayList;

public class AnimalSubclass {
    private ArrayList<String> subclasses;

    public AnimalSubclass(){
        subclasses = new ArrayList<>();
    }

    public void add(String name){
        this.subclasses.add(name);
    }

    public void remove(String name){
        this.subclasses.remove(name);
    }

    public ArrayList<String> getValues(){
        return this.subclasses;
    }
}

