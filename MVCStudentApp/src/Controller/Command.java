package Controller;

/**
 * Перечень возможных команд
 * LIST - вывести список студентов
 * DELETE - удалить запись
 * EXIT - завершение работы программы
 * HELP - вывести список возможных команд
 *
 */
public enum Command {
    NONE,
    READ,
    CREATE,
    UPDATE,
    LIST,
    DELETE,
    EXIT,
    HELP
}
