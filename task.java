import java.util.TimerTask;

public class task extends TimerTask {

    private void wrayter(String string) {
    }

    public task(note note) {
        System.out.println("Заметка создана." + note);
        wrayter("Заметка создана." + note);
    }

    public void run() {
        try {
            System.out.println("Внимание! Напоминаю о заметке!!! ");
            wrayter("Задача выполнена!");
        } catch (Exception ex) {
            System.out.println("Ошибка! " + ex.getMessage());
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}