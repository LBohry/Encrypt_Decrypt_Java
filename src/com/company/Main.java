package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

import static javax.swing.JOptionPane.showMessageDialog;

public class Main implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton encrypt;
    JButton decrypt;

    JPanel panel;
    boolean encrypted=false;
    String first_text;
    int count = 0;
    boolean stop=false;

    Main(){

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,420);

        textField = new JTextField();
        textField.setSize(150,50);
        textField.setBounds(270,10,140,30);
        //textField.setAlignmentY(TextField.);

        encrypt = new JButton("Encrypt");
        decrypt = new JButton("Decrypt");
        encrypt.setFocusable(false);
        decrypt.setFocusable(false);
        encrypt.setBounds(180,70,150,30);
        decrypt.setBounds(350,70,150,30);

        encrypt.addActionListener(this);
        decrypt.addActionListener(this);


        panel = new JPanel();
        panel.setLayout(null);


        panel.add(textField);
        panel.add(encrypt);
        panel.add(decrypt);

        frame.add(panel);

        frame.setVisible(true);
    }


    public class Global
    {
        public String first_text;

        public String get_text(){
            return first_text;
        }
        public void setString(String first_text){
            this.first_text = first_text;
        }
    }

    public Global g = new Global();

    public static void main(String[] args) {
        Main e = new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       // if (textField.getText().length()!=0 && count==0) {
       //     g.setString(textField.getText());
       // }
        if (e.getSource()==encrypt){
            if (textField.getText().length()==0) {
                showMessageDialog(frame, "Cannot encrypt empty string!");
            }
            else {
                if (count==0){
                   g.setString(textField.getText());
                }
                byte[] encryptArray = java.util.Base64.getEncoder().encode(textField.getText().getBytes());
                String encstr = null;
                try {
                    encstr = new String(encryptArray, "UTF-8");
                } catch (UnsupportedEncodingException ex) {
                    ex.printStackTrace();
                }
                textField.setText(encstr);
                encrypted = true;
                count++;
            }
        }

        else if(e.getSource()==decrypt){
            System.out.println(g.get_text());
            if (encrypted==false){
                showMessageDialog(frame, "The string is not yet encrypted!");
            }
            else if (encrypted){
                if (stop==true){
                    showMessageDialog(frame, "This is the original text!");
                }
                else {
                    byte[] dectryptArray = textField.getText().getBytes();
                    byte[] decarray = Base64.getDecoder().decode(dectryptArray);
                    String decstr = null;
                    try {
                        decstr = new String(decarray, "UTF-8");
                    } catch (UnsupportedEncodingException ex) {
                        ex.printStackTrace();
                    }
                    textField.setText(decstr);

                    System.out.println(decstr);
                    System.out.println(textField.getText());
                    System.out.println(g.get_text());
                    if (textField.getText()==decstr && decstr == g.get_text()){
                        stop=true;
                        showMessageDialog(frame, "This is the original text!");                    }
                } //still not working
            }
        }


    }
}
