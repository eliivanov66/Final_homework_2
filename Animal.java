import java.util.ArrayList;

public class Animal {
    private String name;
    private boolean gender;
    private String birthDate;
    private String subclass;
    private Commands commands;

    public Animal(String name, String subclass, boolean gender, String birthDate) {
        this.name = name;
        this.subclass = subclass;
        this.gender = gender;
        this.birthDate = birthDate;
        this.commands = new Commands();
    }

    public ArrayList<String> getCommands(){
        return this.commands.getValues();
    }

    public void addCommands(String command){
        this.commands.add(command);
    }

    public void removeCommands(String command){
        this.commands.remove(command);
    }

    public String getName(){
        return this.name;
    }

    public boolean getGender(){
        return this.gender;
    }

    public String getBirthDate(){
        return this.birthDate;
    }

    public String getSubclass(){
        return this.subclass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();
        temp.append(this.name);
        temp.append(", ");
        temp.append(this.subclass);
        temp.append(", ");
        if (this.gender){
            temp.append("M");
            temp.append(", ");
        } else {
            temp.append("F");
            temp.append(", ");   
        }
        temp.append(this.birthDate);
        temp.append(", ");
        if (this.commands.getValues().size() > 0) {
            temp.append("Команды: ");
            for (String command : this.commands.getValues()) {
                temp.append(command);
                temp.append("-");  
            }
        } else {
            temp.append("Не знает команд");  
        }

        return temp.toString();
    }
}
