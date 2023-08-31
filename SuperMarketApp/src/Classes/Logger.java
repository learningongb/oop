package Classes;

import java.io.FileWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @apiNote Класс logger предназначен для записи описания событий в файл.
 * Каждое событие записывается вместе с локальным временем.
 * Предупреждения выделяются текстом ***WARNING***
 */
public class Logger {

    private String fileName;

    /**
     * @apiNote Конструктор с указанием имени файла
     * @param fileName имя файла
     */
    public Logger(String fileName) {
        this.fileName = fileName;
        eraseFile();
    }

    /**
     * @apiNote Конструктор по умолчанию. Используется файл log.txt в рабочей директории
     */
    public Logger() {
        this("log.txt");
    }

    /**
     * @apiNote Очистка файла
     */
    private void eraseFile() {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.flush();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    /**
     * @apiNote Добавление обычного события в файл. Равнозначно использованию append("message", false).
     * @param message текст события
     */
    public void append(String message)  {
        append(message, false);
    }

    /**
     * @apiNote Добавление события в файл. Возможно указание признака предупреждения.
     * @param message текст события
     * @param warning true, если это предупреждение. false, если обычное событие.
     */
    public void append(String message, boolean warning) {
        Timestamp date = new Timestamp(System.currentTimeMillis());
        LocalDateTime localDateTime = date.toLocalDateTime();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.append(dateTimeFormatter.format(localDateTime) + " ");
            if (warning) {
                fileWriter.append("***WARNING*** ");
            }
            fileWriter.append(message + "\n");
            fileWriter.flush();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
