package LibrarySystem;

import java.util.GregorianCalendar;

public class Loans   {

    public int LoanID;
    public GregorianCalendar loanedDate;
    public GregorianCalendar dueDate;
    public static int count = 1;

    public Loans( GregorianCalendar loanedDate, GregorianCalendar dueDate) {
        setLoanID();

        setLoanedDate(loanedDate);
        setDueDate(dueDate);
    }
    
    public int getLoanID() {
        return LoanID;
    }

    public void setLoanID() {
        this.LoanID = count++;
    }

    public GregorianCalendar getLoanedDate() {
        return loanedDate;
    }

    public void setLoanedDate(GregorianCalendar loanedDate) {
        this.loanedDate = loanedDate;
    }

    public GregorianCalendar getDueDate() {
        return dueDate;
    }

    public void setDueDate(GregorianCalendar dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Loans \n" +
                "LoanID: " + getLoanID() +
                "Loaned Date: " + getLoanedDate() +
                "Due Date: " + getDueDate();
    }
}
