package com.sparta.g1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppWindow extends JFrame implements ActionListener {
    private static final Logger logger = AppLogger.getLogger(Level.ALL, Level.INFO, true);
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
        logger.log(Level.FINER, "App Window created");

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
        logger.log(Level.FINER, "App Window populated");
    }
    public void actionPerformed(ActionEvent event){
        Object source = event.getSource();

        if(source == idSearch){
            logger.log(Level.INFO, "idSearch selected");
            searchLayout.show(searchPanel,panelID);
        }
        else if(source == lastNameSearch){
            logger.log(Level.INFO, "lastNameSearch selected");
            searchLayout.show(searchPanel,panelName);
        }
        else if (source == ageRangeSearch) {
            logger.log(Level.INFO, "ageRangeSearchSelected");
            searchLayout.show(searchPanel,panelAge);
        }
        else if (source == dateRangeSearch){
            logger.log(Level.INFO, "dateRangeSearchSelected");
            searchLayout.show(searchPanel,panelDate);
        }

        else if (source==goButton) {
            logger.log(Level.INFO, "Go button clicked");

            if(idSearch.isSelected()){
                logger.log(Level.FINE, "idSearch is selected when button clicked");

                if(FieldChecks.hasValidID(employeeIdSearchField.getText())){
                    logger.log(Level.FINER, "input ID is valid");
                    Employee employee = employeeDAO.searchById(employeeIdSearchField.getText());
                    if(employee == null){
                        logger.log(Level.FINER, "no Employee found with " + employeeIdSearchField.getText());
                        searchResults.setText("No employee found matching: " + employeeIdSearchField.getText());
                    }
                    else{
                        logger.log(Level.FINER, "Employee Found");
                        searchResults.setText("ID: "+ employee.empId() + ", First Name: " + employee.firstName() +", Last Name: " + employee.lastName() +  ", Email: " + employee.email() + "\n");
                        JOptionPane.showMessageDialog(this,popupMessage());
                    }
                }
                else{
                    logger.log(Level.FINER, "Invalid ID provided search not run");
                    JOptionPane.showMessageDialog(this,"Please enter a valid ID that is 6 characters long.");
                }
            }

            else if(lastNameSearch.isSelected()){
                logger.log(Level.FINE, "lastNameSearch is selected when button clicked");
                String partialNameSearch = employeeNameSearchField.getText().strip();
                if(!FieldChecks.hasValidPartialName(partialNameSearch)){
                    logger.log(Level.FINER, "Invalid name provided search not run");
                    JOptionPane.showMessageDialog(this,"Please enter a valid name.");
                }
                else{
                    logger.log(Level.FINER, "valid name provided running search");
                    ArrayList<Employee> nameSearch = new ArrayList<>(employeeDAO.searchByLastName(partialNameSearch));
                    if(!nameSearch.isEmpty()){
                        logger.log(Level.FINER, "search run and found records");
                        searchResults.setText("Number of records returned that partially match: '" + partialNameSearch +"' is: " + nameSearch.size()+ "\n");
                        for(Employee employee : nameSearch){
                            logger.log(Level.FINEST, "added new employee record to results");
                            searchResults.append("ID: "+ employee.empId() + ", First Name: " + employee.firstName() +", Last Name: " + employee.lastName() +  ", Email: " + employee.email() + "\n");
                        }
                        JOptionPane.showMessageDialog(this,popupMessage());
                    }
                    else {
                        logger.log(Level.FINER, "search run and found no records");
                        searchResults.setText("No records found for " + "'" + partialNameSearch + "'");
                    }
                }
            }

            else if(dateRangeSearch.isSelected()){
                logger.log(Level.FINE, "dateRangeSearch is selected when button clicked");
                String date1 = searchFieldStartDate.getText();
                String date2 = searchFieldEndDate.getText();

                if(FieldChecks.hasValidDates(date1,date2)) {
                    logger.log(Level.FINER, "valid dates provided");

                    LocalDate startDate = LocalDate.parse(date1, DataSanitisation.formatDates());
                    LocalDate endDate = LocalDate.parse(date2, DataSanitisation.formatDates());

                    if (startDate.isAfter(endDate)) {
                        logger.log(Level.FINER, "Start date is after last date search not run");
                        JOptionPane.showMessageDialog(this,"Please enter a valid date range!");
                    } else {
                        ArrayList<Employee> dateRangeSearch = new ArrayList<>(employeeDAO.searchByHireDateRange(startDate, endDate));
                        if (!dateRangeSearch.isEmpty()) {
                            logger.log(Level.FINER, "records found populating results");
                            searchResults.setText("Number of records returned between hire date range of " + date1 + " and " + date2 + ": " + dateRangeSearch.size() + "\n");
                            for (Employee employee : dateRangeSearch) {
                                logger.log(Level.FINEST, "added new employee record to results");
                                searchResults.append("ID: " + employee.empId() + ", First Name: " + employee.firstName() + ", Last Name: " + employee.lastName() + ", Email: " + employee.email() + ", Join Date: " + employee.dateOfJoining() + "\n");
                            }
                            JOptionPane.showMessageDialog(this,popupMessage());
                        } else {
                            logger.log(Level.FINER, "no records found");
                            searchResults.setText("No records found.");
                        }
                    }
                }
                else{
                    logger.log(Level.FINER, "Invalid dates entered");
                    JOptionPane.showMessageDialog(this,"Please enter a valid date range!");
                }
            }
            else if (ageRangeSearch.isSelected()) {
                logger.log(Level.FINE, "ageRangeSearch is selected when button clicked");

                if(!FieldChecks.hasValidAgeRange(searchFieldMinAge.getText(),searchFieldMaxAge.getText())
                ){
                    logger.log(Level.FINER, "Invalid ages provided in input fields");
                    JOptionPane.showMessageDialog(this,"Please enter valid ages.");
                }
                else {
                    ArrayList<Employee> ageRangeSearch = new ArrayList<>(employeeDAO.searchByAgeRange(Integer.parseInt(searchFieldMinAge.getText()),Integer.parseInt(searchFieldMaxAge.getText())));
                    if(!ageRangeSearch.isEmpty()){
                        logger.log(Level.FINER, "records found populating results");
                        searchResults.setText("Number of records returned between age range of " +searchFieldMinAge.getText()+ " and " +searchFieldMaxAge.getText() + ": " + ageRangeSearch.size()+ "\n");
                        for(Employee employee : ageRangeSearch){
                            logger.log(Level.FINEST, "added new employee record to results");
                            searchResults.append("ID: "+ employee.empId() + ", First Name: " + employee.firstName() +", Last Name: " + employee.lastName() +  ", Email: " + employee.email() + ", DoB: " + employee.dob() + "\n");
                        }
                        JOptionPane.showMessageDialog(this,popupMessage());
                    }
                    else {
                        logger.log(Level.FINER, "no records found");
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
