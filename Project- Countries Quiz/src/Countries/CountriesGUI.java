package Countries;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * CountriesGUI.java
 * A class representing the GUI used in a maintaining a countries database.
 * <pre>
 *   Project     <b>CountriesGUI Database</b>
 *   Description This program provides database management for the countries. 
 *               It has the capability to display, add, edit, delete and search 
 *               countries.
 *   Platform    Java(TM) SE Runtime Environment 1.8.0_151
 *   System      Windows 10 version 
 *   Course      <i>CS 142 Winter 2018</i>
 * </pre>
 *
 * @author:	Sanyapoom Sirijirakarn and Quynh Duc Vu
 * @version: 	1.00
 * @see     	javax.swing.JFrame
 * @see         java.awt.Toolkit
 * @see         java.util.ArrayList
 * @see         java.text.DecimalFormat
 * @see         java.awt.print.PrinterException
 * @see         java.io.File
 * @see         java.io.FileNotFoundException
 * @see         java.util.ArrayList
 * @see         javax.swing.ImageIcon;
 * @see         java.util.Scanner
 * @see         java.util.StringTokenizer
 * @see         javax.swing.JFileChooser
 * @see         javax.swing.JOptionPane
 * @see         javax.swing.filechooser.FileNameExtensionFilter
 */
