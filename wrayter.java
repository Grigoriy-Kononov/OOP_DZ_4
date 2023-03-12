import java.io.*;
import java.io.IOException;
import java.util.Date;

public class wrayter {
    public static void wrayter(String msg) {
        try (FileWriter file = new FileWriter("d:\\УЧЕБА\\Объектно-ориентированное программирование\\OOP_DZ_4\\Recorder.txt", true)) {
            Date currentTime = new Date();
            StringBuilder sb = new StringBuilder();
            sb.append(currentTime + ": " + msg + "\n");
            file.append(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}