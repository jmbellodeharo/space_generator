import javax.swing.*;

public class MainApp {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame NWindownGeneration = new WindowGeneration();
            }
        });
    }
}
