/*
 * File: Jeopardy.java 
 * Author: Nusaiba Baqibillah
 * Date: February 9, 2020
 * Purpose: This java file contains the Jeopardy.java class, as well as the main
 * method, which creates and displays a GUI to play a simple jeopardy game using
 * File I/O.
 */ 

package jeopardy;

// necessary imports
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import java.util.List;

public class Jeopardy extends JFrame {
    /* Field variables for GUI components to make them accessible throughout
    the class. */
    // declaring main frame
    private JFrame frame;
    
    // declaring necessary panels
    private JPanel gradePanel;
    private JPanel buttonPanel;
    private JPanel optionPanel;
    // private JPanel scorePanel;
    
    // declaring fields for gradePanel
    private JLabel title;
    private JButton generate;
    
    // declaring fields for buttonPanel
    private JLabel cat1;
    private JLabel cat2;
    private JLabel cat3;
    private JLabel cat4;
    private JLabel cat5;
    
    private JButton first_100;
    private JButton second_100;
    private JButton third_100;
    private JButton fourth_100;
    private JButton fifth_100;
    private JButton first_200;
    private JButton second_200;
    private JButton third_200;
    private JButton fourth_200;
    private JButton fifth_200;
    private JButton first_300;
    private JButton second_300;
    private JButton third_300;
    private JButton fourth_300;
    private JButton fifth_300;
    private JButton first_400;
    private JButton second_400;
    private JButton third_400;
    private JButton fourth_400;
    private JButton fifth_400;
    private JButton first_500;
    private JButton second_500;
    private JButton third_500;
    private JButton fourth_500;
    private JButton fifth_500;
    
    // declaring buttons for optionsPanel
    private JButton exit;
    private JButton instructions;
    
    // creating custom colors
    private final Color storm = new Color(224,228,204);
    private final Color pond = new Color(167,219,216);
    private final Color cheeto = new Color(243,134,48);
    private final Color sky = new Color(105,210,231);
    
    // declaring field variables
    //JFileChooser fileChooser;
    //int returnVal;
    File file;
    BufferedReader br;
    String currentLine;
    List<String> list;
    String[] stringArr;
    JFileChooser fileChooser = new JFileChooser();
    int returnVal;
    
    Jeopardy() {
        frame = new JFrame("Jeopardy Game");
        frame.setSize(750,700);
        frame.setLayout(new BorderLayout());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.DARK_GRAY);
        
        // set up and add components to gradePanel
        gradePanel = new JPanel();
        gradePanel.setBackground(cheeto);
        gradePanel.setBorder(BorderFactory.createLineBorder(storm));
        gradePanel.setAlignmentX(CENTER_ALIGNMENT);
        gradePanel.setAlignmentY(CENTER_ALIGNMENT);
        //gradePanel.setLayout(new GridLayout(2, 0));
        title = new JLabel("JEOPARDY");
        title.setFont(new Font("Sans Serif", Font.BOLD, 45));
        title.setForeground(sky);
        gradePanel.add(title);
        
        // set up and add components to optionPanel
        optionPanel = new JPanel();
        optionPanel.setBackground(storm);
        generate = new JButton("Generate Questions");
        instructions = new JButton("Instructions");
        exit = new JButton("Exit");
        generate.setBackground(Color.WHITE);
        instructions.setBackground(Color.WHITE);
        exit.setBackground(Color.WHITE);
        optionPanel.add(generate);
        optionPanel.add(instructions);
        optionPanel.add(exit);
        
        // set up and add components to button panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6,5,10,5));
        buttonPanel.setBackground(storm);
        
        cat1 = new JLabel("CATEGORY 1");
        cat2 = new JLabel("Category 2");
        cat3 = new JLabel("Category 3");
        cat4 = new JLabel("Category 4");
        cat5 = new JLabel("Category 5");
        
        cat1.setHorizontalAlignment(JLabel.CENTER);
        cat2.setHorizontalAlignment(JLabel.CENTER);
        cat3.setHorizontalAlignment(JLabel.CENTER);
        cat4.setHorizontalAlignment(JLabel.CENTER);
        cat5.setHorizontalAlignment(JLabel.CENTER);
        
        cat1.setFont(new Font("Sans Serif", Font.BOLD, 20));
        cat2.setFont(new Font("Sans Serif", Font.BOLD, 20));
        cat3.setFont(new Font("Sans Serif", Font.BOLD, 20));
        cat4.setFont(new Font("Sans Serif", Font.BOLD, 20));
        cat5.setFont(new Font("Sans Serif", Font.BOLD, 20));
        
