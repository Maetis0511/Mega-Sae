package Jeu;
import java.util.concurrent.TimeUnit;
public class dialogue {

    public static void dialogues(String text) {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            try {
            TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}
