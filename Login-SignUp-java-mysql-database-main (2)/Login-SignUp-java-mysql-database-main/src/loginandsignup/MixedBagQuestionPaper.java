/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package loginandsignup;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;

/**
 *
 * @author aparn
 */
public class MixedBagQuestionPaper extends javax.swing.JFrame {

    /**
     * Creates new form MixedBagQuestionPaper
     */
    
    private JPanel panel,btnPanel;
    private JLabel marksLabel, numOfQuestionsLabel,subjectLabel;
    private JTextField marksField, numOfQuestionsField,subjectField;
    private JButton generateButton,homeButton;
    
    
    public MixedBagQuestionPaper() {
        
        super("Mixed Bag Question Paper Generator");
        
        panel = new JPanel();
        panel.setFont(new Font("Verdana",Font.PLAIN,16));
        panel.setBorder(BorderFactory.createTitledBorder("Enter Appropriate Details to Generate Paper : "));
        panel.setLayout(new GridLayout(0,2));
        btnPanel = new JPanel();
    	btnPanel.setBorder(BorderFactory.createTitledBorder("Click the Button to Generate Paper : "));
    	btnPanel.setLayout(new GridLayout(0,2));
        marksLabel = new JLabel("Marks:",JLabel.CENTER);
        marksLabel.setFont(new Font("Verdana",Font.BOLD,16));
        marksField = new JTextField(2);
        marksField.setFont(new Font("Verdana",Font.BOLD,16));
        marksField.setHorizontalAlignment(JTextField.CENTER);
        /*numOfQuestionsLabel = new JLabel("Number of Questions :",JLabel.CENTER);
        numOfQuestionsLabel.setFont(new Font("Verdana",Font.BOLD,16));
        numOfQuestionsField = new JTextField(2);
        numOfQuestionsField.setFont(new Font("Verdana",Font.BOLD,16));
        numOfQuestionsField.setHorizontalAlignment(JTextField.CENTER); */
        subjectLabel = new JLabel("Subject:",JLabel.CENTER);
        subjectLabel.setFont(new Font("Verdana",Font.BOLD,16));
        subjectField = new JTextField(5);
        subjectField.setFont(new Font("Verdana",Font.BOLD,16));
        subjectField.setHorizontalAlignment(JTextField.CENTER);
        //voidLabel = new JLabel("",JLabel.CENTER);
        generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Verdana",Font.BOLD,16));
        //generateButton.setAlignmentX(CENTER_ALIGNMENT);
        //generateButton.setAlignmentY(BOTTOM_ALIGNMENT);
        homeButton = new JButton("Go to Home");
        homeButton.setFont(new Font("Verdana",Font.BOLD,16));
        
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int marks = Integer.parseInt(marksField.getText());
                //int numOfQuestions = Integer.parseInt(numOfQuestionsField.getText());
                String sub = subjectField.getText();
                generateQuestionPaper(marks, sub);
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
        
        panel.setSize(800,800); 
        panel.setBackground(new Color(204,153,255,255));
        panel.add(marksLabel);
        panel.add(marksField);
        //panel.add(numOfQuestionsLabel);
        //panel.add(numOfQuestionsField);
        panel.add(subjectLabel);
        panel.add(subjectField);
        panel.add(btnPanel);
        btnPanel.add(generateButton);
        btnPanel.add(homeButton);
        add(panel);
        pack();
        //setSize(900, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

    private void generateQuestionPaper(int marksInput, String sub) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");

        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try {
                Document document = new Document();
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileToSave));
            document.open();

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/questiondb", "root", "");
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM questions WHERE subject = '"+sub+"'";
            ResultSet resultSet = statement.executeQuery(query);

            document.add(new Paragraph("Question Paper\n\n"));
            int sumMarks = 0;
            int count = 1;
            while (resultSet.next() && sumMarks<=marksInput) {
                int questionMarks = resultSet.getInt("marks");
                sumMarks += questionMarks;
                String questionText = resultSet.getString("questions");

                    document.add(new Paragraph(count + ") " + questionText));
                    document.add(new Paragraph("Marks: " + questionMarks + "\n\n"));
                    count++;
                if(sumMarks>marksInput)
                {
                    break;
                }
                }

            document.close();
            JOptionPane.showMessageDialog(panel, "Question Paper generated successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(panel, "Error generating Question Paper: " + e.getMessage());
        }
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
            java.util.logging.Logger.getLogger(MixedBagQuestionPaper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MixedBagQuestionPaper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MixedBagQuestionPaper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MixedBagQuestionPaper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MixedBagQuestionPaper().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
