package edu.century.finalproject;

import edu.century.finalproject.constants.*;

import javax.swing.*;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.Action;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.InputStream;
import java.awt.image.BufferedImage;
import java.awt.Insets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition for a GUI class of Ciinema Theater POS program
 * 
 * Class: CSCI 2082-90 - Data Structures and Algorithms
 * Instructor: Zakaria Baani
 * Assignment: Final Project
 * 
 * Date: October 23, 2019
 * Due:  December 11, 2019
 * @author David Duong <dduong051@gmail.com>
 * @author Alexandr Sergeyev <ns1418cz@go.minnstate.edu>
 */
public class TicketPOSGUI extends JFrame implements ActionListener, GUIConstants, GUILabels, GUIMenu, GUIButtonCaptions, GUIFonts {
	
	/**
	 * Constant properties such as labels, fonts, text field sizes, etc
	 * moved to edu.century.finalproject.constants.* package
	 */
	
	/**
	 * Admin privileges
	 */
	private boolean isAdmin = false;
	
    
    /**
     * JTextField for Movie Search
     */
    public JTextField searchMovieTextField        = new JTextField(NUMBER_OF_CHAR_INPUT_LARGE3);
    
    /**
     * JTextField for Customer Info
     */
    private JTextField customerFirstNameTextField = new JTextField(NUMBER_OF_CHAR_INPUT_MEDIUM);
    private JTextField customerLastNameTextField  = new JTextField(NUMBER_OF_CHAR_INPUT_MEDIUM);
    private JTextField customerEmailTextField     = new JTextField(NUMBER_OF_CHAR_INPUT_MEDIUM);
    
    
    /**
     * JTextField for Payment Info
     */
    private JTextField cardNumberTextField        = new JTextField(NUMBER_OF_CHAR_INPUT_LARGE);
    private JTextField cardExpMonthTextField      = new JTextField(NUMBER_OF_CHAR_INPUT_SMALL);
    private JTextField cardExpYearTextField       = new JTextField(NUMBER_OF_CHAR_INPUT_SMALL);
    private JTextField cardZipTextField           = new JTextField(NUMBER_OF_CHAR_INPUT_SMALL);
    
    /**
     * JTextField for Login Form
     */
    private JTextField loginUsernameTextField     = new JTextField(NUMBER_OF_CHAR_INPUT_MEDIUM);
    private JTextField loginPasswordTextField     = new JTextField(NUMBER_OF_CHAR_INPUT_MEDIUM);
    
    private List<Genre>     genres   = new ArrayList<>();
    private List<Theater>   theaters = new ArrayList<>();
    private List<Movie>     movies   = new ArrayList<>();
    private List<MovieTime> times    = new ArrayList<>();
    
    /**
     * JComboBox for period selector
     */
    private JComboBox<String> genreSelectorBox;
    
    /**
     * JComboBox for period selector
     */
    private JComboBox<String> timeSelectorBox;;
    
    
    /**
	 * Menus
	 */
	JMenuBar  menuBar;
	JMenu     menuDemo, menuLogIn, menuAdmin;
	JMenuItem menuDemoCustomerViewitem, 
			  menuDemoExitItem,
		  	  menuLoginItem; 
	JMenuItem menuAdminMoviesItem, 
			  menuAdminTheatersItem,
			  menuAdminTimesItem,
			  menuAdminGenresItem,
			  menuAdminScheduleItem, 
			  menuAdminTicketsItem, 
			  menuAdminReservationsItem, 
			  menuAdminSalesItem,
			  menuAdminLogOutItem;
	
	/**
	 * Panels
	 */
	
	// Main Panel
	JPanel mainWindowPanel;
	
	// Sub panel of mainPanel
	// where customer can see movies and place an order
	// (view from customer perspective)
	JPanel customerViewPanel;
	
	// Sub panel of customerMainPanel
	// where movie menu will be displayed
	// (view from customer perspective)
	JPanel movieMenuPanel;
	JPanel movieMenuContentPanel;
	JPanel searchBarPanel;
	
	// Sub panel of mainPanel 
	// where admin will enter login and password
	// (view from admin perspective)
	JPanel loginMainPanel;
	
