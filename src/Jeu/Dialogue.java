package Jeu;
import java.util.concurrent.TimeUnit;

public class Dialogue {
    private static final int delaiDialogue = 0;
    /**
     * Function to display a text gradually
     * @param text the text to display
     */
    public static void dialogues(String text) {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            try {
            TimeUnit.MILLISECONDS.sleep(delaiDialogue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("\n");
    }
}
