package com.sparta.g1;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

public class AppWindow extends JFrame implements ActionListener {
    private int windowHeight;
    private int windowWidth;
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

        searchPanel.add(oneSearchPanel, "ID");
        searchPanel.add(twoSearchPanel, "Name");
        searchPanel.add(threeSearchPanel,"Age");
        searchPanel.add(fourSearchPanel, "HireDate");


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

                if(employeeIdSearchField.getText().length()==6){
                    Employee employee = employeeDAO.searchById(employeeIdSearchField.getText());
                    if(employee == null){
                        searchResults.setText("No employee found matching: " + employeeIdSearchField.getText());
                    }
                    else{
                        searchResults.setText("ID: "+ employee.empId() + ", First Name: " + employee.firstName() +", Last Name: " + employee.lastName() +  ", Email: " + employee.email() + "\n");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this,"Please enter a valid ID that is 6 characters long.");
                }
            }

            else if(lastNameSearch.isSelected()){
                if(employeeNameSearchField.getText().isEmpty() || employeeNameSearchField.getText().length()>20){
                    JOptionPane.showMessageDialog(this,"Please enter a valid name.");
                }
                else{
                    ArrayList<Employee> nameSearch = new ArrayList<>(employeeDAO.searchByLastName(employeeNameSearchField.getText()));
                    if(!nameSearch.isEmpty()){
                        searchResults.setText("Number of records returned that partially match: '" + employeeNameSearchField.getText() +"' is: " + nameSearch.size()+ "\n");
                        for(Employee employee : nameSearch){
                            searchResults.append("ID: "+ employee.empId() + ", First Name: " + employee.firstName() +", Last Name: " + employee.lastName() +  ", Email: " + employee.email() + "\n");
                        }
                        dialogPopupSuccess();
                    }
                    else {
                        searchResults.setText("No records found.");
                    }
                }
            }

            else if(dateRangeSearch.isSelected()){
                LocalDate startDate = LocalDate.parse(searchFieldStartDate.getText(), DataSanitisation.formatDates());
                LocalDate endDate = LocalDate.parse((searchFieldEndDate).getText(), DataSanitisation.formatDates());

                if(startDate.isAfter(endDate)){
                    searchResults.setText("Please pick a start date before the end date.");
                }
                else{
                    ArrayList<Employee> dateRangeSearch = new ArrayList<>(employeeDAO.searchByHireDateRange(startDate,endDate));
                    if(!dateRangeSearch.isEmpty()){
                        searchResults.setText("Number of records returned between age range of " +searchFieldMinAge.getText()+ " and " +searchFieldMaxAge.getText() + ": " + dateRangeSearch.size()+ "\n");
                        for(Employee employee : dateRangeSearch){
                            searchResults.append("ID: "+ employee.empId() + ", First Name: " + employee.firstName() +", Last Name: " + employee.lastName() +  ", Email: " + employee.email() + ", Join Date: " + employee.dateOfJoining() + "\n");
                        }
                        dialogPopupSuccess();
                    }
                    else {
                        searchResults.setText("No records found.");
                    }
                }
            }
            else if (ageRangeSearch.isSelected()) {

                if((searchFieldMinAge.getText().isEmpty() || searchFieldMaxAge.getText().isEmpty())
                        || (getMinAgeFieldTextNumber()>getMaxAgeFieldTextNumber())
                        || (getMinAgeFieldTextNumber()<0 || getMinAgeFieldTextNumber()> 120)
                        || (getMaxAgeFieldTextNumber()<0 || getMaxAgeFieldTextNumber()> 120)
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
                        dialogPopupSuccess();
                    }
                    else {
                        searchResults.setText("No records found.");
                    }
                }
            }
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
    private int getMinAgeFieldTextNumber(){
        return Integer.parseInt(searchFieldMinAge.getText());
    }
    private int getMaxAgeFieldTextNumber(){
        return Integer.parseInt(searchFieldMaxAge.getText());
    }
}
