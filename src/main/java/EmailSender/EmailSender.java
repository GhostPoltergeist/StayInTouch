package EmailSender;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.RoundRectangle2D;
import java.io.*;
import java.util.ArrayList;

import static FontLoader.fontLoader.*;

public class EmailSender extends JFrame implements ActionListener, FocusListener {
    JLabel stayInTouch;
    JTextField nTo, nFrom, nuserPass, subj_txtField;
    JTextArea msg_txtArea;
    public static ArrayList<String> RECEIVER_EMAILS = new ArrayList<>();
    public static String SUBJECT;
    public static String MESSAGE;
    JButton file_btn, report_btn, github_btn, manuals_btn, submit_btn, group_btn;

    public EmailSender() {
        loadFonts();

        file_btn = new JButton("Upload File") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Fill the button with a rounded rectangle
                g2.setColor(getBackground());
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));

                // Draw the button text
                g2.setColor(getForeground());
                g2.drawString(getText(), (getWidth() - g2.getFontMetrics().stringWidth(getText())) / 2,
                        (getHeight() + g2.getFontMetrics().getAscent() - g2.getFontMetrics().getDescent()) / 2);

                g2.dispose();
            }
        };
        file_btn.setBounds(5, 5, 110, 25);
        file_btn.setFont(jetBrainsMono.deriveFont(13f));
        file_btn.setFocusPainted(false);
        file_btn.setBorderPainted(false);
        file_btn.setForeground(new Color(0x0670FC));
        file_btn.setBackground(new Color(6, 112, 252, 100));
        file_btn.addActionListener(this);

        report_btn = new JButton("Reports") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Fill the button with a rounded rectangle
                g2.setColor(getBackground());
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));

                // Draw the button text
                g2.setColor(getForeground());
                g2.drawString(getText(), (getWidth() - g2.getFontMetrics().stringWidth(getText())) / 2,
                        (getHeight() + g2.getFontMetrics().getAscent() - g2.getFontMetrics().getDescent()) / 2);

                g2.dispose();
            }
        };
        report_btn.setBounds(133, 5, 110, 25);
        report_btn.setFont(jetBrainsMono.deriveFont(13f));
        report_btn.setFocusPainted(false);
        report_btn.setBorderPainted(false);
        report_btn.setForeground(new Color(0xD2042D));
        report_btn.setBackground(new Color(210, 4, 45, 100));
        report_btn.addActionListener(this);

        github_btn = new JButton("Releases") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Fill the button with a rounded rectangle
                g2.setColor(getBackground());
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));

                // Draw the button text
                g2.setColor(getForeground());
                g2.drawString(getText(), (getWidth() - g2.getFontMetrics().stringWidth(getText())) / 2,
                        (getHeight() + g2.getFontMetrics().getAscent() - g2.getFontMetrics().getDescent()) / 2);

                g2.dispose();
            }
        };
        github_btn.setBounds(260, 5, 110, 25);
        github_btn.setFont(jetBrainsMono.deriveFont(13f));
        github_btn.setFocusPainted(false);
        github_btn.setBorderPainted(false);
        github_btn.setForeground(new Color(0x228B22));
        github_btn.setBackground(new Color(124, 252, 0, 100));
        github_btn.addActionListener(this);

        manuals_btn = new JButton("Manuals") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Fill the button with a rounded rectangle
                g2.setColor(getBackground());
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));

                // Draw the button text
                g2.setColor(getForeground());
                g2.drawString(getText(), (getWidth() - g2.getFontMetrics().stringWidth(getText())) / 2,
                        (getHeight() + g2.getFontMetrics().getAscent() - g2.getFontMetrics().getDescent()) / 2);

                g2.dispose();
            }
        };
        manuals_btn.setBounds(390, 5, 110, 25);
        manuals_btn.setFont(jetBrainsMono.deriveFont(13f));
        manuals_btn.setFocusPainted(false);
        manuals_btn.setBorderPainted(false);
        manuals_btn.setForeground(new Color(0x702963));
        manuals_btn.setBackground(new Color(112, 41, 99, 100));
        manuals_btn.addActionListener(this);

        nTo = new JTextField("Email(Receiver)");
        nTo.setBounds(5,40, 500, 40);
        nTo.setForeground(Color.BLACK);
        nTo.setFont(jetBrainsMono.deriveFont(13f));
        nTo.setHorizontalAlignment(JTextField.CENTER);
        nTo.setBackground(new Color(0xFFFFFF));
        nTo.addFocusListener(this);

        nFrom = new JTextField("Email(Sender)");
        nFrom.setBounds(5,85, 500, 40);
        nFrom.setForeground(Color.BLACK);
        nFrom.setFont(jetBrainsMono.deriveFont(13f));
        nFrom.setHorizontalAlignment(JTextField.CENTER);
        nFrom.setBackground(new Color(0xFFFFFF));
        nFrom.addFocusListener(this);

        nuserPass = new JTextField("Sender(Code-Password) ");
        nuserPass.setBounds(5,130, 500, 40);
        nuserPass.setForeground(Color.BLACK);
        nuserPass.setHorizontalAlignment(JTextField.CENTER);
        nuserPass.setFont(jetBrainsMono.deriveFont(13f));
        nuserPass.setBackground(new Color(0xFFFFFF));
        nuserPass.addFocusListener(this);

        subj_txtField = new JTextField("Subject");
        subj_txtField.setBounds(5,175, 500, 40);
        subj_txtField.setForeground(Color.BLACK);
        subj_txtField.setHorizontalAlignment(JTextField.CENTER);
        subj_txtField.setFont(jetBrainsMono.deriveFont(13f));
        subj_txtField.setBackground(new Color(0xFFFFFF));
        subj_txtField.addFocusListener(this);

        msg_txtArea = new JTextArea("                            Message");
        msg_txtArea.setBounds(5,220, 876, 210);
        msg_txtArea.setForeground(Color.BLACK);
        msg_txtArea.setLineWrap(true);
        msg_txtArea.setMargin(new Insets(5,5,5,5));
        msg_txtArea.setWrapStyleWord(true);
        msg_txtArea.setFont(jetBrainsMono.deriveFont(13f));
        msg_txtArea.setBackground(new Color(0xFFFFFF));
        msg_txtArea.setBorder(new LineBorder(Color.GRAY));
        msg_txtArea.addFocusListener(this);

        submit_btn = new JButton("Send") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Fill the button with a rounded rectangle
                g2.setColor(getBackground());
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));

                // Draw the button text
                g2.setColor(getForeground());
                g2.drawString(getText(), (getWidth() - g2.getFontMetrics().stringWidth(getText())) / 2,
                        (getHeight() + g2.getFontMetrics().getAscent() - g2.getFontMetrics().getDescent()) / 2);

                g2.dispose();
            }
        };
        submit_btn.setBounds(750, 455, 110, 25);
        submit_btn.setFont(jetBrainsMono.deriveFont(13f));
        submit_btn.setFocusPainted(false);
        submit_btn.setBorderPainted(false);
        submit_btn.setForeground(new Color(0xFFFFFF));
        submit_btn.setBackground(new Color(16, 16, 16, 180));
        submit_btn.addActionListener(this);

        group_btn = new JButton("MultiSend") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Fill the button with a rounded rectangle
                g2.setColor(getBackground());
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));

                // Draw the button text
                g2.setColor(getForeground());
                g2.drawString(getText(), (getWidth() - g2.getFontMetrics().stringWidth(getText())) / 2,
                        (getHeight() + g2.getFontMetrics().getAscent() - g2.getFontMetrics().getDescent()) / 2);

                g2.dispose();
            }
        };
        group_btn.setBounds(630, 455, 110, 25);
        group_btn.setFont(jetBrainsMono.deriveFont(13f));
        group_btn.setFocusPainted(false);
        group_btn.setBorderPainted(false);
        group_btn.setForeground(new Color(0xFFFFFF));
        group_btn.setBackground(new Color(16, 16, 16, 180));
        group_btn.addActionListener(this);
        group_btn.setEnabled(false);

        stayInTouch = new JLabel("StayInTouch");
        stayInTouch.setFont(pressStart.deriveFont(12f));
        stayInTouch.setForeground(new Color(47,47,47, 158));
        stayInTouch.setBounds(15,415, 250,100);

        setSize(900, 540);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(0xFFFFFF));
        getContentPane().setBackground(new Color(0xFFFFFF));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Adding Components
        add(nTo);
        add(nFrom);
        add(nuserPass);
        add(file_btn);
        add(report_btn);
        add(github_btn);
        add(manuals_btn);
        add(stayInTouch);

        add(subj_txtField);

        add(msg_txtArea);

        add(submit_btn);
        add(group_btn);
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
                        group_btn.setEnabled(true);
                        submit_btn.setEnabled(false);
                        nTo.setEditable(false);
                        nTo.setText("Loaded.");
                        nTo.setForeground(Color.WHITE);
                        nTo.setBackground(new Color(0X2F2F2F));
                        nTo.setFocusable(false);
                    }

                    fileTempPlaceHolder.close();
                    buffering.close();

                } catch (Exception er) {
                    er.printStackTrace();
                }
            }
        }
        if (e.getSource() == submit_btn) {
            SUBJECT = subj_txtField.getText();
            MESSAGE = msg_txtArea.getText();

            try {
                File directoryRenWvr = new File(System.getProperty("user.home") + "\\Desktop\\INF_LOGS\\logs");
                File second_directoryRenWvr = new File(System.getProperty("user.home") + "\\Desktop\\INF_LOGS\\config");
                File third_directoryRenWvr = new File(System.getProperty("user.home") + "\\Desktop\\INF_LOGS\\bin");
                boolean creatingDirectory = directoryRenWvr.mkdirs();
                boolean creating_secondDirectory = second_directoryRenWvr.mkdirs();
                boolean creating_thirdDirectory = third_directoryRenWvr.mkdirs();

                BufferedWriter writer = new BufferedWriter(new FileWriter(System.getProperty("user.home") + "\\Desktop\\INF_LOGS\\logs\\RECEIVER_EMAILS.txt"));
                BufferedWriter second_writer = new BufferedWriter(new FileWriter(System.getProperty("user.home") + "\\Desktop\\INF_LOGS\\config\\SENDER.txt"));

                writer.write(nTo.getText());
                writer.newLine(); // Add a newline after each email

                second_writer.write(nFrom.getText());
                second_writer.newLine();
                second_writer.write(nuserPass.getText());

                writer.flush(); // Flush the buffered writer
                writer.close();

                second_writer.flush();
                second_writer.close();

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            try {
                File secondDirectory = new File(System.getProperty("user.home") + "\\Desktop\\INF_LOGS\\settings");
                boolean creatingDirectory = secondDirectory.mkdirs();

                BufferedWriter writer = new BufferedWriter(new FileWriter(System.getProperty("user.home") + "\\Desktop\\INF_LOGS\\settings\\SUBJECT.txt"));
                BufferedWriter second_writer = new BufferedWriter(new FileWriter(System.getProperty("user.home") + "\\Desktop\\INF_LOGS\\settings\\MESSAGE.txt"));

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
                File secondDirectory = new File(System.getProperty("user.home") + "\\Desktop\\INF_LOGS\\bin");

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
                    JOptionPane.showMessageDialog(null, "Email Sent Successfully!");
                } else {
                    // Script execution failed
                    JOptionPane.showMessageDialog(null, "Email execution failed. Exit code: " + exitCode);
                }

                // Clean up: Delete the temporary files when done
                jythonJarDestination.delete();
                senderPyDestination.delete();
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error executing Jython script: " + ex.getMessage());
            }
        }
        if (e.getSource()==group_btn) {
            SUBJECT = subj_txtField.getText();
            MESSAGE = msg_txtArea.getText();

            try {
                File directoryRenWvr = new File(System.getProperty("user.home") + "\\Desktop\\INF_LOGS\\logs");
                File second_directoryRenWvr = new File(System.getProperty("user.home") + "\\Desktop\\INF_LOGS\\config");
                File third_directoryRenWvr = new File(System.getProperty("user.home") + "\\Desktop\\INF_LOGS\\bin");
                boolean creatingDirectory = directoryRenWvr.mkdirs();
                boolean creating_secondDirectory = second_directoryRenWvr.mkdirs();
                boolean creating_thirdDirectory = third_directoryRenWvr.mkdirs();

                BufferedWriter writer = new BufferedWriter(new FileWriter(System.getProperty("user.home") + "\\Desktop\\INF_LOGS\\logs\\RECEIVER_EMAILS.txt"));
                BufferedWriter second_writer = new BufferedWriter(new FileWriter(System.getProperty("user.home") + "\\Desktop\\INF_LOGS\\config\\SENDER.txt"));

                for (String email : RECEIVER_EMAILS) {
                    writer.write(email);
                    writer.newLine(); // Add a newline after each email
                }

                second_writer.write(nFrom.getText());
                second_writer.newLine();
                second_writer.write(nuserPass.getText());

                writer.flush(); // Flush the buffered writer
                writer.close();

                second_writer.flush();
                second_writer.close();

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            try {
                File secondDirectory = new File(System.getProperty("user.home") + "\\Desktop\\INF_LOGS\\settings");
                boolean creatingDirectory = secondDirectory.mkdirs();

                BufferedWriter writer = new BufferedWriter(new FileWriter(System.getProperty("user.home") + "\\Desktop\\INF_LOGS\\settings\\SUBJECT.txt"));
                BufferedWriter second_writer = new BufferedWriter(new FileWriter(System.getProperty("user.home") + "\\Desktop\\INF_LOGS\\settings\\MESSAGE.txt"));

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
                File secondDirectory = new File(System.getProperty("user.home") + "\\Desktop\\INF_LOGS\\bin");

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
                    JOptionPane.showMessageDialog(null, "Email Sent Successfully!");
                } else {
                    // Script execution failed
                    JOptionPane.showMessageDialog(null, "Email execution failed. Exit code: " + exitCode);
                }

                // Clean up: Delete the temporary files when done
                jythonJarDestination.delete();
                senderPyDestination.delete();
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error executing Jython script: " + ex.getMessage());
            }
        }
        if (e.getSource()==report_btn) {
            openWebPage("https://github.com/GhostPoltergeist/StayInTouch/issues");
        }
        if (e.getSource()==github_btn) {
            openWebPage("https://github.com/GhostPoltergeist/StayInTouch/releases");
        }
        if (e.getSource()==manuals_btn) {
            openWebPage("https://github.com/GhostPoltergeist/StayInTouch/blob/main/README.md");
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource()==nTo && nTo.getText().equals("Email(Receiver)")) {
            nTo.setText("");
        }
        if (e.getSource()==nFrom && nFrom.getText().equals("Email(Sender)")) {
            nFrom.setText("");
        }
        if (e.getSource()==nuserPass && nuserPass.getText().equals("Sender(Code-Password) ")) {
            nuserPass.setText("");
        }
        if (e.getSource()==subj_txtField && subj_txtField.getText().equals("Subject")) {
            subj_txtField.setText("");
        }
        if (e.getSource()==msg_txtArea && msg_txtArea.getText().equals("                            Message")) {
            msg_txtArea.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource()==nTo && nTo.getText().isEmpty()) {
            nTo.setText("Email(Receiver)");
        }
        if (e.getSource()==nFrom && nFrom.getText().isEmpty()) {
            nFrom.setText("Email(Sender)");
        }
        if (e.getSource()==nuserPass && nuserPass.getText().isEmpty()) {
            nuserPass.setText("Sender(Code-Password) ");
        }
        if (e.getSource()==subj_txtField && subj_txtField.getText().isEmpty()) {
            subj_txtField.setText("Subject");
        }
        if (e.getSource()==msg_txtArea && msg_txtArea.getText().isEmpty()) {
            msg_txtArea.setText("                            Message");
        }
    }

    public static void openWebPage(String url) {
        try {
            Desktop.getDesktop().browse(new java.net.URI(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

