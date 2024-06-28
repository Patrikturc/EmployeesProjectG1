package com.sparta.g1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

public class AppWindow extends JFrame implements ActionListener {
    private final String panelID = "ID";
    private final String panelName = "Name";
    private final String panelAge = "Age";
    private final String panelDate = "Date";
    JButton goButton = new JButton("Go");
    JRadioButton idSearch = new JRadioButton("Search by ID");
    JRadioButton lastNameSearch = new JRadioButton("Search by Last Name");
    JRadioButton dateRangeSearch = new JRadioButton("Search by Hire Date");
    JRadioButton ageRangeSearch = new JRadioButton("Search by Age");
    JTextField employeeIdSearchField = new JTextField(10);
    JTextField employeeNameSearchField = new JTextField(10);
    JTextField searchFieldMinAge = new JTextField(10);
    JTextField searchFieldMaxAge = new JTextField(10);
    JTextField searchFieldStartDate = new JTextField(10);
    JTextField searchFieldEndDate = new JTextField(10);
    JTextArea searchResults = new JTextArea();
    ScrollPane searchScroll = new ScrollPane();
    JPanel topPanel = new JPanel();
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
        int windowHeight = 800;
        int windowWidth = 800;
        this.setSize(windowWidth, windowHeight);
        setLocationRelativeTo(null);
        requestFocus();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Employee Search");
        setResizable(false);

