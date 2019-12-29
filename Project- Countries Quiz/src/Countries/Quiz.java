package Countries;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Quiz extends javax.swing.JDialog {

    private int maxQuestion = 5;
    private ArrayList<Country> countries = new ArrayList<Country>();
    private ArrayList<User> players = new ArrayList<User>();
    private final String fileName = "src/Countries/Countries.txt";
    private final String userData = "src/Countries/Users.txt";

    private int currentIndex = 0;
    private int currrentCorrect = 0;
    private int count = 0;
    private int quizNumber = 1;

    public Quiz(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.getRootPane().setDefaultButton(submitJButton);
        this.setLocationRelativeTo(null);
        readFromFile(fileName);
        displayPlayer(userData);
        nextJButton.setEnabled(false);
        playJButton.setEnabled(false);
        displayFlag();
    }

    public void readFromFile(String file) {
        countries.clear();

        try {
            Scanner input = new Scanner(new File(file));

            while (input.hasNextLine()) {
                String line = input.nextLine();
                Country country = new Country();  //create a country
                StringTokenizer stringTokenizer = new StringTokenizer(line, ",");
                // Populate the Country country object using , to differentiaite each of them
                //pars through each field to create a country
                while (stringTokenizer.hasMoreElements()) {
                    country.setName(stringTokenizer.nextToken());
                    countryJComboBox.addItem(country.getName());
                    country.setCountryPop(Float.parseFloat(stringTokenizer.nextToken()));
                    country.setCapital(stringTokenizer.nextToken());
                    country.setCapitalPop(Float.parseFloat(stringTokenizer.nextToken()));
                    country.setSize(Integer.parseInt(stringTokenizer.nextToken()));
                    country.setLocation(stringTokenizer.nextToken());
                    country.setLanguage(stringTokenizer.nextToken());
                    country.setRiver(stringTokenizer.nextToken());
                    country.setFlag(new ImageIcon("src/Countries/" + stringTokenizer.nextToken()), flagJLabel.getWidth(), flagJLabel.getHeight());
                }
                //add countries to arraylist
                countries.add(country);
            }
            //close file
            input.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File does not exist",
                    "File Input Error", JOptionPane.WARNING_MESSAGE);
            //Choose a new file
            JFileChooser chooser = new JFileChooser("src/Countries");

            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "Txt Files", "txt");
            chooser.setFileFilter(filter);
            int choice = chooser.showOpenDialog(null);
            if (choice == JFileChooser.APPROVE_OPTION) {
                File chosenFile = chooser.getSelectedFile();
                file = "src/Countries/" + chosenFile.getName();
                System.out.println("file = " + file);
                readFromFile(file);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Unable to read file",
                    "File Input Error", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
    }

    public void displayPlayer(String data) {
        players.clear();

        try {
            Scanner input = new Scanner(new File(data));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                User player = new User();  //create a country
                StringTokenizer stringTokenizer = new StringTokenizer(line, ",");
                // Populate the Country country object using , to differentiaite each of them
                //pars through each field to create a country
                while (stringTokenizer.hasMoreElements()) {
                    player.setName(stringTokenizer.nextToken());
                    userJComboBox.addItem(player.getName());
                    player.setFirstScore(Integer.parseInt(stringTokenizer.nextToken()));
                    player.setSecondScore(Integer.parseInt(stringTokenizer.nextToken()));
                    player.setThirdScore(Integer.parseInt(stringTokenizer.nextToken()));
                }
                //add countries to arraylist
                players.add(player);
            }
            //close file
            input.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File does not exist",
                    "File Input Error", JOptionPane.WARNING_MESSAGE);
            //Choose a new file
            JFileChooser chooser = new JFileChooser("src/Countries");

            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "Txt Files", "txt");
            chooser.setFileFilter(filter);
            int choice = chooser.showOpenDialog(null);
            if (choice == JFileChooser.APPROVE_OPTION) {
                File chosenFile = chooser.getSelectedFile();
                data = "src/Countries/" + chosenFile.getName();
                System.out.println("file = " + data);
                readFromFile(data);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Unable to read file",
                    "File Input Error", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
    }

    private void displayFlag() {
        currentIndex = getUniqueRandomNumber();
        String country = (String) countryJComboBox.getItemAt(currentIndex);
        String countryPath = "src/Images/" + country + ".png";
        int flagWidth = 429;
        int flagHeight = 251;

        ImageIcon flag = new ImageIcon(countryPath);

        Image image = flag.getImage();  // transform it
        Image newImg = image.getScaledInstance(flagWidth, flagHeight, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        flag = new ImageIcon(newImg);

        flagJLabel.setIcon(flag);
    }

    private int getUniqueRandomNumber() {
        Random myRandom = new Random();
        int result = myRandom.nextInt(countries.size());
        return result;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        titleJPanel = new javax.swing.JPanel();
        picJLabel = new javax.swing.JLabel();
        titleJLabel = new javax.swing.JLabel();
        flagJLabel = new javax.swing.JLabel();
        questionJLabel = new javax.swing.JLabel();
        countryJComboBox = new javax.swing.JComboBox<>();
        resultJLabel = new javax.swing.JLabel();
        submitJButton = new javax.swing.JButton();
        nextJButton = new javax.swing.JButton();
        playJButton = new javax.swing.JButton();
        userJLabel = new javax.swing.JLabel();
        userJComboBox = new javax.swing.JComboBox<>();
        quizJMenuBar = new javax.swing.JMenuBar();
        selectJMenu = new javax.swing.JMenu();
        fiveJRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        tenJRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        fifteenJRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quiz");
        setType(java.awt.Window.Type.UTILITY);

        titleJPanel.setPreferredSize(new java.awt.Dimension(496, 85));

        picJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Countries/pic.jpg"))); // NOI18N

        titleJLabel.setFont(new java.awt.Font("Elephant", 3, 36)); // NOI18N
        titleJLabel.setForeground(new java.awt.Color(0, 102, 204));
        titleJLabel.setText("Quiz");

        javax.swing.GroupLayout titleJPanelLayout = new javax.swing.GroupLayout(titleJPanel);
        titleJPanel.setLayout(titleJPanelLayout);
        titleJPanelLayout.setHorizontalGroup(
            titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleJLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        titleJPanelLayout.setVerticalGroup(
            titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(picJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        flagJLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        flagJLabel.setPreferredSize(new java.awt.Dimension(429, 251));

        questionJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        questionJLabel.setText("Select country");

        countryJComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        resultJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        resultJLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        submitJButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        submitJButton.setText("Submit");
        submitJButton.setPreferredSize(new java.awt.Dimension(95, 25));
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });

        nextJButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nextJButton.setText("Next Flag");
        nextJButton.setPreferredSize(new java.awt.Dimension(95, 25));
        nextJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextJButtonActionPerformed(evt);
            }
        });

        playJButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        playJButton.setText("Play Again");
        playJButton.setPreferredSize(new java.awt.Dimension(90, 25));
        playJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playJButtonActionPerformed(evt);
            }
        });

        userJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userJLabel.setText("Select player");

        userJComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        selectJMenu.setText("Select number of questions");

        buttonGroup.add(fiveJRadioButtonMenuItem);
        fiveJRadioButtonMenuItem.setSelected(true);
        fiveJRadioButtonMenuItem.setText("Five questions");
        fiveJRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveJRadioButtonMenuItemActionPerformed(evt);
            }
        });
        selectJMenu.add(fiveJRadioButtonMenuItem);

        buttonGroup.add(tenJRadioButtonMenuItem);
        tenJRadioButtonMenuItem.setText("Ten questions");
        tenJRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenJRadioButtonMenuItemActionPerformed(evt);
            }
        });
        selectJMenu.add(tenJRadioButtonMenuItem);

        buttonGroup.add(fifteenJRadioButtonMenuItem);
        fifteenJRadioButtonMenuItem.setText("Fifteen questions");
        fifteenJRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fifteenJRadioButtonMenuItemActionPerformed(evt);
            }
        });
        selectJMenu.add(fifteenJRadioButtonMenuItem);

        quizJMenuBar.add(selectJMenu);

        setJMenuBar(quizJMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(titleJPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(flagJLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(questionJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(64, 64, 64)
                                        .addComponent(userJLabel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(countryJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(userJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(resultJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(playJButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nextJButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(submitJButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(flagJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(submitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextJButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playJButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(questionJLabel)
                            .addComponent(userJLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(countryJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resultJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        count++;

        userJComboBox.setEnabled(false);
        selectJMenu.setEnabled(false);
        if (countryJComboBox.getSelectedIndex() == currentIndex) {
            currrentCorrect++;
            resultJLabel.setText("Correct: " + currrentCorrect + "/" + count);
        } else {
            resultJLabel.setText("Incorrect.");
        }
        if (count == maxQuestion) {
            if (quizNumber == 1) {
                players.get(userJComboBox.getSelectedIndex()).setFirstScore(currrentCorrect);
            }else if(quizNumber == 2){
                players.get(userJComboBox.getSelectedIndex()).setSecondScore(currrentCorrect);
            }else{
                players.get(userJComboBox.getSelectedIndex()).setThirdScore(currrentCorrect);
            }
            resultJLabel.setText(currrentCorrect + "/" + maxQuestion);
            nextJButton.setEnabled(false);
            submitJButton.setEnabled(false);
            playJButton.setEnabled(true);
            countryJComboBox.setEnabled(false);
        } else {
            nextJButton.setEnabled(true);
            submitJButton.setEnabled(false);
            playJButton.setEnabled(false);
        }
    }//GEN-LAST:event_submitJButtonActionPerformed

    private void nextJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextJButtonActionPerformed
        displayFlag();
        resultJLabel.setText("");
        countryJComboBox.setSelectedIndex(0);
        nextJButton.setEnabled(false);
        submitJButton.setEnabled(true);
    }//GEN-LAST:event_nextJButtonActionPerformed

    private void playJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playJButtonActionPerformed
        currrentCorrect = 0;
        count = 0;
        resultJLabel.setText("");
        submitJButton.setEnabled(true);
        nextJButton.setEnabled(false);
        playJButton.setEnabled(false);
        countryJComboBox.setEnabled(false);
        userJComboBox.setEnabled(true);
        selectJMenu.setEnabled(true);

        displayFlag();
    }//GEN-LAST:event_playJButtonActionPerformed

    private void fiveJRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveJRadioButtonMenuItemActionPerformed
        maxQuestion = 5;
        quizNumber = 1;
    }//GEN-LAST:event_fiveJRadioButtonMenuItemActionPerformed

    private void tenJRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenJRadioButtonMenuItemActionPerformed
        maxQuestion = 10;
        quizNumber = 2;
    }//GEN-LAST:event_tenJRadioButtonMenuItemActionPerformed

    private void fifteenJRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fifteenJRadioButtonMenuItemActionPerformed
        maxQuestion = 15;
        quizNumber = 3;
    }//GEN-LAST:event_fifteenJRadioButtonMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Quiz dialog = new Quiz(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JComboBox<String> countryJComboBox;
    private javax.swing.JRadioButtonMenuItem fifteenJRadioButtonMenuItem;
    private javax.swing.JRadioButtonMenuItem fiveJRadioButtonMenuItem;
    private javax.swing.JLabel flagJLabel;
    private javax.swing.JButton nextJButton;
    private javax.swing.JLabel picJLabel;
    private javax.swing.JButton playJButton;
    private javax.swing.JLabel questionJLabel;
    private javax.swing.JMenuBar quizJMenuBar;
    private javax.swing.JLabel resultJLabel;
    private javax.swing.JMenu selectJMenu;
    private javax.swing.JButton submitJButton;
    private javax.swing.JRadioButtonMenuItem tenJRadioButtonMenuItem;
    private javax.swing.JLabel titleJLabel;
    private javax.swing.JPanel titleJPanel;
    private javax.swing.JComboBox<String> userJComboBox;
    private javax.swing.JLabel userJLabel;
    // End of variables declaration//GEN-END:variables
}
