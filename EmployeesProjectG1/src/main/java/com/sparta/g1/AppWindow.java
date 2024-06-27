package com.sparta.g1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class AppWindow extends JFrame implements ActionListener {
    private int windowHeight;
    private int windowWidth;
    JButton goButton = new JButton("Go");
    JRadioButton idSearch = new JRadioButton("Search by ID");
    JRadioButton lastNameSearch = new JRadioButton("Search by last name");
    JRadioButton dateRangeSearch = new JRadioButton("Search by hire date");
    JRadioButton ageRangeSearch = new JRadioButton("Search by Age");
    JTextField employeeIdSearchField = new JTextField(10);
    JTextField searchFieldTwo = new JTextField(10);
    JTextField searchFieldMinAge = new JTextField(10);
    JTextField searchFieldMaxAge = new JTextField(10);
    JTextField searchFieldFive = new JTextField(10);
    JTextField searchFieldSix = new JTextField(10);
    JTextArea searchResults = new JTextArea();
    ScrollPane searchScroll = new ScrollPane();
    JPanel topPanel = new JPanel();
    JPanel middlePanel = new JPanel();
    JPanel searchPanel = new JPanel();
    JPanel oneSearchPanel = new JPanel();
    JPanel twoSearchPanel = new JPanel();
    JPanel threeSearchPanel = new JPanel();
    JPanel fourSearchPanel = new JPanel();
    CardLayout searchLayout = new CardLayout();
    ButtonGroup topPanelButtons = new ButtonGroup();


    HashSet<Employee> employeeList = new HashSet<>(EmployeeDataConverter.getListOfEmployees());
    EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl(employeeList);


    public AppWindow() throws IOException {
        this.windowHeight = 800;
        this.windowWidth = 800;
        this.setSize(windowWidth,windowHeight);
        setLocationRelativeTo(null);
        requestFocus();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Employee Search");
        setResizable(false);


        addWindowComponents();
        setVisible(true);

    }

    private void addWindowComponents(){

        //Top Panel
        idSearch.addActionListener(this);
        lastNameSearch.addActionListener(this);
        dateRangeSearch.addActionListener(this);
        ageRangeSearch.addActionListener(this);

        topPanelButtons.add(idSearch);
        topPanelButtons.add(lastNameSearch);
        topPanelButtons.add(dateRangeSearch);
        topPanelButtons.add(ageRangeSearch);
        topPanel.add(idSearch);
        topPanel.add(lastNameSearch);
        topPanel.add(dateRangeSearch);
        topPanel.add(ageRangeSearch);

        topPanel.setLayout(new FlowLayout());
        this.add(topPanel, BorderLayout.NORTH);

        searchPanel.setLayout(searchLayout);

        oneSearchPanel.add(new JLabel("Employee ID"));
        oneSearchPanel.add(employeeIdSearchField);

        twoSearchPanel.add(new JLabel("Employee Last Name"));
        twoSearchPanel.add(searchFieldTwo);

        threeSearchPanel.add(new JLabel("Minimum Age"));
        threeSearchPanel.add(searchFieldMinAge);
        threeSearchPanel.add(new JLabel("Maximum Age"));
        threeSearchPanel.add(searchFieldMaxAge);

        fourSearchPanel.add(new JLabel("Date Start"));
        fourSearchPanel.add(searchFieldFive);
        fourSearchPanel.add(new JLabel("Date End"));
        fourSearchPanel.add(searchFieldSix);

        searchPanel.add(oneSearchPanel, "ID");
        searchPanel.add(twoSearchPanel, "Name");
        searchPanel.add(threeSearchPanel,"Age");
        searchPanel.add(fourSearchPanel, "HireDate");

        this.add(searchPanel, BorderLayout.CENTER);

        searchResults.setLineWrap(true);
        searchResults.setWrapStyleWord(true);

        searchScroll.add(searchResults);

        this.add(searchScroll, BorderLayout.AFTER_LAST_LINE);
        this.add(goButton,BorderLayout.AFTER_LINE_ENDS);

        goButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event){
        Object source = event.getSource();

        if(source == idSearch){
            searchLayout.show(searchPanel,"ID");
        }
        else if(source == lastNameSearch){
            searchLayout.show(searchPanel,"Name");
        }
        else if (source == ageRangeSearch) {
            searchLayout.show(searchPanel,"Age");
        }
        else if (source == dateRangeSearch){
            searchLayout.show(searchPanel,"HireDate");
        }
        else if (source==goButton) {

            if(idSearch.isSelected()){
                ArrayList<Employee> ageRangeSearch = new ArrayList<>(employeeDAO.searchByAgeRange(20,30));
                if(!ageRangeSearch.isEmpty()){
                    for(Employee employee : ageRangeSearch){
                        searchResults.append(employee.toString() + "\n");
                    }
                    dialogPopupSuccess();
                }}
            else if (ageRangeSearch.isSelected()) {
                ArrayList<Employee> ageRangeSearch = new ArrayList<>(employeeDAO.searchByAgeRange(Integer.parseInt(searchFieldMinAge.getText()),Integer.parseInt(searchFieldMaxAge.getText())));
                if(!ageRangeSearch.isEmpty()){
                    searchResults.setText("");
                    for(Employee employee : ageRangeSearch){
                        searchResults.append(employee.toString() + "\n");
                    }
                    dialogPopupSuccess();
                }
            }

            //todo check for valid inputs, and display search results, convert dates to valid dates for search

//            ArrayList<Employee> ageRangeSearch = new ArrayList<>(employeeDAO.searchByAgeRange(20,30));
//            if(!ageRangeSearch.isEmpty()){
//                for(Employee employee : ageRangeSearch){
//                    searchResults.append(employee.toString() + "\n");
//                }
//                dialogPopupSuccess();
//            }

        }
    }
    private void dialogPopupSuccess(){
        JDialog successPopup = new JDialog(this,"Dialog Box");
        successPopup.setSize(350,100);
        JLabel label = new JLabel();
        if(DataSanitisation.getNumberOfCorruptedEntries()== 0 || DataSanitisation.getNumberOfCorruptedEntries()>1){
            label.setText("Query ran successfully with " +  DataSanitisation.getNumberOfCorruptedEntries() + " corrupted entries found.");
        }
        else{
            label.setText("Query ran successfully with " +  DataSanitisation.getNumberOfCorruptedEntries() + " corrupted entry found.");
        }
        successPopup.add(label);
        successPopup.setLocationRelativeTo(null);
        successPopup.requestFocus();
        successPopup.setVisible(true);
    }

}
