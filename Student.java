
package librarymanagement;
public class Student {
    private String std_username;
    private String std_password;
    private String std_type;
    
    //Constuctor
    public Student(String std_username,String std_password,String std_type){
        this.std_password = std_password;
        this.std_username = std_username;
        this.std_type = std_type;
    }
    String getSTD_TYPE(){
        return std_type;
    }
    String getSTD_PASSWORD(){
        return std_password;
    }
    String getSTD_USERNAME(){
        return std_username;
    }
    
}
