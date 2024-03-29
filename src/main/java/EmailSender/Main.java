package EmailSender;
import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {UIManager.setLookAndFeel(new FlatDarkLaf());}
        catch (UnsupportedLookAndFeelException e) {throw new RuntimeException(e);}
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                EmailSender sender;
                try {
                    sender = new EmailSender();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}