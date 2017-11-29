/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement;

/**
 *
 * @author ARahman
 */
public class Book {
    private String bookname;
    private String bookid;
    private String booktype;
    private int bookselfno;

    public Book(String bookname, String bookid, String booktype, int bookselfno) {
        this.bookname = bookname;
        this.bookid = bookid;
        this.booktype = booktype;
        this.bookselfno = bookselfno;
    }

    public String getBookname() {
        return bookname;
    }

    public String getBookid() {
        return bookid;
    }

    public String getBooktype() {
        return booktype;
    }

    public int getBookselfno() {
        return bookselfno;
    }
    
    
    
    
    
}
