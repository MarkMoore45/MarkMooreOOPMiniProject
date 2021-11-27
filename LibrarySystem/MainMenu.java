package LibrarySystem;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

class LibrarySystem extends JFrame implements ActionListener {

    JMenu bookMenu;
    JMenu memberMenu;
    JMenu loanMenu;
    JLabel welcomeLabel;
    JButton addMemberButton;
    JButton addBookButton;
    JButton borrowBookButton;
    JPanel shortcutPanel;
    TitledBorder titledBorder;

    public LibrarySystem() {


        super("Library System");

        setLayout(new GridBagLayout());

        setIconImage(new ImageIcon(getClass().getResource("book_logo.png")).getImage());

        createBookMenu();
        createMemberMenu();
        createLoanMenu();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.gray);
        menuBar.add(bookMenu);
        menuBar.add(memberMenu);
        menuBar.add((loanMenu));

        welcomeLabel = new JLabel("Welcome to the Library System" );
        welcomeLabel.setFont(new Font("serif",Font.ITALIC,20));
        add(welcomeLabel);

        setSize(500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        shortcutPanel = new JPanel();

        titledBorder = new TitledBorder("Shortcut Buttons");
        titledBorder.setTitleColor(Color.RED);

        shortcutPanel.setPreferredSize(new Dimension(240, 60));
        shortcutPanel.setBorder(titledBorder);
        shortcutPanel.setLocation(150, 150);


        addBookButton = new JButton("Add Book");
        addBookButton.addActionListener(this);
        shortcutPanel.add(addBookButton);

        addMemberButton = new JButton("Add Member");
        addMemberButton.addActionListener(this);
        shortcutPanel.add(addMemberButton);

        borrowBookButton = new JButton("Borrow Book");
        borrowBookButton.addActionListener(this);
        shortcutPanel.add(borrowBookButton);

        add(shortcutPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    ArrayList<Book> books = new ArrayList<>();
    private Book book;

    ArrayList<Member> members = new ArrayList<>();
    private Member member;

    public static void main(String[] args) {
         new LibrarySystem();
    }

    private void createMemberMenu( ) {
        JMenuItem    item;

        memberMenu = new JMenu("Member");
        memberMenu.setMnemonic(KeyEvent.VK_M);

        item = new JMenuItem("Add Member");
        item.addActionListener(this);
        memberMenu.add( item );

        item = new JMenuItem("Update Member");
        item.addActionListener(this);
        memberMenu.add( item );

        item = new JMenuItem("Delete Member");
        item.addActionListener(this);
        memberMenu.add( item );

        item = new JMenuItem("View Member Profile");
        item.addActionListener(this);
        memberMenu.add( item );
    }

    private void createBookMenu( ) {
        JMenuItem    item;

        bookMenu = new JMenu("Book");
        bookMenu.setMnemonic(KeyEvent.VK_B);

        item = new JMenuItem("Add Book");
        item.addActionListener(this);
        bookMenu.add( item );

        item = new JMenuItem("Update Book");
        item.addActionListener(this);
        bookMenu.add( item );

        item = new JMenuItem("Delete Book");
        item.addActionListener(this);
        bookMenu.add( item );

        item = new JMenuItem("View Book");
        item.addActionListener(this);
        bookMenu.add( item );
    }

    private void createLoanMenu( ) {
        JMenuItem    item;

        loanMenu = new JMenu("Loan");
        loanMenu.setMnemonic(KeyEvent.VK_L);

        item = new JMenuItem("Borrow Book");
        item.addActionListener(this);
        loanMenu.add( item );

        item = new JMenuItem("Return Book");
        item.addActionListener(this);
        loanMenu.add( item );

        item = new JMenuItem("View Loan");
        item.addActionListener(this);
        loanMenu.add( item );

        item = new JMenuItem("Pay Fines");
        item.addActionListener(this);
        loanMenu.add( item );
    }

    public void addBook(){
         String ISBN;
         String title;
         String author;
         String genre;
         int pages;
         char status;
         final String [] genreList = {"Non-Fiction","Fiction","Sci-Fi","Horror","Romance","Historic","Sports & Leisure","Fantasy"};

         //validate
        ISBN = JOptionPane.showInputDialog("Enter Books's ISBN");
        title = JOptionPane.showInputDialog("Enter Books's Title");
        author = JOptionPane.showInputDialog("Enter Books's Author");
        genre = (String) JOptionPane.showInputDialog(null,"Book","Book",JOptionPane.QUESTION_MESSAGE,null,genreList,genreList[0]);
        pages = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of pages in the book"));
        status = 'A';

        book = new Book(ISBN,title,author,genre,pages,status);
        books.add(book);
        JOptionPane.showMessageDialog(null,"Book '" + title + "' added to the system");
    }

    public void viewBooks() {
        JComboBox bookCombo = new JComboBox();
        JTextArea output = new JTextArea();

        output.setText("Book Details:\n");

        if(books.size() < 1) {
            JOptionPane.showMessageDialog(null,"No books have been  added to the system yet.","Warning",JOptionPane.WARNING_MESSAGE);
        }
        else {
            Iterator<Book> iterator = books.iterator();

            while(iterator.hasNext()) {
                bookCombo.addItem(iterator.next().getTitle() + "\n");
            }

            JOptionPane.showMessageDialog(null,bookCombo,"Select a book to view details",JOptionPane.PLAIN_MESSAGE);

            int selected = bookCombo.getSelectedIndex();
            output.append(books.get(selected).toString());

            JOptionPane.showMessageDialog(null,output,"Book Details",JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void deleteBook() {

        JComboBox bookList = new JComboBox();

        if(books.size() < 1) {
            JOptionPane.showMessageDialog(null,"No books have been  added to the system yet.","Warning",JOptionPane.WARNING_MESSAGE);
        }
        else {
            for (Book book : books) {
                bookList.addItem(book.getTitle());
            }

            JOptionPane.showMessageDialog(null, "Select Book to be removed", "Remove Book", JOptionPane.INFORMATION_MESSAGE);

            JOptionPane.showMessageDialog(null, bookList, "Remove Book", JOptionPane.INFORMATION_MESSAGE);

            int selected = bookList.getSelectedIndex();

            books.remove(selected);

            JOptionPane.showMessageDialog(null, "Book Removed", "Removed", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void updateBook(){
        String ISBN;
        String title;
        String author;
        String genre;
        int pages;
        char status;
        final String [] genreList = {"Non-Fiction","Fiction","Sci-Fi","Horror","Romance","Historic","Sports & Leisure","Fantasy"};

        JComboBox bookCombo = new JComboBox();
        JTextArea output = new JTextArea();


        if (books.size() < 1) {
            JOptionPane.showMessageDialog(null, "No books have been  added to the system yet.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            Iterator<Book> iterator = books.iterator();

            while (iterator.hasNext()) {
                bookCombo.addItem(iterator.next().getTitle() + "\n");
            }

            JOptionPane.showMessageDialog(null, bookCombo, "Select Book to update details", JOptionPane.PLAIN_MESSAGE);

            int selected = bookCombo.getSelectedIndex();
            output.append(members.get(selected).toString());
        }
    }

    public void addMember(){
         int MemberID;
         String forename;
         String surname;
         String password;
         String email;
         String address;
         int phone;

         //validate
        forename = JOptionPane.showInputDialog("Enter Member's Forename");

            if(forename.length()>30){
                forename = JOptionPane.showInputDialog("Forename is too long. Please enter a different forename");
            }
            else if(forename == null || forename.equals("") || forename.equals(" ")){
                forename = JOptionPane.showInputDialog("Forename must not be empty");
            }

        surname = JOptionPane.showInputDialog("Enter Member's Surname");

        if(surname.length()>30){
            surname = JOptionPane.showInputDialog("Surname is too long. Please enter a different forename");
        }
        else if(surname == null || surname.equals("") || surname.equals(" ")){
            surname = JOptionPane.showInputDialog("Surname must not be empty");
        }

        email = JOptionPane.showInputDialog("Enter Member's E-mail");
        int locationOfAtSymbol=0,j;
        char ch;
        String domainName="",recipient="";
        boolean valid = false;

        while(!valid)
        {
            if(email.length()>=7 && email.length()<=322)
            {
                locationOfAtSymbol = email.indexOf('@');

                if(locationOfAtSymbol!=-1)
                    if(email.endsWith(".com") || email.endsWith(".org") || email.endsWith(".net") || email.endsWith(".ie"))
                    {
                        recipient = email.substring(0,locationOfAtSymbol);

                        if(recipient.length()>=1 && recipient.length()<=64)
                        {
                            for(j=0;j<recipient.length();j++)
                            {
                                ch = recipient.charAt(j);

                                if(!Character.isDigit(ch) && !Character.isLetter(ch) && ch!='-' && ch!='.' && ch!='_')
                                    break;
                            }

                            if(j==recipient.length())
                            {
                                if(email.endsWith("e"))
                                    domainName = email.substring(locationOfAtSymbol+1,email.length()-3);
                                else
                                    domainName = email.substring(locationOfAtSymbol+1,email.length()-4);

                                if(domainName.length()>=2 && domainName.length()<=253)
                                {
                                    for(j=0;j<domainName.length();j++)
                                    {
                                        ch = domainName.charAt(j);

                                        if(!Character.isDigit(ch) && !Character.isLetter(ch) && ch!='-' && ch!='.')
                                            break;
                                    }

                                    if(j==domainName.length())
                                        valid = true;
                                    else
                                        email = JOptionPane.showInputDialog("Invalid! Domain name must only contain letters, digits, dashes and dots");
                                }
                                else
                                    email = JOptionPane.showInputDialog("Invalid! Domain name must contain between 2 and 253 characters inclusive");
                            }
                            else
                                email = JOptionPane.showInputDialog("Invalid! Recipient name must only contain letters, digits, dashes, dots and underscores");
                        }
                        else
                            email = JOptionPane.showInputDialog("Invalid! Recipient name must contain between 1 and 64 characters inclusive");
                    }
                    else
                        email = JOptionPane.showInputDialog("Invalid! Email value must end with .com   .org   .net or .ie");
                else
                    email = JOptionPane.showInputDialog("Invalid! Email value must contain an @ symbol");
            }
            else
                email = JOptionPane.showInputDialog("Invalid! Email value must have between 7 and 322 characters inclusive");
        }

        password = JOptionPane.showInputDialog("Enter Member's Password");
        address = JOptionPane.showInputDialog("Enter Member's Address");
        phone = Integer.parseInt(JOptionPane.showInputDialog("Enter Member's Phone Number"));

        member = new Member(forename,surname,email,password,address,phone);
        members.add(member);
        JOptionPane.showMessageDialog(null,"Member " + forename + " " + surname + " added to the system");
    }

    public void viewMembers() {
        JComboBox memberCombo = new JComboBox();
        JTextArea output = new JTextArea();

        output.setText("Member Details:\n");

        if(members.size() < 1) {
            JOptionPane.showMessageDialog(null,"No members have been  added to the system yet.","Warning",JOptionPane.WARNING_MESSAGE);
        }
        else {
            Iterator<Member> iterator = members.iterator();

            while(iterator.hasNext()) {
                memberCombo.addItem(iterator.next().getForename() +  "\n");
            }

            JOptionPane.showMessageDialog(null,memberCombo,"Select Member to view details",JOptionPane.PLAIN_MESSAGE);

            int selected = memberCombo.getSelectedIndex();
            output.append(members.get(selected).toString());

            JOptionPane.showMessageDialog(null,output,"Member Details",JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void deleteMember() {

        if(members.size() < 1) {
            JOptionPane.showMessageDialog(null,"No members have been  added to the system yet.","Warning",JOptionPane.WARNING_MESSAGE);
        }
        else {
            JComboBox memberList = new JComboBox();

            for (Member member : members) {
                memberList.addItem(member.getForename());
            }

            JOptionPane.showMessageDialog(null, "Select Member to be removed", "Remove Member", JOptionPane.INFORMATION_MESSAGE);

            JOptionPane.showMessageDialog(null, memberList, "Remove Member", JOptionPane.INFORMATION_MESSAGE);

            int selected = memberList.getSelectedIndex();

            members.remove(selected);

            JOptionPane.showMessageDialog(null, "Member Removed", "Removed", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void updateMember() {
        String forename = "0";
        String surname = "0";
        String password = "0";
        String email = "0";
        String address = "0";
        int phone = 0;


        JComboBox memberCombo = new JComboBox();
        JTextArea output = new JTextArea();


        if (members.size() < 1) {
            JOptionPane.showMessageDialog(null, "No members have been  added to the system yet.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            Iterator<Member> iterator = members.iterator();

            while (iterator.hasNext()) {
                memberCombo.addItem(iterator.next().getForename() + "\n");
            }

            JOptionPane.showMessageDialog(null, memberCombo, "Select Member to update details", JOptionPane.PLAIN_MESSAGE);

            int selected = memberCombo.getSelectedIndex();
            output.append(members.get(selected).toString());

            member.setForename(JOptionPane.showInputDialog("Enter Member's Forename"));

            if(forename.length()>30){
                member.setForename(JOptionPane.showInputDialog("Forename is too long. Please enter a different forename"));
            }
            else if(forename == null || forename.equals("") || forename.equals(" ")){
                member.setForename(JOptionPane.showInputDialog("Forename must not be empty"));
            }

            member.setSurname(JOptionPane.showInputDialog("Enter Member's Surname"));

            if(surname.length()>30){
                member.setSurname(JOptionPane.showInputDialog("Surname is too long. Please enter a different forename"));
            }
            else if(surname == null || surname.equals("") || surname.equals(" ")){
                member.setSurname(JOptionPane.showInputDialog("Surname must not be empty"));
            }

            member.setEmail(JOptionPane.showInputDialog("Enter Member's E-mail"));
            int locationOfAtSymbol=0,j;
            char ch;
            String domainName="",recipient="";
            boolean valid = false;

            while(!valid)
            {
                if(email.length()>=7 && email.length()<=322)
                {
                    locationOfAtSymbol = email.indexOf('@');

                    if(locationOfAtSymbol!=-1)
                        if(email.endsWith(".com") || email.endsWith(".org") || email.endsWith(".net") || email.endsWith(".ie"))
                        {
                            recipient = email.substring(0,locationOfAtSymbol);

                            if(recipient.length()>=1 && recipient.length()<=64)
                            {
                                for(j=0;j<recipient.length();j++)
                                {
                                    ch = recipient.charAt(j);

                                    if(!Character.isDigit(ch) && !Character.isLetter(ch) && ch!='-' && ch!='.' && ch!='_')
                                        break;
                                }

                                if(j==recipient.length())
                                {
                                    if(email.endsWith("e"))
                                        domainName = email.substring(locationOfAtSymbol+1,email.length()-3);
                                    else
                                        domainName = email.substring(locationOfAtSymbol+1,email.length()-4);

                                    if(domainName.length()>=2 && domainName.length()<=253)
                                    {
                                        for(j=0;j<domainName.length();j++)
                                        {
                                            ch = domainName.charAt(j);

                                            if(!Character.isDigit(ch) && !Character.isLetter(ch) && ch!='-' && ch!='.')
                                                break;
                                        }

                                        if(j==domainName.length())
                                            valid = true;
                                        else
                                            email = JOptionPane.showInputDialog("Invalid! Domain name must only contain letters, digits, dashes and dots");
                                    }
                                    else
                                        email = JOptionPane.showInputDialog("Invalid! Domain name must contain between 2 and 253 characters inclusive");
                                }
                                else
                                    email = JOptionPane.showInputDialog("Invalid! Recipient name must only contain letters, digits, dashes, dots and underscores");
                            }
                            else
                                email = JOptionPane.showInputDialog("Invalid! Recipient name must contain between 1 and 64 characters inclusive");
                        }
                        else
                            email = JOptionPane.showInputDialog("Invalid! Email value must end with .com   .org   .net or .ie");
                    else
                        email = JOptionPane.showInputDialog("Invalid! Email value must contain an @ symbol");
                }
                else
                    email = JOptionPane.showInputDialog("Invalid! Email value must have between 7 and 322 characters inclusive");
            }

            member.setPassword(JOptionPane.showInputDialog("Enter Member's Password"));
            member.setAddress(JOptionPane.showInputDialog("Enter Member's Address"));
            member.setPhone(Integer.parseInt(JOptionPane.showInputDialog("Enter Member's Phone Number")));


            JOptionPane.showMessageDialog(null,"Updated Members details");

        }
    }

    public void borrowBook() {
        JComboBox bookCombo = new JComboBox();
        JTextArea output = new JTextArea();

        output.setText("Book Details:\n");

        if (books.size() < 1) {
            JOptionPane.showMessageDialog(null, "No books have been  added to the system yet.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            Iterator<Book> iterator = books.iterator();

            while (iterator.hasNext()) {
                bookCombo.addItem(iterator.next().getTitle() + "\n");
            }

            JOptionPane.showMessageDialog(null, bookCombo, "Select a book to borrow", JOptionPane.PLAIN_MESSAGE);

            int selected = bookCombo.getSelectedIndex();
            output.append(books.get(selected).toString());
        }
    }

    public void returnBook(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String menuName = e.getActionCommand();


        if(menuName == "Add Member" || e.getSource() == addMemberButton) {
            addMember();
        } else if(menuName.equals("View Member Profile")) {
            viewMembers();
        } else if(menuName.equals("Delete Member")) {
            deleteMember();
        } else if(menuName.equals("Update Member")) {
            updateMember();
        }


        if(menuName == "Add Book" || e.getSource() == addBookButton) {
            addBook();
        } else if(menuName.equals("View Book")) {
            viewBooks();
        } else if(menuName.equals("Delete Book")) {
            deleteBook();
        }else if(menuName.equals("Update Book")) {
            updateBook();
        }

        if(menuName == "Borrow Book" || e.getSource() == borrowBookButton) {
            borrowBook();
        } else if(menuName.equals("Return Book")) {
            returnBook();
        }else if(menuName.equals("View Loan")) {
            returnBook();
        }else if(menuName.equals("Pay Fine")) {
            returnBook();
        }


    }
}
