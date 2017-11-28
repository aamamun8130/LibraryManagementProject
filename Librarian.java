
package librarymanagement;


public class Librarian {
    
    private String lib_u_name;
    private String lib_p_word;
    
    // Constuctor
    public Librarian(String lib_u_name, String lib_p_word){
        this.lib_u_name = lib_u_name;
        this.lib_p_word = lib_p_word;
    }
    
    public String getLib_u_name(){
      return lib_u_name; 
    }
    
    public String getLib_p_word(){
      return lib_p_word; 
    }
    
    
}
