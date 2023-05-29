import java.time.LocalDate;
import java.util.ArrayList;

public class Logic {
    public static void Contoller(ArrayList<Animal> animalShelter, AnimalSubclass animalSubclasses, Commands animalCommands, Counter animaCounter) {
        StringBuilder menu = new StringBuilder();
        Integer userChoice = -1;
        String tempName;
        String tempSubclass;
        Boolean tempGender;
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int tempYear;
        int tempMonth;
        int tempDay;
        String tempBirthDate;
        Animal tempAnimal;
        int removeIndex;
        while (userChoice != 0){
            switch (userChoice) {
                case -1:
                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append("1 - показать существующих животных в реестре\n");
                    menu.append("2 - добавить новую запись в реестр\n");
                    menu.append("3 - редактирование существующие записи в реестре\n");
                    menu.append("4 - удаление существующих записей из реестра\n");
                    menu.append("0 - Выйти из приложения\n");
                    UserInterface.out(menu.toString());
                    userChoice = UserInterface.inInt("Ваш выбор: ");
                    break;
                case 1:
                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append("Существующие записи в реестре: \n");
                    for (int i = 0; i < animalShelter.size(); i++) {
                        menu.append(String.format(" %d - %s\n", i + 1, animalShelter.get(i).toString() ));
                    }    
                    UserInterface.out(menu.toString());
                    userChoice = -1;
                    break;
                case 2:
                    userChoice = -1;
                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append("Создание новой записи: \n");
                    UserInterface.out(menu.toString());

                    tempName = UserInterface.inString("Введите кличку животного: ");
                    while (userChoice < 1 || userChoice > animalSubclasses.getValues().size()){
                        menu = new StringBuilder();
                        menu.append("================================================\n");
                        menu.append("Выбери тип животного: \n");
                        for (int i = 0; i < animalSubclasses.getValues().size(); i++) {
                            menu.append(String.format(" %d - %s\n", i + 1, animalSubclasses.getValues().get(i).toString() ));
                        }
                        UserInterface.out(menu.toString()); 
                        userChoice = UserInterface.inInt("Ваш выбор: ");
                    }
                    tempSubclass = animalSubclasses.getValues().get(userChoice - 1);
                    userChoice = -1;

                    while (userChoice < 1 || userChoice > 2){
                        menu = new StringBuilder();
                        menu.append("================================================\n");
                        menu.append("Выберите пол животного: \n");
                        menu.append("1 - Мужской\n");
                        menu.append("2 - Женский\n");
                        UserInterface.out(menu.toString()); 
                        userChoice = UserInterface.inInt("Ваш выбор: ");
                    }
                    tempGender = (userChoice == 1);
                    userChoice = -1;

                    tempYear = UserInterface.inIntLimited("Введите год рождения животного: ", 0, LocalDate.now().getYear());
                    if (tempYear % 4 == 0) {
                        days[1] = 29;
                    }
                    tempMonth = UserInterface.inIntLimited("Введите месяц рождения животного: ", 1, 12);
                    tempDay = UserInterface.inIntLimited("Введите день рождения животного: ", 1, days[tempMonth - 1]);
                    tempBirthDate = String.format("%s-%s-%s", tempYear, tempMonth, tempDay);
                    UserInterface.out(tempBirthDate);

                    tempAnimal = new Animal(tempName, tempSubclass, tempGender, tempBirthDate);
                    
                    while (userChoice != 0){
                        menu = new StringBuilder();
                        menu.append("================================================\n");
                        if (tempAnimal.getCommands().size() != 0) {
                            menu.append("животное знает команды: ");
                            for (String i : tempAnimal.getCommands()) {
                                menu.append(i);
                                menu.append(" ");
                            }
                            menu.append("\n");
                        }
                        menu.append("Выбери команды, которые знает животное: \n");
                        for (int i = 0; i < animalCommands.getValues().size(); i++) {
                            menu.append(String.format(" %d - %s\n", i + 1, animalCommands.getValues().get(i).toString() ));
                        }
                        menu.append(" 0 - завершить ввод данных\n");
                        UserInterface.out(menu.toString()); 
                        userChoice = UserInterface.inIntLimited("Ваш выбор: ", 0, animalCommands.getValues().size());
                        if (userChoice != 0) {
                            if (! tempAnimal.getCommands().contains(animalCommands.getValues().get(userChoice - 1))){
                                tempAnimal.addCommands(animalCommands.getValues().get(userChoice - 1));
                            }
                        }
                    }
                    
                    animalShelter.add(tempAnimal);
                    
                    userChoice = -1;
                    break;
                case 3:
                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append("Выберите запись для редактирования: \n");
                    for (int i = 0; i < animalShelter.size(); i++) {
                        menu.append(String.format(" %d - %s\n", i + 1, animalShelter.get(i).toString() ));
                    }    
                    menu.append(" 0 - отмена\n");
                    UserInterface.out(menu.toString()); 
                    userChoice = UserInterface.inIntLimited("Ваш выбор: ", 0, animalShelter.size());

                    if (userChoice != 0) {
                        animalShelter.remove(userChoice - 1);
                        removeIndex = userChoice - 1;

                        menu = new StringBuilder();
                        menu.append("================================================\n");
                        menu.append("Редактирование записи: \n");
                        UserInterface.out(menu.toString());
    
                        tempName = UserInterface.inString("Введите кличку животного: ");
                        while (userChoice < 1 || userChoice > animalSubclasses.getValues().size()){
                            menu = new StringBuilder();
                            menu.append("================================================\n");
                            menu.append("Выбери тип животного: \n");
                            for (int i = 0; i < animalSubclasses.getValues().size(); i++) {
                                menu.append(String.format(" %d - %s\n", i + 1, animalSubclasses.getValues().get(i).toString() ));
                            }
                            UserInterface.out(menu.toString()); 
                            userChoice = UserInterface.inInt("Ваш выбор: ");
                        }
                        tempSubclass = animalSubclasses.getValues().get(userChoice - 1);
                        userChoice = -1;
    
                        while (userChoice < 1 || userChoice > 2){
                            menu = new StringBuilder();
                            menu.append("================================================\n");
                            menu.append("Выберите пол животного: \n");
                            menu.append("1 - Мужской\n");
                            menu.append("2 - Женский\n");
                            UserInterface.out(menu.toString()); 
                            userChoice = UserInterface.inInt("Ваш выбор: ");
                        }
                        tempGender = (userChoice == 1);
                        userChoice = -1;
    
                        
                        tempYear = UserInterface.inIntLimited("Введите год рождения животного: ", 0, LocalDate.now().getYear());
                        if (tempYear % 4 == 0) {
                            days[1] = 29;
                        }
                        tempMonth = UserInterface.inIntLimited("Введите месяц рождения животного: ", 1, 12);
                        tempDay = UserInterface.inIntLimited("Введите день рождения животного: ", 1, days[tempMonth - 1]);
                        tempBirthDate = String.format("%s-%s-%s", tempYear, tempMonth, tempDay);
                        UserInterface.out(tempBirthDate);
    
                        tempAnimal = new Animal(tempName, tempSubclass, tempGender, tempBirthDate);
                        
                        while (userChoice != 0){
                            menu = new StringBuilder();
                            menu.append("================================================\n");
                            if (tempAnimal.getCommands().size() != 0) {
                                menu.append("животное знает команды: ");
                                for (String i : tempAnimal.getCommands()) {
                                    menu.append(i);
                                    menu.append(" ");
                                }
                                menu.append("\n");
                            }
                            menu.append("Выбери команды, которые знает животное: \n");
                            for (int i = 0; i < animalCommands.getValues().size(); i++) {
                                menu.append(String.format(" %d - %s\n", i + 1, animalCommands.getValues().get(i).toString() ));
                            }
                            menu.append(" 0 - завершить ввод данных\n");
                            UserInterface.out(menu.toString()); 
                            userChoice = UserInterface.inIntLimited("Ваш выбор: ", 0, animalCommands.getValues().size());
                            if (userChoice != 0) {
                                if (! tempAnimal.getCommands().contains(animalCommands.getValues().get(userChoice - 1))){
                                    tempAnimal.addCommands(animalCommands.getValues().get(userChoice - 1));
                                }
                            }
                        }
                        animalShelter.add(removeIndex, tempAnimal);
                    }
                    userChoice = -1;
                    break;
                case 4:
                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append("Выберите запись для редактирования: \n");
                    for (int i = 0; i < animalShelter.size(); i++) {
                        menu.append(String.format(" %d - %s\n", i + 1, animalShelter.get(i).toString() ));
                    }    
                    menu.append(" 0 - отмена\n");
                    UserInterface.out(menu.toString()); 
                    userChoice = UserInterface.inIntLimited("Ваш выбор: ", 0, animalShelter.size());

                    if (userChoice != 0) {
                        animalShelter.remove(userChoice - 1);
                        removeIndex = userChoice - 1;
                    }
                default:
                    userChoice = -1;
                    break;
            }
        }
    }
}

