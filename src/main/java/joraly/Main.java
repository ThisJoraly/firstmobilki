package joraly;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Scanner;
import java.io.PrintWriter;

public class Main {
    public static String file = "C:\\Users\\Artyom\\Desktop\\students.txt"; // путь к файлу
    public static void main(String[] args) throws IOException {
        while(true) {
            Scanner scan = new Scanner(System.in); // сканнер - для получения значений студента из консоли
            System.out.println("Введите имя студента");
            var name = scan.nextLine(); // принимаем строку в переменную
            System.out.println("Введите возраст студента");
            var age = scan.nextLine(); // принимаем строку в переменную
            System.out.println("Введите средний балл студента");
            var grade = scan.nextLine(); // принимаем строку в переменную
            String strFile = null;
            try {
                strFile = Files.readString(Path.of(file));
            } catch (NoSuchFileException e) {
                Files.createFile(Path.of(file));
            }
            var student = name + "\n" + age + "\n" + grade; // делаем строку с данными нашего студента
            strFile += student; // добавляем к строке, полученной из файла
            PrintWriter pw = new PrintWriter(file); // создаем PrintWriter для лёгкой записи строки в файл
            pw.println(strFile); // записываем обновленную строку с новыми данными в файлы
            pw.close(); // закрываем поток PrintWriter
            System.out.println("Вы хотите создать еще одного студента? 1/0");
            int ans = new Scanner(System.in).nextInt(); // принимаем число через новый объект типа Scanner
            if (ans == 1) { // если пользователь написал 1 вызывается опять метод main
                main(args);
            } else {
                scan.close();
                System.exit(0); // завершаем программу со статусом 0
            }
        }
    }
}