        addWindowComponents();
        setVisible(true);

    }
    private void addWindowComponents(){

        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
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
        this.add(topPanel);

        searchPanel.setLayout(searchLayout);

        oneSearchPanel.add(new JLabel("Employee ID"));
        oneSearchPanel.add(employeeIdSearchField);

        twoSearchPanel.add(new JLabel("Employee Last Name"));
        twoSearchPanel.add(employeeNameSearchField);

        threeSearchPanel.add(new JLabel("Minimum Age"));
        threeSearchPanel.add(searchFieldMinAge);
        threeSearchPanel.add(new JLabel("Maximum Age"));
        threeSearchPanel.add(searchFieldMaxAge);

        fourSearchPanel.add(new JLabel("Date Start"));
        fourSearchPanel.add(searchFieldStartDate);
        fourSearchPanel.add(new JLabel("Date End"));
        fourSearchPanel.add(searchFieldEndDate);

        searchFieldStartDate.setText("MM/DD/YYYY");
        searchFieldEndDate.setText("MM/DD/YYYY");

        searchPanel.add(oneSearchPanel, panelID);
        searchPanel.add(twoSearchPanel, panelName);
        searchPanel.add(threeSearchPanel,panelAge);
        searchPanel.add(fourSearchPanel, panelDate);

        idSearch.setSelected(true);

        this.add(searchPanel);

        searchResults.setLineWrap(true);
        searchResults.setWrapStyleWord(true);

        searchScroll.add(searchResults);
        searchScroll.setSize(400,600);

        this.add(searchScroll);
        this.add(goButton);

        goButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent event){
        Object source = event.getSource();

        if(source == idSearch){
            searchLayout.show(searchPanel,panelID);
        }
        else if(source == lastNameSearch){
            searchLayout.show(searchPanel,panelName);
        }
        else if (source == ageRangeSearch) {
            searchLayout.show(searchPanel,panelAge);
        }
        else if (source == dateRangeSearch){
            searchLayout.show(searchPanel,panelDate);
        }

        else if (source==goButton) {

            if(idSearch.isSelected()){

                if(FieldChecks.hasValidID(employeeIdSearchField.getText())){
                    Employee employee = employeeDAO.searchById(employeeIdSearchField.getText());
                    if(employee == null){
                        searchResults.setText("No employee found matching: " + employeeIdSearchField.getText());
                    }
                    else{
                        searchResults.setText("ID: "+ employee.empId() + ", First Name: " + employee.firstName() +", Last Name: " + employee.lastName() +  ", Email: " + employee.email() + "\n");
                        JOptionPane.showMessageDialog(this,popupMessage());
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this,"Please enter a valid ID that is 6 characters long.");
                }
            }

            else if(lastNameSearch.isSelected()){
                String partialNameSearch = employeeNameSearchField.getText().strip();
                if(!FieldChecks.hasValidPartialName(partialNameSearch)){
                    JOptionPane.showMessageDialog(this,"Please enter a valid name.");
                }
                else{
                    ArrayList<Employee> nameSearch = new ArrayList<>(employeeDAO.searchByLastName(partialNameSearch));
                    if(!nameSearch.isEmpty()){
                        searchResults.setText("Number of records returned that partially match: '" + partialNameSearch +"' is: " + nameSearch.size()+ "\n");
                        for(Employee employee : nameSearch){
                            searchResults.append("ID: "+ employee.empId() + ", First Name: " + employee.firstName() +", Last Name: " + employee.lastName() +  ", Email: " + employee.email() + "\n");
                        }
                        JOptionPane.showMessageDialog(this,popupMessage());
                    }
                    else {
                        searchResults.setText("No records found for " + "'" + partialNameSearch + "'");
                    }
                }
            }

            else if(dateRangeSearch.isSelected()){
                String date1 = searchFieldStartDate.getText();
                String date2 = searchFieldEndDate.getText();

                if(FieldChecks.hasValidDates(date1,date2)) {

                    LocalDate startDate = LocalDate.parse(date1, DataSanitisation.formatDates());
                    LocalDate endDate = LocalDate.parse(date2, DataSanitisation.formatDates());

                    if (startDate.isAfter(endDate)) {
                        JOptionPane.showMessageDialog(this,"Please enter a valid date range!");
                    } else {
                        ArrayList<Employee> dateRangeSearch = new ArrayList<>(employeeDAO.searchByHireDateRange(startDate, endDate));
                        if (!dateRangeSearch.isEmpty()) {
                            searchResults.setText("Number of records returned between hire date range of " + date1 + " and " + date2 + ": " + dateRangeSearch.size() + "\n");
                            for (Employee employee : dateRangeSearch) {
                                searchResults.append("ID: " + employee.empId() + ", First Name: " + employee.firstName() + ", Last Name: " + employee.lastName() + ", Email: " + employee.email() + ", Join Date: " + employee.dateOfJoining() + "\n");
                            }
                            JOptionPane.showMessageDialog(this,popupMessage());
                        } else {
                            searchResults.setText("No records found.");
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this,"Please enter a valid date range!");
                }
            }
            else if (ageRangeSearch.isSelected()) {

                if(!FieldChecks.hasValidAgeRange(searchFieldMinAge.getText(),searchFieldMaxAge.getText())
                ){
                    JOptionPane.showMessageDialog(this,"Please enter valid ages.");
                }
                else {
                    ArrayList<Employee> ageRangeSearch = new ArrayList<>(employeeDAO.searchByAgeRange(Integer.parseInt(searchFieldMinAge.getText()),Integer.parseInt(searchFieldMaxAge.getText())));
                    if(!ageRangeSearch.isEmpty()){
                        searchResults.setText("Number of records returned between age range of " +searchFieldMinAge.getText()+ " and " +searchFieldMaxAge.getText() + ": " + ageRangeSearch.size()+ "\n");
                        for(Employee employee : ageRangeSearch){
                            searchResults.append("ID: "+ employee.empId() + ", First Name: " + employee.firstName() +", Last Name: " + employee.lastName() +  ", Email: " + employee.email() + ", DoB: " + employee.dob() + "\n");
                        }
                        JOptionPane.showMessageDialog(this,popupMessage());
                    }
                    else {
                        searchResults.setText("No records found.");
                    }
                }
            }
        }
    }

    private String popupMessage(){
        if(DataSanitisation.getNumberOfCorruptedEntries()== 0 || DataSanitisation.getNumberOfCorruptedEntries()>1){
            return "Query ran successfully with " +  DataSanitisation.getNumberOfCorruptedEntries() + " corrupted entries found.";
        }
        else{
            return ("Query ran successfully with " +  DataSanitisation.getNumberOfCorruptedEntries() + " corrupted entry found.");
        }
    }
}
