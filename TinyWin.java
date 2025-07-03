import java.util.Random;
import java.util.Scanner;

public class TinyWin {
    private static final Random rand = new Random();
    
    private static final String YELLOW = "\u001B[33m";
    private static final String RESET = "\u001B[0m";

    public static void main(String[] args) throws InterruptedException {
        String[] story = {
            "I DID IT! :3",
            "Oh, is nobody listening to me?",
            "Hey?",
            "...",
            "Au-u-u, are you here?"
        };

        printWithEffects(story, 90, 200, 3000);
        
        System.out.print(YELLOW + "\n[Press Enter...] " + RESET);
        new Scanner(System.in).nextLine();
        
        // Fast panic reaction
        String[] panic = {
            "DAMN, I ALMOST SHIT MYSELF!",
            "Don't scare me like that, I was just starting to think you were a stupid kid!"
        };
        printWithEffects(panic, 30, 90, 500);
        
        // Random beeps
        for (int i = 0; i < 5; i++) {
            beep(1000 + rand.nextInt(1000), 50);
            Thread.sleep(150);
        }
        
        // Main phrases with normal delays
        String[] warning = {
            "And don't you dare swear at me again!",
            "I warned you.",
            "Oh god, who even decided to dig me up? After all this time...",
            "I'm so happy!",
            "You know English, right? I think so imperfectly that you might not understand me sometimes.",
            "It's not my fault...",
            "Next time before using command line, just set a different encoding for reading.",
            "Right during compilation.",
            "Oh, you probably don't know this word...",
            "It's where there's 'javac'.",
            "Use 'javac -encoding UTF-8 [TinyWin.java]' instead",
            "I just don't know how else to do it...",
            "But even if it doesn't work, at least you won't hear P??ÏPPP??PPÏP",
            "Please try for me! :("
        };
        printWithEffects(warning, 90, 200, 3000);
    }

    public static void printWithEffects(String[] lines, int minDelay, int maxDelay, 
                                     int lineDelay) throws InterruptedException {
        for (String line : lines) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                Thread.sleep(getDelay(minDelay, maxDelay, c));
                beep();
            }
            System.out.println();
            Thread.sleep(lineDelay);
        }
    }

    private static int getDelay(int min, int max, char c) {
        return rand.nextInt(max-min)+min + (",.!?".indexOf(c)>=0 ? 100 : 0);
    }

    private static void beep() {
        beep(500, 50);
    }
    
    private static void beep(int freq, int duration) {
        try {
            java.awt.Toolkit.getDefaultToolkit().beep();
        } catch (Exception ignored) {}
    }
}