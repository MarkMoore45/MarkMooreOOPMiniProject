package LibrarySystem;

import javax.swing.*;
import java.awt.*;

class LibrarySystem extends JFrame
{

    JMenu bookMenu;
    JMenu memberMenu;
    JMenu loanMenu;
    JLabel welcome;

    public LibrarySystem() {

        super("Library System");

        setLayout(new GridBagLayout());

        createBookMenu();
        createMemberMenu();
        createLoanMenu();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.gray);
        menuBar.add(bookMenu);
        menuBar.add(memberMenu);
        menuBar.add((loanMenu));

        welcome = new JLabel("Welcome to the Library System" );
        welcome.setFont(new Font("serif",Font.ITALIC,20));
        add(welcome);

        setSize(500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        LibrarySystem frame = new LibrarySystem();
    }

    private void createMemberMenu( ) {
        JMenuItem    item;

        memberMenu = new JMenu("Member");
        item = new JMenuItem("Add Member");
        memberMenu.add( item );

        item = new JMenuItem("Update Member");
        memberMenu.add( item );

        item = new JMenuItem("Remove Member");
        memberMenu.add( item );

        item = new JMenuItem("View Member Profile");
        memberMenu.add( item );
    }

    private void createBookMenu( ) {
        JMenuItem    item;

        bookMenu = new JMenu("Book");
        item = new JMenuItem("Add Book");
        bookMenu.add( item );

        item = new JMenuItem("Update Book");
        bookMenu.add( item );

        item = new JMenuItem("Remove Book");
        bookMenu.add( item );

        item = new JMenuItem("View Book");
        bookMenu.add( item );
    }

    private void createLoanMenu( ) {
        JMenuItem    item;

        loanMenu = new JMenu("Loan");
        item = new JMenuItem("Loan Book");
        loanMenu.add( item );

        item = new JMenuItem("Return Book");
        loanMenu.add( item );

        item = new JMenuItem("View Loan");
        loanMenu.add( item );

        item = new JMenuItem("Pay Fines");
        loanMenu.add( item );
    }
}