        first_100 = new JButton("100");
        first_100.setBackground(pond);
        second_100 = new JButton("100");
        second_100.setBackground(pond);
        third_100 = new JButton("100");
        third_100.setBackground(pond);
        fourth_100 = new JButton("100");
        fourth_100.setBackground(pond);
        fifth_100 = new JButton("100");
        fifth_100.setBackground(pond);
        first_200 = new JButton("200");
        first_200.setBackground(pond);
        second_200 = new JButton("200");
        second_200.setBackground(pond);
        third_200 = new JButton("200");
        third_200.setBackground(pond);
        fourth_200 = new JButton("200");
        fourth_200.setBackground(pond);
        fifth_200 = new JButton("200");
        fifth_200.setBackground(pond);
        first_300 = new JButton("300");
        first_300.setBackground(pond);
        second_300 = new JButton("300");
        second_300.setBackground(pond);
        third_300 = new JButton("300");
        third_300.setBackground(pond);
        fourth_300 = new JButton("300");
        fourth_300.setBackground(pond);
        fifth_300 = new JButton("300");
        fifth_300.setBackground(pond);
        first_400 = new JButton("400");
        first_400.setBackground(pond);
        second_400 = new JButton("400");
        second_400.setBackground(pond);
        third_400 = new JButton("400");
        third_400.setBackground(pond);
        fourth_400 = new JButton("400");
        fourth_400.setBackground(pond);
        fifth_400 = new JButton("400");
        fifth_400.setBackground(pond);
        first_500 = new JButton("500");
        first_500.setBackground(pond);
        second_500 = new JButton("500");
        second_500.setBackground(pond);
        third_500 = new JButton("500");
        third_500.setBackground(pond);
        fourth_500 = new JButton("500");
        fourth_500.setBackground(pond);
        fifth_500 = new JButton("500");
        fifth_500.setBackground(pond);
        
        buttonPanel.add(cat1);
        buttonPanel.add(cat2);
        buttonPanel.add(cat3);
        buttonPanel.add(cat4);
        buttonPanel.add(cat5);
        
        buttonPanel.add(first_100);
        buttonPanel.add(second_100);
        buttonPanel.add(third_100);
        buttonPanel.add(fourth_100);
        buttonPanel.add(fifth_100);
        buttonPanel.add(first_200);
        buttonPanel.add(second_200);
        buttonPanel.add(third_200);
        buttonPanel.add(fourth_200);
        buttonPanel.add(fifth_200);
        buttonPanel.add(first_300);
        buttonPanel.add(second_300);
        buttonPanel.add(third_300);
        buttonPanel.add(fourth_300);
        buttonPanel.add(fifth_300);
        buttonPanel.add(first_400);
        buttonPanel.add(second_400);
        buttonPanel.add(third_400);
        buttonPanel.add(fourth_400);
        buttonPanel.add(fifth_400);
        buttonPanel.add(first_500);
        buttonPanel.add(second_500);
        buttonPanel.add(third_500);
        buttonPanel.add(fourth_500);
        buttonPanel.add(fifth_500);
        
