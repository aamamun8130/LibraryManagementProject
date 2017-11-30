
package librarymanagement;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Student {
    private SimpleStringProperty std_username;
    private String std_password;
    private String std_type;
    StdLibraryInfo slbinfo;
    
    
    //Constuctor
    public Student(String std_username,String std_password,String std_type, String p, String q){
        this.std_password = std_password;
        this.std_username = new SimpleStringProperty(std_username);
        this.std_type = std_type;
        slbinfo = new StdLibraryInfo(p,q);
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
    
       
    public void canSearchBook(ObservableList<Book> bookLst ){
        for(Book blist : bookLst){
            
        }
        
    }
    
   
    
    
}
