import java.util.Calendar;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * Main
 */
public class Main {

    public static final String reset = "\u001B[0m";
    public static final String red = "\u001B[31m";
    public static final String yellow = "\u001B[33m";
    public static final String cyan = "\u001B[36m";

    public static void main(String[] args) throws InterruptedException {
        int setNote = userInput(cyan + "Создайте заметку и назначьте время напоминания:" +
                "\n1. Рисунок" +
                "\n2. Голосовая заметка" +
                "\n3. Текстовая заметка\n" + reset);

        switch (setNote) {
            case 1:
                runTask(imgNoteCreator(yellow + "This is image note" + reset));
                break;
            case 2:
                runTask(voiceNoteCreator(yellow + "This is voice note" + reset));
                break;
            case 3:
                runTask(txtNoteCreator(yellow + "This is text note" + reset));
                break;
            default:
                System.out.println(" ");
        }
    }

    private static int userInput(String msg) {
        Scanner sc = new Scanner(System.in);
        int inputStr;
        while (true) {
            System.out.print(msg);
            try {
                inputStr = Integer.parseInt(sc.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println(red + "Неверный ввод! Введите целое число!" + reset);
            }
        }
        return inputStr;
    }

    public static note imgNoteCreator(String msg) {
        note img = new drawingNote(msg);
        return img;
    }

    public static note voiceNoteCreator(String msg) {
        note voice = new voiseNote(msg);
        return voice;
    }

    public static note txtNoteCreator(String msg) {
        note txt = new tekstNote(msg);
        return txt;
    }

    public static void runTask(note currentNote) {
        System.out.println("Настройка напоминания.");
        int day = userInput(yellow + "Введите число: " + reset);
        int hour = userInput(yellow + "Введите час: " + reset);
        int minute = userInput(yellow + "Введите минуту: " + reset);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        recorder("Время напоминания: " + day + hour + minute);

        Timer time = new Timer();
        time.schedule(new task(currentNote), calendar.getTime(), TimeUnit.HOURS.toMillis(8));
    }

    private static void recorder(String string) {
    }

}
