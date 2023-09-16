package model.interfaces;

/**
 * Интерфейс, описывающий поведение логера.
 */
public interface iLogger {
    /**
     * Записывает строку в лог
     * @param message строка лога
     */
    void write(String message);
}
