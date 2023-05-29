import java.util.Scanner;

public class UserInterface {


    public static void out(String msg){
        System.out.println(msg);
    }
    
    public static int inInt(String msg){
        boolean valueBad = true;
        int tempOut = 0;
        Scanner in = new Scanner(System.in);
        while (valueBad){
            in = new Scanner(System.in);
            try {
                out(msg);
                tempOut = in.nextInt();
                valueBad = false;
            } catch (Exception e) {
                valueBad = true;
                out("Некорректный ввод");
            }
        }
        //in.close();
        return tempOut;
    }

    public static String inString(String msg){
        boolean valueBad = true;
        String tempOut = "";
        Scanner in = new Scanner(System.in);
        while (valueBad){
            in = new Scanner(System.in);
            try {
                out(msg);
                tempOut = in.nextLine();
                valueBad = false;
            } catch (Exception e) {
                valueBad = true;
                out("Некорректный ввод");
            }
        }
        //in.close();
        return tempOut;
    }

    public static int inIntLimited(String msg, int min, int max){
        boolean valueBad = true;
        int tempOut = 0;
        Scanner in = new Scanner(System.in);
        while (valueBad){
            in = new Scanner(System.in);
            try {
                out(msg);
                tempOut = in.nextInt();
                valueBad = (tempOut < min) || (tempOut > max);
            } catch (Exception e) {
                valueBad = true;
                out("Некорректный ввод");
            }
        }
        //in.close();
        return tempOut;
    }
}
