/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package loginandsignup;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author aparn
 */
public class AddQuestion extends javax.swing.JFrame {

    /**
     * Creates new form AddQuestion
     */
    
    private JPanel panel,btnPanel;
    private JLabel questionLabel, marksLabel,subjectLabel;
    private JTextField questionTextField, marksTextField, subjectTextField;
    private JButton addToDB,homeButton;
    
    
    public AddQuestion() {
        
        super("Add a Question to the Database");
    
        panel = new JPanel();
        panel.setFont(new Font("Verdana",Font.PLAIN,16));
        panel.setBorder(BorderFactory.createTitledBorder("Enter Appropriate Details to Add Question To Database : "));
        panel.setLayout(new GridLayout(0,2));
        btnPanel = new JPanel();
        btnPanel.setBorder(BorderFactory.createTitledBorder("Click the Button to Add the Question : "));
        //btnPanel.setLayout(new GridLayout(0,1));
        questionLabel = new JLabel("Enter Question :",JLabel.CENTER);
        questionLabel.setFont(new Font("Verdana",Font.BOLD,16));
        questionTextField = new JTextField();
        questionTextField.setFont(new Font("Verdana",Font.BOLD,14));
        questionTextField.setHorizontalAlignment(JTextField.CENTER);
        marksLabel = new JLabel("Enter Respective Marks : ",JLabel.CENTER);
        marksLabel.setFont(new Font("Verdana",Font.BOLD,16));
        marksTextField = new JTextField();
        marksTextField.setFont(new Font("Verdana",Font.BOLD,16));
        marksTextField.setHorizontalAlignment(JTextField.CENTER);
        subjectLabel = new JLabel("Enter Respective Subject : ",JLabel.CENTER);
        subjectLabel.setFont(new Font("Verdana",Font.BOLD,16));
        subjectTextField = new JTextField();
        subjectTextField.setFont(new Font("Verdana",Font.BOLD,16));
        subjectTextField.setHorizontalAlignment(JTextField.CENTER);
        addToDB = new JButton("Add Question"); 
        addToDB.setFont(new Font("Verdana",Font.BOLD,16));
        addToDB.setAlignmentX(CENTER_ALIGNMENT);
        addToDB.setAlignmentY(BOTTOM_ALIGNMENT);
        //addToDB.setPreferredSize(new Dimension(100,100));
        homeButton = new JButton("Go to Home");
        homeButton.setFont(new Font("Verdana",Font.BOLD,16));
        
        
        panel.setSize(800,800); 
        panel.setBackground(new Color(153,153,255,255));
        panel.add(questionLabel);
        panel.add(questionTextField);
        panel.add(marksLabel);
        panel.add(marksTextField);
        panel.add(subjectLabel);
        panel.add(subjectTextField);
        //btnPanel.setSize(200,200);
        panel.add(btnPanel);
        btnPanel.add(addToDB);
        btnPanel.add(homeButton);
        add(panel);
        //setSize(900, 600);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        addToDB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String qn = (questionTextField.getText());
                int marks = Integer.parseInt(marksTextField.getText());
                String sub = (subjectTextField.getText());
                addQuestion(qn, marks, sub);
            }
        });
        
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home HomeFrame = new Home();
                HomeFrame.setVisible(true);
                HomeFrame.pack();
                HomeFrame.setLocationRelativeTo(null); 
                dispose();
            }
        });
}

 private void addQuestion(String qn, int marks, String sub) {
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/questiondb", "root", "");
            Statement statement = connection.createStatement();
            
            String query = "INSERT INTO `questions` (`questions`, `marks`, `subject`) VALUES ('"+qn+"', '"+marks+"', '"+sub+"')";
            statement.executeUpdate(query);
        JOptionPane.showMessageDialog(panel, "Question Added to Database successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(panel, "Error Adding Question to Database : " + e.getMessage());
        }
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(AddQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddQuestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
