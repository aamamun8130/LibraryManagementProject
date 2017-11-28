/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author Abdur Rahman
 */
public class LBXMLController implements Initializable {
    //Database Controll
    static PreparedStatement ps = null;
    static Connection conn = null;
    public static void Connector() throws ClassNotFoundException, SQLException{
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:librarymanagement.sqlite");
    }
    //student optoin all design controll start from
    
        
    boolean login = false;
    int p;
    int q;
    
    @FXML
    private PasswordField st_pass,st_cpass;
    
    @FXML
    private TextField st_uname;
    
    @FXML
    private Label reg_warning;
    
    @FXML
    private JFXButton btn_regst;
    
    void clearCreateAccountField(){
        st_pass.setText("");
        st_cpass.setText("");
        st_uname.setText("");
    }
    void clearLoginField(){
        log_p_word_Id.setText("");
        log_u_name_Id.setText("");
    }
    int loc_std = 0;
    int fore_std = 0;
    ForeigenStudent f_std1;
    LocalStudent l_std1;
    
     @FXML
    void st_registration(ActionEvent event) {
        if(!st_pass.getText().equals(st_cpass.getText())){
            reg_warning.setText("Password Not Matched!!!");
        }
        else{
           reg_warning.setText("Submission Successful");
           if(fore_std==1){
               f_std1 = new ForeigenStudent(st_uname.getText(),st_pass.getText(),"foreigen");
               
           }
           if(loc_std==1){
               l_std1 = new LocalStudent(st_uname.getText(),st_pass.getText(),"local");
           }
           clearCreateAccountField();
        }
        
        
    }
    
    @FXML
    private JFXButton studentButton;

    @FXML
    private AnchorPane studentNavigation;

    @FXML
    private JFXButton createAccountButton;

    @FXML
    private JFXButton loginButton;

    @FXML
    private AnchorPane createAccountNavigation;
    
    @FXML
    private AnchorPane loginNavigation;
    
    @FXML
    private JFXButton loginbutton2;
    
    @FXML
    private Label logoutLavel;
    
    @FXML
    private AnchorPane plate;
    
    @FXML
    private AnchorPane bookSearchpane;
    
    @FXML
    void createAccountButtonAction(ActionEvent event) {
        createAccountNavigation.setVisible(true);
        loginNavigation.setVisible(false);
        p=2;
    }
     
    
    @FXML
    void loginButtonAction(ActionEvent event) {
       
         loginNavigation.setVisible(true);
        createAccountNavigation.setVisible(false);
        p=2;   
        
        
    }
     @FXML
    private AnchorPane std_typer;
    
    @FXML
    void studentButtonAction(ActionEvent event) {
       if(!login){
           std_typer.setVisible(true);
           login=true;
           q=1;
          
       }
    }
    
    
    @FXML
    void localButtonAction(ActionEvent event) {
        loc_std = 1;
        fore_std = 0;
        studentNavigation.setVisible(true);
        studentNavigation.setLayoutX(240);
        studentNavigation.setLayoutY(197);
        loginNavigation.setVisible(false);
        createAccountNavigation.setVisible(false);
    }
    @FXML
    void foreignButtonAction(ActionEvent event) {
        fore_std = 1;
        loc_std = 0;
        studentNavigation.setVisible(true);
        studentNavigation.setLayoutX(240);
        studentNavigation.setLayoutY(270);
        loginNavigation.setVisible(false);
        createAccountNavigation.setVisible(false);
    }
     @FXML
    void std_type_lavel_exit(MouseEvent event) {
        fore_std = 0;
        loc_std = 0;
     std_typer.setVisible(false);
     login=false;
     loginNavigation.setVisible(false);
     createAccountNavigation.setVisible(false);
     studentNavigation.setVisible(false);
     
    }
    
    @FXML
    private TextField log_u_name_Id;
      @FXML
    private PasswordField log_p_word_Id;
      
