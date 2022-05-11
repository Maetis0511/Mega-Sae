package Jeu;
import java.util.concurrent.TimeUnit;
public class Dialogue {

    public static void dialogues(String text, int temps) {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            try {
            TimeUnit.MILLISECONDS.sleep(temps);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}
