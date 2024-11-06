import com.formdev.flatlaf.FlatLightLaf;
import views.MainPane;

import javax.swing.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(new FlatLightLaf());
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("ExFilter");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            MainPane mainPane = new MainPane();
            frame.setContentPane(mainPane.getContentPane());
            frame.setSize(700, 500);
            frame.setLocationRelativeTo(null);
            frame.setIconImage(new ImageIcon(Objects.requireNonNull(Main.class.getResource("/views/app-icon.png"))).getImage());
            frame.setVisible(true);
        });
    }
}