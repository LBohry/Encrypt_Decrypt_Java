package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton encrypt;
    JButton decrypt;

    JPanel panel;

    Main(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,420);

        textField = new JTextField();

        encrypt = new JButton("Encrypt");
        decrypt = new JButton("Decrypt");

        encrypt.addActionListener(this);
        decrypt.addActionListener(this);


        panel = new JPanel();

        panel.add(textField);
        panel.add(encrypt);
        panel.add(decrypt);

        frame.add(panel);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Main e = new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