       @FXML
    private Label login_alarm;

    
    @FXML
    void loginButton2Action(ActionEvent event) {
        try {
           
        if(fore_std==1 && f_std1.getSTD_TYPE().equals("foreigen") && f_std1.getSTD_PASSWORD().equals(log_p_word_Id.getText()) && f_std1.getSTD_USERNAME().equals(log_u_name_Id.getText())){
            plate.setVisible(true);
            loginNavigation.setVisible(false);
            createAccountNavigation.setVisible(false);
            studentNavigation.setVisible(false);
            std_typer.setVisible(false);
            clearLoginField();
            login = true;
         }
         else  if (loc_std==1 && l_std1.getSTD_TYPE().equals("local") && l_std1.getSTD_USERNAME().equals(log_u_name_Id.getText()) && l_std1.getSTD_PASSWORD().equals(log_p_word_Id.getText()) ){
                 plate.setVisible(true);
            loginNavigation.setVisible(false);
            createAccountNavigation.setVisible(false);
            studentNavigation.setVisible(false);
            std_typer.setVisible(false);
            clearLoginField();
            login = true;
                 }
         else{
             
                login_alarm.setText("Alarm!!! Wrong Entry");
         }
        
        } catch (Exception e) {
            //here
            login_alarm.setText("Alarm!!! Something Wrong");
        } 
            
       
          
       }
    @FXML
    void logoutAction(MouseEvent event) {
        login = false;
        plate.setVisible(false);
        selmover.setVisible(true);
        selmover.setLayoutX(30.0);
        bookSearchpane.setVisible(true);
        yourlibinfo.setVisible(false);
        finelab.setVisible(false);
    }
    
    @FXML
    private Pane selmover;
    
    @FXML
    private Label lab1;

    @FXML
    private Label lab2;

    @FXML
    private Label lab3;
    
    @FXML
    private AnchorPane yourlibinfo;

    @FXML
    private AnchorPane finelab;
    
    @FXML
    private Label stdxlab1;
        
    @FXML
    private Label stdxlab2;
            
    @FXML
    private Label stdxlab3;
               
    
    @FXML
    void act1(MouseEvent event) {
        if(event.getSource() == lab1){
        selmover.setVisible(true);
        selmover.setLayoutX(30.0);
        bookSearchpane.setVisible(true);
        yourlibinfo.setVisible(false);
        finelab.setVisible(false);
        
        }
        else if(event.getSource() == lab2){
        selmover.setVisible(true);
        selmover.setLayoutX(154.0);
        yourlibinfo.setVisible(true);
        bookSearchpane.setVisible(false);
         finelab.setVisible(false);
        }
        else if(event.getSource() == lab3){
        selmover.setVisible(true);
        selmover.setLayoutX(270.0);
        finelab.setVisible(true);
        yourlibinfo.setVisible(false);
        bookSearchpane.setVisible(false);
        }
        else if(event.getSource() == stdxlab1){
            fore_std = 0;
            loc_std = 0;
            studentNavigation.setVisible(false);
            std_typer.setVisible(false);
            if(p!=2){
             login=false;   
            }
            q=0;
        }
        else if(event.getSource() == stdxlab2){
            createAccountNavigation.setVisible(false);
            
            if(q!=1){
             login=false;   
            }
            p=0;
            reg_warning.setText("");
            clearCreateAccountField();
            
        }
        else if(event.getSource() == stdxlab3){
            loginNavigation.setVisible(false);
            if(q!=1){
             login=false;   
            }
            p=0;
            login_alarm.setText("");
            clearLoginField();
        }

    }
    

    // student design control end................end
    
    
    // librarian design control start from..........
    
    @FXML
    private Label librarianNavigationExit;
    
    @FXML
    private Label lib_neg_exit;
        
    @FXML
    private AnchorPane librarianafterloginancorepane;
        
     @FXML
    void act2(MouseEvent event) {
        
        if(event.getSource()==librarianNavigationExit){
            librarianNavigation.setVisible(false);
            login=false;
        }
        else if(event.getSource()==lib_neg_exit){
            lib_neg_lab.setVisible(false);
            login=false;
            
        }
        

    }
    
    @FXML
    private AnchorPane librarianNavigation;
    
    @FXML
    private Pane lib_neg_lab;
    
    
    @FXML
    void librarianButtonAction(ActionEvent event) {
       if(!login){
           lib_neg_lab.setVisible(true);
         //librarianNavigation.setVisible(true);
         login=true;
       }
    }
    
