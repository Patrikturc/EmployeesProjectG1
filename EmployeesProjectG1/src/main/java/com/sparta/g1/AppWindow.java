package com.sparta.g1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppWindow extends JFrame implements ActionListener {
    private int windowHeight;
    private int windowWidth;
    JButton goButton = new JButton("Go");
    JRadioButton idSearch = new JRadioButton("Search by ID");
    JRadioButton lastNameSearch = new JRadioButton("Search by last name");
    JRadioButton dateRangeSearch = new JRadioButton("Search by hire date");
    JRadioButton ageRangeSearch = new JRadioButton("Search by Age");
    JTextField searchFieldOne = new JTextField();
    JTextField searchFieldTwo = new JTextField();
    JTextField searchFieldThree = new JTextField();
    JTextArea searchResults = new JTextArea();
    JPanel topPanel = new JPanel();
    JPanel searchPanel = new JPanel();
    JPanel oneSearchPanel = new JPanel();
    JPanel twoSearchPanel = new JPanel();
    CardLayout searchLayout = new CardLayout();




    public AppWindow(){
        this.windowHeight = 600;
        this.windowWidth = 600;
        this.setSize(windowWidth,windowHeight);
        setLocationRelativeTo(null);
        requestFocus();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Employee Search");
        setResizable(false);
        searchResults.setSize(500,300);

        addWindowComponents();;

        setVisible(true);

    }

    private void addWindowComponents(){

        goButton.addActionListener(this);
        idSearch.addActionListener(this);
        lastNameSearch.addActionListener(this);
        dateRangeSearch.addActionListener(this);
        ageRangeSearch.addActionListener(this);
        topPanel.add(idSearch);
        topPanel.add(lastNameSearch);
        topPanel.add(dateRangeSearch);
        topPanel.add(ageRangeSearch);
        oneSearchPanel.add(searchFieldOne);
        twoSearchPanel.add(searchFieldTwo);
        twoSearchPanel.add(searchFieldThree);
        this.add(topPanel,BorderLayout.NORTH);
        this.add(searchPanel);
        this.add(searchResults,BorderLayout.CENTER);
        this.add(goButton, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent event){
        Object source = event.getSource();

        if(source == idSearch){
            //Do something
        }
    }
}
