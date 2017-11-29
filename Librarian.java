
package librarymanagement;


public class Librarian {
    
    private String lib_u_name;
    private String lib_p_word;
    private boolean lib_block_status;
    
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
    
    public boolean getLib_block_status(){
       return lib_block_status; 
    }
    public void setLib_block_status(boolean lib_acc_lock){
        lib_block_status = lib_acc_lock;
    }
    
    
}