    @FXML
    void seniorLibButtonAction(ActionEvent event){
        librarianNavigation.setVisible(true);
        lib_neg_lab.setVisible(false);
    }
    
    @FXML
    void juniorLibButtonAction(ActionEvent event){
        librarianNavigation.setVisible(true);
        lib_neg_lab.setVisible(false);
    }
    
    
    @FXML
    void librarianLoginAction(ActionEvent event) {
        librarianafterloginancorepane.setVisible(true);
         librarianNavigation.setVisible(false);
        
    }
    
    @FXML
    void librarianLogoutButtonAction(ActionEvent event) {
    librarianafterloginancorepane.setVisible(false);
    studentinfopane.setVisible(false);
    borrowbookpane.setVisible(false);
    submissionbookpane.setVisible(false);
    settingpane.setVisible(false);
    login=false;
    }
    
        @FXML
    private AnchorPane studentinfopane;

    @FXML
    private AnchorPane borrowbookpane;

    @FXML
    private AnchorPane submissionbookpane;

    @FXML
    private AnchorPane settingpane;
    
    @FXML
    void studentinfoButtonAction(ActionEvent event) {
        studentinfopane.setVisible(true);
        borrowbookpane.setVisible(false);
        submissionbookpane.setVisible(false);
        settingpane.setVisible(false);
    }
    @FXML
    void borrowbookButtonAction(ActionEvent event) {
        studentinfopane.setVisible(false);
        borrowbookpane.setVisible(true);
        submissionbookpane.setVisible(false);
        settingpane.setVisible(false);
    }

    @FXML
    void submissionbookButtonAction(ActionEvent event) {
        studentinfopane.setVisible(false);
        borrowbookpane.setVisible(false);
        submissionbookpane.setVisible(true);
        settingpane.setVisible(false);
    }
    
    
    @FXML
    void settingButtonAction(ActionEvent event) {
        studentinfopane.setVisible(false);
        borrowbookpane.setVisible(false);
        submissionbookpane.setVisible(false);
        settingpane.setVisible(true);
    }
    
      // librarian design control ..........end 
    
    
    // Accountant design control start from..........
  
    @FXML
    private JFXButton log;
    
    @FXML
    private Label accountantNavigationExit1;
    
        @FXML
    void accountantNavigationExit(MouseEvent event) {
        if(event.getSource()==accountantNavigationExit1){
          accountantNavigation.setVisible(false);
             login=false;  
        }

    }
    @FXML
    private AnchorPane accountantNavigation;
    
    @FXML
    void accountantButtonAction(ActionEvent event) {
        
        if(!login){
             accountantNavigation.setVisible(true);
             login=true;
        }

    }
    
    @FXML
    private AnchorPane accountantafterloginpane;
    
    
    @FXML
    void accountantLoginButtonAction(ActionEvent event) {
       accountantNavigation.setVisible(false); 
     accountantafterloginpane.setVisible(true);
    }
    
    @FXML
    void accountantSignoutButtonAction(ActionEvent event) {
     accountantafterloginpane.setVisible(false);
     login=false;
    }
    
    
    // Accountant design control ..........end 
    
    
    // Authority design control start from..........
    
    
    @FXML
    private AnchorPane authorityNavigation;
    
    @FXML
    private Pane aut_neg_lab;
    
    @FXML
    void authorityButtonAction(ActionEvent event) {
        if(!login){
            aut_neg_lab.setVisible(true);
         //authorityNavigation.setVisible(true);
         login=true;
        }
        
       }
    
    
    
    
    @FXML
    private Pane librarianSettingPane;

    @FXML
    private Pane studentSettingPane;


    @FXML
    private Pane accountantSettingPane;
    
    
    @FXML
    void authorityStudentButton(ActionEvent event) {
        librarianSettingPane.setVisible(false);
        studentSettingPane.setVisible(true);
        accountantSettingPane.setVisible(false);

    }

    @FXML
    void authoritylibrarianButton(ActionEvent event) {
        librarianSettingPane.setVisible(true);
        studentSettingPane.setVisible(false);
        accountantSettingPane.setVisible(false);

    }
    @FXML
    void authorityAccountanttButton(ActionEvent event) {
        librarianSettingPane.setVisible(false);
        studentSettingPane.setVisible(false);
        accountantSettingPane.setVisible(true);

    }
    
