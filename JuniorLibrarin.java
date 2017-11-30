
package librarymanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class JuniorLibrarin extends Librarian{
    
    // constuctor
    public JuniorLibrarin(String lib_u_name, String lib_p_word){
        super(lib_u_name,lib_p_word);
    }
    
    public void canAddBook(ObservableList<Book>BookList,String bookname,String bookid,String booktype,int bookselfno){
       BookList.add(new Book(bookname,bookid,booktype,bookselfno));
    }
    
}