	// Sub panel of mainPanel - customer Main Panel 
	// where admin can see movies, orders and edit data
	// (view from admin perspective)
	JPanel adminMainPanel;
	
    
    /**
     * Main function
     * 
     * @param args
     */
    public static void main(String[] args) {
    	TicketPOSGUI gui = new TicketPOSGUI( );
    	// in order to display window centrally
    	gui.setLocationRelativeTo(null);
        gui.setVisible(true);
	}
    
    
    public TicketPOSGUI() {
    	
    	// start window
    	super(PROGRAM_NAME);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Load default Data (Movies, Genres, etc)
        //setDefaultData();
        
        // loading top menu
        loadMenu();
        
        loadDefaultData();
        //load comboboxes
        String[] arrayGenres = new String[genres.size()];
        for (int i = 0; i < genres.size(); i++) {
        	arrayGenres[i] = genres.get(i).name;
		}
        genreSelectorBox = new JComboBox(arrayGenres);
        
        String[] arrayTimes = new String[times.size()];
        for (int i = 0; i < times.size(); i++) {
        	arrayTimes[i] = times.get(i).time;
		}
        timeSelectorBox = new JComboBox(arrayTimes);
        
        
        // Create spring layout
        SpringLayout mainLayout = new SpringLayout();
        FlowLayout flowLayout = new FlowLayout();
        GridLayout gridLayoutMovie = new GridLayout(0, 3, 10, 10);
        
        // Create main panel
        mainWindowPanel = new JPanel();
        mainWindowPanel.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        mainWindowPanel.setLayout(mainLayout);
        
        
        
        
       
        /**
         *  Define buttons
         */
        
        // Search
        JButton actionSearchButton = new JButton(BUTTON_CAPTION_SEARCH);
        actionSearchButton.addActionListener(this);
        
        // Login
        JButton actionLoginButton = new JButton(BUTTON_CAPTION_LOGIN);
        actionLoginButton.addActionListener(this);
        
        
        
        /**
         *  Start Customer Panel (screen)
         */
        // Set Customer Panel Position Inside Main Window Panel
        customerViewPanel = new JPanel ();
        customerViewPanel.setBorder( new TitledBorder ( new EtchedBorder (), "Customer View" ) );
        customerViewPanel.setLayout(mainLayout);
        
        // Content block of the movies where we add movies
        searchBarPanel = new JPanel ();
        searchBarPanel.setBorder( new TitledBorder ( new EtchedBorder (), "searchBarPanel" ) );
//        searchBarPanel.setPreferredSize(new Dimension(1000, 70));
        
        // Sub Panel of Customer Panel where movie menu will be displayed
        movieMenuPanel = new JPanel ();
        movieMenuPanel.setBorder( new TitledBorder ( new EtchedBorder (), "movieMenuMainPanel" ) );
//        movieMenuPanel.setPreferredSize(new Dimension(1000, 600));
        
        // Content block of the movies where we add movies
        movieMenuContentPanel = new JPanel ();
        movieMenuContentPanel.setBorder( new TitledBorder ( new EtchedBorder (), "movieMenuContentPanel" ) );
        movieMenuContentPanel.setLayout(gridLayoutMovie);
//        movieMenuContentPanel.setPreferredSize(new Dimension(1000, 600));
        
        // Add buttons to content block
        JButton button;
        String buttonText = "";
        
        BufferedImage image = null;
		
        
        for (int i = 0; i < movies.size(); i++) {
        	buttonText = "";
        	buttonText += movies.get(i).getTitle().toUpperCase() + "\n" + "\n";
        	buttonText += "\n";
        	buttonText += "Duration: " + movies.get(i).getDuration() + " mins \n" + "\n";
        	buttonText += "\n";
        	for (int j = 0; j < movies.get(i).genres.size(); j++) {
        		buttonText += movies.get(i).genres.get(j).name.toUpperCase();
        		if(j != (movies.get(i).genres.size() - 1)) {
        			buttonText += ", ";
        		}
			}
        	buttonText += "\n" + "\n";
        	
        	for (int j = 0; j < movies.get(i).times.size(); j++) {
        		buttonText += movies.get(i).times.get(j).toUpperCase();
        		if(j != (movies.get(i).times.size() - 1)) {
        			buttonText += ", ";
        		}
			}
        	buttonText += "\n";
        	
			button = new JButton();
			button.setMargin(new Insets(0,0,0,0));
			button.setHorizontalAlignment(SwingConstants.LEFT);
			button.setAlignmentY(TOP_ALIGNMENT);
			try {
				
				System.out.println("resources\\" + movies.get(i).getImage());
				
				ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			    InputStream input = classLoader.getResourceAsStream("resources\\" + movies.get(i).getImage());
			    // URL input = classLoader.getResource("image.png"); // <-- You can use URL class too.
			    image = ImageIO.read(input);

			    button.setIcon(new ImageIcon(image));
			  } catch (Exception ex) {
			    System.out.println(ex);
			  }
			
			button.setText("<html>" + buttonText.replaceAll("\\n", "<br>") + "</html>");
			button.setPreferredSize(TicketPOSGUI.SIZE_150_300);
			movieMenuContentPanel.add(button);
		}
        
        
        // Add Scroll Panel to content block
        JScrollPane movieMenuScrollPanel = new JScrollPane(
        		movieMenuContentPanel, 
        		ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,  
        		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
		);
        movieMenuScrollPanel.setMinimumSize(new Dimension(1160, 580));
        movieMenuScrollPanel.setPreferredSize(new Dimension(1160, 580));
        movieMenuScrollPanel.getVerticalScrollBar().setUnitIncrement(25);
        
        
        // Layout
        // Set Customer Panel/Screen position inside Main Window Panel
        mainLayout.putConstraint(SpringLayout.WEST,  customerViewPanel, 0, SpringLayout.WEST, mainWindowPanel);
        mainLayout.putConstraint(SpringLayout.EAST,  customerViewPanel, 0, SpringLayout.EAST, mainWindowPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, customerViewPanel, 0, SpringLayout.NORTH, mainWindowPanel);
        mainLayout.putConstraint(SpringLayout.SOUTH, customerViewPanel, 0, SpringLayout.SOUTH, mainWindowPanel); 
        
        mainLayout.putConstraint(SpringLayout.WEST,  searchBarPanel, 0, SpringLayout.WEST, customerViewPanel);
        mainLayout.putConstraint(SpringLayout.EAST,  searchBarPanel, 0, SpringLayout.EAST, customerViewPanel);
//        mainLayout.putConstraint(SpringLayout.NORTH, searchBarPanel, 0, SpringLayout.NORTH, customerMainPanel);
//        mainLayout.putConstraint(SpringLayout.SOUTH, searchBarContentPanel, 0, SpringLayout.SOUTH, customerMainPanel); 
        
        // Set position of the elements inside Customer Panel/Screen
        // Row 1 - Search Form
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.SEARCH_FORM_LABEL, TicketPOSGUI.LAYOUT_PADDING_1, SpringLayout.WEST,  searchBarPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.SEARCH_FORM_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_1+3,SpringLayout.NORTH, searchBarPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  searchMovieTextField,           TicketPOSGUI.LAYOUT_PADDING_1, SpringLayout.EAST,  TicketPOSGUI.SEARCH_FORM_LABEL);
        mainLayout.putConstraint(SpringLayout.NORTH, searchMovieTextField,           TicketPOSGUI.LAYOUT_HEIGHT_1,  SpringLayout.NORTH, searchBarPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.GENRE_LABEL,       TicketPOSGUI.LAYOUT_PADDING_1, SpringLayout.EAST,  searchMovieTextField);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.GENRE_LABEL,       TicketPOSGUI.LAYOUT_HEIGHT_1+3,SpringLayout.NORTH, searchBarPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  genreSelectorBox,               TicketPOSGUI.LAYOUT_PADDING_1, SpringLayout.EAST,  TicketPOSGUI.GENRE_LABEL);
        mainLayout.putConstraint(SpringLayout.NORTH, genreSelectorBox,               TicketPOSGUI.LAYOUT_HEIGHT_1,  SpringLayout.NORTH, searchBarPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.TIMES_LABEL,       TicketPOSGUI.LAYOUT_PADDING_1, SpringLayout.EAST,  genreSelectorBox);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.TIMES_LABEL,       TicketPOSGUI.LAYOUT_HEIGHT_1+3,SpringLayout.NORTH, searchBarPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  timeSelectorBox,                TicketPOSGUI.LAYOUT_PADDING_1, SpringLayout.EAST,  TicketPOSGUI.TIMES_LABEL);
        mainLayout.putConstraint(SpringLayout.NORTH, timeSelectorBox,                TicketPOSGUI.LAYOUT_HEIGHT_1,  SpringLayout.NORTH, searchBarPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  actionSearchButton,             TicketPOSGUI.LAYOUT_PADDING_1, SpringLayout.EAST,  timeSelectorBox);
        mainLayout.putConstraint(SpringLayout.NORTH, actionSearchButton,             TicketPOSGUI.LAYOUT_HEIGHT_1,  SpringLayout.NORTH, searchBarPanel);
        
        // Set Customer Panel/Screen position inside Main Window Panel
        mainLayout.putConstraint(SpringLayout.WEST,  movieMenuPanel, 0, SpringLayout.WEST,  customerViewPanel);
        mainLayout.putConstraint(SpringLayout.EAST,  movieMenuPanel, 0, SpringLayout.EAST,  customerViewPanel);