     @FXML
    void adminButtonAction(ActionEvent event) {
        authorityNavigation.setVisible(true);
        aut_neg_lab.setVisible(false);

    }
    
    @FXML
    void authorityLogoutButtonAction(ActionEvent event) {
    authorityNavigation.setVisible(false);
    login=false;
    }
    
    @FXML
    private Pane controller_home_pane;
    
     @FXML
    void counsellerButtonAction(ActionEvent event) {
        controller_home_pane.setVisible(true);
        aut_neg_lab.setVisible(false);

    }
    
    @FXML
    void controllerLogoutButtonAction(ActionEvent event) {
        controller_home_pane.setVisible(false);
        login=false;

    }
    
    @FXML
    private Pane finance_m_Home_pane;

    @FXML
    void financeManagerButtonAction(ActionEvent event) {
        finance_m_Home_pane.setVisible(true);
        aut_neg_lab.setVisible(false);

    }
    
     @FXML
    void financeMangLogoutButtonAction(ActionEvent event) {
        finance_m_Home_pane.setVisible(false);
        login=false;

    }
    
    
    @FXML
    private Label aut_neg_exit_lab;

    
     @FXML
    void act3(MouseEvent event) {
        if(event.getSource()==aut_neg_exit_lab){
            aut_neg_lab.setVisible(false);
            login=false;
        }

    }
    
    
        //LB_setting ontrol start from here
    
    @FXML
    private Pane lb_block_acc_pane;
    
    @FXML
    private Pane view_lb_p_u_pane;
    
    @FXML
    private Pane set_u_p_lb_pane;
    
    
     @FXML
    void block_lb_ButtonAction(ActionEvent event) {
        lb_block_acc_pane.setVisible(true);
        view_lb_p_u_pane.setVisible(false);
        set_u_p_lb_pane.setVisible(false);

    }
    @FXML
    private Label slb_u_view_lab;
    
    @FXML
    private Label jlb_u_view_lab;
    
    @FXML
    private Label slb_p_view_lab;
    
    @FXML
    private Label jlb_p_view_lab;
    
     @FXML
    void view_u_p_ButtonAction(ActionEvent event) {
        slb_u_view_lab.setText(slb1.getLib_u_name());
        slb_p_view_lab.setText(slb1.getLib_p_word());
        jlb_u_view_lab.setText(jlb1.getLib_u_name());
        jlb_p_view_lab.setText(jlb1.getLib_p_word());
        lb_block_acc_pane.setVisible(false);
        view_lb_p_u_pane.setVisible(true);
        set_u_p_lb_pane.setVisible(false);

    }
     @FXML
    void set_u_p_ButtonAction(ActionEvent event) {
        lb_block_acc_pane.setVisible(false);
        view_lb_p_u_pane.setVisible(false);
        set_u_p_lb_pane.setVisible(true);

    }
    
     @FXML
    private JFXRadioButton set_seniorLb_radio_id;

    @FXML
    private JFXRadioButton set_juniorLb_radio_id;

    @FXML
    private TextField set_lb_u_name_field;

    @FXML
    private TextField set_lb_p_word_field;
    
    SeniorLibrarian slb1;
    JuniorLibrarin jlb1;
    
    @FXML
    private Label set_lb_u_p_noti_lab;
    
     @FXML
    void set_u_p_submitButtonAction(ActionEvent event) {
        
        if(set_seniorLb_radio_id.isSelected()){
            slb1 = new SeniorLibrarian(set_lb_u_name_field.getText(),set_lb_p_word_field.getText());
            set_lb_u_p_noti_lab.setText("Submission Successful!!!");
        }
        
        else if(set_juniorLb_radio_id.isSelected()){
            jlb1 = new JuniorLibrarin(set_lb_u_name_field.getText(),set_lb_p_word_field.getText());
            set_lb_u_p_noti_lab.setText("Submission Successful!!!");
        }
        
        else{
            set_lb_u_p_noti_lab.setText("Submission Not Successful!!!");
        }
        

    }

    
    
    
    
    
        //LB_setting ontrol end here
    
    
      // Authority design control ..........end 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connector();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LBXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LBXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
