package EmailSender;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import static FontLoader.fontLoader.*;

public class EmailSender extends JFrame implements ActionListener {
    public static ArrayList<String> RECEIVER_EMAILS = new ArrayList<>();
    public static String SUBJECT;
    public static String MESSAGE;
    JLabel title_sit;
    JPanel file_first_panel, file_second_panel;
    JPanel subj_panel, msg_panel;
    JTextArea subj_txtArea, msg_txtArea;
    JButton file_btn, submit_btn;

    public EmailSender() {
        loadFonts();

        title_sit = new JLabel("Stay In Touch (BETA)");
        title_sit.setBounds(15, 105, 317, 37);
        title_sit.setForeground(new Color(0xF9F8F8));
        title_sit.setFont(jetBrainsMono.deriveFont(25f));

        file_first_panel = new JPanel();
        file_first_panel.setBounds(15, 157, 91, 19);
        file_first_panel.setBackground(new Color(0xF7FEFF));

        file_second_panel = new JPanel();
        file_second_panel.setBounds(17, 163, 91, 19);
        file_second_panel.setBackground(new Color(0x611E5D));

        file_btn = new JButton("Select File");
        file_btn.setBounds(5, 160, 110, 12);
        file_btn.setFont(jetBrainsMono.deriveFont(12f));
        file_btn.setForeground(new Color(0x4D3250));
        file_btn.setFocusable(false);
        file_btn.setOpaque(false);
        file_btn.setContentAreaFilled(false);
        file_btn.addActionListener(this);

        subj_panel = new JPanel();
        subj_panel.setBounds(23, 201, 350, 45);
        subj_panel.setBackground(new Color(0x611E5D));

        subj_txtArea = new JTextArea("Subject");
        subj_txtArea.setBounds(15, 196, 354, 43);
        subj_txtArea.setForeground(new Color(0x4D3250));
        subj_txtArea.setBackground(new Color(0xF7FEFF));
        subj_txtArea.setFont(jetBrainsMono.deriveFont(15f));
        subj_txtArea.setLineWrap(false);
        subj_txtArea.setWrapStyleWord(false);

        msg_panel = new JPanel();
        msg_panel.setBounds(22, 284, 426, 159);
        msg_panel.setBackground(new Color(0x611E5D));

        msg_txtArea = new JTextArea("Message");
        msg_txtArea.setBounds(13, 265, 431, 170);
        msg_txtArea.setForeground(new Color(0x4D3250));
        msg_txtArea.setBackground(new Color(0xF7FEFF));
        msg_txtArea.setFont(jetBrainsMono.deriveFont(16f));
        msg_txtArea.setLineWrap(false);
        msg_txtArea.setWrapStyleWord(false);

        submit_btn = new JButton("Submit");
        submit_btn.setBounds(686, 400, 105, 42);
        submit_btn.setFont(jetBrainsMono.deriveFont(19f));
        submit_btn.setForeground(new Color(0x4D3250));
        submit_btn.setBackground(new Color(0xF7FEFF));
        submit_btn.setFocusable(false);
        submit_btn.addActionListener(this);

        setSize(815, 485);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(0x393039));
        getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.white);
        getContentPane().setBackground(new Color(0x872BD8));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Adding Components
        add(title_sit);
        add(file_btn);
        add(file_first_panel);
        add(file_second_panel);

        add(subj_txtArea);
        add(subj_panel);

        add(msg_txtArea);
        add(msg_panel);

        add(submit_btn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == file_btn) {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt", "text");
            fileChooser.setFileFilter(filter);
            int response = fileChooser.showOpenDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    FileReader fileTempPlaceHolder = new FileReader(file);
                    BufferedReader buffering = new BufferedReader(fileTempPlaceHolder);

                    String line;
                    while ((line = buffering.readLine()) != null) {
                        RECEIVER_EMAILS.add(line); // Add each email to the list
                    }

                    fileTempPlaceHolder.close();
                    buffering.close();

                } catch (Exception er) {
                    er.printStackTrace();
                }
            }
            try {
                File directoryRenWvr = new File(System.getProperty("user.home") + "\\Desktop\\inf_log\\logs");
                File second_directoryRenWvr = new File(System.getProperty("user.home") + "\\Desktop\\inf_log\\config");
                File third_directoryRenWvr = new File(System.getProperty("user.home") + "\\Desktop\\inf_log\\bin");
                boolean creatingDirectory = directoryRenWvr.mkdirs();
                boolean creating_secondDirectory = second_directoryRenWvr.mkdirs();
                boolean creating_thirdDirectory = third_directoryRenWvr.mkdirs();

                BufferedWriter writer = new BufferedWriter(new FileWriter(System.getProperty("user.home") + "\\Desktop\\inf_log\\logs\\RECEIVER_EMAILS.txt"));
                BufferedWriter second_writer = new BufferedWriter(new FileWriter(System.getProperty("user.home") + "\\Desktop\\inf_log\\config\\SENDER.txt"));

                for (String email : RECEIVER_EMAILS) {
                    writer.write(email);
                    writer.newLine(); // Add a newline after each email
                }

                second_writer.write("delete this text in this line and put your gmail address");
                second_writer.newLine();
                second_writer.write("delete this text in this second line and put your gmail code password");
                second_writer.newLine();
                second_writer.newLine();
                second_writer.write("[!]You can your gmail code in the gmail settings");
                second_writer.newLine();
                second_writer.write("[!]Or simply read the instructions (README.txt) provided here (https://github.com/GhostPoltergeist/EmailSender)");


                writer.flush(); // Flush the buffered writer
                writer.close();

                second_writer.flush();
                second_writer.close();

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        if (e.getSource() == submit_btn) {
            SUBJECT = subj_txtArea.getText();
            MESSAGE = msg_txtArea.getText();

            try {
                File secondDirectory = new File(System.getProperty("user.home") + "\\Desktop\\inf_log\\settings");
                boolean creatingDirectory = secondDirectory.mkdirs();

                BufferedWriter writer = new BufferedWriter(new FileWriter(System.getProperty("user.home") + "\\Desktop\\inf_log\\settings\\SUBJECT.txt"));
                BufferedWriter second_writer = new BufferedWriter(new FileWriter(System.getProperty("user.home") + "\\Desktop\\inf_log\\settings\\MESSAGE.txt"));

                // Write data to the output files
                writer.write(SUBJECT);
                writer.flush();

                second_writer.write(MESSAGE);
                second_writer.flush();

                // Close the writers
                writer.close();
                second_writer.close();

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            try {
                UIManager.put("OptionPane.background", Color.WHITE);
                UIManager.put("OptionPane.messageForeground", new Color(0x611E5D));
                UIManager.put("Panel.background", Color.WHITE);
                UIManager.put("OptionPane.messageFont", jetBrainsMono.deriveFont(16f));

                // Load the jython.jar and sender.py files from the classpath
                InputStream jythonJarInputStream = Main.class.getResourceAsStream("/jython/jython.jar");
                InputStream senderPyInputStream = Main.class.getResourceAsStream("/python/sender.py");

                if (jythonJarInputStream == null || senderPyInputStream == null) {
                    JOptionPane.showMessageDialog(null, "Resource files not found on the classpath");
                    return;
                }

                // Create a reference to the second directory
                File secondDirectory = new File(System.getProperty("user.home") + "\\Desktop\\inf_log\\bin");

                // Create destination files in the second directory
                File jythonJarDestination = new File(secondDirectory, "jython.jar");
                File senderPyDestination = new File(secondDirectory, "sender.py");

                // Copy jython.jar and sender.py to the second directory
                try (OutputStream jythonOut = new FileOutputStream(jythonJarDestination);
                     OutputStream senderOut = new FileOutputStream(senderPyDestination)) {
                    byte[] buffer = new byte[8192];
                    int bytesRead;
                    while ((bytesRead = jythonJarInputStream.read(buffer)) != -1) {
                        jythonOut.write(buffer, 0, bytesRead);
                    }
                    while ((bytesRead = senderPyInputStream.read(buffer)) != -1) {
                        senderOut.write(buffer, 0, bytesRead);
                    }
                }

                // Now you have copied the files to the secondDirectory

                ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", jythonJarDestination.getAbsolutePath(), senderPyDestination.getAbsolutePath());
                processBuilder.redirectErrorStream(true);

                Process process = processBuilder.start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

                String line;
                while ((line = reader.readLine()) != null) {
                    System.err.println(line);
                }

                int exitCode = process.waitFor();

                if (exitCode == 0) {
                    // Script executed successfully
                    JOptionPane.showMessageDialog(null, "Email script sent successfully!");
                } else {
                    // Script execution failed
                    JOptionPane.showMessageDialog(null, "Email script execution failed. Exit code: " + exitCode);
                }

                // Clean up: Delete the temporary files when done
                jythonJarDestination.delete();
                senderPyDestination.delete();
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error executing Jython script: " + ex.getMessage());
            }
        }
    }
}

