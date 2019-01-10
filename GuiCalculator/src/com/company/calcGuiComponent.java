package com.company;

import jdk.internal.jline.internal.Log;
import org.apache.log4j.spi.LoggingEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class calcGuiComponent implements ActionListener {

    public calcGuiComponent() {

        JFrame frame = new JFrame("calculator");
        JTextArea area=new JTextArea();
        Container Grid = new Container();
        JTextPane answerPane = new JTextPane();
        frame.setSize(150, 300);
        int widthSetCounter = 3;
        int heightSetCounter = 6;
        char[] operators = new char[]{'+', '-', '*', '/', '='};
        Grid.setLayout(new GridLayout(6, 3));

            JButton showHistory= new JButton("history");
            showHistory.addActionListener(this);
            JButton clearHistory=new JButton("clear");
            clearHistory.addActionListener(this);
            JButton answerButton= new JButton("answer");
            answerButton.addActionListener(this);
            Grid.add(showHistory);
            Grid.add(clearHistory);
            Grid.add(answerButton);

        for (int a = 0; a < 5; a++) {
            if(a==0) {
                JButton button = new JButton("" + a);
                button .addActionListener(this);
                JButton button1 = new JButton("" + (a + 1));
                button1 .addActionListener(this);
                Grid.add(button);
                Grid.add(button1);
            }
            else {
                JButton button = new JButton("" + a*2);
                button .addActionListener(this);
                JButton button1 = new JButton("" + (a *2 + 1));
                button1 .addActionListener(this);
                Grid.add(button);
                Grid.add(button1);
            }
           JButton operatorButton = new JButton("" + operators[a]);
            operatorButton .addActionListener(this);
           Grid.add(operatorButton);
    }


        frame.add(area,BorderLayout.NORTH);
        frame.add(Grid,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        }
        @Override
        public void actionPerformed(ActionEvent e) {
            String[] pieces = new String[3];
            String pieceMeal = ((JButton) e.getSource()).getText();
            int i = 0;
            if (!pieceMeal.equals("history") && !pieceMeal.equals("clear") && !pieceMeal.equals("answer")) {
                i++;
                if (i == 1) {
                    pieces[0] = pieceMeal;
                } else if (i == 2) {
                    pieces[1] = pieceMeal;
                } else if (i == 3) {
                    pieces[2] = pieceMeal;
                    i = 0;
                    try {
                        double part1 = Double.parseDouble(pieces[0]);
                        String part2 = pieces[1];
                        double part3 = Double.parseDouble(pieces[2]);
                        if (part2.equals("+")) {
                            double part4 = part1 + part3;
                        } else if (part2.equals("-")) {
                            double part4 = part1 - part3;
                        } else if (part2.equals("/")) {
                            double part4 = part1 / part3;
                        } else if (part2.equals("*")) {
                            double part4 = part1 * part3;
                        }
                    } catch (Exception e1) {
                        Log.info("Invalid Sequence");
                    }


    }}}}




