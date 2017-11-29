
package librarymanagement;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student {
    private SimpleStringProperty std_username;
    private String std_password;
    private String std_type;
    private SimpleIntegerProperty due;
    
    //Constuctor
    public Student(String std_username,String std_password,String std_type){
        this.std_password = std_password;
        this.std_username = new SimpleStringProperty(std_username);
        this.std_type = std_type;
    }
    String getSTD_TYPE(){
        return std_type;
    }
    String getSTD_PASSWORD(){
        return std_password;
    }
    String getSTD_USERNAME(){
        return std_username.get();
    }

    public String getStd_username() {
        return std_username.get();
    }
    
    public Integer getDue() {
        return due.get();
    }
    
    
}
