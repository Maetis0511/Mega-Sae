package Jeu;
import java.util.concurrent.TimeUnit;
public class Dialogue {
    /**
     * Function to display a text gradually
     * @param text the text to display
     * @param temps the time to display the text (in milliseconds)
     */
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
