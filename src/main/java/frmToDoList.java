/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import java.awt.CardLayout;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.ImageIcon;
import java.awt.Color;

/**
 *
 * @author PC
 */
public class frmToDoList extends javax.swing.JFrame {
    DefaultTableModel model_SchoolHomeworks;
    DefaultTableModel model_PersonalWorks;
    DefaultTableModel model_Goals;
    DefaultTableModel model_BooksToRead;
    /**
     * Creates new form frmToDoList
     */
    CardLayout cardLayout;
    public frmToDoList() {
        
        initComponents();
        setLocationRelativeTo(null);
        
        cardLayout = (CardLayout)(pnlCardLayout.getLayout());
    }
        
    public ArrayList<SchoolHomeworks> getHomeworks() throws SQLException{
        Connection connection=null;
        DBHelper dbHelper = new DBHelper();
        Statement statement=null;
        ResultSet resultSet;
        ArrayList<SchoolHomeworks> homeworks = null;
        
        try{
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet= statement.executeQuery("select * from schoolhomeworks");
            homeworks = new ArrayList<SchoolHomeworks>();
            while(resultSet.next()){
                homeworks.add(new SchoolHomeworks(resultSet.getInt("ID"),
                        resultSet.getString("Subject"),
                        resultSet.getString("Mission"),
                        resultSet.getString("DueDate"),
                        resultSet.getBoolean("Done")));
            }
        }
            
        
        catch(SQLException exception){
         
            dbHelper.showErrorMessage(exception);
    
        
    }
        finally{
            statement.close();
            connection.close();
            
        }
        return homeworks;
    }
    
    
    public ArrayList<PersonalWorks> getWorks() throws SQLException{
        Connection connection=null;
        DBHelper dbHelper = new DBHelper();
        Statement statement=null;
        ResultSet resultSet;
        ArrayList<PersonalWorks> personalworks = null;
        
        try{
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet= statement.executeQuery("select * from personalworks");
            personalworks = new ArrayList<PersonalWorks>();
            while(resultSet.next()){
                personalworks.add(new PersonalWorks(resultSet.getInt("ID"),
                        resultSet.getString("Subject"),
                        resultSet.getString("Mission"),
                        resultSet.getString("DueDate"),
                        resultSet.getBoolean("Done")));
            }
        }
            
        
        catch(SQLException exception){
         
            dbHelper.showErrorMessage(exception);
    
        
    }
        finally{
            statement.close();
            connection.close();
            
        }
        return personalworks;
    }
    
    
    public ArrayList<Goals> getGoals() throws SQLException{
        Connection connection=null;
        DBHelper dbHelper = new DBHelper();
        Statement statement=null;
        ResultSet resultSet;
        ArrayList<Goals> goals = null;
        
        try{
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet= statement.executeQuery("select * from goals");
            goals = new ArrayList<Goals>();
            while(resultSet.next()){
                goals.add(new Goals(resultSet.getInt("ID"),
                        resultSet.getString("Subject"),
                        resultSet.getString("Mission"),
                        resultSet.getString("DueDate"),
                        resultSet.getBoolean("Done")));
            }
        }
            
        
        catch(SQLException exception){
         
            dbHelper.showErrorMessage(exception);
    
        
    }
        finally{
            statement.close();
            connection.close();
            
        }
        return goals;
    }
    
    
    public ArrayList<BooksToRead> getBooksToRead() throws SQLException{
        Connection connection=null;
        DBHelper dbHelper = new DBHelper();
        Statement statement=null;
        ResultSet resultSet;
        ArrayList<BooksToRead> bookstoread = null;
        
        try{
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet= statement.executeQuery("select * from bookstoread");
            bookstoread = new ArrayList<BooksToRead>();
            while(resultSet.next()){
                bookstoread.add(new BooksToRead(resultSet.getInt("ID"),
                        resultSet.getString("BookName"),
                        resultSet.getString("Author"),
                        resultSet.getInt("NumberOfPages"),
                        resultSet.getBoolean("Done")));
            }
        }
            
        
        catch(SQLException exception){
         
            dbHelper.showErrorMessage(exception);
    
        
    }
        finally{
            statement.close();
            connection.close();
            
        }
        return bookstoread;
    }
    public void PersonalWorks(){
   
         model_PersonalWorks = (DefaultTableModel)tblPersonalWorks.getModel();
         model_PersonalWorks.setRowCount(0);
        try {
            ArrayList<PersonalWorks> personalworks = getWorks();
            for(PersonalWorks personalWorks:personalworks){
                Object[] row = {personalWorks.getId(),personalWorks.getSubject(),personalWorks.getMission(),personalWorks.getDuedate(),personalWorks.isDone()};
                model_PersonalWorks.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmToDoList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Goals(){
      model_Goals = (DefaultTableModel)tblGoals.getModel();
      model_Goals.setRowCount(0);
        try {
            ArrayList<Goals> goals = getGoals();
            for(Goals goals_1:goals){
                Object[] row = {goals_1.getId(),goals_1.getSubject(),goals_1.getMission(),goals_1.getDuedate(),goals_1.isDone()};
                model_Goals.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmToDoList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void BooksToRead(){
      model_BooksToRead = (DefaultTableModel)tblBooksToRead.getModel();
      model_BooksToRead.setRowCount(0);
        try {
            ArrayList<BooksToRead> bookstoread = getBooksToRead();
            for(BooksToRead booksToRead:bookstoread){
                Object[] row = {booksToRead.getId(),booksToRead.getBookname(),booksToRead.getAuthor(),booksToRead.getNumberOfPages(),booksToRead.isDone()};
                model_BooksToRead.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmToDoList.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    
       public void SchoolHomeworks(){
        model_SchoolHomeworks = (DefaultTableModel)tblSchoolHomeworks.getModel();
        model_SchoolHomeworks.setRowCount(0);
        try {
            ArrayList<SchoolHomeworks> homeworks = getHomeworks();
            for(SchoolHomeworks homeWorks:homeworks){
                Object[] row = {homeWorks.getId(),homeWorks.getSubject(),homeWorks.getMission(),homeWorks.getDuedate(),homeWorks.isDone()};
                model_SchoolHomeworks.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmToDoList.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
    
    
    
    
    
    
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frmAddSchoolHomeworks = new javax.swing.JFrame();
        lblAddSubjectSchoolHomeworks1 = new javax.swing.JLabel();
        tfAddSubjectSchoolHomeworks1 = new javax.swing.JTextField();
        lblAddMissionSchoolHomeworks1 = new javax.swing.JLabel();
        tfAddMissionSchoolHomeworks1 = new javax.swing.JTextField();
        lblAddDueDateSchoolHomeworks1 = new javax.swing.JLabel();
        lblAddisDoneSchoolHomeworks1 = new javax.swing.JLabel();
        tfAddDueDateSchoolHomeworks1 = new javax.swing.JTextField();
        chbAddisDoneSchoolHomeworks1 = new javax.swing.JCheckBox();
        btnAddSchoolHomeworks1 = new javax.swing.JButton();
        lblAddMessageSchoolHomeworks = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        frmAddPersonalWorks = new javax.swing.JFrame();
        lblAddSubjectPersonalWorks1 = new javax.swing.JLabel();
        tfAddSubjectPersonalWorks = new javax.swing.JTextField();
        lblAddMissionPersonalWorks1 = new javax.swing.JLabel();
        tfAddMissionPersonalWorks1 = new javax.swing.JTextField();
        lblAddDueDatePersonalWorks1 = new javax.swing.JLabel();
        lblAddisDonePersonalWorks1 = new javax.swing.JLabel();
        tfAddDueDatePersonalWorks1 = new javax.swing.JTextField();
        chbAddisDonePersonalWorks1 = new javax.swing.JCheckBox();
        btnAddPersonalWorks1 = new javax.swing.JButton();
        lblAddMessagePersonalWorks = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        frmAddGoals = new javax.swing.JFrame();
        lblAddSubjectGoals1 = new javax.swing.JLabel();
        tfAddSubjectGoals1 = new javax.swing.JTextField();
        lblAddMissionGoals1 = new javax.swing.JLabel();
        tfAddMissionGoals1 = new javax.swing.JTextField();
        lblAddDueDateGoals1 = new javax.swing.JLabel();
        lblAddisDoneGoals1 = new javax.swing.JLabel();
        tfAddDueDateGoals1 = new javax.swing.JTextField();
        chbAddisDoneGoals1 = new javax.swing.JCheckBox();
        btnAddGoals1 = new javax.swing.JButton();
        lblAddMessageGoals = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        frmAddBooksToRead = new javax.swing.JFrame();
        lblAddBookNameBooksToRead = new javax.swing.JLabel();
        tfAddBookNameBooksToRead = new javax.swing.JTextField();
        lblAddAuthorBooksToRead = new javax.swing.JLabel();
        tfAddAuthorBooksToRead = new javax.swing.JTextField();
        lblAddNumberOfPageBooksToRead = new javax.swing.JLabel();
        lblAddisDoneBooksToRead = new javax.swing.JLabel();
        tfAddNumberOfPagesBooksToRead = new javax.swing.JTextField();
        chbAddisDoneBooksToRead = new javax.swing.JCheckBox();
        btnAddBooksToRead1 = new javax.swing.JButton();
        lblAddMessageBooksToRead = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        frmUpdateSchoolHomeworks = new javax.swing.JFrame();
        lblUpdateSubjectSchoolHomeworks = new javax.swing.JLabel();
        tfUpdateSubjectSchoolHomeworks = new javax.swing.JTextField();
        lblUpdateMissionSchoolHomeworks = new javax.swing.JLabel();
        tfUpdateMissionSchoolHomeworks = new javax.swing.JTextField();
        lblUpdateDueDateSchoolHomeworks = new javax.swing.JLabel();
        lblUpdateisDoneSchoolHomeworks = new javax.swing.JLabel();
        tfUpdateDueDateSchoolHomeworks = new javax.swing.JTextField();
        chbUpdateisDoneSchoolHomeworks = new javax.swing.JCheckBox();
        btnUpdateSchoolHomeworks1 = new javax.swing.JButton();
        lblUpdateIDSchoolHomeworks = new javax.swing.JLabel();
        tfUpdateIDSchoolHomeworks = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        frmUpdatePersonalWorks = new javax.swing.JFrame();
        lblUpdateSubjectPersonalWorks = new javax.swing.JLabel();
        tfUpdateSubjectPersonalWorks = new javax.swing.JTextField();
        lblUpdateMissionPersonalWorks = new javax.swing.JLabel();
        tfUpdateMissionPersonalWorks = new javax.swing.JTextField();
        lblUpdateDueDatePersonalWorks = new javax.swing.JLabel();
        lblUpdateisDonePersonalWorks = new javax.swing.JLabel();
        tfUpdateDueDatePersonalWorks = new javax.swing.JTextField();
        chbUpdateisDonePersonalWorks = new javax.swing.JCheckBox();
        btnUpdatePersonalWorks1 = new javax.swing.JButton();
        lblUpdateIDPersonalWorks = new javax.swing.JLabel();
        tfUpdateIDPersonalWorks = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        frmUpdateGoals = new javax.swing.JFrame();
        lblUpdateSubjectGoals = new javax.swing.JLabel();
        tfUpdateSubjectGoals = new javax.swing.JTextField();
        lblUpdateMissionGoals = new javax.swing.JLabel();
        tfUpdateMissionGoals = new javax.swing.JTextField();
        lblUpdateDueDateGoals = new javax.swing.JLabel();
        lblUpdateisDoneGoals = new javax.swing.JLabel();
        tfUpdateDueDateGoals = new javax.swing.JTextField();
        chbUpdateisDoneGoals = new javax.swing.JCheckBox();
        btnUpdateGoals1 = new javax.swing.JButton();
        lblUpdateIDGoals = new javax.swing.JLabel();
        tfUpdateIDGoals = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        frmUpdateBooksToRead = new javax.swing.JFrame();
        lblUpdateBookNameBooksToRead = new javax.swing.JLabel();
        tfUpdateBookNameBooksToRead = new javax.swing.JTextField();
        lblUpdateAuthorBooksToRead = new javax.swing.JLabel();
        tfUpdateAuthorBooksToRead = new javax.swing.JTextField();
        lblUpdateNumberOfPageBooksToRead = new javax.swing.JLabel();
        lblUpdateisDoneBooksToRead = new javax.swing.JLabel();
        tfUpdateNumberOfPagesBooksToRead = new javax.swing.JTextField();
        chbUpdateisDoneBooksToRead = new javax.swing.JCheckBox();
        btnUpdateBooksToRead1 = new javax.swing.JButton();
        lblUpdateBookNameBooksToRead1 = new javax.swing.JLabel();
        tfUpdateIDBooksToRead = new javax.swing.JTextField();
        lblUpdateMessageBooksToRead = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        splitPane = new javax.swing.JSplitPane();
        jPanel5 = new javax.swing.JPanel();
        btnHomePage = new javax.swing.JButton();
        btnPersonalWorks = new javax.swing.JButton();
        btnGoals = new javax.swing.JButton();
        btnBooksToRead = new javax.swing.JButton();
        btnSchoolHomeworks = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pnlCardLayout = new javax.swing.JPanel();
        pnlHomePage = new javax.swing.JPanel();
        lblSchoolHomeworks1 = new javax.swing.JLabel();
        pnlSchoolHomeworks = new javax.swing.JPanel();
        lblSchoolHomeworks = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSchoolHomeworks = new javax.swing.JTable();
        lblSearch3 = new javax.swing.JLabel();
        tfSearch3 = new javax.swing.JTextField();
        btnAddSchoolHomeworks = new javax.swing.JButton();
        btnUpdateSchoolHomeworks = new javax.swing.JButton();
        btnDeleteSchoolHomeworks = new javax.swing.JButton();
        pnlPersonalWorks = new javax.swing.JPanel();
        lblPersonalWorks = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPersonalWorks = new javax.swing.JTable();
        lblSearch2 = new javax.swing.JLabel();
        tfSearch2 = new javax.swing.JTextField();
        btnAddPersonalWorks = new javax.swing.JButton();
        btnDeletePersonalWorks = new javax.swing.JButton();
        btnUpdatePersonalWorks = new javax.swing.JButton();
        pnlGoals = new javax.swing.JPanel();
        lblGoals = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGoals = new javax.swing.JTable();
        lblSearch1 = new javax.swing.JLabel();
        tfSearch1 = new javax.swing.JTextField();
        btnAddGoals = new javax.swing.JButton();
        btnDeleteGoals = new javax.swing.JButton();
        btnUpdateGoals = new javax.swing.JButton();
        pnlBooksToRead = new javax.swing.JPanel();
        lblBooksToRead = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();
        btnAddBooksToRead = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBooksToRead = new javax.swing.JTable();
        tblBooksToRead.setBackground(Color.WHITE);
        btnUpdateBooksToRead = new javax.swing.JButton();
        btnDeleteBooksToRead = new javax.swing.JButton();

        frmAddSchoolHomeworks.setTitle("Add Homework");
        frmAddSchoolHomeworks.setMinimumSize(new java.awt.Dimension(450, 350));
        frmAddSchoolHomeworks.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAddSubjectSchoolHomeworks1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblAddSubjectSchoolHomeworks1.setText("Subject:");
        frmAddSchoolHomeworks.getContentPane().add(lblAddSubjectSchoolHomeworks1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 60, 30));

        tfAddSubjectSchoolHomeworks1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAddSubjectSchoolHomeworks1ActionPerformed(evt);
            }
        });
        frmAddSchoolHomeworks.getContentPane().add(tfAddSubjectSchoolHomeworks1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 180, 30));

        lblAddMissionSchoolHomeworks1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblAddMissionSchoolHomeworks1.setText("Mission:");
        frmAddSchoolHomeworks.getContentPane().add(lblAddMissionSchoolHomeworks1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 60, 30));
        frmAddSchoolHomeworks.getContentPane().add(tfAddMissionSchoolHomeworks1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 180, 30));

        lblAddDueDateSchoolHomeworks1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblAddDueDateSchoolHomeworks1.setText("DueDate:");
        frmAddSchoolHomeworks.getContentPane().add(lblAddDueDateSchoolHomeworks1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, 30));

        lblAddisDoneSchoolHomeworks1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblAddisDoneSchoolHomeworks1.setText("isDone:");
        frmAddSchoolHomeworks.getContentPane().add(lblAddisDoneSchoolHomeworks1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, 30));
        frmAddSchoolHomeworks.getContentPane().add(tfAddDueDateSchoolHomeworks1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 180, 30));
        frmAddSchoolHomeworks.getContentPane().add(chbAddisDoneSchoolHomeworks1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, 30));

        btnAddSchoolHomeworks1.setBackground(new java.awt.Color(51, 51, 51));
        btnAddSchoolHomeworks1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnAddSchoolHomeworks1.setForeground(new java.awt.Color(255, 255, 255));
        btnAddSchoolHomeworks1.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("icons8-add-48.png"))); // NOI18N
        btnAddSchoolHomeworks1.setText("Add");
        btnAddSchoolHomeworks1.setBorderPainted(false);
        btnAddSchoolHomeworks1.setFocusable(false);
        btnAddSchoolHomeworks1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSchoolHomeworks1ActionPerformed(evt);
            }
        });
        frmAddSchoolHomeworks.getContentPane().add(btnAddSchoolHomeworks1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 170, 50));

        lblAddMessageSchoolHomeworks.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        frmAddSchoolHomeworks.getContentPane().add(lblAddMessageSchoolHomeworks, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 290, 20));

        jLabel8.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("beyaztuğla.jpg"))); // NOI18N
        frmAddSchoolHomeworks.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 340));

        frmAddPersonalWorks.setMinimumSize(new java.awt.Dimension(450, 350));
        frmAddPersonalWorks.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAddSubjectPersonalWorks1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblAddSubjectPersonalWorks1.setText("Subject:");
        frmAddPersonalWorks.getContentPane().add(lblAddSubjectPersonalWorks1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 60, 30));

        tfAddSubjectPersonalWorks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAddSubjectPersonalWorksActionPerformed(evt);
            }
        });
        frmAddPersonalWorks.getContentPane().add(tfAddSubjectPersonalWorks, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 180, 30));

        lblAddMissionPersonalWorks1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblAddMissionPersonalWorks1.setText("Mission:");
        frmAddPersonalWorks.getContentPane().add(lblAddMissionPersonalWorks1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 60, 30));
        frmAddPersonalWorks.getContentPane().add(tfAddMissionPersonalWorks1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 180, 30));

        lblAddDueDatePersonalWorks1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblAddDueDatePersonalWorks1.setText("DueDate:");
        frmAddPersonalWorks.getContentPane().add(lblAddDueDatePersonalWorks1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, 30));

        lblAddisDonePersonalWorks1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblAddisDonePersonalWorks1.setText("isDone:");
        frmAddPersonalWorks.getContentPane().add(lblAddisDonePersonalWorks1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, 30));
        frmAddPersonalWorks.getContentPane().add(tfAddDueDatePersonalWorks1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 180, 30));
        frmAddPersonalWorks.getContentPane().add(chbAddisDonePersonalWorks1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, 30));

        btnAddPersonalWorks1.setBackground(new java.awt.Color(51, 51, 51));
        btnAddPersonalWorks1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnAddPersonalWorks1.setForeground(new java.awt.Color(255, 255, 255));
        btnAddPersonalWorks1.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("icons8-add-48.png"))); // NOI18N
        btnAddPersonalWorks1.setText("Add");
        btnAddPersonalWorks1.setBorderPainted(false);
        btnAddPersonalWorks1.setFocusable(false);
        btnAddPersonalWorks1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPersonalWorks1ActionPerformed(evt);
            }
        });
        frmAddPersonalWorks.getContentPane().add(btnAddPersonalWorks1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 170, 50));

        lblAddMessagePersonalWorks.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        frmAddPersonalWorks.getContentPane().add(lblAddMessagePersonalWorks, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 200, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("beyaztuğla.jpg"))); // NOI18N
        frmAddPersonalWorks.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 340));

        frmAddGoals.setMinimumSize(new java.awt.Dimension(450, 350));
        frmAddGoals.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAddSubjectGoals1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblAddSubjectGoals1.setText("Subject:");
        frmAddGoals.getContentPane().add(lblAddSubjectGoals1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 60, 30));

        tfAddSubjectGoals1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAddSubjectGoals1ActionPerformed(evt);
            }
        });
        frmAddGoals.getContentPane().add(tfAddSubjectGoals1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 180, 30));

        lblAddMissionGoals1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblAddMissionGoals1.setText("Mission:");
        frmAddGoals.getContentPane().add(lblAddMissionGoals1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 60, 30));
        frmAddGoals.getContentPane().add(tfAddMissionGoals1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 180, 30));

        lblAddDueDateGoals1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblAddDueDateGoals1.setText("DueDate:");
        frmAddGoals.getContentPane().add(lblAddDueDateGoals1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, 30));

        lblAddisDoneGoals1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblAddisDoneGoals1.setText("isDone:");
        frmAddGoals.getContentPane().add(lblAddisDoneGoals1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, 30));
        frmAddGoals.getContentPane().add(tfAddDueDateGoals1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 180, 30));
        frmAddGoals.getContentPane().add(chbAddisDoneGoals1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, 30));

        btnAddGoals1.setBackground(new java.awt.Color(51, 51, 51));
        btnAddGoals1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnAddGoals1.setForeground(new java.awt.Color(255, 255, 255));
        btnAddGoals1.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("icons8-add-48.png"))); // NOI18N
        btnAddGoals1.setText("Add");
        btnAddGoals1.setBorderPainted(false);
        btnAddGoals1.setFocusable(false);
        btnAddGoals1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddGoals1ActionPerformed(evt);
            }
        });
        frmAddGoals.getContentPane().add(btnAddGoals1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 170, 50));

        lblAddMessageGoals.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        frmAddGoals.getContentPane().add(lblAddMessageGoals, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 200, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("beyaztuğla.jpg"))); // NOI18N
        frmAddGoals.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 340));

        frmAddBooksToRead.setMinimumSize(new java.awt.Dimension(450, 350));
        frmAddBooksToRead.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAddBookNameBooksToRead.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblAddBookNameBooksToRead.setText("BookName:");
        frmAddBooksToRead.getContentPane().add(lblAddBookNameBooksToRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, 30));

        tfAddBookNameBooksToRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAddBookNameBooksToReadActionPerformed(evt);
            }
        });
        frmAddBooksToRead.getContentPane().add(tfAddBookNameBooksToRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 180, 30));

        lblAddAuthorBooksToRead.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblAddAuthorBooksToRead.setText("Author:");
        frmAddBooksToRead.getContentPane().add(lblAddAuthorBooksToRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 60, 30));
        frmAddBooksToRead.getContentPane().add(tfAddAuthorBooksToRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 180, 30));

        lblAddNumberOfPageBooksToRead.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblAddNumberOfPageBooksToRead.setText("Number Of Pages:");
        frmAddBooksToRead.getContentPane().add(lblAddNumberOfPageBooksToRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 30));

        lblAddisDoneBooksToRead.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblAddisDoneBooksToRead.setText("isDone:");
        frmAddBooksToRead.getContentPane().add(lblAddisDoneBooksToRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, 30));
        frmAddBooksToRead.getContentPane().add(tfAddNumberOfPagesBooksToRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 180, 30));
        frmAddBooksToRead.getContentPane().add(chbAddisDoneBooksToRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, 30));

        btnAddBooksToRead1.setBackground(new java.awt.Color(51, 51, 51));
        btnAddBooksToRead1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnAddBooksToRead1.setForeground(new java.awt.Color(255, 255, 255));
        btnAddBooksToRead1.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("icons8-add-48.png"))); // NOI18N
        btnAddBooksToRead1.setText("Add");
        btnAddBooksToRead1.setBorderPainted(false);
        btnAddBooksToRead1.setFocusable(false);
        btnAddBooksToRead1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBooksToRead1ActionPerformed(evt);
            }
        });
        frmAddBooksToRead.getContentPane().add(btnAddBooksToRead1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 170, 50));

        lblAddMessageBooksToRead.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        frmAddBooksToRead.getContentPane().add(lblAddMessageBooksToRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 200, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("beyaztuğla.jpg"))); // NOI18N
        frmAddBooksToRead.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 340));

        frmUpdateSchoolHomeworks.setMinimumSize(new java.awt.Dimension(450, 350));
        frmUpdateSchoolHomeworks.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUpdateSubjectSchoolHomeworks.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblUpdateSubjectSchoolHomeworks.setText("Subject:");
        frmUpdateSchoolHomeworks.getContentPane().add(lblUpdateSubjectSchoolHomeworks, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 60, 30));

        tfUpdateSubjectSchoolHomeworks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUpdateSubjectSchoolHomeworksActionPerformed(evt);
            }
        });
        frmUpdateSchoolHomeworks.getContentPane().add(tfUpdateSubjectSchoolHomeworks, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 180, 30));

        lblUpdateMissionSchoolHomeworks.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblUpdateMissionSchoolHomeworks.setText("Mission:");
        frmUpdateSchoolHomeworks.getContentPane().add(lblUpdateMissionSchoolHomeworks, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 60, 30));
        frmUpdateSchoolHomeworks.getContentPane().add(tfUpdateMissionSchoolHomeworks, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 180, 30));

        lblUpdateDueDateSchoolHomeworks.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblUpdateDueDateSchoolHomeworks.setText("DueDate:");
        frmUpdateSchoolHomeworks.getContentPane().add(lblUpdateDueDateSchoolHomeworks, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, 30));

        lblUpdateisDoneSchoolHomeworks.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblUpdateisDoneSchoolHomeworks.setText("isDone:");
        frmUpdateSchoolHomeworks.getContentPane().add(lblUpdateisDoneSchoolHomeworks, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, 30));
        frmUpdateSchoolHomeworks.getContentPane().add(tfUpdateDueDateSchoolHomeworks, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 180, 30));
        frmUpdateSchoolHomeworks.getContentPane().add(chbUpdateisDoneSchoolHomeworks, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, 30));

        btnUpdateSchoolHomeworks1.setBackground(new java.awt.Color(51, 51, 51));
        btnUpdateSchoolHomeworks1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnUpdateSchoolHomeworks1.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateSchoolHomeworks1.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("icons8-available-updates-48.png"))); // NOI18N
        btnUpdateSchoolHomeworks1.setText("Update");
        btnUpdateSchoolHomeworks1.setBorderPainted(false);
        btnUpdateSchoolHomeworks1.setFocusable(false);
        btnUpdateSchoolHomeworks1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateSchoolHomeworks1ActionPerformed(evt);
            }
        });
        frmUpdateSchoolHomeworks.getContentPane().add(btnUpdateSchoolHomeworks1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 170, 50));

        lblUpdateIDSchoolHomeworks.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblUpdateIDSchoolHomeworks.setText("ID:");
        frmUpdateSchoolHomeworks.getContentPane().add(lblUpdateIDSchoolHomeworks, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 60, 30));

        tfUpdateIDSchoolHomeworks.setEditable(false);
        tfUpdateIDSchoolHomeworks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUpdateIDSchoolHomeworksActionPerformed(evt);
            }
        });
        frmUpdateSchoolHomeworks.getContentPane().add(tfUpdateIDSchoolHomeworks, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 180, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("beyaztuğla.jpg"))); // NOI18N
        frmUpdateSchoolHomeworks.getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 340));

        frmUpdatePersonalWorks.setMinimumSize(new java.awt.Dimension(450, 350));
        frmUpdatePersonalWorks.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUpdateSubjectPersonalWorks.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblUpdateSubjectPersonalWorks.setText("Subject:");
        frmUpdatePersonalWorks.getContentPane().add(lblUpdateSubjectPersonalWorks, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 60, 30));

        tfUpdateSubjectPersonalWorks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUpdateSubjectPersonalWorksActionPerformed(evt);
            }
        });
        frmUpdatePersonalWorks.getContentPane().add(tfUpdateSubjectPersonalWorks, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 180, 30));

        lblUpdateMissionPersonalWorks.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblUpdateMissionPersonalWorks.setText("Mission:");
        frmUpdatePersonalWorks.getContentPane().add(lblUpdateMissionPersonalWorks, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 60, 30));
        frmUpdatePersonalWorks.getContentPane().add(tfUpdateMissionPersonalWorks, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 180, 30));

        lblUpdateDueDatePersonalWorks.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblUpdateDueDatePersonalWorks.setText("DueDate:");
        frmUpdatePersonalWorks.getContentPane().add(lblUpdateDueDatePersonalWorks, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, 30));

        lblUpdateisDonePersonalWorks.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblUpdateisDonePersonalWorks.setText("isDone:");
        frmUpdatePersonalWorks.getContentPane().add(lblUpdateisDonePersonalWorks, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, 30));
        frmUpdatePersonalWorks.getContentPane().add(tfUpdateDueDatePersonalWorks, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 180, 30));
        frmUpdatePersonalWorks.getContentPane().add(chbUpdateisDonePersonalWorks, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, 30));

        btnUpdatePersonalWorks1.setBackground(new java.awt.Color(51, 51, 51));
        btnUpdatePersonalWorks1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnUpdatePersonalWorks1.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdatePersonalWorks1.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("icons8-available-updates-48.png"))); // NOI18N
        btnUpdatePersonalWorks1.setText("Update");
        btnUpdatePersonalWorks1.setBorderPainted(false);
        btnUpdatePersonalWorks1.setFocusable(false);
        btnUpdatePersonalWorks1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePersonalWorks1ActionPerformed(evt);
            }
        });
        frmUpdatePersonalWorks.getContentPane().add(btnUpdatePersonalWorks1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 170, 50));

        lblUpdateIDPersonalWorks.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblUpdateIDPersonalWorks.setText("ID:");
        frmUpdatePersonalWorks.getContentPane().add(lblUpdateIDPersonalWorks, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 60, 30));

        tfUpdateIDPersonalWorks.setEditable(false);
        tfUpdateIDPersonalWorks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUpdateIDPersonalWorksActionPerformed(evt);
            }
        });
        frmUpdatePersonalWorks.getContentPane().add(tfUpdateIDPersonalWorks, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 180, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("beyaztuğla.jpg"))); // NOI18N
        frmUpdatePersonalWorks.getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 340));

        frmUpdateGoals.setMinimumSize(new java.awt.Dimension(450, 350));
        frmUpdateGoals.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUpdateSubjectGoals.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblUpdateSubjectGoals.setText("Subject:");
        frmUpdateGoals.getContentPane().add(lblUpdateSubjectGoals, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 60, 30));

        tfUpdateSubjectGoals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUpdateSubjectGoalsActionPerformed(evt);
            }
        });
        frmUpdateGoals.getContentPane().add(tfUpdateSubjectGoals, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 180, 30));

        lblUpdateMissionGoals.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblUpdateMissionGoals.setText("Mission:");
        frmUpdateGoals.getContentPane().add(lblUpdateMissionGoals, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 60, 30));
        frmUpdateGoals.getContentPane().add(tfUpdateMissionGoals, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 180, 30));

        lblUpdateDueDateGoals.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblUpdateDueDateGoals.setText("DueDate:");
        frmUpdateGoals.getContentPane().add(lblUpdateDueDateGoals, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, 30));

        lblUpdateisDoneGoals.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblUpdateisDoneGoals.setText("isDone:");
        frmUpdateGoals.getContentPane().add(lblUpdateisDoneGoals, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, 30));
        frmUpdateGoals.getContentPane().add(tfUpdateDueDateGoals, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 180, 30));
        frmUpdateGoals.getContentPane().add(chbUpdateisDoneGoals, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, 30));

        btnUpdateGoals1.setBackground(new java.awt.Color(0, 0, 0));
        btnUpdateGoals1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnUpdateGoals1.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateGoals1.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("icons8-available-updates-48.png"))); // NOI18N
        btnUpdateGoals1.setText("Update");
        btnUpdateGoals1.setBorderPainted(false);
        btnUpdateGoals1.setFocusable(false);
        btnUpdateGoals1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateGoals1ActionPerformed(evt);
            }
        });
        frmUpdateGoals.getContentPane().add(btnUpdateGoals1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 170, 50));

        lblUpdateIDGoals.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblUpdateIDGoals.setText("ID:");
        frmUpdateGoals.getContentPane().add(lblUpdateIDGoals, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 60, 30));

        tfUpdateIDGoals.setEditable(false);
        tfUpdateIDGoals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUpdateIDGoalsActionPerformed(evt);
            }
        });
        frmUpdateGoals.getContentPane().add(tfUpdateIDGoals, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 180, 30));

        jLabel14.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("beyaztuğla.jpg"))); // NOI18N
        frmUpdateGoals.getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 340));

        frmUpdateBooksToRead.setMinimumSize(new java.awt.Dimension(450, 350));
        frmUpdateBooksToRead.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUpdateBookNameBooksToRead.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblUpdateBookNameBooksToRead.setText("BookName:");
        frmUpdateBooksToRead.getContentPane().add(lblUpdateBookNameBooksToRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 80, 30));

        tfUpdateBookNameBooksToRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUpdateBookNameBooksToReadActionPerformed(evt);
            }
        });
        frmUpdateBooksToRead.getContentPane().add(tfUpdateBookNameBooksToRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 180, 30));

        lblUpdateAuthorBooksToRead.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblUpdateAuthorBooksToRead.setText("Author:");
        frmUpdateBooksToRead.getContentPane().add(lblUpdateAuthorBooksToRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 60, 30));
        frmUpdateBooksToRead.getContentPane().add(tfUpdateAuthorBooksToRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 180, 30));

        lblUpdateNumberOfPageBooksToRead.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblUpdateNumberOfPageBooksToRead.setText("Number Of Pages:");
        frmUpdateBooksToRead.getContentPane().add(lblUpdateNumberOfPageBooksToRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, 30));

        lblUpdateisDoneBooksToRead.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblUpdateisDoneBooksToRead.setText("isDone:");
        frmUpdateBooksToRead.getContentPane().add(lblUpdateisDoneBooksToRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, 30));
        frmUpdateBooksToRead.getContentPane().add(tfUpdateNumberOfPagesBooksToRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 180, 30));
        frmUpdateBooksToRead.getContentPane().add(chbUpdateisDoneBooksToRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, 30));

        btnUpdateBooksToRead1.setBackground(new java.awt.Color(51, 51, 51));
        btnUpdateBooksToRead1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnUpdateBooksToRead1.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateBooksToRead1.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("icons8-available-updates-48.png"))); // NOI18N
        btnUpdateBooksToRead1.setText("Update");
        btnUpdateBooksToRead1.setBorderPainted(false);
        btnUpdateBooksToRead1.setFocusable(false);
        btnUpdateBooksToRead1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateBooksToRead1ActionPerformed(evt);
            }
        });
        frmUpdateBooksToRead.getContentPane().add(btnUpdateBooksToRead1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 170, 50));

        lblUpdateBookNameBooksToRead1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblUpdateBookNameBooksToRead1.setText("ID:");
        frmUpdateBooksToRead.getContentPane().add(lblUpdateBookNameBooksToRead1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, 30));

        tfUpdateIDBooksToRead.setEditable(false);
        tfUpdateIDBooksToRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUpdateIDBooksToReadActionPerformed(evt);
            }
        });
        frmUpdateBooksToRead.getContentPane().add(tfUpdateIDBooksToRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 180, 30));

        lblUpdateMessageBooksToRead.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        frmUpdateBooksToRead.getContentPane().add(lblUpdateMessageBooksToRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 200, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("beyaztuğla.jpg"))); // NOI18N
        frmUpdateBooksToRead.getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 340));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ToDoList");
        setBackground(new java.awt.Color(51, 0, 102));
        setMinimumSize(new java.awt.Dimension(1102, 758));
        setPreferredSize(new java.awt.Dimension(1102, 758));
        setSize(new java.awt.Dimension(1, 1));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        splitPane.setBackground(new java.awt.Color(255, 255, 255));
        splitPane.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        splitPane.setDividerSize(1);
        splitPane.setForeground(new java.awt.Color(255, 255, 255));
        splitPane.setMinimumSize(new java.awt.Dimension(846, 660));
        splitPane.setOpaque(false);
        splitPane.setPreferredSize(new java.awt.Dimension(846, 660));

        jPanel5.setBackground(new java.awt.Color(51, 0, 102));
        jPanel5.setForeground(new java.awt.Color(51, 0, 102));
        jPanel5.setPreferredSize(new java.awt.Dimension(230, 313));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHomePage.setBackground(new java.awt.Color(255, 255, 255));
        btnHomePage.setFont(new java.awt.Font("Imprint MT Shadow", 0, 18)); // NOI18N
        btnHomePage.setForeground(new java.awt.Color(153, 51, 0));
        btnHomePage.setIcon(new ImageIcon(this.getClass().getResource("/icons8-home-48.png"))); // NOI18N
        btnHomePage.setText("Home Page");
        btnHomePage.setFocusPainted(false);
        btnHomePage.setOpaque(false);
        btnHomePage.setSelected(true);
        btnHomePage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomePageActionPerformed(evt);
            }
        });
        jPanel5.add(btnHomePage, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 40, 300, 49));

        btnPersonalWorks.setBackground(new java.awt.Color(255, 255, 255));
        btnPersonalWorks.setFont(new java.awt.Font("Imprint MT Shadow", 0, 18)); // NOI18N
        btnPersonalWorks.setForeground(new java.awt.Color(153, 51, 0));
        btnPersonalWorks.setIcon(new ImageIcon(this.getClass().getResource("icons8-laptop-48.png"))); // NOI18N
        btnPersonalWorks.setText("Personal Works");
        btnPersonalWorks.setBorderPainted(false);
        btnPersonalWorks.setFocusPainted(false);
        btnPersonalWorks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonalWorksActionPerformed(evt);
            }
        });
        jPanel5.add(btnPersonalWorks, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 180, 260, 49));

        btnGoals.setBackground(new java.awt.Color(255, 255, 255));
        btnGoals.setFont(new java.awt.Font("Imprint MT Shadow", 0, 18)); // NOI18N
        btnGoals.setForeground(new java.awt.Color(153, 51, 0));
        btnGoals.setIcon(new ImageIcon(this.getClass().getResource("icons8-goal-48.png"))); // NOI18N
        btnGoals.setText("Goals");
        btnGoals.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btnGoals.setBorderPainted(false);
        btnGoals.setFocusPainted(false);
        btnGoals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoalsActionPerformed(evt);
            }
        });
        jPanel5.add(btnGoals, new org.netbeans.lib.awtextra.AbsoluteConstraints(-110, 250, 340, 49));

        btnBooksToRead.setBackground(new java.awt.Color(255, 255, 255));
        btnBooksToRead.setFont(new java.awt.Font("Imprint MT Shadow", 0, 18)); // NOI18N
        btnBooksToRead.setForeground(new java.awt.Color(153, 51, 0));
        btnBooksToRead.setIcon(new ImageIcon(this.getClass().getResource("icons8-bookmark-48.png"))); // NOI18N
        btnBooksToRead.setText("Books To Read");
        btnBooksToRead.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBooksToRead.setFocusPainted(false);
        btnBooksToRead.setOpaque(false);
        btnBooksToRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBooksToReadActionPerformed(evt);
            }
        });
        jPanel5.add(btnBooksToRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 320, 270, 49));

        btnSchoolHomeworks.setBackground(new java.awt.Color(255, 255, 255));
        btnSchoolHomeworks.setFont(new java.awt.Font("Imprint MT Shadow", 0, 18)); // NOI18N
        btnSchoolHomeworks.setForeground(new java.awt.Color(153, 51, 0));
        btnSchoolHomeworks.setIcon(new ImageIcon(this.getClass().getResource("icons8-school-48.png"))); // NOI18N
        btnSchoolHomeworks.setText("School Homeworks");
        btnSchoolHomeworks.setFocusPainted(false);
        btnSchoolHomeworks.setOpaque(false);
        btnSchoolHomeworks.setSelected(true);
        btnSchoolHomeworks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSchoolHomeworksActionPerformed(evt);
            }
        });
        jPanel5.add(btnSchoolHomeworks, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 110, 260, 49));

        jLabel6.setIcon(new ImageIcon(this.getClass().getResource("v462-n-130-textureidea_1 (1).jpg"))); // NOI18N
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 230, 550));

        jLabel7.setIcon(new ImageIcon(this.getClass().getResource("v462-n-130-textureidea_1 (1).jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 410, -1, -1));

        splitPane.setLeftComponent(jPanel5);

        pnlCardLayout.setBackground(new java.awt.Color(255, 255, 255));
        pnlCardLayout.setPreferredSize(new java.awt.Dimension(610, 660));
        pnlCardLayout.setLayout(new java.awt.CardLayout());
        jLabel1 = new javax.swing.JLabel();
        pnlCardLayout.add(jLabel1, "name_173824879732100");
        
                jLabel1.setIcon(new ImageIcon(this.getClass().getResource("homepage-concept-scribble-keywords-icons-doodle-35696257.jpg")));

        pnlHomePage.setBackground(new java.awt.Color(255, 255, 255));
        pnlHomePage.setMinimumSize(new java.awt.Dimension(610, 510));
        pnlHomePage.setPreferredSize(new java.awt.Dimension(610, 510));
        pnlHomePage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSchoolHomeworks1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        lblSchoolHomeworks1.setText("Home Page");
        lblSchoolHomeworks1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pnlHomePage.add(lblSchoolHomeworks1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 110, 30));

        pnlCardLayout.add(pnlHomePage, "pnlHomePage");

        pnlSchoolHomeworks.setBackground(new java.awt.Color(255, 255, 255));
        pnlSchoolHomeworks.setMinimumSize(new java.awt.Dimension(610, 510));
        pnlSchoolHomeworks.setPreferredSize(new java.awt.Dimension(610, 510));
        pnlSchoolHomeworks.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSchoolHomeworks.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        lblSchoolHomeworks.setText("School Homeworks");
        lblSchoolHomeworks.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pnlSchoolHomeworks.add(lblSchoolHomeworks, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 180, 30));

        tblSchoolHomeworks.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        tblSchoolHomeworks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Subject", "Mission", "DueDate", "isDone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSchoolHomeworks.setFillsViewportHeight(true);
        tblSchoolHomeworks.setSelectionBackground(new java.awt.Color(255, 51, 51));
        tblSchoolHomeworks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblSchoolHomeworks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSchoolHomeworksMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSchoolHomeworks);
        if (tblSchoolHomeworks.getColumnModel().getColumnCount() > 0) {
            tblSchoolHomeworks.getColumnModel().getColumn(3).setResizable(false);
            tblSchoolHomeworks.getColumnModel().getColumn(4).setResizable(false);
        }

        pnlSchoolHomeworks.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 830, 330));

        lblSearch3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblSearch3.setText("Search:");
        pnlSchoolHomeworks.add(lblSearch3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 30));

        tfSearch3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSearch3KeyReleased(evt);
            }
        });
        pnlSchoolHomeworks.add(tfSearch3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 280, 30));

        btnAddSchoolHomeworks.setBackground(Color.DARK_GRAY);
        btnAddSchoolHomeworks.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnAddSchoolHomeworks.setForeground(new java.awt.Color(255, 255, 255));
        btnAddSchoolHomeworks.setIcon(new ImageIcon(this.getClass().getResource("icons8-add-48.png"))); // NOI18N
        btnAddSchoolHomeworks.setText("Add");
        btnAddSchoolHomeworks.setBorderPainted(false);
        btnAddSchoolHomeworks.setFocusable(false);
        btnAddSchoolHomeworks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSchoolHomeworksActionPerformed(evt);
            }
        });
        pnlSchoolHomeworks.add(btnAddSchoolHomeworks, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 170, 50));

        btnUpdateSchoolHomeworks.setBackground(Color.DARK_GRAY);
        btnUpdateSchoolHomeworks.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnUpdateSchoolHomeworks.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateSchoolHomeworks.setIcon(new ImageIcon(this.getClass().getResource("icons8-available-updates-48.png"))); // NOI18N
        btnUpdateSchoolHomeworks.setText("Update");
        btnUpdateSchoolHomeworks.setBorderPainted(false);
        btnUpdateSchoolHomeworks.setFocusable(false);
        btnUpdateSchoolHomeworks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateSchoolHomeworksActionPerformed(evt);
            }
        });
        pnlSchoolHomeworks.add(btnUpdateSchoolHomeworks, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 550, 170, 50));

        btnDeleteSchoolHomeworks.setBackground(Color.DARK_GRAY);
        btnDeleteSchoolHomeworks.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnDeleteSchoolHomeworks.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteSchoolHomeworks.setIcon(new ImageIcon(this.getClass().getResource("icons8-delete-48.png"))); // NOI18N
        btnDeleteSchoolHomeworks.setText("Delete");
        btnDeleteSchoolHomeworks.setBorderPainted(false);
        btnDeleteSchoolHomeworks.setFocusable(false);
        btnDeleteSchoolHomeworks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSchoolHomeworksActionPerformed(evt);
            }
        });
        pnlSchoolHomeworks.add(btnDeleteSchoolHomeworks, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 550, 170, 50));

        pnlCardLayout.add(pnlSchoolHomeworks, "pnlSchoolHomeworks");

        pnlPersonalWorks.setBackground(new java.awt.Color(255, 255, 255));
        pnlPersonalWorks.setMinimumSize(new java.awt.Dimension(610, 510));
        pnlPersonalWorks.setPreferredSize(new java.awt.Dimension(610, 510));
        pnlPersonalWorks.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPersonalWorks.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        lblPersonalWorks.setText("Personal Works");
        lblPersonalWorks.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pnlPersonalWorks.add(lblPersonalWorks, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, -1, -1));

        tblPersonalWorks.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        tblPersonalWorks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Subject", "Mission", "DueDate", "isDone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPersonalWorks.setFillsViewportHeight(true);
        tblPersonalWorks.setGridColor(new java.awt.Color(153, 153, 255));
        tblPersonalWorks.setRowSelectionAllowed(true);
        tblPersonalWorks.setSelectionBackground(new java.awt.Color(255, 51, 51));
        tblPersonalWorks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(tblPersonalWorks);
        if (tblPersonalWorks.getColumnModel().getColumnCount() > 0) {
            tblPersonalWorks.getColumnModel().getColumn(0).setResizable(false);
            tblPersonalWorks.getColumnModel().getColumn(1).setResizable(false);
            tblPersonalWorks.getColumnModel().getColumn(2).setResizable(false);
            tblPersonalWorks.getColumnModel().getColumn(3).setResizable(false);
            tblPersonalWorks.getColumnModel().getColumn(4).setResizable(false);
        }

        pnlPersonalWorks.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 830, 330));

        lblSearch2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblSearch2.setText("Search:");
        pnlPersonalWorks.add(lblSearch2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 30));

        tfSearch2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSearch2KeyReleased(evt);
            }
        });
        pnlPersonalWorks.add(tfSearch2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 280, 30));

        btnAddPersonalWorks.setBackground(Color.DARK_GRAY);
        btnAddPersonalWorks.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnAddPersonalWorks.setForeground(new java.awt.Color(255, 255, 255));
        btnAddPersonalWorks.setIcon(new ImageIcon(this.getClass().getResource("icons8-add-48.png"))); // NOI18N
        btnAddPersonalWorks.setText("Add");
        btnAddPersonalWorks.setBorderPainted(false);
        btnAddPersonalWorks.setFocusable(false);
        btnAddPersonalWorks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPersonalWorksActionPerformed(evt);
            }
        });
        pnlPersonalWorks.add(btnAddPersonalWorks, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 170, 50));

        btnDeletePersonalWorks.setBackground(Color.DARK_GRAY);
        btnDeletePersonalWorks.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnDeletePersonalWorks.setForeground(new java.awt.Color(255, 255, 255));
        btnDeletePersonalWorks.setIcon(new ImageIcon(this.getClass().getResource("icons8-delete-48.png"))); // NOI18N
        btnDeletePersonalWorks.setText("Delete");
        btnDeletePersonalWorks.setBorderPainted(false);
        btnDeletePersonalWorks.setFocusable(false);
        btnDeletePersonalWorks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePersonalWorksActionPerformed(evt);
            }
        });
        pnlPersonalWorks.add(btnDeletePersonalWorks, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 550, 170, 50));

        btnUpdatePersonalWorks.setBackground(Color.DARK_GRAY);
        btnUpdatePersonalWorks.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnUpdatePersonalWorks.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdatePersonalWorks.setIcon(new ImageIcon(this.getClass().getResource("icons8-available-updates-48.png"))); // NOI18N
        btnUpdatePersonalWorks.setText("Update");
        btnUpdatePersonalWorks.setBorderPainted(false);
        btnUpdatePersonalWorks.setFocusable(false);
        btnUpdatePersonalWorks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePersonalWorksActionPerformed(evt);
            }
        });
        pnlPersonalWorks.add(btnUpdatePersonalWorks, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 550, 170, 50));

        pnlCardLayout.add(pnlPersonalWorks, "pnlPersonalWorks");

        pnlGoals.setBackground(new java.awt.Color(255, 255, 255));
        pnlGoals.setMinimumSize(new java.awt.Dimension(610, 510));
        pnlGoals.setPreferredSize(new java.awt.Dimension(610, 510));
        pnlGoals.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblGoals.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        lblGoals.setText("Goals");
        lblGoals.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pnlGoals.add(lblGoals, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, -1, 30));

        tblGoals.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        tblGoals.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Subject", "Mission", "DueDate", "isDone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGoals.setFillsViewportHeight(true);
        tblGoals.setSelectionBackground(new java.awt.Color(255, 51, 51));
        tblGoals.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblGoals.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblGoals);
        if (tblGoals.getColumnModel().getColumnCount() > 0) {
            tblGoals.getColumnModel().getColumn(4).setResizable(false);
        }

        pnlGoals.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 830, 330));

        lblSearch1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblSearch1.setText("Search:");
        pnlGoals.add(lblSearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 30));

        tfSearch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSearch1KeyReleased(evt);
            }
        });
        pnlGoals.add(tfSearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 280, 30));

        btnAddGoals.setBackground(Color.DARK_GRAY);
        btnAddGoals.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnAddGoals.setForeground(new java.awt.Color(255, 255, 255));
        btnAddGoals.setIcon(new ImageIcon(this.getClass().getResource("icons8-add-48.png"))); // NOI18N
        btnAddGoals.setText("Add");
        btnAddGoals.setBorderPainted(false);
        btnAddGoals.setFocusable(false);
        btnAddGoals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddGoalsActionPerformed(evt);
            }
        });
        pnlGoals.add(btnAddGoals, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 170, 50));

        btnDeleteGoals.setBackground(Color.DARK_GRAY);
        btnDeleteGoals.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnDeleteGoals.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteGoals.setIcon(new ImageIcon(this.getClass().getResource("icons8-delete-48.png"))); // NOI18N
        btnDeleteGoals.setText("Delete");
        btnDeleteGoals.setBorderPainted(false);
        btnDeleteGoals.setFocusable(false);
        btnDeleteGoals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteGoalsActionPerformed(evt);
            }
        });
        pnlGoals.add(btnDeleteGoals, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 550, 170, 50));

        btnUpdateGoals.setBackground(Color.DARK_GRAY);
        btnUpdateGoals.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnUpdateGoals.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateGoals.setIcon(new ImageIcon(this.getClass().getResource("icons8-available-updates-48.png"))); // NOI18N
        btnUpdateGoals.setText("Update");
        btnUpdateGoals.setBorderPainted(false);
        btnUpdateGoals.setFocusable(false);
        btnUpdateGoals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateGoalsActionPerformed(evt);
            }
        });
        pnlGoals.add(btnUpdateGoals, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 550, 170, 50));

        pnlCardLayout.add(pnlGoals, "pnlGoals");

        pnlBooksToRead.setBackground(new java.awt.Color(255, 255, 255));
        pnlBooksToRead.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        pnlBooksToRead.setMinimumSize(new java.awt.Dimension(610, 510));
        pnlBooksToRead.setPreferredSize(new java.awt.Dimension(610, 510));
        pnlBooksToRead.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBooksToRead.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        lblBooksToRead.setText("Books To Read");
        lblBooksToRead.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pnlBooksToRead.add(lblBooksToRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 140, -1));

        tfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSearchKeyReleased(evt);
            }
        });
        pnlBooksToRead.add(tfSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 280, 30));

        lblSearch.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblSearch.setText("Search:");
        pnlBooksToRead.add(lblSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 30));

        btnAddBooksToRead.setBackground(Color.DARK_GRAY);
        btnAddBooksToRead.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnAddBooksToRead.setForeground(new java.awt.Color(255, 255, 255));
        btnAddBooksToRead.setIcon(new ImageIcon(this.getClass().getResource("icons8-add-48.png"))); // NOI18N
        btnAddBooksToRead.setText("Add");
        btnAddBooksToRead.setBorderPainted(false);
        btnAddBooksToRead.setFocusable(false);
        btnAddBooksToRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBooksToReadActionPerformed(evt);
            }
        });
        pnlBooksToRead.add(btnAddBooksToRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 170, 50));

        jScrollPane3.setPreferredSize(new java.awt.Dimension(300, 0));

        tblBooksToRead.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        tblBooksToRead.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "BookName", "Author", "NumberOfPages", "isDone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBooksToRead.setFillsViewportHeight(true);
        tblBooksToRead.setGridColor(new java.awt.Color(204, 0, 0));
        tblBooksToRead.setSelectionBackground(new java.awt.Color(255, 51, 51));
        tblBooksToRead.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblBooksToRead.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblBooksToRead.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblBooksToRead);
        if (tblBooksToRead.getColumnModel().getColumnCount() > 0) {
            tblBooksToRead.getColumnModel().getColumn(0).setResizable(false);
            tblBooksToRead.getColumnModel().getColumn(1).setResizable(false);
            tblBooksToRead.getColumnModel().getColumn(2).setResizable(false);
            tblBooksToRead.getColumnModel().getColumn(3).setResizable(false);
            tblBooksToRead.getColumnModel().getColumn(4).setResizable(false);
        }

        pnlBooksToRead.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 830, 330));

        btnUpdateBooksToRead.setBackground(Color.DARK_GRAY);
        btnUpdateBooksToRead.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnUpdateBooksToRead.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateBooksToRead.setIcon(new ImageIcon(this.getClass().getResource("icons8-available-updates-48.png"))); // NOI18N
        btnUpdateBooksToRead.setText("Update");
        btnUpdateBooksToRead.setBorderPainted(false);
        btnUpdateBooksToRead.setFocusable(false);
        btnUpdateBooksToRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateBooksToReadActionPerformed(evt);
            }
        });
        pnlBooksToRead.add(btnUpdateBooksToRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 550, 170, 50));

        btnDeleteBooksToRead.setBackground(Color.DARK_GRAY);
        btnDeleteBooksToRead.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnDeleteBooksToRead.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteBooksToRead.setIcon(new ImageIcon(this.getClass().getResource("icons8-delete-48.png"))); // NOI18N
        btnDeleteBooksToRead.setText("Delete");
        btnDeleteBooksToRead.setBorderPainted(false);
        btnDeleteBooksToRead.setFocusPainted(false);
        btnDeleteBooksToRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBooksToReadActionPerformed(evt);
            }
        });
        pnlBooksToRead.add(btnDeleteBooksToRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 550, 170, 50));

        pnlCardLayout.add(pnlBooksToRead, "pnlBooksToRead");

        splitPane.setRightComponent(pnlCardLayout);

        getContentPane().add(splitPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 760));

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomePageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomePageActionPerformed
        cardLayout.show(pnlCardLayout,"pnlHomePage");
    }//GEN-LAST:event_btnHomePageActionPerformed

    private void btnPersonalWorksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonalWorksActionPerformed
        cardLayout.show(pnlCardLayout,"pnlPersonalWorks");
        PersonalWorks();
    }//GEN-LAST:event_btnPersonalWorksActionPerformed

    private void btnGoalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoalsActionPerformed
        cardLayout.show(pnlCardLayout,"pnlGoals");
      Goals();
    }//GEN-LAST:event_btnGoalsActionPerformed

    private void btnBooksToReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBooksToReadActionPerformed
        cardLayout.show(pnlCardLayout,"pnlBooksToRead");
      BooksToRead();
    }//GEN-LAST:event_btnBooksToReadActionPerformed

    private void btnSchoolHomeworksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSchoolHomeworksActionPerformed
       cardLayout.show(pnlCardLayout,"pnlSchoolHomeworks");
     SchoolHomeworks();
    }//GEN-LAST:event_btnSchoolHomeworksActionPerformed

    private void tfSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyReleased
    String searchKey = tfSearch.getText();
    TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>(model_BooksToRead);
    tblBooksToRead.setRowSorter(tableRowSorter);
    tableRowSorter.setRowFilter(RowFilter.regexFilter(searchKey));
    }//GEN-LAST:event_tfSearchKeyReleased

    private void tfSearch1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearch1KeyReleased
        String searchKey1 = tfSearch.getText();
    TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>(model_Goals);
    tblGoals.setRowSorter(tableRowSorter);
    tableRowSorter.setRowFilter(RowFilter.regexFilter(searchKey1));
    }//GEN-LAST:event_tfSearch1KeyReleased

    private void tfSearch2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearch2KeyReleased
       String searchKey2 = tfSearch.getText();
    TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>(model_PersonalWorks);
    tblPersonalWorks.setRowSorter(tableRowSorter);
    tableRowSorter.setRowFilter(RowFilter.regexFilter(searchKey2));
    }//GEN-LAST:event_tfSearch2KeyReleased

    private void tfSearch3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearch3KeyReleased
        String searchKey3 = tfSearch.getText();
    TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>(model_SchoolHomeworks);
    tblSchoolHomeworks.setRowSorter(tableRowSorter);
    tableRowSorter.setRowFilter(RowFilter.regexFilter(searchKey3));
    }//GEN-LAST:event_tfSearch3KeyReleased

    private void btnAddBooksToReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBooksToReadActionPerformed
        frmAddBooksToRead.setLocationRelativeTo(null);
        frmAddBooksToRead.setVisible(true);
        
    }//GEN-LAST:event_btnAddBooksToReadActionPerformed

    private void btnAddSchoolHomeworksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSchoolHomeworksActionPerformed
      frmAddSchoolHomeworks.setLocationRelativeTo(null);
        frmAddSchoolHomeworks.setVisible(true);
    }//GEN-LAST:event_btnAddSchoolHomeworksActionPerformed

    private void btnAddPersonalWorksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPersonalWorksActionPerformed
       frmAddPersonalWorks.setLocationRelativeTo(null);
        frmAddPersonalWorks.setVisible(true);
        
    }//GEN-LAST:event_btnAddPersonalWorksActionPerformed

    private void btnAddGoalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddGoalsActionPerformed
        frmAddGoals.setLocationRelativeTo(null);
        frmAddGoals.setVisible(true);
        
    }//GEN-LAST:event_btnAddGoalsActionPerformed

    
	private void btnDeletePersonalWorksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePersonalWorksActionPerformed
 
        if(tblPersonalWorks.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(this,"Please select the mission you want to delete.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        else{
        
        Connection connection=null;
        DBHelper dbHelper = new DBHelper();
        PreparedStatement statement=null;
        try{
            
            connection=dbHelper.getConnection();
            String sql1 = "DELETE from personalworks where ID=?";//the codes at the bottom sort the contents after deleting them.
            String sql2 = "SET @num := 0";
            String sql3 = "UPDATE personalworks SET ID = @num := (@num+1)";
            String sql4 = "ALTER TABLE personalworks AUTO_INCREMENT = 1";
            statement = connection.prepareStatement(sql1);
            statement.setObject(1,tblPersonalWorks.getValueAt(tblPersonalWorks.getSelectedRow(),0));
            int result = statement.executeUpdate();
            statement = connection.prepareStatement(sql2);
            result= statement.executeUpdate();
            statement = connection.prepareStatement(sql3);
            result= statement.executeUpdate();
            statement = connection.prepareStatement(sql4);
            result= statement.executeUpdate();
            PersonalWorks();//recalls the model of personalworks to renew the table.
            JOptionPane.showMessageDialog(this,"Selected mission has been succesfully deleted.", "Success",JOptionPane.PLAIN_MESSAGE);

        }
        catch(SQLException exception){
            dbHelper.showErrorMessage(exception);
        }
        finally{
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(frmToDoList.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        }
    }//GEN-LAST:event_btnDeletePersonalWorksActionPerformed

    private void btnUpdatePersonalWorksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePersonalWorksActionPerformed

         if (tblPersonalWorks.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(this,"Please select the mission to update.", "Information",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
        frmUpdatePersonalWorks.setLocationRelativeTo(null);
        frmUpdatePersonalWorks.setVisible(true);
        tfUpdateIDPersonalWorks.setText(tblPersonalWorks.getValueAt(tblPersonalWorks.getSelectedRow(),0).toString());
        tfUpdateSubjectPersonalWorks.setText((String) tblPersonalWorks.getValueAt(tblPersonalWorks.getSelectedRow(),1));
        tfUpdateMissionPersonalWorks.setText((String) tblPersonalWorks.getValueAt(tblPersonalWorks.getSelectedRow(),2));
        tfUpdateDueDatePersonalWorks.setText((String)tblPersonalWorks.getValueAt(tblPersonalWorks.getSelectedRow(),3));
        boolean check=(Boolean)tblPersonalWorks.getValueAt(tblPersonalWorks.getSelectedRow(),4);
        chbUpdateisDonePersonalWorks.setSelected(check);
         }
    }//GEN-LAST:event_btnUpdatePersonalWorksActionPerformed

    private void btnUpdateSchoolHomeworksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateSchoolHomeworksActionPerformed
        
         if (tblSchoolHomeworks.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(this,"Please select the mission to update.", "Information",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
        frmUpdateSchoolHomeworks.setLocationRelativeTo(null);
        frmUpdateSchoolHomeworks.setVisible(true);
        tfUpdateIDSchoolHomeworks.setText(tblSchoolHomeworks.getValueAt(tblSchoolHomeworks.getSelectedRow(),0).toString());
        tfUpdateSubjectSchoolHomeworks.setText((String) tblSchoolHomeworks.getValueAt(tblSchoolHomeworks.getSelectedRow(),1));
        tfUpdateMissionSchoolHomeworks.setText((String) tblSchoolHomeworks.getValueAt(tblSchoolHomeworks.getSelectedRow(),2));
        tfUpdateDueDateSchoolHomeworks.setText((String)tblSchoolHomeworks.getValueAt(tblSchoolHomeworks.getSelectedRow(),3));
        boolean check=(Boolean)tblSchoolHomeworks.getValueAt(tblSchoolHomeworks.getSelectedRow(),4);
        chbUpdateisDoneSchoolHomeworks.setSelected(check);
         }
    }//GEN-LAST:event_btnUpdateSchoolHomeworksActionPerformed

    private void btnDeleteSchoolHomeworksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSchoolHomeworksActionPerformed
        
        if(tblSchoolHomeworks.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(this,"Please select the mission you want to delete.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        else{
        
        Connection connection=null;
        DBHelper dbHelper = new DBHelper();
        PreparedStatement statement=null;
        try{
            int row=tblSchoolHomeworks.getSelectedRow();
            int column=tblSchoolHomeworks.getSelectedColumn();
            connection=dbHelper.getConnection();
            String sql1 = "DELETE from schoolhomeworks where ID=?";//the codes at the bottom sort the contents after deleting them.
            String sql2 = "SET @num := 0";
            String sql3 = "UPDATE schoolhomeworks SET ID = @num := (@num+1)";
            String sql4 = "ALTER TABLE schoolhomeworks AUTO_INCREMENT = 1";
            statement = connection.prepareStatement(sql1);
            statement.setObject(1,tblSchoolHomeworks.getValueAt(tblSchoolHomeworks.getSelectedRow(),0));
            int result = statement.executeUpdate();
            statement = connection.prepareStatement(sql2);
            result= statement.executeUpdate();
            statement = connection.prepareStatement(sql3);
            result= statement.executeUpdate();
            statement = connection.prepareStatement(sql4);
            result= statement.executeUpdate();
            SchoolHomeworks();//recalls the model of schoolhomeworks to renew the table.
            JOptionPane.showMessageDialog(this,"Selected mission has been succesfully deleted.", "Success",JOptionPane.PLAIN_MESSAGE);
            

        }
        catch(SQLException exception){
            dbHelper.showErrorMessage(exception);
        }
        finally{
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(frmToDoList.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        }
    }//GEN-LAST:event_btnDeleteSchoolHomeworksActionPerformed

    private void btnDeleteGoalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteGoalsActionPerformed
        if(tblGoals.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(this,"Please select the mission you want to delete.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        else{
        
        Connection connection=null;
        DBHelper dbHelper = new DBHelper();
        PreparedStatement statement=null;
        try{
            int row=tblGoals.getSelectedRow();
            int column=tblGoals.getSelectedColumn();
            connection=dbHelper.getConnection();
            String sql1 = "DELETE from goals where ID=?";//the codes at the bottom sort the contents after deleting them.
            String sql2 = "SET @num := 0";
            String sql3 = "UPDATE goals SET ID = @num := (@num+1)";
            String sql4 = "ALTER TABLE goals AUTO_INCREMENT = 1";
            statement = connection.prepareStatement(sql1);
            statement.setObject(1,tblGoals.getValueAt(tblGoals.getSelectedRow(),0));
            int result = statement.executeUpdate();
            statement = connection.prepareStatement(sql2);
            result= statement.executeUpdate();
            statement = connection.prepareStatement(sql3);
            result= statement.executeUpdate();
            statement = connection.prepareStatement(sql4);
            result= statement.executeUpdate();
            
            Goals();//recalls the model of goals to renew the table.
            JOptionPane.showMessageDialog(this,"Selected mission has been succesfully deleted.", "Success",JOptionPane.PLAIN_MESSAGE);
            

        }
        catch(SQLException exception){
            dbHelper.showErrorMessage(exception);
        }
        finally{
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(frmToDoList.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        }
    }//GEN-LAST:event_btnDeleteGoalsActionPerformed

    private void btnUpdateGoalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateGoalsActionPerformed
       
        if (tblGoals.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(this,"Please select the mission to update.", "Information",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            frmUpdateGoals.setLocationRelativeTo(null);
        frmUpdateGoals.setVisible(true);
        tfUpdateIDGoals.setText(tblGoals.getValueAt(tblGoals.getSelectedRow(),0).toString());
        tfUpdateSubjectGoals.setText((String) tblGoals.getValueAt(tblGoals.getSelectedRow(),1));
        tfUpdateMissionGoals.setText((String) tblGoals.getValueAt(tblGoals.getSelectedRow(),2));
        tfUpdateDueDateGoals.setText((String)tblGoals.getValueAt(tblGoals.getSelectedRow(),3));
        boolean check=(Boolean)tblGoals.getValueAt(tblGoals.getSelectedRow(),4);
        chbUpdateisDoneGoals.setSelected(check);}
    }//GEN-LAST:event_btnUpdateGoalsActionPerformed

    private void btnUpdateBooksToReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateBooksToReadActionPerformed
     
        
         if (tblBooksToRead.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(this,"Please select the book to update.", "Information",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
             frmUpdateBooksToRead.setLocationRelativeTo(null);
        frmUpdateBooksToRead.setVisible(true);
        tfUpdateIDBooksToRead.setText(tblBooksToRead.getValueAt(tblBooksToRead.getSelectedRow(),0).toString());
        tfUpdateBookNameBooksToRead.setText((String) tblBooksToRead.getValueAt(tblBooksToRead.getSelectedRow(),1));
        tfUpdateAuthorBooksToRead.setText((String) tblBooksToRead.getValueAt(tblBooksToRead.getSelectedRow(),2));
        tfUpdateNumberOfPagesBooksToRead.setText(tblBooksToRead.getValueAt(tblBooksToRead.getSelectedRow(),3).toString());
        boolean check=(Boolean)tblBooksToRead.getValueAt(tblBooksToRead.getSelectedRow(),4);
        chbUpdateisDoneBooksToRead.setSelected(check);
         }
    }//GEN-LAST:event_btnUpdateBooksToReadActionPerformed

    private void btnDeleteBooksToReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBooksToReadActionPerformed
        if(tblBooksToRead.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(this,"Please select the book you want to delete.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        else{
        
        Connection connection=null;
        DBHelper dbHelper = new DBHelper();
        PreparedStatement statement=null;
        try{
            int row=tblBooksToRead.getSelectedRow();
            int column=tblBooksToRead.getSelectedColumn();
            connection=dbHelper.getConnection();
            String sql1 = "DELETE from bookstoread where ID=?";//the codes at the bottom sort the contents after deleting them.
            String sql2 = "SET @num := 0";
            String sql3 = "UPDATE bookstoread SET ID = @num := (@num+1)";
            String sql4 = "ALTER TABLE bookstoread AUTO_INCREMENT = 1";
            statement = connection.prepareStatement(sql1);
            statement.setObject(1,tblBooksToRead.getValueAt(tblBooksToRead.getSelectedRow(),0));
            int result = statement.executeUpdate();
            statement = connection.prepareStatement(sql2);
            result= statement.executeUpdate();
            statement = connection.prepareStatement(sql3);
            result= statement.executeUpdate();
            statement = connection.prepareStatement(sql4);
            result= statement.executeUpdate();
            BooksToRead();//recalls the model of bookstoread to renew the table.
            JOptionPane.showMessageDialog(this,"Selected book has been succesfully deleted.", "Success",JOptionPane.PLAIN_MESSAGE);

        }
        catch(SQLException exception){
            dbHelper.showErrorMessage(exception);
        }
        finally{
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(frmToDoList.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        }
    }//GEN-LAST:event_btnDeleteBooksToReadActionPerformed

    private void tfAddSubjectSchoolHomeworks1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAddSubjectSchoolHomeworks1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAddSubjectSchoolHomeworks1ActionPerformed

    private void btnAddSchoolHomeworks1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSchoolHomeworks1ActionPerformed
       if(tfAddSubjectSchoolHomeworks1.getText().equals("") || tfAddMissionSchoolHomeworks1.getText().equals("") || tfAddDueDateSchoolHomeworks1.getText().equals("")){
         JOptionPane.showMessageDialog(this,"Please fill in all the blanks."," Error",JOptionPane.ERROR_MESSAGE);   
        }
        else{
        
        
        Connection connection=null;
        DBHelper dbHelper = new DBHelper();
        PreparedStatement statement=null;
        try{
            connection=dbHelper.getConnection();
            String sql = "insert into schoolhomeworks(Subject,Mission,DueDate,Done)values(?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,tfAddSubjectSchoolHomeworks1.getText());
            statement.setString(2,tfAddMissionSchoolHomeworks1.getText());
            statement.setString(3,tfAddDueDateSchoolHomeworks1.getText());
            statement.setBoolean(4, chbAddisDoneSchoolHomeworks1.isSelected());
            int result = statement.executeUpdate();
            SchoolHomeworks();

        }
        catch(SQLException exception){
            dbHelper.showErrorMessage(exception);
        }
        finally{
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(frmToDoList.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        }
    
    }//GEN-LAST:event_btnAddSchoolHomeworks1ActionPerformed

    private void tfAddSubjectPersonalWorksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAddSubjectPersonalWorksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAddSubjectPersonalWorksActionPerformed

    private void btnAddPersonalWorks1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPersonalWorks1ActionPerformed
        if(tfAddSubjectPersonalWorks.getText().equals("") || tfAddMissionPersonalWorks1.getText().equals("") || tfAddDueDatePersonalWorks1.getText().equals("")){
           JOptionPane.showMessageDialog(this,"Please fill in all the blanks."," Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
        
        Connection connection=null;
        DBHelper dbHelper = new DBHelper();
        PreparedStatement statement=null;
        try{
            connection=dbHelper.getConnection();
            String sql = "insert into personalworks(Subject,Mission,DueDate,Done)values(?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,tfAddSubjectPersonalWorks.getText());
            statement.setString(2,tfAddMissionPersonalWorks1.getText());
            statement.setString(3,tfAddDueDatePersonalWorks1.getText());
            statement.setBoolean(4, chbAddisDonePersonalWorks1.isSelected());
            int result = statement.executeUpdate();
            PersonalWorks();

        }
        catch(SQLException exception){
            dbHelper.showErrorMessage(exception);
        }
        finally{
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(frmToDoList.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        }
                      
    }//GEN-LAST:event_btnAddPersonalWorks1ActionPerformed

    private void tfAddSubjectGoals1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAddSubjectGoals1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAddSubjectGoals1ActionPerformed

    private void btnAddGoals1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddGoals1ActionPerformed
         if(tfAddSubjectGoals1.getText().equals("") || tfAddMissionGoals1.getText().equals("") || tfAddDueDateGoals1.getText().equals("")){
           JOptionPane.showMessageDialog(this,"Please fill in all the blanks."," Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
       
        Connection connection=null;
        DBHelper dbHelper = new DBHelper();
        PreparedStatement statement=null;
        try{
            connection=dbHelper.getConnection();
            String sql = "insert into goals(Subject,Mission,DueDate,Done)values(?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,tfAddSubjectGoals1.getText());
            statement.setString(2,tfAddMissionGoals1.getText());
            statement.setString(3,tfAddDueDateGoals1.getText());
            statement.setBoolean(4, chbAddisDoneGoals1.isSelected());
            int result = statement.executeUpdate();
            Goals();

        }
        catch(SQLException exception){
            dbHelper.showErrorMessage(exception);
        }
        finally{
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(frmToDoList.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
          }
    }//GEN-LAST:event_btnAddGoals1ActionPerformed

    private void tfAddBookNameBooksToReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAddBookNameBooksToReadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAddBookNameBooksToReadActionPerformed

    private void btnAddBooksToRead1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBooksToRead1ActionPerformed
        try{
        if(tfAddBookNameBooksToRead.getText().equals("") || tfAddAuthorBooksToRead.getText().equals("") || tfAddNumberOfPagesBooksToRead.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Please fill in all the blanks."," Error",JOptionPane.ERROR_MESSAGE);
        }
       
   
        else{




        Connection connection=null;
        DBHelper dbHelper = new DBHelper();
        PreparedStatement statement=null;
        try{
            connection=dbHelper.getConnection();
            String sql = "insert into bookstoread(BookName,Author,NumberOfPages,Done)values(?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,tfAddBookNameBooksToRead.getText());
            statement.setString(2,tfAddAuthorBooksToRead.getText());
            statement.setInt(3,Integer.valueOf(tfAddNumberOfPagesBooksToRead.getText()));
            statement.setBoolean(4, chbAddisDoneBooksToRead.isSelected());
            int result = statement.executeUpdate();
            BooksToRead();

        }
        catch(SQLException exception){
            dbHelper.showErrorMessage(exception);
        }
        finally{
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(frmToDoList.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        }
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this,"Please enter the correct number of page."," Error",JOptionPane.ERROR_MESSAGE);
            
        }
    }//GEN-LAST:event_btnAddBooksToRead1ActionPerformed

    private void tfUpdateSubjectSchoolHomeworksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUpdateSubjectSchoolHomeworksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUpdateSubjectSchoolHomeworksActionPerformed

    private void btnUpdateSchoolHomeworks1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateSchoolHomeworks1ActionPerformed
       if(tfUpdateSubjectSchoolHomeworks.getText().equals("") || tfUpdateMissionSchoolHomeworks.getText().equals("") || tfUpdateDueDateSchoolHomeworks.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Please fill in all the blanks."," Error",JOptionPane.ERROR_MESSAGE);
            
        }
        else{




        Connection connection=null;
        DBHelper dbHelper = new DBHelper();
        PreparedStatement statement=null;
        try{
            connection=dbHelper.getConnection();
            String sql1 = "update schoolhomeworks set Subject=? where ID=?";
            String sql2 = "update schoolhomeworks set Mission=? where ID=?";
            String sql3 = "update schoolhomeworks set DueDate=? where ID=?";
            String sql4 = "update schoolhomeworks set Done=? where ID=?";
                    
            statement = connection.prepareStatement(sql1);
            statement.setString(1,tfUpdateSubjectSchoolHomeworks.getText());
            statement.setInt(2,Integer.valueOf(tfUpdateIDSchoolHomeworks.getText()));
            int result = statement.executeUpdate();
            statement = connection.prepareStatement(sql2);
            statement.setString(1,tfUpdateMissionSchoolHomeworks.getText());
            statement.setInt(2,Integer.valueOf(tfUpdateIDSchoolHomeworks.getText()));
            result = statement.executeUpdate();
            statement = connection.prepareStatement(sql3);
            statement.setString(1,tfUpdateDueDateSchoolHomeworks.getText());
            statement.setInt(2,Integer.valueOf(tfUpdateIDSchoolHomeworks.getText()));
            result = statement.executeUpdate();
            statement = connection.prepareStatement(sql4);
            statement.setBoolean(1, chbUpdateisDoneSchoolHomeworks.isSelected());
            statement.setInt(2,Integer.valueOf(tfUpdateIDSchoolHomeworks.getText()));
            result = statement.executeUpdate();
            JOptionPane.showMessageDialog(this,"Successfully Updated", "Success",JOptionPane.PLAIN_MESSAGE);
            SchoolHomeworks();

        }
        catch(SQLException exception){
            dbHelper.showErrorMessage(exception);
        }
        finally{
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(frmToDoList.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        }
    }//GEN-LAST:event_btnUpdateSchoolHomeworks1ActionPerformed

    private void tfUpdateSubjectPersonalWorksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUpdateSubjectPersonalWorksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUpdateSubjectPersonalWorksActionPerformed

    private void btnUpdatePersonalWorks1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePersonalWorks1ActionPerformed
        if(tfUpdateSubjectPersonalWorks.getText().equals("") || tfUpdateMissionPersonalWorks.getText().equals("") || tfUpdateDueDatePersonalWorks.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Please fill in all the blanks."," Error",JOptionPane.ERROR_MESSAGE);
            
        }
        else{




        Connection connection=null;
        DBHelper dbHelper = new DBHelper();
        PreparedStatement statement=null;
        try{
            connection=dbHelper.getConnection();
            String sql1 = "update personalworks set Subject=? where ID=?";
            String sql2 = "update personalworks set Mission=? where ID=?";
            String sql3 = "update personalworks set DueDate=? where ID=?";
            String sql4 = "update personalworks set Done=? where ID=?";
                    
            statement = connection.prepareStatement(sql1);
            statement.setString(1,tfUpdateSubjectPersonalWorks.getText());
            statement.setInt(2,Integer.valueOf(tfUpdateIDPersonalWorks.getText()));
            int result = statement.executeUpdate();
            statement = connection.prepareStatement(sql2);
            statement.setString(1,tfUpdateMissionPersonalWorks.getText());
            statement.setInt(2,Integer.valueOf(tfUpdateIDPersonalWorks.getText()));
            result = statement.executeUpdate();
            statement = connection.prepareStatement(sql3);
            statement.setString(1,tfUpdateDueDatePersonalWorks.getText());
            statement.setInt(2,Integer.valueOf(tfUpdateIDPersonalWorks.getText()));
            result = statement.executeUpdate();
            statement = connection.prepareStatement(sql4);
            statement.setBoolean(1, chbUpdateisDonePersonalWorks.isSelected());
            statement.setInt(2,Integer.valueOf(tfUpdateIDPersonalWorks.getText()));
            result = statement.executeUpdate();
            JOptionPane.showMessageDialog(this,"Successfully Updated", "Success",JOptionPane.PLAIN_MESSAGE);
            PersonalWorks();

        }
        catch(SQLException exception){
            dbHelper.showErrorMessage(exception);
        }
        finally{
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(frmToDoList.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        }
    }//GEN-LAST:event_btnUpdatePersonalWorks1ActionPerformed

    private void tfUpdateSubjectGoalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUpdateSubjectGoalsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUpdateSubjectGoalsActionPerformed

    private void btnUpdateGoals1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateGoals1ActionPerformed
         if(tfUpdateSubjectGoals.getText().equals("") || tfUpdateMissionGoals.getText().equals("") || tfUpdateDueDateGoals.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Please fill in all the blanks."," Error",JOptionPane.ERROR_MESSAGE);
            
        }
        else{




        Connection connection=null;
        DBHelper dbHelper = new DBHelper();
        PreparedStatement statement=null;
        try{
            connection=dbHelper.getConnection();
            String sql1 = "update goals set Subject=? where ID=?";
            String sql2 = "update goals set Mission=? where ID=?";
            String sql3 = "update goals set DueDate=? where ID=?";
            String sql4 = "update goals set Done=? where ID=?";
                    
            statement = connection.prepareStatement(sql1);
            statement.setString(1,tfUpdateSubjectGoals.getText());
            statement.setInt(2,Integer.valueOf(tfUpdateIDGoals.getText()));
            int result = statement.executeUpdate();
            statement = connection.prepareStatement(sql2);
            statement.setString(1,tfUpdateMissionGoals.getText());
            statement.setInt(2,Integer.valueOf(tfUpdateIDGoals.getText()));
            result = statement.executeUpdate();
            statement = connection.prepareStatement(sql3);
            statement.setString(1,(tfUpdateDueDateGoals.getText()));
            statement.setInt(2,Integer.valueOf(tfUpdateIDGoals.getText()));
            result = statement.executeUpdate();
            statement = connection.prepareStatement(sql4);
            statement.setBoolean(1, chbUpdateisDoneGoals.isSelected());
            statement.setInt(2,Integer.valueOf(tfUpdateIDGoals.getText()));
            result = statement.executeUpdate();
            JOptionPane.showMessageDialog(this,"Successfully Updated", "Success",JOptionPane.PLAIN_MESSAGE);
            Goals();

        }
        catch(SQLException exception){
            dbHelper.showErrorMessage(exception);
        }
        finally{
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(frmToDoList.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        }
    }//GEN-LAST:event_btnUpdateGoals1ActionPerformed

    private void tfUpdateBookNameBooksToReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUpdateBookNameBooksToReadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUpdateBookNameBooksToReadActionPerformed

    private void btnUpdateBooksToRead1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateBooksToRead1ActionPerformed
         if(tfUpdateBookNameBooksToRead.getText().equals("") || tfUpdateAuthorBooksToRead.getText().equals("") || tfUpdateNumberOfPagesBooksToRead.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Please fill in all the blanks."," Error",JOptionPane.ERROR_MESSAGE);
            
        }
        else{
        



        Connection connection=null;
        DBHelper dbHelper = new DBHelper();
        PreparedStatement statement=null;
        try{
            connection=dbHelper.getConnection();
            String sql1 = "update bookstoread set BookName=? where ID=?";
            String sql2 = "update bookstoread set Author=? where ID=?";
            String sql3 = "update bookstoread set NumberOfPages=? where ID=?";
            String sql4 = "update bookstoread set Done=? where ID=?";
                    
            statement = connection.prepareStatement(sql1);
            statement.setString(1,tfUpdateBookNameBooksToRead.getText());
            statement.setInt(2,Integer.valueOf(tfUpdateIDBooksToRead.getText()));
            int result = statement.executeUpdate();
            statement = connection.prepareStatement(sql2);
            statement.setString(1,tfUpdateAuthorBooksToRead.getText());
            statement.setInt(2,Integer.valueOf(tfUpdateIDBooksToRead.getText()));
            result = statement.executeUpdate();
            statement = connection.prepareStatement(sql3);
            statement.setInt(1,Integer.valueOf(tfUpdateNumberOfPagesBooksToRead.getText()));
            statement.setInt(2,Integer.valueOf(tfUpdateIDBooksToRead.getText()));
            result = statement.executeUpdate();
            statement = connection.prepareStatement(sql4);
            statement.setBoolean(1, chbUpdateisDoneBooksToRead.isSelected());
            statement.setInt(2,Integer.valueOf(tfUpdateIDBooksToRead.getText()));
            result = statement.executeUpdate();
            JOptionPane.showMessageDialog(this,"Successfully Updated", "Success",JOptionPane.PLAIN_MESSAGE);
            BooksToRead();

        }
        catch(SQLException exception){
            dbHelper.showErrorMessage(exception);
        }
        finally{
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(frmToDoList.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        }
    }//GEN-LAST:event_btnUpdateBooksToRead1ActionPerformed

    private void tfUpdateIDSchoolHomeworksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUpdateIDSchoolHomeworksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUpdateIDSchoolHomeworksActionPerformed

    private void tfUpdateIDPersonalWorksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUpdateIDPersonalWorksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUpdateIDPersonalWorksActionPerformed

    private void tfUpdateIDGoalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUpdateIDGoalsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUpdateIDGoalsActionPerformed

    private void tfUpdateIDBooksToReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUpdateIDBooksToReadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUpdateIDBooksToReadActionPerformed

    private void tblSchoolHomeworksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSchoolHomeworksMouseClicked
        System.out.println(tblPersonalWorks.getComponents());
    }//GEN-LAST:event_tblSchoolHomeworksMouseClicked

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
            java.util.logging.Logger.getLogger(frmToDoList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmToDoList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmToDoList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmToDoList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
           
                new frmToDoList().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddBooksToRead;
    private javax.swing.JButton btnAddBooksToRead1;
    private javax.swing.JButton btnAddGoals;
    private javax.swing.JButton btnAddGoals1;
    private javax.swing.JButton btnAddPersonalWorks;
    private javax.swing.JButton btnAddPersonalWorks1;
    private javax.swing.JButton btnAddSchoolHomeworks;
    private javax.swing.JButton btnAddSchoolHomeworks1;
    private javax.swing.JButton btnBooksToRead;
    private javax.swing.JButton btnDeleteBooksToRead;
    private javax.swing.JButton btnDeleteGoals;
    private javax.swing.JButton btnDeletePersonalWorks;
    private javax.swing.JButton btnDeleteSchoolHomeworks;
    private javax.swing.JButton btnGoals;
    private javax.swing.JButton btnHomePage;
    private javax.swing.JButton btnPersonalWorks;
    private javax.swing.JButton btnSchoolHomeworks;
    private javax.swing.JButton btnUpdateBooksToRead;
    private javax.swing.JButton btnUpdateBooksToRead1;
    private javax.swing.JButton btnUpdateGoals;
    private javax.swing.JButton btnUpdateGoals1;
    private javax.swing.JButton btnUpdatePersonalWorks;
    private javax.swing.JButton btnUpdatePersonalWorks1;
    private javax.swing.JButton btnUpdateSchoolHomeworks;
    private javax.swing.JButton btnUpdateSchoolHomeworks1;
    private javax.swing.JCheckBox chbAddisDoneBooksToRead;
    private javax.swing.JCheckBox chbAddisDoneGoals1;
    private javax.swing.JCheckBox chbAddisDonePersonalWorks1;
    private javax.swing.JCheckBox chbAddisDoneSchoolHomeworks1;
    private javax.swing.JCheckBox chbUpdateisDoneBooksToRead;
    private javax.swing.JCheckBox chbUpdateisDoneGoals;
    private javax.swing.JCheckBox chbUpdateisDonePersonalWorks;
    private javax.swing.JCheckBox chbUpdateisDoneSchoolHomeworks;
    private javax.swing.JFrame frmAddBooksToRead;
    private javax.swing.JFrame frmAddGoals;
    private javax.swing.JFrame frmAddPersonalWorks;
    private javax.swing.JFrame frmAddSchoolHomeworks;
    private javax.swing.JFrame frmUpdateBooksToRead;
    private javax.swing.JFrame frmUpdateGoals;
    private javax.swing.JFrame frmUpdatePersonalWorks;
    private javax.swing.JFrame frmUpdateSchoolHomeworks;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblAddAuthorBooksToRead;
    private javax.swing.JLabel lblAddBookNameBooksToRead;
    private javax.swing.JLabel lblAddDueDateGoals1;
    private javax.swing.JLabel lblAddDueDatePersonalWorks1;
    private javax.swing.JLabel lblAddDueDateSchoolHomeworks1;
    private javax.swing.JLabel lblAddMessageBooksToRead;
    private javax.swing.JLabel lblAddMessageGoals;
    private javax.swing.JLabel lblAddMessagePersonalWorks;
    private javax.swing.JLabel lblAddMessageSchoolHomeworks;
    private javax.swing.JLabel lblAddMissionGoals1;
    private javax.swing.JLabel lblAddMissionPersonalWorks1;
    private javax.swing.JLabel lblAddMissionSchoolHomeworks1;
    private javax.swing.JLabel lblAddNumberOfPageBooksToRead;
    private javax.swing.JLabel lblAddSubjectGoals1;
    private javax.swing.JLabel lblAddSubjectPersonalWorks1;
    private javax.swing.JLabel lblAddSubjectSchoolHomeworks1;
    private javax.swing.JLabel lblAddisDoneBooksToRead;
    private javax.swing.JLabel lblAddisDoneGoals1;
    private javax.swing.JLabel lblAddisDonePersonalWorks1;
    private javax.swing.JLabel lblAddisDoneSchoolHomeworks1;
    private javax.swing.JLabel lblBooksToRead;
    private javax.swing.JLabel lblGoals;
    private javax.swing.JLabel lblPersonalWorks;
    private javax.swing.JLabel lblSchoolHomeworks;
    private javax.swing.JLabel lblSchoolHomeworks1;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblSearch1;
    private javax.swing.JLabel lblSearch2;
    private javax.swing.JLabel lblSearch3;
    private javax.swing.JLabel lblUpdateAuthorBooksToRead;
    private javax.swing.JLabel lblUpdateBookNameBooksToRead;
    private javax.swing.JLabel lblUpdateBookNameBooksToRead1;
    private javax.swing.JLabel lblUpdateDueDateGoals;
    private javax.swing.JLabel lblUpdateDueDatePersonalWorks;
    private javax.swing.JLabel lblUpdateDueDateSchoolHomeworks;
    private javax.swing.JLabel lblUpdateIDGoals;
    private javax.swing.JLabel lblUpdateIDPersonalWorks;
    private javax.swing.JLabel lblUpdateIDSchoolHomeworks;
    private javax.swing.JLabel lblUpdateMessageBooksToRead;
    private javax.swing.JLabel lblUpdateMissionGoals;
    private javax.swing.JLabel lblUpdateMissionPersonalWorks;
    private javax.swing.JLabel lblUpdateMissionSchoolHomeworks;
    private javax.swing.JLabel lblUpdateNumberOfPageBooksToRead;
    private javax.swing.JLabel lblUpdateSubjectGoals;
    private javax.swing.JLabel lblUpdateSubjectPersonalWorks;
    private javax.swing.JLabel lblUpdateSubjectSchoolHomeworks;
    private javax.swing.JLabel lblUpdateisDoneBooksToRead;
    private javax.swing.JLabel lblUpdateisDoneGoals;
    private javax.swing.JLabel lblUpdateisDonePersonalWorks;
    private javax.swing.JLabel lblUpdateisDoneSchoolHomeworks;
    private javax.swing.JPanel pnlBooksToRead;
    private javax.swing.JPanel pnlCardLayout;
    private javax.swing.JPanel pnlGoals;
    private javax.swing.JPanel pnlHomePage;
    private javax.swing.JPanel pnlPersonalWorks;
    private javax.swing.JPanel pnlSchoolHomeworks;
    private javax.swing.JSplitPane splitPane;
    private javax.swing.JTable tblBooksToRead;
    private javax.swing.JTable tblGoals;
    private javax.swing.JTable tblPersonalWorks;
    private javax.swing.JTable tblSchoolHomeworks;
    private javax.swing.JTextField tfAddAuthorBooksToRead;
    private javax.swing.JTextField tfAddBookNameBooksToRead;
    private javax.swing.JTextField tfAddDueDateGoals1;
    private javax.swing.JTextField tfAddDueDatePersonalWorks1;
    private javax.swing.JTextField tfAddDueDateSchoolHomeworks1;
    private javax.swing.JTextField tfAddMissionGoals1;
    private javax.swing.JTextField tfAddMissionPersonalWorks1;
    private javax.swing.JTextField tfAddMissionSchoolHomeworks1;
    private javax.swing.JTextField tfAddNumberOfPagesBooksToRead;
    private javax.swing.JTextField tfAddSubjectGoals1;
    private javax.swing.JTextField tfAddSubjectPersonalWorks;
    private javax.swing.JTextField tfAddSubjectSchoolHomeworks1;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTextField tfSearch1;
    private javax.swing.JTextField tfSearch2;
    private javax.swing.JTextField tfSearch3;
    private javax.swing.JTextField tfUpdateAuthorBooksToRead;
    private javax.swing.JTextField tfUpdateBookNameBooksToRead;
    private javax.swing.JTextField tfUpdateDueDateGoals;
    private javax.swing.JTextField tfUpdateDueDatePersonalWorks;
    private javax.swing.JTextField tfUpdateDueDateSchoolHomeworks;
    private javax.swing.JTextField tfUpdateIDBooksToRead;
    private javax.swing.JTextField tfUpdateIDGoals;
    private javax.swing.JTextField tfUpdateIDPersonalWorks;
    private javax.swing.JTextField tfUpdateIDSchoolHomeworks;
    private javax.swing.JTextField tfUpdateMissionGoals;
    private javax.swing.JTextField tfUpdateMissionPersonalWorks;
    private javax.swing.JTextField tfUpdateMissionSchoolHomeworks;
    private javax.swing.JTextField tfUpdateNumberOfPagesBooksToRead;
    private javax.swing.JTextField tfUpdateSubjectGoals;
    private javax.swing.JTextField tfUpdateSubjectPersonalWorks;
    private javax.swing.JTextField tfUpdateSubjectSchoolHomeworks;
    // End of variables declaration//GEN-END:variables
}
