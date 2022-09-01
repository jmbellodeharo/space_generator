import javax.swing.*;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Window height: ");
                int height = Integer.parseInt(scanner.nextLine());
                System.out.println("Window width: ");
                int width = Integer.parseInt(scanner.nextLine());

                JFrame NWindownGeneration = new WindowGeneration(height, width);
            }
        });
    }
}
