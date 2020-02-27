/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeopardy;

// necessary imports
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import java.util.List;

public class Instructions extends JFrame {
    private JFrame frame;
    private JPanel panel;
    private JPanel titlePanel;
    private JLabel title;
    private JTextArea textField;
    private JButton okButton;
    
    private String text = "\nWelcome to the simple jeopardy game!"
            + " There are a few steps you need to follow in order to make this "
            + "game work properly.\n\n\t1. Upon opening the game, click the "
            + "'Generate Questions' button and choose the file with your "
            + "questions and categories.\n\t\ta. Your file must be in .txt"
            + "format.\n\t\tb. Your file must contain 30 lines. The first 5 "
            + "lines must be the name of your categories. The remaining 25 lines"
            + " must be your questions.\n\t\tMake sure each category and question"
            + "exists on its own line.\n\t\tc. Arrange your questions by weight"
            + "order. (ie. 100-level questions come first, 200-level come second,"
            + "  etc.)\n\t3. Click on the numbered panels to display the question."
            + " When finished, click the 'x' button in the upper-right corner to"
            + "return to the game panel.\n\t4. Enjoy the game.\n\n Additional "
            + "Tips:\n\t- Click the 'instructions' button to access these "
            + "instructions at any time.\n\t- Click 'exit' or the 'x' button in"
            + " the upper-right corner of the main game panel to exit the game."
            + "\n\t- Any panel that is grayed out has already been selected.";
    
    
    Instructions() {
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        //frame.setSize(600,900);
        frame.setBounds(200, 200, 1000, 410);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        titlePanel = new JPanel();
        titlePanel.setAlignmentX(CENTER_ALIGNMENT);
        title = new JLabel("JEOPARDY GAME INSTRUCTIONS");
        title.setFont(new Font("Sans Serif", Font.BOLD, 25));
        titlePanel.add(title);
        frame.add(titlePanel, BorderLayout.NORTH);
        
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        textField = new JTextArea();
        textField.setText(text);
        textField.setFont(new Font("Sans Serif", Font.PLAIN, 13));
        textField.setBackground(new Color(224,228,204));
        panel.add(textField, BorderLayout.CENTER);
        okButton = new JButton("Return to game");
        panel.add(okButton, BorderLayout.SOUTH);
        frame.add(panel, BorderLayout.CENTER);
        
        frame.setLocationRelativeTo(null);
        //frame.pack();
        frame.setVisible(true);
        
        okButton.addActionListener((ActionEvent e) -> {
            frame.dispose();
        });
    }
    
    
}
