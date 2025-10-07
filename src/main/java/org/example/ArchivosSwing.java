package org.example;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ArchivosSwing extends JFrame {

    private JButton button1;
    private JLabel label;
    private JPanel principal;
    private JEditorPane editorPane1;

    ArchivosSwing(){
        this.setTitle("Visor XML");
        this.setSize(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setContentPane(principal);

        button1.addActionListener(e -> {

            var filechooser = new JFileChooser();
            filechooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            filechooser.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File f) {
                    if(f.isDirectory()){ return true; }
                    return f.getName().endsWith(".xml");
                }

                @Override
                public String getDescription() {
                    return "Archivos XML";
                }
            });

            filechooser.setDialogType(JFileChooser.OPEN_DIALOG);

            var result = filechooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File f = filechooser.getSelectedFile();
                Path path = f.toPath();
                System.out.println(path);
                try {
                    List<String> lineas = Files.readAllLines(path);
                    for (String linea : lineas) {
                        System.out.println(linea);
                        editorPane1.setText( editorPane1.getText()+System.lineSeparator()+linea );
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });
    }

    public void show(Boolean b){
        this.setVisible(b);
    }

    public static void main(String[] args) {
        var login = new ArchivosSwing();
        login.show(true);
    }

}
