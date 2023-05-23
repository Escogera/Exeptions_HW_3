import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DataString {
    String[] dataStrings;
    String filePath;
    
    public DataString(Scanner sc) throws DataException {
        dataStrings = sc.nextLine().split(" ");   
        if (dataStrings.length > 6)
            throw new DataException("Неверный формат записи! Записей больше, чем необходимо.");
        if (dataStrings.length < 6)
            throw new DataException("Неверный формат записи! Записей меньше, чем необходимо.");
    }

    private boolean checkFormat() throws DataException {
        boolean flag = true;
        for (int i = 0; i < dataStrings.length; i++) {
            switch (i) {
                case 3:
                    Validator validator = new DateValidator();
                    if (!validator.isValid(dataStrings[i])) {
                        flag = false;
                        throw new DataException("Неверный формат записи даты рождения! Пример формата: 01.01.0001");
                    }
                    break;
                case 4:
                    Validator validator2 = new PhoneValidator();
                    if (!validator2.isValid(dataStrings[i])) {
                        flag = false;
                        throw new DataException(
                                "Неверный формат записи номера телефона! Должно быть 11 цифр без знаков и пробелов");
                    }
                    break;
                case 5:
                    Validator validator3 = new GenderValidator();
                    if (!validator3.isValid(dataStrings[i])) {
                        flag = false;
                        throw new DataException(
                                "Неверный формат записи обозначения пола! Нужна 1 буква \"m\" или \"f\"");
                    }
                    break;
                default:
                    break;
            }
        }
        return flag;
    }

    public void save() {
        filePath = dataStrings[0] + ".txt";
        try {
            if (checkFormat()) {
                try (FileWriter writer = new FileWriter(filePath, true)) {
                    for (String string : dataStrings) {
                        writer.write(string + " ");
                    }
                    writer.write("\n");
                } catch (IOException e) {
                    e.getMessage();
                    e.printStackTrace();
                }
            }
        } catch (DataException e) {
            e.getMessage();
            e.printStackTrace();
        }

    }
}
