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
public class StdLibraryInfo {
    private String stdbookname;
    private String stdbooksubdate;
    private double stddue;

    public StdLibraryInfo(String stdbookname, String stdbooksubdate) {
        this.stdbookname = stdbookname;
        this.stdbooksubdate = stdbooksubdate;
    }

    public String getStdbookname() {
        return stdbookname;
    }

    public String getStdbooksubdate() {
        return stdbooksubdate;
    }

    public double getStddue() {
        return stddue;
    }

    public void setStdbookname(String stdbookname) {
        this.stdbookname = stdbookname;
    }

    public void setStdbooksubdate(String stdbooksubdate) {
        this.stdbooksubdate = stdbooksubdate;
    }

    public void setStddue(double stddue) {
        this.stddue = stddue;
    }
    
    
    
}