//        mainLayout.putConstraint(SpringLayout.NORTH, movieMenuMainPanel, 50, SpringLayout.NORTH, customerMainPanel);
        mainLayout.putConstraint(SpringLayout.SOUTH, movieMenuPanel, 0, SpringLayout.SOUTH, customerViewPanel);
        
        // Change Font Size
        searchMovieTextField.setFont(TicketPOSGUI.FONT_16);
        
        // Add elements (Search Form) to Customer Panel/Screen
        searchBarPanel.add(TicketPOSGUI.SEARCH_FORM_LABEL);
        searchBarPanel.add(searchMovieTextField);
        searchBarPanel.add(TicketPOSGUI.GENRE_LABEL);
        searchBarPanel.add(genreSelectorBox);
        searchBarPanel.add(TicketPOSGUI.TIMES_LABEL);
        searchBarPanel.add(timeSelectorBox);
        searchBarPanel.add(actionSearchButton);
        
        movieMenuPanel.add(movieMenuScrollPanel);

        customerViewPanel.add(searchBarPanel);
        customerViewPanel.add(movieMenuPanel);
        
        // Add Customer Panel/Screen to Main Window Panel
		mainWindowPanel.add(customerViewPanel);
        // End Customer Panel (screen)
		
		
		
		
		
		/**
		 *  Start Login Panel (screen)
		 */
        // Set Login Panel Position Inside Main Window Panel
		loginMainPanel = new JPanel ();
		loginMainPanel.setBorder( new TitledBorder ( new EtchedBorder (), "Login" ) );
		loginMainPanel.setLayout(mainLayout);
		
		// Set Login Panel/Screen position inside Main Window Panel
        mainLayout.putConstraint(SpringLayout.WEST,  loginMainPanel, 0, SpringLayout.WEST, mainWindowPanel);
        mainLayout.putConstraint(SpringLayout.EAST,  loginMainPanel, 0, SpringLayout.EAST, mainWindowPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, loginMainPanel, 0, SpringLayout.NORTH, mainWindowPanel);
        mainLayout.putConstraint(SpringLayout.SOUTH, loginMainPanel, 0, SpringLayout.SOUTH, mainWindowPanel);
        
        // Set position of the elements inside Login Panel/Screen
        // Row 1 - Form Label
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.LOGIN_FORM_LABEL, TicketPOSGUI.LAYOUT_PADDING_3, SpringLayout.WEST, loginMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.LOGIN_FORM_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_4, SpringLayout.NORTH, loginMainPanel);
        // Row 2 - Username
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.LOGIN_USERNAME_LABEL, TicketPOSGUI.LAYOUT_PADDING_3, SpringLayout.WEST, loginMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.LOGIN_USERNAME_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_5, SpringLayout.NORTH, loginMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  loginUsernameTextField,  LAYOUT_PADDING_5, SpringLayout.WEST, loginMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, loginUsernameTextField,  LAYOUT_HEIGHT_5, SpringLayout.NORTH, loginMainPanel);
        // Row 3 - Password
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.LOGIN_PASSWORD_LABEL, TicketPOSGUI.LAYOUT_PADDING_3, SpringLayout.WEST, loginMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  loginPasswordTextField,  LAYOUT_PADDING_5, SpringLayout.WEST, loginMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, loginPasswordTextField,  LAYOUT_HEIGHT_6, SpringLayout.NORTH, loginMainPanel);
        // Row 4 - Login Button
        mainLayout.putConstraint(SpringLayout.WEST,  actionLoginButton, TicketPOSGUI.LAYOUT_PADDING_3, SpringLayout.WEST, loginMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.LOGIN_PASSWORD_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_6, SpringLayout.NORTH, loginMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, actionLoginButton, TicketPOSGUI.LAYOUT_HEIGHT_7, SpringLayout.NORTH, loginMainPanel);
        
        // Add elements to Login Panel
        loginMainPanel.add(TicketPOSGUI.LOGIN_FORM_LABEL);
        loginMainPanel.add(TicketPOSGUI.LOGIN_USERNAME_LABEL);
        loginMainPanel.add(loginUsernameTextField);
        loginMainPanel.add(TicketPOSGUI.LOGIN_PASSWORD_LABEL);
        loginMainPanel.add(loginPasswordTextField);
        loginMainPanel.add(actionLoginButton);
        
        // Add Login Panel to Main Panel
		mainWindowPanel.add(loginMainPanel);
        // End Login Panel (screen)
		
		
		
		
		
		// Start Admin Panel (screen)
        // Set Admin Panel Position Inside Main Window Panel
		adminMainPanel = new JPanel ();
		adminMainPanel.setBorder( new TitledBorder ( new EtchedBorder (), "Admin View" ) );
		adminMainPanel.setLayout(mainLayout);
        
        mainLayout.putConstraint(SpringLayout.WEST,  adminMainPanel, 0, SpringLayout.WEST, mainWindowPanel);
        mainLayout.putConstraint(SpringLayout.EAST,  adminMainPanel, 0, SpringLayout.EAST, mainWindowPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, adminMainPanel, 0, SpringLayout.NORTH, mainWindowPanel);
        mainLayout.putConstraint(SpringLayout.SOUTH, adminMainPanel, 0, SpringLayout.SOUTH, mainWindowPanel);        
        
		mainWindowPanel.add(adminMainPanel);
        // End Admin Panel (screen)
        
        // add main panel to the window
        add(mainWindowPanel);
        
        // hide all panels and show customer panel by default
        hideAllPanels();
        customerViewPanel.setVisible(true);    
    }
    
    
    /**
     * Buttons click handler
     */
    public void actionPerformed(ActionEvent e)
    {
        String actionCommand = e.getActionCommand( );
        
        if (actionCommand.equals(TicketPOSGUI.BUTTON_CAPTION_LOGIN)) {
			
			// From Login Form, Check username and password
			
			// Get login form inputs
			String username = loginUsernameTextField.getText();
			String password = loginPasswordTextField.getText();
			
			if(username.equals(TicketPOSGUI.SECRET_USERNAME) && password.equals(TicketPOSGUI.SECRET_PASSWORD)) {
				logAdminIn();
				showPanel(adminMainPanel);
			} else {
				alert("Wrong username or password!", "Error");
			}
		        	
		} else if(actionCommand.equals(TicketPOSGUI.BUTTON_CAPTION_SEARCH)) {
			
    		// From Search Form, Find Movies using user input
			
			// Get search form inputs
			String searchString = searchMovieTextField.getText();
			String searchGenre  = String.valueOf(genreSelectorBox.getSelectedItem());
			String searchTime   = String.valueOf(timeSelectorBox.getSelectedItem());
			
			//@TODO temporarily show search input
			String message = "";
			message += "Search String: '" + searchString + "'" + "\n";
			message += "Selected Genre: " + searchGenre  + "\n";
			message += "Selected Time: "  + searchTime   + "\n";
			
			alert(message, "Info");
			
		} else if(actionCommand.equals(TicketPOSGUI.MENU_ADMIN_MOVIES_VIEW)) {
			
			// From Menu, Show Admin Panel (Screen) where admin can edit movies description
			// if user is not logged in show login screen
			if(! isAdmin()) {
				showPanel(loginMainPanel);
			} else {				
				alert("Movies Edit Screen", "Info");
			}
			
		} else if(actionCommand.equals(TicketPOSGUI.MENU_ADMIN_THEATERS_VIEW)) {
			
			// From Menu, Show Admin Panel (Screen) where admin can edit theater description
			// if user is not logged in show login screen
			if(! isAdmin()) {
				showPanel(loginMainPanel);
			} else {				
				alert("Theater Edit Screen", "Info");
			}
			
		} else if(actionCommand.equals(TicketPOSGUI.MENU_ADMIN_TIMES_VIEW)) {
			
			// From Menu, Show Admin Panel (Screen) where admin can edit times description
			// if user is not logged in show login screen
			if(! isAdmin()) {
				showPanel(loginMainPanel);
			} else {				
				alert("Times Edit Screen", "Info");
			}
			
		} else if(actionCommand.equals(TicketPOSGUI.MENU_ADMIN_GENRES_VIEW)) {
			
			// From Menu, Show Admin Panel (Screen) where admin can edit genres
			// if user is not logged in show login screen
			if(! isAdmin()) {
				showPanel(loginMainPanel);
			} else {				
				alert("Genres Edit Screen", "Info");
			}
			
		} else if(actionCommand.equals(TicketPOSGUI.MENU_ADMIN_SCHEDULE_VIEW)) {
			
			// From Menu, Show Admin Panel (Screen) where admin can edit movie schedule
			// if user is not logged in show login screen
			if(! isAdmin()) {
				showPanel(loginMainPanel);
			} else {				
				alert("Movie Schedule Edit Screen", "Info");
			}
			
		} else if(actionCommand.equals(TicketPOSGUI.MENU_ADMIN_TICKETS_VIEW)) {
			
			// From Menu, Show Admin Panel (Screen) where admin can see all tickets sold
			// if user is not logged in show login screen
			if(! isAdmin()) {
				showPanel(loginMainPanel);
			} else {				
				alert("Tickets View Screen", "Info");
			}
			
		} else if(actionCommand.equals(TicketPOSGUI.MENU_ADMIN_RESERVATIONS_VIEW)) {
			
			// From Menu, Show Admin Panel (Screen) where admin can see all tickets with totals
			// if user is not logged in show login screen
			if(! isAdmin()) {
				showPanel(loginMainPanel);
			} else {				
				alert("Reservations View Screen", "Info");
			}
			
		} else if(actionCommand.equals(TicketPOSGUI.MENU_ADMIN_SALES_VIEW)) {
			
			// From Menu, Show Admin Panel (Screen) where admin can see sales stats
			// if user is not logged in show login screen
			if(! isAdmin()) {
				showPanel(loginMainPanel);
			} else {				
				alert("Sales View Screen", "Info");
			}
			
			
		} else if(actionCommand.equals(TicketPOSGUI.MENU_CUSTOMER_VIEW)) {
			
    		// From Menu, Show Customer (Default) Panel (Screen)
			showPanel(customerViewPanel);
			
		} else if(actionCommand.equals(TicketPOSGUI.MENU_LOGIN_VIEW)) {
			
			// From Menu, Show Login Panel (Screen) if not logged in
			// show Admin panel (screen) if user already logged in
			showPanel(loginMainPanel);
			
		} else if(actionCommand.equals(TicketPOSGUI.MENU_ADMIN_LOGOUT)) {
			
			// From Menu, Log out Admin user and Show Customer Panel (Screen)
			logAdminOut();
			showPanel(customerViewPanel);
			
		} else if(actionCommand.equals(TicketPOSGUI.MENU_EXIT)) {
			
    		// From Menu, Close Window
			System.exit(0);
        	
	    } else {
	    	
	    	// Could not find action
	    	alert("Unexpected error. Could not find Action Handler for '" + actionCommand + "'", "Error");
        }
    }
    
    

   
    
    
    /**
     * Validate report form
     * 
     * @return String with error message, empty String if no error
     */
    private String validateForm() {
    	
		String errorMessage = "";
    	
    	// Validate  if input empty
//    	if(employeeNameTextField.getText().isEmpty()) {
//    		errorMessage += "Please enter employee name." + "\n";
//    	}
//    	if(hourlyWageTextField.getText().isEmpty()) {
//    		errorMessage += "Please enter hourly wage." + "\n";
//    	} else {
//    		try {
//    			if(Double.parseDouble(hourlyWageTextField.getText()) <= 0) {
//            		errorMessage += "Hourly Wage should be more than 0." + "\n";
//            	}
//			} catch (java.lang.NumberFormatException e) {
//				errorMessage += "Hourly Wage should be numer and more than 0." + "\n";
//			}
//    		
//    	}
    	
    	return errorMessage;
    	
    }
    
    
    /**
     * Helper function to hide all panels
     */
    public boolean isAdmin() {
		return isAdmin;
	}
    
    
    /**
     * Helper function to log Admin out
     */
    public void logAdminOut() {
    	isAdmin = false;
    	hideAdminMenu();
    }
    
    
    /**
     * Helper function to log Admin in
     */
    public void logAdminIn() {
    	isAdmin = true;
    	showAdminMenu();
    }
    
    
    /**
     * Helper function to show specific panel
     */
    public void showPanel(JPanel panel) {
    	hideAllPanels();
    	panel.setVisible(true);
    }
    
    
    /**
     * Helper function to hide all panels
     */
    public void hideAllPanels() {
		loginMainPanel.setVisible(false);
		customerViewPanel.setVisible(false);
		adminMainPanel.setVisible(false);
		loginMainPanel.setVisible(false);
	}
    
    
    /**
     * Helper function to show Admin menu
     */
    public void showAdminMenu() {
    	menuAdmin.setVisible(true);
    	menuLoginItem.setVisible(false);
    }
    
		
    /**
     * Helper function to hide Admin menu
     */
    public void hideAdminMenu() {
    	menuAdmin.setVisible(false);
    	menuLoginItem.setVisible(true);
    }	
    
    
    public void loadDefaultData() {
    	
    	// load genres
    	genres.add((new Genre("Action")));
    	genres.add((new Genre("Drama")));
    	genres.add((new Genre("Comedy")));
    	genres.add((new Genre("Kids")));
    	genres.add((new Genre("Horror")));
    	genres.add((new Genre("Romance")));
    	genres.add((new Genre("Sci-fi")));
    	genres.add((new Genre("Animated")));
    	
    	times.add((new MovieTime("9:00a")));
    	times.add((new MovieTime("11:00a")));
    	times.add((new MovieTime("12:00p")));
    	times.add((new MovieTime("1:00p")));
    	times.add((new MovieTime("2:00p")));
    	times.add((new MovieTime("3:00p")));
    	times.add((new MovieTime("5:00p")));
    	times.add((new MovieTime("6:00p")));
    	times.add((new MovieTime("7:00p")));
    	times.add((new MovieTime("9:00p")));
    	times.add((new MovieTime("11:00p")));
    	
    	theaters.add((new Theater("Theater 1", 30)));
    	theaters.add((new Theater("Theater 2", 40)));
    	theaters.add((new Theater("Theater 3", 50)));
    	
    	movies.add(
    			(new Movie("Doctor Sleep", 151, ""))
    			.addGenre(new Genre("Horror"))
    			.addGenre(new Genre("Suspense/Thriller"))
    			.addTime("7:00p")
    			.addTime("8:30p")
    			.addTime("9:30p")
    			.setImage("DoctorSleep2019.jpg")
		);
    	
    	
    	movies.add((new Movie("Last Christmas", 102, ""))
    			.addGenre(new Genre("Comedy"))
    			.addGenre(new Genre("Romance"))
    			.addTime("7:00p")
    			.addTime("9:30p")
    			.setImage("LastChristmas2019.jpg")
		);
    	
    	movies.add(
    			(new Movie("Midway", 138, ""))
    			.addGenre(new Genre("Action/Adventure"))
    			.addGenre(new Genre("Drama"))
    			.addGenre(new Genre("War"))
    			.addTime("10:30p")
    			.addTime("11:30p")
    			.setImage("Midway.jpg")
		);
    	
    	movies.add(
    			(new Movie("Playing Fire", 96, ""))
    			.addGenre(new Genre("Comedy"))
    			.addGenre(new Genre("Family"))
    			.addTime("7:00p")
    			.addTime("11:30p")
    			.setImage("PlayingWithFire.jpg")
		);
    	
    	movies.add(
    			(new Movie("Arctic Dogs", 100, ""))
    			.addGenre(new Genre("Animated"))
    			.addGenre(new Genre("Comedy"))
    			.addGenre(new Genre("Family"))
    			.addTime("8:00p")
    			.addTime("10:00p")
    			.setImage("ArcticDogs.jpg")
		);
    	
    	movies.add(
    			(new Movie("Terminator: Dark Fate", 128, ""))
    			.addGenre(new Genre("Action/Adventure"))
    			.addGenre(new Genre("Sci-Fi/Fantasy"))
    			.addTime("8:00p")
    			.addTime("10:00p")
    			.setImage("TerminatorDarkFate.jpg")
		);
    	
    	movies.add(
    			(new Movie("Countdown", 90, ""))
    			.addGenre(new Genre("Horror"))
    			.addGenre(new Genre("Suspense/Thriller"))
    			.addTime("9:30p")
    			.addTime("11:00p")
    			.setImage("Countdown.jpg")
		);
    	
    	movies.add(
    			(new Movie("Maleficent: Mistress Of Evil", 118, ""))
    			.addGenre(new Genre("Action/Adventure"))
    			.addGenre(new Genre("Family"))
    			.addGenre(new Genre("Sci-Fi/Fantasy"))
    			.addTime("10:30p")
    			.setImage("Maleficent.jpg")
    	);
    	
    	movies.add(
    			(new Movie("The Adams Family", 87, ""))
    			.addGenre(new Genre("Animated"))
    			.addGenre(new Genre("Comedy"))
    			.addGenre(new Genre("Family"))
    			.addTime("8:30p")
    			.setImage("AddamsFamily.jpg")
		);
    	
    	movies.add(
    			(new Movie("Joker", 122, ""))
    			.addGenre(new Genre("Drama"))
    			.addGenre(new Genre("Suspense/Thriller"))
    			.addTime("7:30p")
    			.addTime("9:00p")
    			.setImage("Joker.jpg")
		);
    	
    	
    }
    
    
    /**
     * Helper function to create menu for GUI
     */
    private void loadMenu() {
    	
    	// Create the menu bar.
        menuBar = new JMenuBar();
        
        // Build menu for customer.
        menuDemo = new JMenu(MENU_DEMO);
        menuBar.add(menuDemo);
        
        menuDemoCustomerViewitem = new JMenuItem(TicketPOSGUI.MENU_CUSTOMER_VIEW);
        menuDemoCustomerViewitem.addActionListener(this);
        menuDemo.add(menuDemoCustomerViewitem);
        menuDemo.addSeparator();
        
        menuLoginItem = new JMenuItem(MENU_LOGIN_VIEW);
        menuLoginItem.addActionListener(this);
        menuDemo.add(menuLoginItem);
        menuDemo.addSeparator();
        
        
        menuDemoExitItem = new JMenuItem(MENU_EXIT);
        menuDemoExitItem.addActionListener(this);
        menuDemo.add(menuDemoExitItem);
        
        
        
        // Build menu for Admin
        menuAdmin = new JMenu(MENU_ADMIN);
        menuAdmin.setVisible(isAdmin);
        menuBar.add(menuAdmin);
        
        menuAdminMoviesItem = new JMenuItem(MENU_ADMIN_MOVIES_VIEW);
        menuAdminMoviesItem.addActionListener(this);
        menuAdmin.add(menuAdminMoviesItem);
        
        menuAdminTheatersItem = new JMenuItem(MENU_ADMIN_THEATERS_VIEW);
        menuAdminTheatersItem.addActionListener(this);
        menuAdmin.add(menuAdminTheatersItem);
        
        menuAdminGenresItem = new JMenuItem(MENU_ADMIN_GENRES_VIEW);
        menuAdminGenresItem.addActionListener(this);
        menuAdmin.add(menuAdminGenresItem);
        
        menuAdminTimesItem = new JMenuItem(MENU_ADMIN_TIMES_VIEW);
        menuAdminTimesItem.addActionListener(this);
        menuAdmin.add(menuAdminTimesItem);
        
        menuAdminScheduleItem = new JMenuItem(MENU_ADMIN_SCHEDULE_VIEW);
        menuAdminScheduleItem.addActionListener(this);
        menuAdmin.add(menuAdminScheduleItem);
        menuAdmin.addSeparator();
        
        menuAdminTicketsItem = new JMenuItem(MENU_ADMIN_TICKETS_VIEW);
        menuAdminTicketsItem.addActionListener(this);
        menuAdmin.add(menuAdminTicketsItem);
        
        menuAdminReservationsItem = new JMenuItem(MENU_ADMIN_RESERVATIONS_VIEW);
        menuAdminReservationsItem.addActionListener(this);
        menuAdmin.add(menuAdminReservationsItem);
        
        menuAdminSalesItem = new JMenuItem(MENU_ADMIN_SALES_VIEW);
        menuAdminSalesItem.addActionListener(this);
        menuAdmin.add(menuAdminSalesItem);
        menuAdmin.addSeparator();
        
        menuAdminLogOutItem = new JMenuItem(MENU_ADMIN_LOGOUT);
        menuAdminLogOutItem.addActionListener(this);
        menuAdmin.add(menuAdminLogOutItem);
        
        menuBar.add(menuDemo);
        menuBar.add(menuAdmin);
        setJMenuBar(menuBar);
    }
    
    
    /**
     * Helper function to display messages
     * 
     * @param message (window message text)
     * @param messageHeader (window header)
     */
    private void alert(String message, String messageHeader) {
		JOptionPane.showMessageDialog(null, message, messageHeader, JOptionPane.INFORMATION_MESSAGE);
    }
}
