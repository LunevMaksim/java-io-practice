import java.io.*;
import java.util.Scanner;

public class FileUtils {
    public void inFile() {
        File file = new File("source.txt");
        try (PrintStream printStream = new PrintStream(new FileOutputStream(file, true)); Scanner in = new Scanner(System.in)) {
            System.out.println("Введите текст для записи в файл (exit для завершения): ");
            while (in.hasNextLine()) {
                String str = in.nextLine();
                if ("exit".equalsIgnoreCase(str)) {
                    break;
                } else {
                    printStream.println(str);
                }
            }
        } catch (IOException exception) {
            System.out.println("Ошибка при работе с файлами: " + exception.getMessage());
        }
    }

    public void readFile() {
        File file = new File("source.txt");
        try (Scanner in = new Scanner(file); PrintStream out = new PrintStream(new FileOutputStream("destination.txt", true))) {
            while (in.hasNextLine()) {
                out.println(in.nextLine());
            }
            System.out.println("Копирование успешно завершено!");
        } catch (IOException e) {
            System.out.println("Ошибка копирования: " + e.getMessage());
        }
    }
}