        frame.add(gradePanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(optionPanel, BorderLayout.SOUTH);
        
        frame.pack();
        frame.setVisible(true);
        
        generate.addActionListener((ActionEvent e) -> {
            readFile();
            setLabels();
        });
        
        exit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        
        instructions.addActionListener((ActionEvent e) -> {
            Instructions i = new Instructions();
        });
        
        first_100.addActionListener((ActionEvent e) -> {
            generateQuestions(1);
        });
        
        second_100.addActionListener((ActionEvent e) -> {
            generateQuestions(2);
        });
        
        third_100.addActionListener((ActionEvent e) -> {
            generateQuestions(3);
        });
        
        fourth_100.addActionListener((ActionEvent e) -> {
            generateQuestions(4);
        });
        
        fifth_100.addActionListener((ActionEvent e) -> {
            generateQuestions(5);
        });
        
        first_200.addActionListener((ActionEvent e) -> {
            generateQuestions(6);
        });
        
        second_200.addActionListener((ActionEvent e) -> {
            generateQuestions(7);
        });
        
        third_200.addActionListener((ActionEvent e) -> {
            generateQuestions(8);
        });
        
        fourth_200.addActionListener((ActionEvent e) -> {
            generateQuestions(9);
        });
        
        fifth_200.addActionListener((ActionEvent e) -> {
            generateQuestions(10);
        });
        
        first_300.addActionListener((ActionEvent e) -> {
            generateQuestions(11);
        });
        
        second_300.addActionListener((ActionEvent e) -> {
            generateQuestions(12);
        });
        
        third_300.addActionListener((ActionEvent e) -> {
            generateQuestions(13);
        });
        
        fourth_300.addActionListener((ActionEvent e) -> {
            generateQuestions(14);
        });
        
        fifth_300.addActionListener((ActionEvent e) -> {
            generateQuestions(15);
        });
        
        first_400.addActionListener((ActionEvent e) -> {
            generateQuestions(16);
        });
        
        second_400.addActionListener((ActionEvent e) -> {
            generateQuestions(17);
        });
        
        third_400.addActionListener((ActionEvent e) -> {
            generateQuestions(18);
        });
        
        fourth_400.addActionListener((ActionEvent e) -> {
            generateQuestions(19);
        });
        
        fifth_400.addActionListener((ActionEvent e) -> {
            generateQuestions(20);
        });
        
        first_500.addActionListener((ActionEvent e) -> {
            generateQuestions(21);
        });
        
        second_500.addActionListener((ActionEvent e) -> {
            generateQuestions(22);
        });
        
        third_500.addActionListener((ActionEvent e) -> {
            generateQuestions(23);
        });
        
        fourth_500.addActionListener((ActionEvent e) -> {
            generateQuestions(24);
        });
        
        fifth_500.addActionListener((ActionEvent e) -> {
            generateQuestions(25);
        });
    }
    
    public void readFile() {
        try {
            returnVal = fileChooser.showOpenDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            try {
                br = new BufferedReader(new FileReader(file));
                list = new ArrayList<>();
                while ((currentLine = br.readLine()) != null) {
                    list.add(currentLine);
                }
                stringArr = list.toArray(new String[list.size()]);
                //System.out.println(stringArr[0] + "\n" + stringArr[3]);
                } catch (IOException error) {
                    JOptionPane.showMessageDialog(null, error);
                }
            }
        } catch (Exception o) {
            JOptionPane.showMessageDialog(null, o);
        }
        
    }
    
    public void setLabels() {
        cat1.setText(stringArr[0]);
        cat2.setText(stringArr[1]);
        cat3.setText(stringArr[2]);
        cat4.setText(stringArr[3]);
        cat5.setText(stringArr[4]);
    }
    
    public void generateQuestions(int x) {
        try {
            JFrame f = new JFrame("Question");
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setLocationRelativeTo(null);
            f.setExtendedState(JFrame.MAXIMIZED_BOTH);
            f.setBackground(storm);
            String message = null;
        
            switch(x) {
                case 1:
                    message = stringArr[5];
                    break;
                case 2:
                    message = stringArr[6];
                    break;
                case 3:
                    message = stringArr[7];
                    break;
                case 4:
                    message = stringArr[8];
                    break;
                case 5:
                    message = stringArr[9];
                    break;
                case 6:
                    message = stringArr[10];
                    break;
                case 7:
                    message = stringArr[11];
                    break;
                case 8:
                    message = stringArr[12];
                    break;
                case 9:
                    message = stringArr[13];
                    break;
                case 10:
                    message = stringArr[14];
                    break;
                case 11:
                    message = stringArr[15];
                    break;
                case 12:
                    message = stringArr[16];
                    break;
                case 13:
                    message = stringArr[17];
                    break;
                case 14:
                    message = stringArr[18];
                    break;
                case 15:
                    message = stringArr[19];
                    break;
                case 16:
                    message = stringArr[20];
                    break;
                case 17:
                    message = stringArr[21];
                    break;
                case 18:
                    message = stringArr[22];
                    break;
                case 19:
                    message = stringArr[23];
                    break;
                case 20:
                    message = stringArr[24];
                    break;
                case 21:
                    message = stringArr[25];
                    break;
                case 22:
                    message = stringArr[26];
                    break;
                case 23:
                    message = stringArr[27];
                    break;
                case 24:
                    message = stringArr[28];
                    break;
                case 25:
                    message = stringArr[29];
                    break;
                default:
                    message = "No question found";
                    break;
            }

            JLabel question = new JLabel(message);
            question.setBackground(storm);
            question.setFont(new Font("Sans Serif", Font.BOLD, 35));
            question.setHorizontalAlignment(JLabel.CENTER);
            f.add(question);
            f.setVisible(true);
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, ae);
        }
    }
    
    public static void main(String[] args) {
        Jeopardy jeopardy = new Jeopardy();
    }
    
}