public class CountriesGUI extends javax.swing.JFrame
{
    private ArrayList<Country> countries = new ArrayList<Country>();
    private ArrayList<User> users = new ArrayList<User>();
    private final String filename = "src/Countries/Countries.txt";
    private final String userFilename = "src/Countries/Users.txt";
    /**
     * Creates new form CountriesGUI
     */
    public CountriesGUI()
    {
        initComponents();
        this.getRootPane().setDefaultButton(addJButton); //set buttonAdd as default
        //set icon
        this.setIconImage(Toolkit.getDefaultToolkit().
                getImage("src/Countries/pic.jpg"));
        //centers the form at start
        setLocationRelativeTo(null);
        
        /* Read form an external file Countries.txt and create an ArrayList
          of Country type, countries */
        readFromFile(filename);
        readFromPlayerFile(userFilename);

        // Show the countries names in the JList and display data for selected city
        displayCountries();
        int index = countriesJList.getSelectedIndex();
        if(index >= 0)
            showCountryData(index);
        
        
        //read player in 
            for(int i = 0; i < users.size(); i++) 
            {
                int min = i;
                for (int j = i + 1; j < users.size(); j++) 
                {
                    if (users.get(j).getThirdScore() > users.get(min).getThirdScore()) 
                    {
                        min = j;
                    }
                }
                    User temp = users.get(i);
                    users.set(i, users.get(min));
                    users.set(min, temp);
            }
            
            firstNameLabel.setText(users.get(0).getName());
            firstScoreLabel.setText(String.valueOf(users.get(0).getThirdScore()));  
            secondNameLabel.setText(users.get(1).getName());
            secondScoreLabel.setText(String.valueOf(users.get(1).getThirdScore()));
            thirdNameLabel.setText(users.get(2).getName());   
            thirdScoreLabel.setText(String.valueOf(users.get(2).getThirdScore()));  
               
        
    }
     /*
     * Method: showCountryData(int index)
     * Description: Show selected countries in all the textfield of GUI
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/10/2018
     * @parem void
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    private void showCountryData(int index)
    {
        if(index >= 0)
        {
        nameJTextField.setText(countries.get(index).getName());
        countryPopJTextField.setText(String.valueOf(countries.get(index).getCountryPop()));
        capitalJTextField.setText(String.valueOf(countries.get(index).getCapital()));
        capitalPopJTextField.setText(String.valueOf(countries.get(index).getCapitalPop()));
        sizeJTextField.setText(String.valueOf(countries.get(index).getSize()));
        locationJTextField.setText(countries.get(index).getLocation());
        languageJTextField.setText(countries.get(index).getLanguage());
        riverJTextField.setText(countries.get(index).getRiver());
        flagJLabel.setIcon(countries.get(index).getFlag());
        }
    }
    /*
     * Method: readFromPlayerFile(String file)
     * Description: read player file
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/10/2018
     * @parem void
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    private void readFromPlayerFile(String file) {
        users.clear();
        try {
            Scanner input = new Scanner(new File(file));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                User newUser = new User();
                StringTokenizer stringTokenizer = new StringTokenizer(line, ",");
                while (stringTokenizer.hasMoreElements()) {
                    newUser.setName(stringTokenizer.nextToken());
                    newUser.setFirstScore(Integer.parseInt(stringTokenizer.nextToken()));
                    newUser.setSecondScore(Integer.parseInt(stringTokenizer.nextToken()));
                    newUser.setThirdScore(Integer.parseInt(stringTokenizer.nextToken()));

                }
                users.add(newUser);
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, file + " does not exist",
                    "File Input Error", JOptionPane.WARNING_MESSAGE);
            JFileChooser chooser = new JFileChooser("src/Countries");
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "txt Files", "txt");
            chooser.setFileFilter(filter);
            int choice = chooser.showOpenDialog(null);
            if (choice == JFileChooser.APPROVE_OPTION) {
                File chosenFile = chooser.getSelectedFile();
                file = "src/Countries/" + chosenFile.getName();
                readFromFile(file);
            }
        }
    }
    
    /*
     * Method: readFromFile(String file)
     * Description: Reads countries from a text file that is , delimited and
     *              creates an instance of the Country class with the data read.
     *              Then the newly created city is added to the countries database.
     *              Uses an object from the ReadFile class to read record.
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/15/2018
     * @parem void
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    void readFromFile(String file)
    {
        countries.clear();
        
        try
        {
            Scanner input = new Scanner(new File(file));
            String FlagName = "";
            
            while(input.hasNextLine())
            {
                String line = input.nextLine();
                Country country = new Country();  //create a country
                StringTokenizer stringTokenizer = new StringTokenizer(line,",");
                // Populate the Country country object using , to differentiaite each of them
                //pars through each field to create a country
                while(stringTokenizer.hasMoreElements())
                {
                    country.setName(stringTokenizer.nextToken());
                    country.setCountryPop(Float.parseFloat(stringTokenizer.nextToken()));
                    country.setCapital(stringTokenizer.nextToken());
                    country.setCapitalPop(Float.parseFloat(stringTokenizer.nextToken()));
                    country.setSize(Integer.parseInt(stringTokenizer.nextToken()));
                    country.setLocation(stringTokenizer.nextToken());
                    country.setLanguage(stringTokenizer.nextToken());
                    country.setRiver(stringTokenizer.nextToken());
                    FlagName = stringTokenizer.nextToken();
                    country.setFlag(new ImageIcon("src/Images/" + FlagName)
                            ,flagJLabel.getWidth(),flagJLabel.getHeight());
                    country.setFlagName(FlagName);
                }
                //add countries to arraylist
                countries.add(country);
            }
            //close file
            input.close();
        }
        catch(FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, "File does not exist",
                    "File Input Error", JOptionPane.WARNING_MESSAGE);
            //Choose a new file
            JFileChooser chooser = new JFileChooser("src/Countries");
            
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Txt Files", "txt");
            chooser.setFileFilter(filter);
            int choice = chooser.showOpenDialog(null);
            if(choice == JFileChooser.APPROVE_OPTION)
            {
                File chosenFile = chooser.getSelectedFile();
                file = "src/Countries/" + chosenFile.getName();
                System.out.println("file = " + file);
                readFromFile(file);
            }
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null, "Unable to read file",
                    "File Input Error", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
    }
    
    /*
     * Method: displayCountries
     * Description: Displays country in JList sorted by level = 0 using selection
     *              sort algorithm or last name = 1 using the insertion sort algorithm.
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/5/2018
     * @parem void
     * @return void
     * @see #selectionSort
     * @see #insetionSort
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    private void displayCountries()
    {
        Sorting mySorting = new Sorting();
        int location = countriesJList.getSelectedIndex();      //get index of current country
        String[] countryNames = new String[countries.size()];    //array with name only
        if(populationJRadioButtonMenuItem.isSelected())
        {
            
            //sort by country population using quick sort in descending order
            mySorting.quickSort(countries);  //passing to it the ArrayList
            for(int index = 0; index < countries.size(); index++)
            {
                countryNames[index] = countries.get(index).getName() + ", " + 
                        countries.get(index).getCountryPop();
            }
        }
        else if(nameJRadioButtonMenuItem.isSelected())
        {
            //sort the countries by name using merge sort and display name only
            mySorting.mergeSort(countries);
            for(int index = 0; index < countries.size(); index++)
            {
                countryNames[index] = countries.get(index).getName();
            }
        }
        else
        {
            //sort by country size using quick sort in descending order
            mySorting.quickSort(countries);  //passing to it the ArrayList
            for(int index = 0; index < countries.size(); index++)
            {
                countryNames[index] = countries.get(index).getName() + ", " + 
                        countries.get(index).getSize();
            }
        }
        
        countriesJList.setListData(countryNames); // populate JList with countries
        if(location < 0)
            countriesJList.setSelectedIndex(0);
        else
            countriesJList.setSelectedIndex(location);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        countrybuttonGroup = new javax.swing.ButtonGroup();
        countriesJScrollPane = new javax.swing.JScrollPane();
        countriesJList = new javax.swing.JList<>();
        flagJLabel = new javax.swing.JLabel();
        titleJLabel = new javax.swing.JLabel();
        picJLabel = new javax.swing.JLabel();
        infoJPanel = new javax.swing.JPanel();
        nameJLabel = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        countryPopJLabel = new javax.swing.JLabel();
        countryPopJTextField = new javax.swing.JTextField();
        capitalJLabel = new javax.swing.JLabel();
        capitalJTextField = new javax.swing.JTextField();
        capitalPopJLabel = new javax.swing.JLabel();
        capitalPopJTextField = new javax.swing.JTextField();
        sizeJLabel = new javax.swing.JLabel();
        sizeJTextField = new javax.swing.JTextField();
        locationLabel = new javax.swing.JLabel();
        locationJTextField = new javax.swing.JTextField();
        languageJLabel = new javax.swing.JLabel();
        languageJTextField = new javax.swing.JTextField();
        riverJLabel = new javax.swing.JLabel();
        riverJTextField = new javax.swing.JTextField();
        controlJPanel = new javax.swing.JPanel();
        quizJButton = new javax.swing.JButton();
        addJButton = new javax.swing.JButton();
        editJButton = new javax.swing.JButton();
        deleteJButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        firstJLabel = new javax.swing.JLabel();
        fNameLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        fScoreLabel = new javax.swing.JLabel();
        firstScoreLabel = new javax.swing.JLabel();
        secondJLabel = new javax.swing.JLabel();
        sNameLabel = new javax.swing.JLabel();
        secondNameLabel = new javax.swing.JLabel();
        sScoreLabel = new javax.swing.JLabel();
        secondScoreLabel = new javax.swing.JLabel();
        thirdJLabel = new javax.swing.JLabel();
        tNameLabel = new javax.swing.JLabel();
        thirdNameLabel = new javax.swing.JLabel();
        tScoreLabel = new javax.swing.JLabel();
        thirdScoreLabel = new javax.swing.JLabel();
        mainJMenuBar = new javax.swing.JMenuBar();
        fileJMenu = new javax.swing.JMenu();
        clearJMenuItem = new javax.swing.JMenuItem();
        printGUIJMenuItem = new javax.swing.JMenuItem();
        printFormJMenuItem = new javax.swing.JMenuItem();
        exitJMenuItem = new javax.swing.JMenuItem();
        sortJMenu = new javax.swing.JMenu();
        nameJRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        populationJRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        sizeRadioJButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        dataJMenu = new javax.swing.JMenu();
        addJMenuItem = new javax.swing.JMenuItem();
        editJMenuItem = new javax.swing.JMenuItem();
        deleteJMenuItem = new javax.swing.JMenuItem();
        searchJMenuItem = new javax.swing.JMenuItem();
        helpJMenu = new javax.swing.JMenu();
        aboutJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        countriesJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                countriesJListValueChanged(evt);
            }
        });
        countriesJScrollPane.setViewportView(countriesJList);

        flagJLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        titleJLabel.setFont(new java.awt.Font("Elephant", 3, 36)); // NOI18N
        titleJLabel.setForeground(new java.awt.Color(0, 102, 204));
        titleJLabel.setText("Countries Quiz");

        picJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Countries/pic.jpg"))); // NOI18N

        infoJPanel.setLayout(new java.awt.GridLayout(8, 0, 0, 2));

        nameJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nameJLabel.setText("Country Name: ");
        infoJPanel.add(nameJLabel);

        nameJTextField.setEditable(false);
        nameJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoJPanel.add(nameJTextField);

        countryPopJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        countryPopJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        countryPopJLabel.setText("Country Population(in millions): ");
        infoJPanel.add(countryPopJLabel);

        countryPopJTextField.setEditable(false);
        countryPopJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoJPanel.add(countryPopJTextField);

        capitalJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        capitalJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        capitalJLabel.setText("Capital City: ");
        infoJPanel.add(capitalJLabel);

        capitalJTextField.setEditable(false);
        capitalJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoJPanel.add(capitalJTextField);

        capitalPopJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        capitalPopJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        capitalPopJLabel.setText("Capital Population(in millions): ");
        infoJPanel.add(capitalPopJLabel);

        capitalPopJTextField.setEditable(false);
        capitalPopJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoJPanel.add(capitalPopJTextField);

        sizeJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sizeJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        sizeJLabel.setText("Size(in square miles): ");
        infoJPanel.add(sizeJLabel);

        sizeJTextField.setEditable(false);
        sizeJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoJPanel.add(sizeJTextField);

        locationLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        locationLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        locationLabel.setText("Location(Continent): ");
        infoJPanel.add(locationLabel);

        locationJTextField.setEditable(false);
        locationJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoJPanel.add(locationJTextField);

        languageJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        languageJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        languageJLabel.setText("Main Language: ");
        infoJPanel.add(languageJLabel);

        languageJTextField.setEditable(false);
        languageJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoJPanel.add(languageJTextField);

        riverJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        riverJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        riverJLabel.setText("Largest River: ");
        infoJPanel.add(riverJLabel);

        riverJTextField.setEditable(false);
        riverJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoJPanel.add(riverJTextField);

        controlJPanel.setLayout(new java.awt.GridLayout(1, 1));

        quizJButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        quizJButton.setMnemonic('T');
        quizJButton.setText("Take Quiz!");
        quizJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quizJButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(quizJButton);

        addJButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        addJButton.setMnemonic('A');
        addJButton.setText("Add");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(addJButton);

        editJButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        editJButton.setMnemonic('E');
        editJButton.setText("Edit");
        editJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editJButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(editJButton);

        deleteJButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        deleteJButton.setMnemonic('D');
        deleteJButton.setText("Delete");
        deleteJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(deleteJButton);

        exitButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        exitButton.setMnemonic('X');
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(exitButton);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Top 3 players"));

        firstJLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        firstJLabel.setText("1st");

        fNameLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        fNameLabel.setText("Name:");

        firstNameLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        firstNameLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        fScoreLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        fScoreLabel.setText("Score:");

        firstScoreLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        firstScoreLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        secondJLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        secondJLabel.setText("2nd");

        sNameLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        sNameLabel.setText("Name:");

        secondNameLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        secondNameLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        sScoreLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        sScoreLabel.setText("Score:");

        secondScoreLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        secondScoreLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        thirdJLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        thirdJLabel.setText("3rd");

        tNameLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tNameLabel.setText("Name:");

        thirdNameLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        thirdNameLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tScoreLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tScoreLabel.setText("Score:");

        thirdScoreLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        thirdScoreLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fNameLabel)
                        .addGap(14, 14, 14)
                        .addComponent(firstNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(sNameLabel)
                        .addGap(14, 14, 14)
                        .addComponent(secondNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tNameLabel)
                        .addGap(14, 14, 14)
                        .addComponent(thirdNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(sScoreLabel)
                        .addGap(12, 12, 12)
                        .addComponent(secondScoreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tScoreLabel)
                        .addGap(12, 12, 12)
                        .addComponent(thirdScoreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstJLabel)
                            .addComponent(thirdJLabel)
                            .addComponent(secondJLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fScoreLabel)
                        .addGap(12, 12, 12)
                        .addComponent(firstScoreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(firstJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fNameLabel)
                    .addComponent(firstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fScoreLabel)
                    .addComponent(firstScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(secondJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sNameLabel)
                    .addComponent(secondNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sScoreLabel)
                    .addComponent(secondScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(thirdJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tNameLabel)
                    .addComponent(thirdNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tScoreLabel)
                    .addComponent(thirdScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );

        fileJMenu.setMnemonic('f');
        fileJMenu.setText("File");

        clearJMenuItem.setMnemonic('C');
        clearJMenuItem.setText("Clear");
        fileJMenu.add(clearJMenuItem);

        printGUIJMenuItem.setMnemonic('P');
        printGUIJMenuItem.setText("Print GUI");
        fileJMenu.add(printGUIJMenuItem);

        printFormJMenuItem.setMnemonic('F');
        printFormJMenuItem.setText("Print Form");
        fileJMenu.add(printFormJMenuItem);

        exitJMenuItem.setMnemonic('E');
        exitJMenuItem.setText("Exit");
        fileJMenu.add(exitJMenuItem);

        mainJMenuBar.add(fileJMenu);

        sortJMenu.setMnemonic('S');
        sortJMenu.setText("Sort");

        countrybuttonGroup.add(nameJRadioButtonMenuItem);
        nameJRadioButtonMenuItem.setMnemonic('n');
        nameJRadioButtonMenuItem.setSelected(true);
        nameJRadioButtonMenuItem.setText("By name");
        nameJRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameJRadioButtonMenuItemActionPerformed(evt);
            }
        });
        sortJMenu.add(nameJRadioButtonMenuItem);

        countrybuttonGroup.add(populationJRadioButtonMenuItem);
        populationJRadioButtonMenuItem.setMnemonic('p');
        populationJRadioButtonMenuItem.setText("By country population");
        populationJRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                populationJRadioButtonMenuItemActionPerformed(evt);
            }
        });
        sortJMenu.add(populationJRadioButtonMenuItem);

        countrybuttonGroup.add(sizeRadioJButtonMenuItem);
        sizeRadioJButtonMenuItem.setMnemonic('s');
        sizeRadioJButtonMenuItem.setText("By size");
        sizeRadioJButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeRadioJButtonMenuItemActionPerformed(evt);
            }
        });
        sortJMenu.add(sizeRadioJButtonMenuItem);

        mainJMenuBar.add(sortJMenu);

        dataJMenu.setMnemonic('d');
        dataJMenu.setText("Data Management");

        addJMenuItem.setMnemonic('A');
        addJMenuItem.setText("Add");
        dataJMenu.add(addJMenuItem);

        editJMenuItem.setMnemonic('E');
        editJMenuItem.setText("Edit");
        dataJMenu.add(editJMenuItem);

        deleteJMenuItem.setMnemonic('D');
        deleteJMenuItem.setText("Delete");
        dataJMenu.add(deleteJMenuItem);

        searchJMenuItem.setMnemonic('S');
        searchJMenuItem.setText("Search");
        dataJMenu.add(searchJMenuItem);

        mainJMenuBar.add(dataJMenu);

        helpJMenu.setMnemonic('H');
        helpJMenu.setText("Help");

        aboutJMenuItem.setMnemonic('a');
        aboutJMenuItem.setText("About");
        helpJMenu.add(aboutJMenuItem);

        mainJMenuBar.add(helpJMenu);

        setJMenuBar(mainJMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(controlJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(countriesJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(flagJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(picJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addComponent(titleJLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(infoJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(picJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(countriesJScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                    .addComponent(flagJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(controlJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     /**
     * Method: countriesJListValueChanged(java.awt.event.ActionEvent evt)         
     * Description: This is a class to dynamically show info of the selected countries
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/1/2018
     * @parem void
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */
    private void countriesJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_countriesJListValueChanged
        int index = countriesJList.getSelectedIndex();
            if(index >= 0)
            showCountryData(index);
    }//GEN-LAST:event_countriesJListValueChanged
    /**
     * Method: nameJRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt)         
     * Description: When nameJRadioButton is selected, sort the JList by name
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/1/2018
     * @parem void
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    private void nameJRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameJRadioButtonMenuItemActionPerformed
        // display cities sorted by name
        displayCountries();
    }//GEN-LAST:event_nameJRadioButtonMenuItemActionPerformed
    /**
     * Method: populationJRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt)         
     * Description: When populationJRadioButton is selected, sort the JList by population
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/1/2018
     * @parem void
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    private void populationJRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_populationJRadioButtonMenuItemActionPerformed
        // display cities sorted by name
        displayCountries();
    }//GEN-LAST:event_populationJRadioButtonMenuItemActionPerformed
    /**
     * Method: sizeRadioJButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt)         
     * Description: When sizeJRadioButton is selected, sort the JList by size
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/1/2018
     * @parem void
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    private void sizeRadioJButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeRadioJButtonMenuItemActionPerformed
        // display cities sorted by name
        displayCountries();
    }//GEN-LAST:event_sizeRadioJButtonMenuItemActionPerformed
    /**
     * Method: exitJButtonActionPerformed (java.awt.event.ActionEvent evt)
     * Description: This is a class to exit the program
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/1/2018
     * @parem void
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // End  program
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed
    /**
     * Method: addJButtonActionPerformed (java.awt.event.ActionEvent evt)
     * Description: This is a class to add country
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem void
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */
    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        try
        {
            AddCountry addCity = new AddCountry();
            addCity.setVisible(true);
            //The model diaog takes focus,  upon regaining focus;
            Country newCity = addCity.getCountry();
            if( newCity != null && !countryExists(newCity))
            {
                //add new country
                countries.add(newCity);
                displayCountries();                //refresh country
                
                saveCountries(filename);
                searchCountry(newCity.getName());  //highlight added country
                readFromFile(filename);
                displayCountries();        
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Country not Added",
                    "Country is null or already exists", JOptionPane.WARNING_MESSAGE);
                countriesJList.setVisible(true);
                countriesJList.setSelectedIndex(0);
            }

        }
        catch(NullPointerException nullex)
        {
            JOptionPane.showMessageDialog(null, "Country not added", "Input Error",
                JOptionPane.WARNING_MESSAGE);
            countriesJList.setVisible(true);
            countriesJList.setSelectedIndex(0);
        }
    }//GEN-LAST:event_addJButtonActionPerformed
    /**
     * Method: editJButtonActionPerformed (java.awt.event.ActionEvent evt)
     * Description: This is a class to edit country
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem void
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */
    private void editJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editJButtonActionPerformed
        // Edit selected country
        try
        {
            //get name of selected country
            String countriesName = countriesJList.getSelectedValue().toString();
            //remove year if edit mode is on sorted countries by year
            if(countriesName.contains(","))
            countriesName = countriesName.substring(0, countriesName.indexOf(','));
            
            Country countryToEdit = new Country(findCountry(countriesName));
            int index = countriesJList.getSelectedIndex();
            System.out.println("selected index = " + index);
            
            //pass city info to EditCity constructor and view edit form
            EditCountry editedCountry = new EditCountry(countryToEdit);
            editedCountry.setVisible(true);
            
            if(editedCountry.getCountry() != null) // && !cityExists(newCity) ???
            {
                //remove old countries from ArrayList
                countries.remove(index);
                
                //add edited countries to ArrayList
                countries.add(editedCountry.getCountry());
                
                //save new country to file
                saveCountries(filename);
                readFromFile(filename);
                displayCountries();
            }
        }
        catch(NullPointerException nullex)
        {
            JOptionPane.showMessageDialog(null, "Country not Edited", "Input Error",
                JOptionPane.WARNING_MESSAGE);
            //clearAll();
            countriesJList.setVisible(true);
            countriesJList.setSelectedIndex(0);
        }
    }//GEN-LAST:event_editJButtonActionPerformed

        /**
     * Method: deleteJButtonActionPerformed (java.awt.event.ActionEvent evt)
     * Description: This is a class to delete country from JList
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem void
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */
    private void deleteJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJButtonActionPerformed
        // Delete selected country
        int result = JOptionPane.showConfirmDialog(null,
            "Are you sure you wish to delete this country?", "Delete Country",
            JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);

        if(result == JOptionPane.YES_OPTION) //confirm delete selected country
        {
            int index = countriesJList.getSelectedIndex();
            if(index >= 0)
            {
                File deleteFile = new File("src/Images/" + countries.get(index).getFlagName());
                deleteFile.delete();
                countries.remove(index);
                displayCountries();
                saveCountries(filename);
            }
        }
    }//GEN-LAST:event_deleteJButtonActionPerformed

    private void quizJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quizJButtonActionPerformed
        Quiz myQuiz = new Quiz(this, true);
        myQuiz.setVisible(true);
        
        
        
        
        
        readFromPlayerFile(userFilename);
        //read player in 
            for(int i = 0; i < users.size(); i++) 
            {
                int min = i;
                for (int j = i + 1; j < users.size(); j++) 
                {
                    if (users.get(j).getThirdScore() > users.get(min).getThirdScore()) 
                    {
                        min = j;
                    }
                }
                    User temp = users.get(i);
                    users.set(i, users.get(min));
                    users.set(min, temp);
            }
            
            firstNameLabel.setText(users.get(0).getName());
            firstScoreLabel.setText(String.valueOf(users.get(0).getThirdScore()));  
            secondNameLabel.setText(users.get(1).getName());
            secondScoreLabel.setText(String.valueOf(users.get(1).getThirdScore()));
            thirdNameLabel.setText(users.get(2).getName());   
            thirdScoreLabel.setText(String.valueOf(users.get(2).getThirdScore()));  
    }//GEN-LAST:event_quizJButtonActionPerformed
       /**
     * Method: findCountry  
     * Description: This is a class to find index of countries
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem operaName
     * @return index
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */
    //search for a city by a name and return the city if found
    private Country findCountry(String countryName)
    {
        int index = -1;
        //make sure JList is sorted by name
        nameJRadioButtonMenuItem.doClick();
        for(int i = 0; i < countries.size(); i++)
        {
            if(countryName.equals(countries.get(i).getName()))
                index = i;
        }
        if(index >= 0)
        {
            countriesJList.setSelectedIndex(index);
            return countries.get(index);
        }
        else
            return null;
    }
    
     /**
     * Method: countryExists        
     * Description: This is a class to check whether country is already exist or not 
     *              in the database
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem void
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */        
    private boolean countryExists(Country country)
    {
        boolean thereIsOne = false;
        for(int index = 0; index < countries.size() && !thereIsOne; index++)
        {
            if(countries.get(index).equals(country))  //using equals method in the country class
                thereIsOne = true;
        }
        return thereIsOne;
    }
    
    
     /**
     * Method: searchCountry
     * Description: Searching country with linear search and selected it on JList
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem countryName
     * @return void
     * pre-condition: Uses the ArrayList operas.
     * post-condition: opera name is selected
     * @see #linearSearch
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */
    
    private void searchCountry(String countryName)
    {
        if((countryName!= null) && (countryName.length()> 0))
        {
            nameJRadioButtonMenuItem.setSelected(true);
            displayCountries();
            
            String[] operaArray = new String[countries.size()];
            for(int i = 0; i < operaArray.length;i++)
            {
                operaArray[i] = countries.get(i).getName();
            }
            
            int index = linearSearch(operaArray, countryName);
            if(index == -1)
            {
                JOptionPane.showMessageDialog(null, countryName + " not Found",
                        "Search Result", JOptionPane.WARNING_MESSAGE);
                countriesJList.setSelectedIndex(0);
            }
            else
                countriesJList.setSelectedIndex(index);
        }
    }
    
        /**
     * Method: saveCountries 
     * Description: This is a class to write countries txt file that is | delimited
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem a valid file name, Operas.txt is expected
     * @return a new txt file with current countries
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */
    private void saveCountries(String file)
    {
        try
        {
            FileWriter filePointer = new FileWriter(file, false);
            PrintWriter output = new PrintWriter(filePointer);
            for(int index = 0; index < countries.size(); index++)
            {
                Country tempCountry = countries.get(index);
                String line = tempCountry.getName() + "," + tempCountry.getCountryPop() +
                        "," + tempCountry.getCapital() + "," +
                        tempCountry.getCapitalPop() + "," + tempCountry.getSize() + "," + 
                        tempCountry.getLocation() + "," + tempCountry.getLanguage() + "," + 
                        tempCountry.getRiver() + "," + tempCountry.getFlagName();
                output.println(line);
            }
            output.close();
        }
        catch(IOException ex)
        {
        JOptionPane.showMessageDialog(null, "Opera not saved", "Save Error",
                JOptionPane.WARNING_MESSAGE);
        countriesJList.setVisible(true);
        countriesJList.setSelectedIndex(0);
        }
    }
    /**
     * Method: searchOpera
     * Description: Searching opera name within the given array and return the index that matched
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem operaName, operaArray
     * @return index
     * pre-condition: Uses the ArrayList operas and the name of opera
     * post-condition: opera name is either found on an index or not
     * @see #linearSearch
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */
    private int linearSearch(String[] operaArray, String operaName)
    {
        int index = -1;
        boolean found = false;
        for(int i = 0; i < operaArray.length && !found; i++)
        {
            if(operaArray[i].toLowerCase().contains(operaName.toLowerCase()))
            {
                index = i;
                found = true;
            }
        }
        return index;
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(CountriesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(CountriesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(CountriesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(CountriesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //Calling splash
        Splash mySplash = new Splash(4000);
        mySplash.showSplash();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new CountriesGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutJMenuItem;
    private javax.swing.JButton addJButton;
    private javax.swing.JMenuItem addJMenuItem;
    private javax.swing.JLabel capitalJLabel;
    private javax.swing.JTextField capitalJTextField;
    private javax.swing.JLabel capitalPopJLabel;
    private javax.swing.JTextField capitalPopJTextField;
    private javax.swing.JMenuItem clearJMenuItem;
    private javax.swing.JPanel controlJPanel;
    private javax.swing.JList<String> countriesJList;
    private javax.swing.JScrollPane countriesJScrollPane;
    private javax.swing.JLabel countryPopJLabel;
    private javax.swing.JTextField countryPopJTextField;
    private javax.swing.ButtonGroup countrybuttonGroup;
    private javax.swing.JMenu dataJMenu;
    private javax.swing.JButton deleteJButton;
    private javax.swing.JMenuItem deleteJMenuItem;
    private javax.swing.JButton editJButton;
    private javax.swing.JMenuItem editJMenuItem;
    private javax.swing.JButton exitButton;
    private javax.swing.JMenuItem exitJMenuItem;
    private javax.swing.JLabel fNameLabel;
    private javax.swing.JLabel fScoreLabel;
    private javax.swing.JMenu fileJMenu;
    private javax.swing.JLabel firstJLabel;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel firstScoreLabel;
    private javax.swing.JLabel flagJLabel;
    private javax.swing.JMenu helpJMenu;
    private javax.swing.JPanel infoJPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel languageJLabel;
    private javax.swing.JTextField languageJTextField;
    private javax.swing.JTextField locationJTextField;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JMenuBar mainJMenuBar;
    private javax.swing.JLabel nameJLabel;
    private javax.swing.JRadioButtonMenuItem nameJRadioButtonMenuItem;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JLabel picJLabel;
    private javax.swing.JRadioButtonMenuItem populationJRadioButtonMenuItem;
    private javax.swing.JMenuItem printFormJMenuItem;
    private javax.swing.JMenuItem printGUIJMenuItem;
    private javax.swing.JButton quizJButton;
    private javax.swing.JLabel riverJLabel;
    private javax.swing.JTextField riverJTextField;
    private javax.swing.JLabel sNameLabel;
    private javax.swing.JLabel sScoreLabel;
    private javax.swing.JMenuItem searchJMenuItem;
    private javax.swing.JLabel secondJLabel;
    private javax.swing.JLabel secondNameLabel;
    private javax.swing.JLabel secondScoreLabel;
    private javax.swing.JLabel sizeJLabel;
    private javax.swing.JTextField sizeJTextField;
    private javax.swing.JRadioButtonMenuItem sizeRadioJButtonMenuItem;
    private javax.swing.JMenu sortJMenu;
    private javax.swing.JLabel tNameLabel;
    private javax.swing.JLabel tScoreLabel;
    private javax.swing.JLabel thirdJLabel;
    private javax.swing.JLabel thirdNameLabel;
    private javax.swing.JLabel thirdScoreLabel;
    private javax.swing.JLabel titleJLabel;
    // End of variables declaration//GEN-END:variables
}
