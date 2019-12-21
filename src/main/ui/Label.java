package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Label extends JFrame implements ActionListener {

    private JLabel label;
    private JTextField field;
    public int size = 0;

    // modified label from example LabelChanger from 210 website
    public Label() {
        super("Welcome to SnakeGame!!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 90));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(new FlowLayout());
        JButton btn = new JButton("Enter");
        btn.setActionCommand("myButton");
        btn.addActionListener(this); //sets "this" class as an action listener for btn.
        //that means that when the btn is clicked,
        //this.actionPerformed(ActionEvent e) will be called.
        //You could also set a different class, if you wanted
        //to capture the response behaviour elsewhere
        label = new JLabel("What size board would you like?");
        field = new JTextField(5);
        add(label);
        add(field);
        add(btn);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    //taken from 210 website on LabelChangers
    //this is the method that runs when Swing registers an action on an element
    //for which this class is an ActionListener
    // REQUIRES: ActionListener
    // MODIFIES: size
    // EFFECTS: if valid size entered in field, create new SnakeGame of given size
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("myButton")) {
            try {
                size = Integer.parseInt(field.getText());
                new SnakeGame(size);
                //this.dispose();
            } catch (Exception ex) {
                System.out.println("Not valid number");
            }

        }
    }

    public static void main(String[] args) {
        new Label();
    }
}
