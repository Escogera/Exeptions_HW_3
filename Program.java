import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите свои данные(ФИО, Дату рождения, Номер телефона, пол) через пробел,\n" +
                               "как показано в примере: Иванов Иван Иванович 01.01.0001 89114111111 m");
            try(Scanner input = new Scanner(System.in)) { 
                DataString dataString = new DataString(input);
                dataString.save();    
            } catch (DataException e) {
                e.getMessage();
                e.printStackTrace();
            } 
                       
        }
    }
}
