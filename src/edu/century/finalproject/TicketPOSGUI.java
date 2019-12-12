package edu.century.finalproject;

import edu.century.finalproject.constants.*;

import javax.swing.*;

import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.border.TitledBorder;

import javax.swing.border.EtchedBorder;
import javax.imageio.ImageIO;
import java.awt.Image;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
import java.io.InputStream;
import java.awt.image.BufferedImage;
import java.awt.Insets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Action;

import java.lang.IllegalArgumentException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


// SendGrid
import com.sendgrid.*;
import java.io.IOException;


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
 * @author Yuepeng Yang <yuepeng.yang@my.century.edu>
 */
public class TicketPOSGUI extends JFrame implements ActionListener, GUIConstants, GUILabels, GUIMenu, GUIButtonCaptions, GUIFonts {
	
	/**
	 * Constant properties such as labels, fonts, text field sizes, etc
	 * moved to edu.century.finalproject.constants.* package
	 */
	
	/**
	 * Admin privileges
	 */
	private boolean isAdmin          = false;
	private boolean isEmailEnabled   = false;
	private double  movieTicketPrice = 5;
	
	/**
	 * Admin Username
	 */
	public static String SECRET_USERNAME = "admin";
	
	/**
	 * Admin Password
	 */
	public static String SECRET_PASSWORD = "12345";
	
    /**
     * JTextField for Movie Search
     */
    public JTextField searchMovieTextField        = new JTextField(NUMBER_OF_CHAR_INPUT_LARGE2);
    
    /**
     * JTextField for Customer Info
     */
    private JTextField customerFirstNameTextField = new JTextField(NUMBER_OF_CHAR_INPUT_LARGE);
    private JTextField customerLastNameTextField  = new JTextField(NUMBER_OF_CHAR_INPUT_LARGE);
    private JTextField customerEmailTextField     = new JTextField(NUMBER_OF_CHAR_INPUT_LARGE);
    
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
    
    /**
     * JTextField For Admins
     */
    private JTextField adminSearchReservationTextField = new JTextField(NUMBER_OF_CHAR_INPUT_MEDIUM);
    private JTextField adminSetPriceTextField          = new JTextField(NUMBER_OF_CHAR_INPUT_MEDIUM);
    private JTextField adminSetEmailSendTextField      = new JTextField(NUMBER_OF_CHAR_INPUT_MEDIUM);
    private JTextField adminSetLoginTextField          = new JTextField(NUMBER_OF_CHAR_INPUT_MEDIUM);
    private JTextField adminSetPasswordTextField       = new JTextField(NUMBER_OF_CHAR_INPUT_MEDIUM);
    /**
     * JTextArea for Admins
     */
    private JTextArea adminconsoleTextArea;
    
    // Display Selected Movie Details on Order/Purchase Page
    private BufferedImage bufferedImage           = null;
    private JLabel movieIconLabel                 = new JLabel();
    private JLabel movieTitleLabel                = new JLabel();
    private JLabel movieDescriptionLabel          = new JLabel();
    private JLabel movieTimesLabel                = new JLabel();
    private JLabel movieGenresLabel               = new JLabel();
    private JLabel movieTicketsLeftLabel          = new JLabel();
    private JLabel movieTicketsPriceLabel          = new JLabel();
    
    // Display Reservation Details on Confirmation Page
    private JLabel confirmationNumberLabel        = new JLabel();
    private JLabel confirmationNameLabel          = new JLabel();
    private JLabel confirmationEmailLabel         = new JLabel();
    private JLabel confirmationMovieLabel         = new JLabel();
    private JLabel confirmationDateLabel          = new JLabel();
    private JLabel confirmationTimeLabel          = new JLabel();
    private JLabel confirmationTheaterLabel       = new JLabel();
    private JLabel confirmationNumberTicketsLabel = new JLabel();
    private JLabel confirmationTotalLabel         = new JLabel();

    public static final NumberFormat USD = NumberFormat.getCurrencyInstance();
    
//    private List<Genre>     genres   = new ArrayList<>();
////    private List<Theater>   theaters = new ArrayList<>();
////    private List<Movie>     movies   = new ArrayList<>();
//    private List<MovieTime> times    = new ArrayList<>();
    
    /**
     * To Store Genres
     */
//    private Hashtable<String, Genre> genres = new Hashtable<String, Genre>();
    private List<Genre> genres = new ArrayList<>();
    
    /**
     * To Store Movie times
     */
//    private Hashtable<String, String> times = new Hashtable<String, String>();
    private List<String> times = new ArrayList<>();
    
    /**
     * To Store Movies and search by title
     */
//    private Hashtable<String, Theater> theaters = new Hashtable<String, Theater>();
    private List<Theater> theaters = new ArrayList<>();
    
    /**
     * To Store Movies and search by title
     */
//    private Hashtable<String, Movie> movies = new Hashtable<String, Movie>();
    private List<Movie> movies = new ArrayList<>();
    private MovieMenuCollection movieMenu = new MovieMenuCollection();
    
    /**
     * To Store current reservation
     */
    private Reservation reservation = new Reservation();
    
    /**
     * To Store chosen movie, negative value = not chosen
     */
    private String chosenMovieIndex = "";
    
    /**
     * To Store reservation and search by Reservation number
     */
    private HashMap<String, Reservation> reservations = new HashMap<String, Reservation>();
//    private List<Reservation> reservations = new ArrayList<>();
    
    /**
     * JComboBox for genre selector
     */
    private JComboBox<String> genreSelectorBox;
    
    /**
     * JComboBox for period selector
     */
    private JComboBox<String> timeSelectorBox;
    
    /**
     * JComboBox for time selector
     */
    private JComboBox<String> orderTicketsDateSelectorBox = new JComboBox(); 
    
    /**
     * JComboBox for time selector
     */
    private JComboBox<String> orderTicketsTimeSelectorBox = new JComboBox(); 
    
    /**
     * JComboBox for number tickets selector
     */
    private JComboBox<String> orderTicketsNumberTicketsSelectorBox = new JComboBox(GUIConstants.NUMBER_TICKETS_ARRAY); 
    
    /**
     * JComboBox for sort selector
     */
    private JComboBox<String> sortMoviesSelectorBox = new JComboBox(); 
    
    
    /**
	 * Menus
	 */
	JMenuBar  menuBar;
	JMenu     menuDemo, menuLogIn, menuAdmin;
	JMenuItem menuDemoCustomerViewitem,
			  menuDemoOrderPageViewitem,
			  menuDemoConfirmationPageViewitem,
			  menuDemoExitItem,
		  	  menuLoginItem; 
	JMenuItem menuAdminFindResrvationItem, 
		      menuAdminSettingsItem, 
			  menuAdminReservationsItem, 
			  menuAdminScheduleItem,
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
	JScrollPane movieMenuScrollPanel;
	JPanel searchBarPanel;
	
	// Sub panel of mainPanel 
	// where admin will enter login and password
	// (view from admin perspective)
	JPanel loginMainPanel;
	
	// Sub panel of mainPanel - customer Main Panel 
	// where admin can see movies, orders and edit data
	// (view from admin perspective)
	JPanel adminMainPanel;
	JPanel adminReservationsPanel;
	JPanel adminSchedulePanel;
	JPanel adminSettingsPanel;
	
	// Order page
	JPanel orderPageMainPanel;
	
	// Confirmation page
	JPanel confirmationPageMainPanel;
	
	JButton actionAdminRefundReservationButton;
	
	public String defaultDate = "2019-12-11";
	
    
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
        
//        System.out.println(genres);
        
//        System.out.println(movies);
//        System.out.println(genres);
//        System.out.println(times);
//        System.out.println(times);
        
        loadDefaultData();
        // load comboboxes
        String[] arrayGenres = new String[genres.size()];
        for (int i = 0; i < genres.size(); i++) {
        	arrayGenres[i] = genres.get(i).getGenreName();
		}
        genreSelectorBox = new JComboBox(arrayGenres);
        genreSelectorBox.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
            	searchMovies();
            }
        });
        
        String[] arrayTimes = new String[times.size()];
        for (int i = 0; i < times.size(); i++) {
        	arrayTimes[i] = times.get(i).toString();
		}
        timeSelectorBox = new JComboBox(arrayTimes);
        timeSelectorBox.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
            	searchMovies();
            }
        });
        
        sortMoviesSelectorBox = new JComboBox(TicketPOSGUI.SORT_OPTIONS_ARRAY);
        sortMoviesSelectorBox.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
            	searchMovies();
            }
        });
        
        
        String[] arrayDate = {"2019-12-11 Wednesday","2019-12-12 Thursday","2019-12-13 Friday","2019-12-14 Saturday","2019-12-15 Sunday"};
        orderTicketsDateSelectorBox = new JComboBox(arrayDate);
        orderTicketsDateSelectorBox.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
            	updateRemaningSeats();
            }
        });
        orderTicketsTimeSelectorBox.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
            	updateRemaningSeats();
            }
        });
        
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
        
        // Sort
        JButton actionSortButton = new JButton(BUTTON_CAPTION_SORT);
        actionSortButton.addActionListener(this);
        
        // Login
        JButton actionLoginButton = new JButton(BUTTON_CAPTION_LOGIN);
        actionLoginButton.addActionListener(this);
        
        // Back (Purchase tickets)
        JButton actionBackButton = new JButton(BUTTON_CAPTION_BACK);
        actionBackButton.addActionListener(this);
        
        // Back (Confirmation Page)
        JButton actionBackAfterPurchaseButton = new JButton(BUTTON_CAPTION_EXIT);
        actionBackAfterPurchaseButton.addActionListener(this);
        
        // Order (Purchase tickets)
        JButton actionOrderButton = new JButton(BUTTON_CAPTION_ORDER);
        actionOrderButton.addActionListener(this);
        
        // Populate Order Page With Test Values
        JButton actionOrderTestValuesButton = new JButton(BUTTON_CAPTION_ORDER_TEST_VALUES);
        actionOrderTestValuesButton.addActionListener(this);
        
        // Populate Order Page With Test Values
        JButton actionOrderResetFormButton = new JButton(BUTTON_CAPTION_ORDER_RESET_FORM);
        actionOrderResetFormButton.addActionListener(this);
        
        // Search Reservation
        JButton actionAdminSearchReservationButton = new JButton(BUTTON_CAPTION_ADMIN_FIND_RESERVATION);
        actionAdminSearchReservationButton.addActionListener(this);
        
        // Refund Reservation
        actionAdminRefundReservationButton = new JButton(BUTTON_CAPTION_ADMIN_REFUND_RESERVATION);
        actionAdminRefundReservationButton.addActionListener(this);
        
        // Update Price
        JButton actionAdminUpdatePriceButton = new JButton(BUTTON_CAPTION_ADMIN_SET_PRICE);
        actionAdminUpdatePriceButton.addActionListener(this);
        
        // Update Email Settings
        JButton actionAdminUpdateEmailSettingsButton = new JButton(BUTTON_CAPTION_ADMIN_SET_EMAIL_SENDING);
        actionAdminUpdateEmailSettingsButton.addActionListener(this);
        
        // Update Login
        JButton actionAdminUpdateLoginButton = new JButton(BUTTON_CAPTION_ADMIN_SET_LOGIN);
        actionAdminUpdateLoginButton.addActionListener(this);
        
        // Update Password
        JButton actionAdminUpdatePasswordButton = new JButton(BUTTON_CAPTION_ADMIN_SET_PASSWORD);
        actionAdminUpdatePasswordButton.addActionListener(this);
        
        
        /**
         * Text AreA
         */
        // text area
        adminconsoleTextArea = new JTextArea(TEXTAREA_NUMBER_OF_LINES, TEXTAREA_NUMBER_OF_CHAR);
        adminconsoleTextArea.setFont(TicketPOSGUI.FONT_18);
        // add scroll to text area
        JScrollPane scrollPanelTextArea = new JScrollPane(adminconsoleTextArea);
        scrollPanelTextArea.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        
        
        
        /**
         *  Start Customer Panel (screen)
         */
        // Set Customer Panel Position Inside Main Window Panel
        customerViewPanel = new JPanel ();
        customerViewPanel.setBorder( new TitledBorder ( new EtchedBorder (), "" ) ); // Customer View
        customerViewPanel.setLayout(mainLayout);
        
        // Content block of the movies where we add movies
        searchBarPanel = new JPanel ();
//        searchBarPanel.setBorder( new TitledBorder ( new EtchedBorder (), "" ) ); // searchBarPanel
        searchBarPanel.setLayout(mainLayout);
//        searchBarPanel.setPreferredSize(new Dimension(1000, 70));
        
        // Sub Panel of Customer Panel where movie menu will be displayed
        movieMenuPanel = new JPanel ();
//        movieMenuPanel.setBorder( new TitledBorder ( new EtchedBorder (), "" ) ); // movieMenuMainPanel
//        movieMenuPanel.setPreferredSize(new Dimension(1000, 600));
        
        // Content block of the movies where we add movies
        movieMenuContentPanel = new JPanel ();
//        movieMenuContentPanel.setBorder( new TitledBorder ( new EtchedBorder (), "movieMenuContentPanel" ) ); //movieMenuContentPanel
        movieMenuContentPanel.setLayout(gridLayoutMovie);
//        movieMenuContentPanel.setPreferredSize(new Dimension(1000, 600));
        
        
        displayMovieMenu();
        
        // Add Scroll Panel to content block
        movieMenuScrollPanel = new JScrollPane(
        		movieMenuContentPanel, 
        		ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,  
        		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
		);
        movieMenuScrollPanel.setMinimumSize(new Dimension(1160, 620));
        movieMenuScrollPanel.setPreferredSize(new Dimension(1160, 620));
        movieMenuScrollPanel.getVerticalScrollBar().setUnitIncrement(25);
        
        
        // Layout
        // Set Customer Panel/Screen position inside Main Window Panel
        mainLayout.putConstraint(SpringLayout.WEST,  customerViewPanel, 0, SpringLayout.WEST, mainWindowPanel);
        mainLayout.putConstraint(SpringLayout.EAST,  customerViewPanel, 0, SpringLayout.EAST, mainWindowPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, customerViewPanel, 0, SpringLayout.NORTH, mainWindowPanel);
        mainLayout.putConstraint(SpringLayout.SOUTH, customerViewPanel, 0, SpringLayout.SOUTH, mainWindowPanel); 
        
        mainLayout.putConstraint(SpringLayout.WEST,  searchBarPanel, 0, SpringLayout.WEST, customerViewPanel);
        mainLayout.putConstraint(SpringLayout.EAST,  searchBarPanel, 0, SpringLayout.EAST, customerViewPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, searchBarPanel, 0, SpringLayout.NORTH, customerViewPanel);
        mainLayout.putConstraint(SpringLayout.SOUTH, searchBarPanel, 40, SpringLayout.NORTH, customerViewPanel); 
        
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
        
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.SORT_LABEL,        TicketPOSGUI.LAYOUT_PADDING_2, SpringLayout.EAST,  timeSelectorBox);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.SORT_LABEL,        TicketPOSGUI.LAYOUT_HEIGHT_1+3,  SpringLayout.NORTH, searchBarPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  sortMoviesSelectorBox,          TicketPOSGUI.LAYOUT_PADDING_1, SpringLayout.EAST,  TicketPOSGUI.SORT_LABEL);
        mainLayout.putConstraint(SpringLayout.NORTH, sortMoviesSelectorBox,          TicketPOSGUI.LAYOUT_HEIGHT_1,  SpringLayout.NORTH, searchBarPanel);
        
        mainLayout.putConstraint(SpringLayout.WEST,  actionSearchButton,             TicketPOSGUI.LAYOUT_PADDING_2, SpringLayout.EAST,  sortMoviesSelectorBox);
        mainLayout.putConstraint(SpringLayout.NORTH, actionSearchButton,             TicketPOSGUI.LAYOUT_HEIGHT_1,  SpringLayout.NORTH, searchBarPanel);
//        mainLayout.putConstraint(SpringLayout.WEST,  actionSortButton,               TicketPOSGUI.LAYOUT_PADDING_1, SpringLayout.EAST,  sortMoviesSelectorBox);
//        mainLayout.putConstraint(SpringLayout.NORTH, actionSortButton,               TicketPOSGUI.LAYOUT_HEIGHT_1,  SpringLayout.NORTH, searchBarPanel);
        
        // Set Customer Panel/Screen position inside Main Window Panel
        mainLayout.putConstraint(SpringLayout.WEST,  movieMenuPanel, 0, SpringLayout.WEST,  customerViewPanel);
        mainLayout.putConstraint(SpringLayout.EAST,  movieMenuPanel, 0, SpringLayout.EAST,  customerViewPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, movieMenuPanel, 10, SpringLayout.SOUTH, searchBarPanel);
        mainLayout.putConstraint(SpringLayout.SOUTH, movieMenuPanel, 10, SpringLayout.SOUTH, customerViewPanel);
        
        searchMovieTextField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER) {
                   searchMovies();
                }
             }
          });

        
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
        searchBarPanel.add(TicketPOSGUI.SORT_LABEL);
        searchBarPanel.add(sortMoviesSelectorBox);
//        searchBarPanel.add(actionSortButton);
        
        movieMenuPanel.add(movieMenuScrollPanel);

        customerViewPanel.add(searchBarPanel);
        customerViewPanel.add(movieMenuPanel);
        
        // Add Customer Panel/Screen to Main Window Panel
		mainWindowPanel.add(customerViewPanel);
        // End Customer Panel (screen)
		
		
		
		/**
         *  Start Order Page Panel (screen)
         */
		// Set Login Panel Position Inside Main Window Panel
		orderPageMainPanel = new JPanel ();
		orderPageMainPanel.setBorder( new TitledBorder ( new EtchedBorder (), "Order" ) );
		orderPageMainPanel.setLayout(mainLayout);
		
		// Set Login Panel/Screen position inside Main Window Panel
        mainLayout.putConstraint(SpringLayout.WEST,  orderPageMainPanel, 0, SpringLayout.WEST, mainWindowPanel);
        mainLayout.putConstraint(SpringLayout.EAST,  orderPageMainPanel, 0, SpringLayout.EAST, mainWindowPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, orderPageMainPanel, 0, SpringLayout.NORTH, mainWindowPanel);
        mainLayout.putConstraint(SpringLayout.SOUTH, orderPageMainPanel, 0, SpringLayout.SOUTH, mainWindowPanel);
        
        // Set position of the elements inside Login Panel/Screen
        // Movie Description
        movieTitleLabel.setFont(GUIFonts.FONT_18);
        
        mainLayout.putConstraint(SpringLayout.WEST,  movieTitleLabel, TicketPOSGUI.LAYOUT_PADDING_2, SpringLayout.WEST, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, movieTitleLabel, TicketPOSGUI.LAYOUT_HEIGHT_3, SpringLayout.NORTH, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  movieIconLabel, TicketPOSGUI.LAYOUT_PADDING_2, SpringLayout.WEST, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, movieIconLabel, TicketPOSGUI.LAYOUT_HEIGHT_4, SpringLayout.NORTH, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  movieTimesLabel, TicketPOSGUI.LAYOUT_PADDING_7, SpringLayout.WEST, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, movieTimesLabel, TicketPOSGUI.LAYOUT_HEIGHT_3, SpringLayout.NORTH, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  movieGenresLabel, TicketPOSGUI.LAYOUT_PADDING_7, SpringLayout.WEST, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, movieGenresLabel, TicketPOSGUI.LAYOUT_HEIGHT_4, SpringLayout.NORTH, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  movieDescriptionLabel, TicketPOSGUI.LAYOUT_PADDING_7, SpringLayout.WEST, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, movieDescriptionLabel, TicketPOSGUI.LAYOUT_HEIGHT_5, SpringLayout.NORTH, orderPageMainPanel);
        
        // Row 0 - Back Button
        mainLayout.putConstraint(SpringLayout.WEST,  actionBackButton, TicketPOSGUI.LAYOUT_PADDING_1, SpringLayout.WEST, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, actionBackButton, TicketPOSGUI.LAYOUT_HEIGHT_1, SpringLayout.NORTH, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.SELECT_TICKETS_LABEL, TicketPOSGUI.LAYOUT_PADDING_14, SpringLayout.WEST, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.SELECT_TICKETS_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_1+20, SpringLayout.NORTH, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  movieTicketsPriceLabel, TicketPOSGUI.LAYOUT_PADDING_1, SpringLayout.EAST, TicketPOSGUI.SELECT_TICKETS_LABEL);
        mainLayout.putConstraint(SpringLayout.NORTH, movieTicketsPriceLabel, TicketPOSGUI.LAYOUT_HEIGHT_1+20, SpringLayout.NORTH, orderPageMainPanel);
        TicketPOSGUI.SELECT_TICKETS_LABEL.setFont(GUIFonts.FONT_18);
        movieTicketsPriceLabel.setFont(GUIFonts.FONT_18);
        
        
        
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.PAYMENT_FORM_LABEL, TicketPOSGUI.LAYOUT_PADDING_14, SpringLayout.WEST, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.PAYMENT_FORM_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_8, SpringLayout.NORTH, orderPageMainPanel);
        TicketPOSGUI.PAYMENT_FORM_LABEL.setFont(GUIFonts.FONT_18);
       
        // Row - Select Date
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.TICKETS_AVAILABLE_LABEL, TicketPOSGUI.LAYOUT_PADDING_14, SpringLayout.WEST, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.TICKETS_AVAILABLE_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_2+25, SpringLayout.NORTH, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  movieTicketsLeftLabel,  LAYOUT_PADDING_16, SpringLayout.WEST, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, movieTicketsLeftLabel,  LAYOUT_HEIGHT_2+25, SpringLayout.NORTH, orderPageMainPanel);
        TicketPOSGUI.TICKETS_AVAILABLE_LABEL.setFont(GUIFonts.FONT_18);
        movieTicketsLeftLabel.setFont(GUIFonts.FONT_18);
        
        
        // Row - Select Date
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.SELECT_TICKETS_DATE_LABEL, TicketPOSGUI.LAYOUT_PADDING_14, SpringLayout.WEST, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.SELECT_TICKETS_DATE_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_4, SpringLayout.NORTH, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  orderTicketsDateSelectorBox,  LAYOUT_PADDING_16, SpringLayout.WEST, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, orderTicketsDateSelectorBox,  LAYOUT_HEIGHT_4, SpringLayout.NORTH, orderPageMainPanel);
        
        // Row - Select Time
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.SELECT_TICKETS_TIME_LABEL, TicketPOSGUI.LAYOUT_PADDING_14, SpringLayout.WEST, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.SELECT_TICKETS_TIME_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_5, SpringLayout.NORTH, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  orderTicketsTimeSelectorBox,  LAYOUT_PADDING_16, SpringLayout.WEST, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, orderTicketsTimeSelectorBox,  LAYOUT_HEIGHT_5, SpringLayout.NORTH, orderPageMainPanel);
        
        // Row - Select Number Tickets
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.SELECT_TICKETS_NUMBER_LABEL, TicketPOSGUI.LAYOUT_PADDING_14, SpringLayout.WEST, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.SELECT_TICKETS_NUMBER_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_6, SpringLayout.NORTH, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  orderTicketsNumberTicketsSelectorBox,  LAYOUT_PADDING_16, SpringLayout.WEST, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, orderTicketsNumberTicketsSelectorBox,  LAYOUT_HEIGHT_6, SpringLayout.NORTH, orderPageMainPanel);
        
        // Row - Customer First Name
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.CUSTOMER_FIRST_NAME_LABEL, TicketPOSGUI.LAYOUT_PADDING_14, SpringLayout.WEST, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.CUSTOMER_FIRST_NAME_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_9+20, SpringLayout.NORTH, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  customerFirstNameTextField,  LAYOUT_PADDING_16, SpringLayout.WEST, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, customerFirstNameTextField,  LAYOUT_HEIGHT_9+20, SpringLayout.NORTH, orderPageMainPanel);
        // Row - Customer Last Name
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.CUSTOMER_LAST_NAME_LABEL, TicketPOSGUI.LAYOUT_PADDING_14, SpringLayout.WEST, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.CUSTOMER_LAST_NAME_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_10+20, SpringLayout.NORTH, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  customerLastNameTextField,  LAYOUT_PADDING_16, SpringLayout.WEST, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, customerLastNameTextField,  LAYOUT_HEIGHT_10+20, SpringLayout.NORTH, orderPageMainPanel);
        // Row - Customer Email
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.CUSTOMER_EMAIL_LABEL, TicketPOSGUI.LAYOUT_PADDING_14, SpringLayout.WEST, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.CUSTOMER_EMAIL_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_11+20, SpringLayout.NORTH, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  customerEmailTextField,  LAYOUT_PADDING_16, SpringLayout.WEST, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, customerEmailTextField,  LAYOUT_HEIGHT_11+20, SpringLayout.NORTH, orderPageMainPanel);
        // Row - Customer Card Number
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.CARD_NUMBER_LABEL, TicketPOSGUI.LAYOUT_PADDING_14, SpringLayout.WEST, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.CARD_NUMBER_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_12+20, SpringLayout.NORTH, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  cardNumberTextField,  LAYOUT_PADDING_16, SpringLayout.WEST, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, cardNumberTextField,  LAYOUT_HEIGHT_12+20, SpringLayout.NORTH, orderPageMainPanel);
        // Row - Customer Card Expiration
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.CARD_EXP_MONTH_LABEL, TicketPOSGUI.LAYOUT_PADDING_14, SpringLayout.WEST, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.CARD_EXP_MONTH_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_13+20, SpringLayout.NORTH, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  cardExpMonthTextField,  LAYOUT_PADDING_16, SpringLayout.WEST, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, cardExpMonthTextField,  LAYOUT_HEIGHT_13+20, SpringLayout.NORTH, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.CARD_EXP_YEAR_LABEL, TicketPOSGUI.LAYOUT_PADDING_18, SpringLayout.WEST, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.CARD_EXP_YEAR_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_13+20, SpringLayout.NORTH, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  cardExpYearTextField,  LAYOUT_PADDING_1, SpringLayout.EAST, TicketPOSGUI.CARD_EXP_YEAR_LABEL);
        mainLayout.putConstraint(SpringLayout.NORTH, cardExpYearTextField,  LAYOUT_HEIGHT_13+20, SpringLayout.NORTH, orderPageMainPanel);
        // Row - Customer Card Zip Code
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.CARD_ZIP_LABEL, TicketPOSGUI.LAYOUT_PADDING_14, SpringLayout.WEST, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.CARD_ZIP_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_14+20, SpringLayout.NORTH, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  cardZipTextField,  LAYOUT_PADDING_16, SpringLayout.WEST, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, cardZipTextField,  LAYOUT_HEIGHT_14+20, SpringLayout.NORTH, orderPageMainPanel);
        // Row - Order Button
        mainLayout.putConstraint(SpringLayout.WEST,  actionOrderButton, TicketPOSGUI.LAYOUT_PADDING_14, SpringLayout.WEST, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, actionOrderButton, TicketPOSGUI.LAYOUT_HEIGHT_16, SpringLayout.NORTH, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  actionOrderTestValuesButton, TicketPOSGUI.LAYOUT_PADDING_1, SpringLayout.EAST, actionOrderButton);
        mainLayout.putConstraint(SpringLayout.NORTH, actionOrderTestValuesButton, TicketPOSGUI.LAYOUT_HEIGHT_16, SpringLayout.NORTH, orderPageMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  actionOrderResetFormButton, TicketPOSGUI.LAYOUT_PADDING_1, SpringLayout.EAST, actionOrderTestValuesButton);
        mainLayout.putConstraint(SpringLayout.NORTH, actionOrderResetFormButton, TicketPOSGUI.LAYOUT_HEIGHT_16, SpringLayout.NORTH, orderPageMainPanel);
        
        // Add elements to Login Panel
        orderPageMainPanel.add(TicketPOSGUI.SELECT_TICKETS_LABEL);
        orderPageMainPanel.add(TicketPOSGUI.TICKETS_AVAILABLE_LABEL);
        orderPageMainPanel.add(TicketPOSGUI.SELECT_TICKETS_DATE_LABEL);
        orderPageMainPanel.add(TicketPOSGUI.SELECT_TICKETS_TIME_LABEL);
        orderPageMainPanel.add(TicketPOSGUI.SELECT_TICKETS_NUMBER_LABEL);
        orderPageMainPanel.add(movieTicketsLeftLabel);
        orderPageMainPanel.add(movieTicketsPriceLabel);
        orderPageMainPanel.add(orderTicketsTimeSelectorBox);
        orderPageMainPanel.add(orderTicketsDateSelectorBox);
        orderPageMainPanel.add(orderTicketsNumberTicketsSelectorBox);
        
        orderPageMainPanel.add(TicketPOSGUI.PAYMENT_FORM_LABEL);
        orderPageMainPanel.add(TicketPOSGUI.CUSTOMER_FIRST_NAME_LABEL);
        orderPageMainPanel.add(TicketPOSGUI.CUSTOMER_LAST_NAME_LABEL);
        orderPageMainPanel.add(TicketPOSGUI.CUSTOMER_EMAIL_LABEL);
        orderPageMainPanel.add(TicketPOSGUI.CARD_NUMBER_LABEL);
        orderPageMainPanel.add(TicketPOSGUI.CARD_EXP_MONTH_LABEL);
        orderPageMainPanel.add(TicketPOSGUI.CARD_EXP_YEAR_LABEL);
        orderPageMainPanel.add(TicketPOSGUI.CARD_ZIP_LABEL);
        orderPageMainPanel.add(customerFirstNameTextField);
        orderPageMainPanel.add(customerLastNameTextField);
        orderPageMainPanel.add(customerEmailTextField);
        orderPageMainPanel.add(cardNumberTextField);
        orderPageMainPanel.add(cardExpMonthTextField);
        orderPageMainPanel.add(cardExpYearTextField);
        orderPageMainPanel.add(cardZipTextField);
        
        orderPageMainPanel.add(actionBackButton);
        orderPageMainPanel.add(actionOrderButton);
        orderPageMainPanel.add(actionOrderTestValuesButton);
        orderPageMainPanel.add(actionOrderResetFormButton);
        orderPageMainPanel.add(movieIconLabel);
        orderPageMainPanel.add(movieTitleLabel);
        orderPageMainPanel.add(movieDescriptionLabel);
        orderPageMainPanel.add(movieGenresLabel);
        orderPageMainPanel.add(movieTimesLabel);
        
        
        
        // Add Login Panel to Main Panel
		mainWindowPanel.add(orderPageMainPanel);
		// End Order Page Panel (screen)
		
		
		
		
		/**
         *  Start Confirmation Page Panel (screen)
         */
		// Set Login Panel Position Inside Main Window Panel
		confirmationPageMainPanel = new JPanel ();
		confirmationPageMainPanel.setBorder( new TitledBorder ( new EtchedBorder (), "Confirmation" ) );
		confirmationPageMainPanel.setLayout(mainLayout);
		
		// Set Login Panel/Screen position inside Main Window Panel
        mainLayout.putConstraint(SpringLayout.WEST,  confirmationPageMainPanel, 0, SpringLayout.WEST, mainWindowPanel);
        mainLayout.putConstraint(SpringLayout.EAST,  confirmationPageMainPanel, 0, SpringLayout.EAST, mainWindowPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, confirmationPageMainPanel, 0, SpringLayout.NORTH, mainWindowPanel);
        mainLayout.putConstraint(SpringLayout.SOUTH, confirmationPageMainPanel, 0, SpringLayout.SOUTH, mainWindowPanel);
        
        // Set position of the elements inside Login Panel/Screen
        // Row 0 - Back Button
        mainLayout.putConstraint(SpringLayout.WEST,  actionBackAfterPurchaseButton, TicketPOSGUI.LAYOUT_PADDING_1, SpringLayout.WEST, confirmationPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, actionBackAfterPurchaseButton, TicketPOSGUI.LAYOUT_HEIGHT_1, SpringLayout.NORTH, confirmationPageMainPanel);
        
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.CONFIRMATION_TITLE_LABEL, TicketPOSGUI.LAYOUT_PADDING_7, SpringLayout.WEST, confirmationPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.CONFIRMATION_TITLE_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_4, SpringLayout.NORTH, confirmationPageMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.CONFIRMATION_NUMBER_LABEL, TicketPOSGUI.LAYOUT_PADDING_7, SpringLayout.WEST, confirmationPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.CONFIRMATION_NUMBER_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_5, SpringLayout.NORTH, confirmationPageMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  confirmationNumberLabel, TicketPOSGUI.LAYOUT_PADDING_10, SpringLayout.WEST, confirmationPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, confirmationNumberLabel, TicketPOSGUI.LAYOUT_HEIGHT_5, SpringLayout.NORTH, confirmationPageMainPanel);
        
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.CONFIRMATION_NAME_LABEL, TicketPOSGUI.LAYOUT_PADDING_7, SpringLayout.WEST, confirmationPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.CONFIRMATION_NAME_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_6, SpringLayout.NORTH, confirmationPageMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  confirmationNameLabel, TicketPOSGUI.LAYOUT_PADDING_10, SpringLayout.WEST, confirmationPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, confirmationNameLabel, TicketPOSGUI.LAYOUT_HEIGHT_6, SpringLayout.NORTH, confirmationPageMainPanel);
        
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.CONFIRMATION_EMAIL_LABEL, TicketPOSGUI.LAYOUT_PADDING_7, SpringLayout.WEST, confirmationPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.CONFIRMATION_EMAIL_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_7, SpringLayout.NORTH, confirmationPageMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  confirmationEmailLabel, TicketPOSGUI.LAYOUT_PADDING_10, SpringLayout.WEST, confirmationPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, confirmationEmailLabel, TicketPOSGUI.LAYOUT_HEIGHT_7, SpringLayout.NORTH, confirmationPageMainPanel);
        
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.CONFIRMATION_MOVIE_LABEL, TicketPOSGUI.LAYOUT_PADDING_7, SpringLayout.WEST, confirmationPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.CONFIRMATION_MOVIE_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_8, SpringLayout.NORTH, confirmationPageMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  confirmationMovieLabel, TicketPOSGUI.LAYOUT_PADDING_10, SpringLayout.WEST, confirmationPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, confirmationMovieLabel, TicketPOSGUI.LAYOUT_HEIGHT_8, SpringLayout.NORTH, confirmationPageMainPanel);
        
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.CONFIRMATION_DATE_LABEL, TicketPOSGUI.LAYOUT_PADDING_7, SpringLayout.WEST, confirmationPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.CONFIRMATION_DATE_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_9, SpringLayout.NORTH, confirmationPageMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  confirmationDateLabel, TicketPOSGUI.LAYOUT_PADDING_10, SpringLayout.WEST, confirmationPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, confirmationDateLabel, TicketPOSGUI.LAYOUT_HEIGHT_9, SpringLayout.NORTH, confirmationPageMainPanel);
        
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.CONFIRMATION_TIME_LABEL, TicketPOSGUI.LAYOUT_PADDING_7, SpringLayout.WEST, confirmationPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.CONFIRMATION_TIME_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_10, SpringLayout.NORTH, confirmationPageMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  confirmationTimeLabel, TicketPOSGUI.LAYOUT_PADDING_10, SpringLayout.WEST, confirmationPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, confirmationTimeLabel, TicketPOSGUI.LAYOUT_HEIGHT_10, SpringLayout.NORTH, confirmationPageMainPanel);
        
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.CONFIRMATION_THEATER_LABEL, TicketPOSGUI.LAYOUT_PADDING_7, SpringLayout.WEST, confirmationPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.CONFIRMATION_THEATER_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_11, SpringLayout.NORTH, confirmationPageMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  confirmationTheaterLabel, TicketPOSGUI.LAYOUT_PADDING_10, SpringLayout.WEST, confirmationPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, confirmationTheaterLabel, TicketPOSGUI.LAYOUT_HEIGHT_11, SpringLayout.NORTH, confirmationPageMainPanel);
        
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.CONFIRMATION_NUMBER_TICKETS_LABEL, TicketPOSGUI.LAYOUT_PADDING_7, SpringLayout.WEST, confirmationPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.CONFIRMATION_NUMBER_TICKETS_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_12, SpringLayout.NORTH, confirmationPageMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  confirmationNumberTicketsLabel, TicketPOSGUI.LAYOUT_PADDING_10, SpringLayout.WEST, confirmationPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, confirmationNumberTicketsLabel, TicketPOSGUI.LAYOUT_HEIGHT_12, SpringLayout.NORTH, confirmationPageMainPanel);
        
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.CONFIRMATION_TOTAL_LABEL, TicketPOSGUI.LAYOUT_PADDING_7, SpringLayout.WEST, confirmationPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.CONFIRMATION_TOTAL_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_13, SpringLayout.NORTH, confirmationPageMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  confirmationTotalLabel, TicketPOSGUI.LAYOUT_PADDING_10, SpringLayout.WEST, confirmationPageMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, confirmationTotalLabel, TicketPOSGUI.LAYOUT_HEIGHT_13, SpringLayout.NORTH, confirmationPageMainPanel);       
        
        // Add elements to Login Panel
        confirmationPageMainPanel.add(TicketPOSGUI.CONFIRMATION_TITLE_LABEL);
        confirmationPageMainPanel.add(TicketPOSGUI.CONFIRMATION_NUMBER_LABEL);
        confirmationPageMainPanel.add(TicketPOSGUI.CONFIRMATION_NAME_LABEL);
        confirmationPageMainPanel.add(TicketPOSGUI.CONFIRMATION_EMAIL_LABEL);
        confirmationPageMainPanel.add(TicketPOSGUI.CONFIRMATION_MOVIE_LABEL);
        confirmationPageMainPanel.add(TicketPOSGUI.CONFIRMATION_DATE_LABEL);
        confirmationPageMainPanel.add(TicketPOSGUI.CONFIRMATION_TIME_LABEL);
        confirmationPageMainPanel.add(TicketPOSGUI.CONFIRMATION_THEATER_LABEL);
        confirmationPageMainPanel.add(TicketPOSGUI.CONFIRMATION_NUMBER_TICKETS_LABEL);
        confirmationPageMainPanel.add(TicketPOSGUI.CONFIRMATION_TOTAL_LABEL);
        
        confirmationPageMainPanel.add(confirmationNumberLabel);
        confirmationPageMainPanel.add(confirmationNameLabel);
        confirmationPageMainPanel.add(confirmationEmailLabel);
        confirmationPageMainPanel.add(confirmationMovieLabel);
        confirmationPageMainPanel.add(confirmationDateLabel);
        confirmationPageMainPanel.add(confirmationTimeLabel);
        confirmationPageMainPanel.add(confirmationTheaterLabel);
        confirmationPageMainPanel.add(confirmationNumberTicketsLabel);
        confirmationPageMainPanel.add(confirmationTotalLabel);
        
        confirmationPageMainPanel.add(actionBackAfterPurchaseButton);
        
        
        
        // Add Confirmation Page Panel to Main Panel
		mainWindowPanel.add(confirmationPageMainPanel);
		// End Confirmation Page Panel (screen)
		
		
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
        
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.ADMIN_SEARCH_RESERVATION_LABEL, TicketPOSGUI.LAYOUT_PADDING_1, SpringLayout.WEST, adminMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.ADMIN_SEARCH_RESERVATION_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_1, SpringLayout.NORTH, adminMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  adminSearchReservationTextField, TicketPOSGUI.LAYOUT_PADDING_5, SpringLayout.WEST, adminMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, adminSearchReservationTextField, TicketPOSGUI.LAYOUT_HEIGHT_1, SpringLayout.NORTH, adminMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  actionAdminSearchReservationButton, TicketPOSGUI.LAYOUT_PADDING_8, SpringLayout.WEST, adminMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, actionAdminSearchReservationButton, TicketPOSGUI.LAYOUT_HEIGHT_1, SpringLayout.NORTH, adminMainPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  actionAdminRefundReservationButton, TicketPOSGUI.LAYOUT_PADDING_11, SpringLayout.WEST, adminMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, actionAdminRefundReservationButton, TicketPOSGUI.LAYOUT_HEIGHT_1, SpringLayout.NORTH, adminMainPanel);
        
        actionAdminRefundReservationButton.setVisible(false);
        
        mainLayout.putConstraint(SpringLayout.WEST,  scrollPanelTextArea, TicketPOSGUI.LAYOUT_PADDING_1, SpringLayout.WEST, adminMainPanel);
        mainLayout.putConstraint(SpringLayout.EAST,  scrollPanelTextArea, -TicketPOSGUI.LAYOUT_PADDING_1, SpringLayout.EAST, adminMainPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, scrollPanelTextArea, TicketPOSGUI.LAYOUT_HEIGHT_2, SpringLayout.NORTH, adminMainPanel);
        mainLayout.putConstraint(SpringLayout.SOUTH, scrollPanelTextArea, -TicketPOSGUI.LAYOUT_HEIGHT_1, SpringLayout.SOUTH, adminMainPanel);
        
        adminMainPanel.add(TicketPOSGUI.ADMIN_SEARCH_RESERVATION_LABEL);
        adminMainPanel.add(adminSearchReservationTextField);
        adminMainPanel.add(actionAdminSearchReservationButton);
        adminMainPanel.add(actionAdminRefundReservationButton);
        adminMainPanel.add(scrollPanelTextArea);
        
		mainWindowPanel.add(adminMainPanel);
        // End Admin Panel (screen)
        
        // add main panel to the window
        add(mainWindowPanel);
        
        // Start Admin Reservations Panel (screen)
        // Set Admin Reservations Panel Position Inside Main Window Panel
		adminReservationsPanel = new JPanel ();
		adminReservationsPanel.setBorder( new TitledBorder ( new EtchedBorder (), "Reservations" ) );
		adminReservationsPanel.setLayout(mainLayout);
        
        mainLayout.putConstraint(SpringLayout.WEST,  adminReservationsPanel, 0, SpringLayout.WEST, mainWindowPanel);
        mainLayout.putConstraint(SpringLayout.EAST,  adminReservationsPanel, 0, SpringLayout.EAST, mainWindowPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, adminReservationsPanel, 0, SpringLayout.NORTH, mainWindowPanel);
        mainLayout.putConstraint(SpringLayout.SOUTH, adminReservationsPanel, 0, SpringLayout.SOUTH, mainWindowPanel);   
        
        
        
		mainWindowPanel.add(adminReservationsPanel);
        // End Admin Panel (screen)
		
		// Start Admin Reservations Panel (screen)
        // Set Admin Reservations Panel Position Inside Main Window Panel
		adminSchedulePanel = new JPanel ();
		adminSchedulePanel.setBorder( new TitledBorder ( new EtchedBorder (), "Movie Schedule" ) );
		adminSchedulePanel.setLayout(mainLayout);
        
        mainLayout.putConstraint(SpringLayout.WEST,  adminSchedulePanel, 0, SpringLayout.WEST, mainWindowPanel);
        mainLayout.putConstraint(SpringLayout.EAST,  adminSchedulePanel, 0, SpringLayout.EAST, mainWindowPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, adminSchedulePanel, 0, SpringLayout.NORTH, mainWindowPanel);
        mainLayout.putConstraint(SpringLayout.SOUTH, adminSchedulePanel, 0, SpringLayout.SOUTH, mainWindowPanel);   
        

        
		mainWindowPanel.add(adminSchedulePanel);
        // End Admin Panel (screen)
		
		// Start Admin Settings Panel (screen)
		adminSettingsPanel = new JPanel ();
		adminSettingsPanel.setBorder( new TitledBorder ( new EtchedBorder (), "Settings" ) );
		adminSettingsPanel.setLayout(mainLayout);
        
        mainLayout.putConstraint(SpringLayout.WEST,  adminSettingsPanel, 0, SpringLayout.WEST, mainWindowPanel);
        mainLayout.putConstraint(SpringLayout.EAST,  adminSettingsPanel, 0, SpringLayout.EAST, mainWindowPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, adminSettingsPanel, 0, SpringLayout.NORTH, mainWindowPanel);
        mainLayout.putConstraint(SpringLayout.SOUTH, adminSettingsPanel, 0, SpringLayout.SOUTH, mainWindowPanel);   

        
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.ADMIN_SETTINGS_LABEL, TicketPOSGUI.LAYOUT_PADDING_6, SpringLayout.WEST, adminSettingsPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.ADMIN_SETTINGS_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_2, SpringLayout.NORTH, adminSettingsPanel);

        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.ADMIN_SET_PRICE_LABEL, TicketPOSGUI.LAYOUT_PADDING_3, SpringLayout.WEST, adminSettingsPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.ADMIN_SET_PRICE_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_4, SpringLayout.NORTH, adminSettingsPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  adminSetPriceTextField, TicketPOSGUI.LAYOUT_PADDING_8, SpringLayout.WEST, adminSettingsPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, adminSetPriceTextField, TicketPOSGUI.LAYOUT_HEIGHT_4, SpringLayout.NORTH, adminSettingsPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  actionAdminUpdatePriceButton, TicketPOSGUI.LAYOUT_PADDING_11, SpringLayout.WEST, adminSettingsPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, actionAdminUpdatePriceButton, TicketPOSGUI.LAYOUT_HEIGHT_4, SpringLayout.NORTH, adminSettingsPanel);
        
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.ADMIN_SET_EMAIL_SENDING_LABEL, TicketPOSGUI.LAYOUT_PADDING_3, SpringLayout.WEST, adminSettingsPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.ADMIN_SET_EMAIL_SENDING_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_5, SpringLayout.NORTH, adminSettingsPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  adminSetEmailSendTextField, TicketPOSGUI.LAYOUT_PADDING_8, SpringLayout.WEST, adminSettingsPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, adminSetEmailSendTextField, TicketPOSGUI.LAYOUT_HEIGHT_5, SpringLayout.NORTH, adminSettingsPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  actionAdminUpdateEmailSettingsButton, TicketPOSGUI.LAYOUT_PADDING_11, SpringLayout.WEST, adminSettingsPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, actionAdminUpdateEmailSettingsButton, TicketPOSGUI.LAYOUT_HEIGHT_5, SpringLayout.NORTH, adminSettingsPanel);
        
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.ADMIN_SET_LOGIN_LABEL, TicketPOSGUI.LAYOUT_PADDING_3, SpringLayout.WEST, adminSettingsPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.ADMIN_SET_LOGIN_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_6, SpringLayout.NORTH, adminSettingsPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  adminSetLoginTextField, TicketPOSGUI.LAYOUT_PADDING_8, SpringLayout.WEST, adminSettingsPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, adminSetLoginTextField, TicketPOSGUI.LAYOUT_HEIGHT_6, SpringLayout.NORTH, adminSettingsPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  actionAdminUpdateLoginButton, TicketPOSGUI.LAYOUT_PADDING_11, SpringLayout.WEST, adminSettingsPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, actionAdminUpdateLoginButton, TicketPOSGUI.LAYOUT_HEIGHT_6, SpringLayout.NORTH, adminSettingsPanel);
        
        mainLayout.putConstraint(SpringLayout.WEST,  TicketPOSGUI.ADMIN_SET_PASSWORD_LABEL, TicketPOSGUI.LAYOUT_PADDING_3, SpringLayout.WEST, adminSettingsPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, TicketPOSGUI.ADMIN_SET_PASSWORD_LABEL, TicketPOSGUI.LAYOUT_HEIGHT_7, SpringLayout.NORTH, adminSettingsPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  adminSetPasswordTextField, TicketPOSGUI.LAYOUT_PADDING_8, SpringLayout.WEST, adminSettingsPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, adminSetPasswordTextField, TicketPOSGUI.LAYOUT_HEIGHT_7, SpringLayout.NORTH, adminSettingsPanel);
        mainLayout.putConstraint(SpringLayout.WEST,  actionAdminUpdatePasswordButton, TicketPOSGUI.LAYOUT_PADDING_11, SpringLayout.WEST, adminSettingsPanel);
        mainLayout.putConstraint(SpringLayout.NORTH, actionAdminUpdatePasswordButton, TicketPOSGUI.LAYOUT_HEIGHT_7, SpringLayout.NORTH, adminSettingsPanel);

        
        adminSettingsPanel.add(TicketPOSGUI.ADMIN_SET_PRICE_LABEL);
        adminSettingsPanel.add(TicketPOSGUI.ADMIN_SET_EMAIL_SENDING_LABEL);
        adminSettingsPanel.add(TicketPOSGUI.ADMIN_SET_LOGIN_LABEL);
        adminSettingsPanel.add(TicketPOSGUI.ADMIN_SET_PASSWORD_LABEL);
        
        adminSettingsPanel.add(actionAdminUpdatePriceButton);
        adminSettingsPanel.add(actionAdminUpdateEmailSettingsButton);
        adminSettingsPanel.add(actionAdminUpdateLoginButton);
        adminSettingsPanel.add(actionAdminUpdatePasswordButton);
        
        adminSettingsPanel.add(adminSetPriceTextField);
        adminSettingsPanel.add(adminSetEmailSendTextField);
        adminSettingsPanel.add(adminSetLoginTextField);
        adminSettingsPanel.add(adminSetPasswordTextField);
        
		mainWindowPanel.add(adminSettingsPanel);
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
			
			if(username.equals(SECRET_USERNAME) && password.equals(SECRET_PASSWORD)) {
				logAdminIn();
				showPanel(adminMainPanel);
			} else {
				alert("Wrong username or password!", "Error");
			}
			
        } else if(actionCommand.equals(TicketPOSGUI.BUTTON_CAPTION_ADMIN_FIND_RESERVATION)) {
        	
        	String      reservationNumber = adminSearchReservationTextField.getText();
        	
        	if (reservationNumber.isEmpty()) {
				alert("Please Enter Reservation Number", "Error");
			} else {
				
				try {
					Reservation reservation       = reservations.get(reservationNumber);
		        	String      reservationInfo   = reservation.toString();
		        	adminconsoleTextArea.setText(reservationInfo);
		        	actionAdminRefundReservationButton.setVisible(true);
				} catch (NullPointerException e2) {
					alert("Could not find reservation", "Error");
					actionAdminRefundReservationButton.setVisible(false);
				}
			}
        	
        } else if(actionCommand.equals(TicketPOSGUI.BUTTON_CAPTION_ADMIN_REFUND_RESERVATION)) {
        	
        	String      reservationNumber = adminSearchReservationTextField.getText();
        	
        	if (reservationNumber.isEmpty()) {
				alert("Cannot refund this reservation", "Error");
				actionAdminRefundReservationButton.setVisible(false);
			} else {
				
				try {
					Reservation reservation   = reservations.get(reservationNumber);
		        	String      movieDate     = reservation.getTicketInfo().getMovieDate();
		        	String      movieTitle    = reservation.getTicketInfo().getMovie().getTitle();
		        	String      movieTimeStr  = reservation.getTicketInfo().getMovieTime();   
		        	MovieTime   movieTime     = new MovieTime(movieTimeStr);
		        	int         numberTickets = reservation.getTicketInfo().getPay().getNumTickets();
		        	
		        	int movieTimeIndex     = movieMenu.getMenuItems().get(movieTitle).getSchedule().get(movieDate).getIndexByTime(movieTime);
		        	
		        	// update number of seats
		        	movieMenu.getMenuItems().get(movieTitle).getSchedule().get(movieDate).getTimes().get(movieTimeIndex).addRemainingSeats(numberTickets);
		        			
		        	// refund (remove) not needed reservation
		        	reservations.remove(reservationNumber);
		        	
		        	actionAdminRefundReservationButton.setVisible(false);
		        	
		        	adminconsoleTextArea.setText("Refunded");
		        	alert("Reservation was refunded", "Info");
		        	
				} catch (NullPointerException e2) {
					alert("Cannot refund this reservation", "Error");
					actionAdminRefundReservationButton.setVisible(false);
				}
			}
        	
        } else if(actionCommand.equals(TicketPOSGUI.BUTTON_CAPTION_ADMIN_SET_PRICE)) {
        	
        	String priceString = adminSetPriceTextField.getText();
        	
        	if (priceString.isEmpty()) {
        		alert("Please Enter Correct Price", "Error");
        	} else {
        		
        		try {
        			double newPrice = Double.parseDouble(priceString);
        			movieTicketPrice = newPrice;
        			alert("Movie ticket price was updated", "Info");
        			
        		} catch (java.lang.NumberFormatException e2) {
        			alert("Please Enter Correct Price", "Error");
        		}
        	}
        	
        } else if(actionCommand.equals(TicketPOSGUI.BUTTON_CAPTION_ADMIN_SET_EMAIL_SENDING)) {
        	
        	String emailSettings = adminSetEmailSendTextField.getText();
        	
        	if (emailSettings.isEmpty()) {
        		alert("Please Enter Settings (0 or 1)", "Error");
        	} else {
        		
        		if (emailSettings.equals("0") || emailSettings.equals("1")) {
        			isEmailEnabled = emailSettings.equals("1") ? true : false;
        			alert("Email Settings was updated", "Info");
        		} else {
        			alert("Please Enter Settings (0 or 1)", "Error");
        		}
        	}
        	
        } else if(actionCommand.equals(TicketPOSGUI.BUTTON_CAPTION_ADMIN_SET_LOGIN)) {
        	
        	String username = adminSetLoginTextField.getText();
        	
        	if (username.isEmpty()) {
        		alert("Please Enter Username", "Error");
        	} else {
        		SECRET_USERNAME = username;
        		alert("Username was updated", "Info");
        	}
        	
        } else if(actionCommand.equals(TicketPOSGUI.BUTTON_CAPTION_ADMIN_SET_PASSWORD)) {
        	
        	String password = adminSetPasswordTextField.getText();
        	
        	if (password.isEmpty()) {
        		alert("Please Enter Password", "Error");
        	} else {
        		SECRET_PASSWORD = password;
        		alert("Password was updated", "Info");
        	}
        	
        } else if(actionCommand.equals(TicketPOSGUI.BUTTON_CAPTION_BACK)) {
			
        	// Reset selected movie
        	chosenMovieIndex = "";
			// From Order Page, Show Customer (Default) Panel (Screen)
			showPanel(customerViewPanel);
			
        } else if(actionCommand.equals(TicketPOSGUI.BUTTON_CAPTION_EXIT)) {
			
        	// Reset current information and selected movie
        	chosenMovieIndex = "";	
			// From Confirmation Page, Show Customer (Default) Panel (Screen)
			showPanel(customerViewPanel);
			
        } else if(actionCommand.equals(TicketPOSGUI.BUTTON_CAPTION_ORDER)) {
			
			// From Order Page, Process Payment, Order Tickets
        	String err_msg = validateForm();
        	
        	if(!err_msg.isEmpty()) {
        		alert(err_msg, "Form Validation Error");
        	} else {
        		int numberTickets   = Integer.parseInt(orderTicketsNumberTicketsSelectorBox.getSelectedItem().toString());
            	String selectedTime = String.valueOf(orderTicketsTimeSelectorBox.getSelectedItem());
            	String selectedDate = String.valueOf(orderTicketsDateSelectorBox.getSelectedItem()).substring(0, 10);
            	
            	String cardNumber   = cardNumberTextField.getText();
            	String cardExpMonth = cardExpMonthTextField.getText();
            	String cardExpYear  = cardExpYearTextField.getText();
            	String cardZipCode  = cardZipTextField.getText();
            	
            	
            	// Check if tickets are available
            	int remainingSeats = movieMenu.getMenuItems()
            			.get(chosenMovieIndex)
            			.getSchedule()
            			.get(selectedDate)
            			.getTimes()
            			.get(orderTicketsTimeSelectorBox.getSelectedIndex()-1)
            			.getRemainingSeats();
            	
            	if(remainingSeats < numberTickets) {
            		
            		String message;
            		if(remainingSeats > 0) {
            			message = "Only " + remainingSeats + " seats left. Please choose other time.";
            		} else {
            			message = "No seats left. Please choose other time.";
            		}
            		
            		alert(message, "Cannot Purchase");
            		

            	} else {
            		
            		System.out.println("Remaning Seats: " + remainingSeats);
                	
                	// Create Customer
                	String firstName    = customerFirstNameTextField.getText();
                	String lastName     = customerLastNameTextField.getText();
                	String email        = customerEmailTextField.getText();
                	Person customer     = new Person(firstName, lastName, email);
                	
                	// Create Payment
                	Payment payment     = new Payment(customer, numberTickets, cardNumber, movieTicketPrice);
                		 
                	// Create Ticket
                	Ticket ticket       = new Ticket();
                	ticket.setPerson(customer);
                	ticket.setMovie(movieMenu.getMenuItems().get(chosenMovieIndex).getMovie());
                	ticket.setTheater(
                			movieMenu.getMenuItems()
                			.get(chosenMovieIndex)
                			.getSchedule()
                			.get(selectedDate)
                			.getTimes()
                			.get(orderTicketsTimeSelectorBox.getSelectedIndex()-1)
                			.getTheater()
        			);
                	ticket.setPay(payment);
                	ticket.setMovieTime(selectedTime);
                	ticket.setMovieDate(selectedDate);

                	// Add Info To Reservation
                	reservation.setTicketInfo(ticket);
                	reservation.setReserveDate(selectedDate);
                	reservation.setTicketInfo(ticket);
             
                	// display confirmation details on confirmation page
                	confirmationNumberLabel.setText(String.valueOf(reservation.getReservationNumber()));
                	confirmationNameLabel.setText(reservation.getTicketInfo().getPerson().getFirstName() + " " + reservation.getTicketInfo().getPerson().getLastName());
                    confirmationEmailLabel.setText(reservation.getTicketInfo().getPerson().getEmail());
                    confirmationMovieLabel.setText(reservation.getTicketInfo().getMovie().getTitle());
                    confirmationDateLabel.setText(String.valueOf(reservation.getTicketInfo().getMovieDate()));
                    confirmationTimeLabel.setText(String.valueOf(reservation.getTicketInfo().getMovieTime()));
                    confirmationTheaterLabel.setText(String.valueOf(reservation.getTicketInfo().getTheater().getName()));
                    confirmationNumberTicketsLabel.setText(String.valueOf(reservation.getTicketInfo().getPay().getNumTickets()));
                    confirmationTotalLabel.setText(USD.format(reservation.getTicketInfo().getPay().getTotal()));
                	
        			showPanel(confirmationPageMainPanel);
        			
        			movieMenu.getMenuItems()
        			.get(chosenMovieIndex)
        			.getSchedule()
        			.get(selectedDate)
        			.getTimes()
        			.get(orderTicketsTimeSelectorBox.getSelectedIndex()-1)
        			.substractRemainingSeats(numberTickets);
        			
        			// Send Out Confirmation Email
        			if(isEmailEnabled) {
        				
        				String contentEmail = "Confirmation Email" + "\n\n";
        				contentEmail += reservation.toString();
        				
        				
        				Email   from    = new Email("sergeyev.alex@gmail.com");
        			    Email   to      = new Email(customer.getEmail());
        			    String  subject = "TicketPOS - Confirmation Email";
        			    Content content = new Content("text/plain", contentEmail);

        			    Mail   mail    = new Mail(from, subject, to, content);
        			    
        			    SendGrid sg = new SendGrid(SENDGRID_KEY);
        			    Request request = new Request();
        			    try {
        			      
        			    	request.setMethod(Method.POST);
        			      request.setEndpoint("mail/send");
        			      request.setBody(mail.build());
        			      Response response = sg.api(request);
        			      System.out.println(response.getStatusCode());
        			      System.out.println(response.getBody());
        			      System.out.println(response.getHeaders());
        			      
        			    } catch (IOException ex) {
        			    	ex.printStackTrace();
        			    }
        			}
        			
        			// Add current reservation to reservations storage and reset current reservation
        			reservations.put(String.valueOf(reservation.getReservationNumber()), reservation);
        			reservation = new Reservation();
            	}
        	}
			// END PURCHASE TICKETS
			
        } else if(actionCommand.equals(TicketPOSGUI.BUTTON_CAPTION_ORDER_TEST_VALUES)) {
			
			orderAddTestValues();
			
    	} else if(actionCommand.equals(TicketPOSGUI.BUTTON_CAPTION_ORDER_RESET_FORM)) {
			
    		orderResetForm();
			
        
        } else if (actionCommand.equals(TicketPOSGUI.BUTTON_CAPTION_LOGIN)) {
			
			// From Login Form, Check username and password
			
			// Get login form inputs
			String username = loginUsernameTextField.getText();
			String password = loginPasswordTextField.getText();
			
			if(username.equals(SECRET_USERNAME) && password.equals(SECRET_PASSWORD)) {
				logAdminIn();
				showPanel(adminMainPanel);
			} else {
				alert("Wrong username or password!", "Error");
			}
			
        } else if(actionCommand.equals(TicketPOSGUI.BUTTON_CAPTION_SORT)) {
			
    		// From Search Form, Sort Movies using user input
        	
		} else if(actionCommand.equals(TicketPOSGUI.BUTTON_CAPTION_SEARCH)) {
			
    		// From Search Form, Find Movies using user input
			
			searchMovies();
			
		} else if(actionCommand.equals(TicketPOSGUI.MENU_ADMIN_FIND_RESERVATION_VIEW)) {
			
			// From Menu, Show Admin Panel (Screen) where admin can edit movies description
			// if user is not logged in show login screen
			if(! isAdmin()) {
				showPanel(loginMainPanel);
			} else {				
				showPanel(adminMainPanel);
			}
			
		} else if(actionCommand.equals(TicketPOSGUI.MENU_ADMIN_RESERVATIONS_VIEW)) {
			
			// From Menu, Show Admin Panel (Screen) where admin can edit theater description
			// if user is not logged in show login screen
			if(! isAdmin()) {
				showPanel(loginMainPanel);
			} else {		
				
				adminReservationsPanel.removeAll();
				
				// Column Names 
		        String[] reservationsTableCollumn = { "Reservation Number", "Movie", "Date", "Time", "Theater", "First Name", "Last Name", "Email", "Qty", "Total", "Reservation Time"}; 
				
		        // Data to be displayed in the JTable 
				String[][] reservationsTableData = new String[reservations.size()][11]; 
				
				
				Iterator<Map.Entry<String, Reservation>> entries = reservations.entrySet().iterator();
				int i = 0;
				while (entries.hasNext()) {
				    Map.Entry<String, Reservation> entry = entries.next();
				    
				    reservationsTableData[i][0] = String.valueOf(entry.getValue().getReservationNumber());
					reservationsTableData[i][1] = String.valueOf(entry.getValue().getTicketInfo().getMovie().getTitle());
					reservationsTableData[i][2] = String.valueOf(entry.getValue().getTicketInfo().getMovieDate());
					reservationsTableData[i][3] = String.valueOf(entry.getValue().getTicketInfo().getMovieTime());
					reservationsTableData[i][4] = String.valueOf(entry.getValue().getTicketInfo().getTheater().getName());
					reservationsTableData[i][5] = String.valueOf(entry.getValue().getTicketInfo().getPerson().getFirstName());
					reservationsTableData[i][6] = String.valueOf(entry.getValue().getTicketInfo().getPerson().getLastName());
					reservationsTableData[i][7] = String.valueOf(entry.getValue().getTicketInfo().getPerson().getEmail());
					reservationsTableData[i][8] = String.valueOf(entry.getValue().getTicketInfo().getPay().getNumTickets());
					reservationsTableData[i][9] = String.valueOf(entry.getValue().getTicketInfo().getPay().getTotal());
					reservationsTableData[i][10] = String.valueOf(entry.getValue().getReserveDate());
		            
					i++;
				}
		        
		  
		        // Initializing the JTable 
		        JTable table = new JTable(reservationsTableData, reservationsTableCollumn); 
		        table.setRowHeight(40);
		        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.getColumnModel().getColumn(0).setPreferredWidth(120);
				table.getColumnModel().getColumn(1).setPreferredWidth(120);
				table.getColumnModel().getColumn(2).setPreferredWidth(60);
				table.getColumnModel().getColumn(3).setPreferredWidth(60);
				table.getColumnModel().getColumn(4).setPreferredWidth(60);
				table.getColumnModel().getColumn(5).setPreferredWidth(120);
				table.getColumnModel().getColumn(6).setPreferredWidth(120);
				table.getColumnModel().getColumn(7).setPreferredWidth(120);
				table.getColumnModel().getColumn(8).setPreferredWidth(60);
				table.getColumnModel().getColumn(9).setPreferredWidth(60);
				table.getColumnModel().getColumn(10).setPreferredWidth(120);
		        
		        JScrollPane scrollPane = new JScrollPane(table);
		        scrollPane.setPreferredSize(new Dimension(1200, 500));
		        scrollPane.setSize(new Dimension(1200, 500));
				
		        adminReservationsPanel.add(scrollPane);
		        
		        adminReservationsPanel.revalidate();
		        adminReservationsPanel.repaint();
				
				showPanel(adminReservationsPanel);
			}
			
		} else if(actionCommand.equals(TicketPOSGUI.MENU_ADMIN_SCHEDULE_VIEW)) {
			
			// From Menu, Show Admin Panel (Screen) where admin can edit times description
			// if user is not logged in show login screen
			if(! isAdmin()) {
				showPanel(loginMainPanel);
			} else {				
				showPanel(adminSchedulePanel);
			}
			
		} else if(actionCommand.equals(TicketPOSGUI.MENU_ADMIN_SETTINGS_VIEW)) {
			
			// From Menu, Show Admin Panel (Screen) where admin can edit genres
			// if user is not logged in show login screen
			if(! isAdmin()) {
				showPanel(loginMainPanel);
			} else {				
				
				adminSetPriceTextField.setText(String.valueOf(movieTicketPrice));
				adminSetEmailSendTextField.setText(String.valueOf(isEmailEnabled));
				adminSetLoginTextField.setText(SECRET_USERNAME);
				showPanel(adminSettingsPanel);
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
	    	
	    	
	    	if(actionCommand.toLowerCase().contains("OpenMovie_".toLowerCase())) {
	    		
//	    		alert("Open Movie '" + actionCommand + "'", "Error");
	    		
	    		// Choose Movie From Menu
				String[] commandStringProcessed = actionCommand.split("_");
				String movieTitle = commandStringProcessed[1];
				chosenMovieIndex = movieTitle;
				showMovie(movieTitle);
				// Display Order Page
				showPanel(orderPageMainPanel);
				orderResetForm();
	    		
	    	} else {	    		
	    		// Could not find action
	    		alert("Unexpected error. Could not find Action Handler for '" + actionCommand + "'", "Error");
	    	}
	    	
        }
    }
    
    
    public void updateMovieMenu(Map<String, MovieMenuItem> filteredCollection) {
    	
    	movieMenuContentPanel.removeAll();
    	
    	// Add buttons to content block
    	JButton                      button;
        String                       buttonText = "";
        Movie                        movie;
        List<MovieScheduleItem>      times;
                
        Iterator<Map.Entry<String, MovieMenuItem>> it = filteredCollection.entrySet().iterator();
        
        while (it.hasNext()) {
            Map.Entry<String, MovieMenuItem> pair = it.next();
            
            movie      = pair.getValue().getMovie();
            times      = pair.getValue().getSchedule().get(defaultDate).getTimes();
			button     = createMenuButton(movie, times);
			movieMenuContentPanel.add(button);
        }
        
        movieMenuContentPanel.validate();
        movieMenuContentPanel.repaint();
        movieMenuScrollPanel.validate();
        movieMenuScrollPanel.repaint();
        customerViewPanel.validate();
        customerViewPanel.repaint(); 
    }
    
    
    
    public void displayMovieMenu() {
    	
    	movieMenuContentPanel.removeAll();
    	
    	// Add buttons to content block
        JButton                      button;
        String                       buttonText = "";
        Movie                        movie;
        List<MovieScheduleItem>      times;
                
        Iterator<Map.Entry<String, MovieMenuItem>> it = movieMenu.getMenuItems().entrySet().iterator();
        
        while (it.hasNext()) {
            Map.Entry<String, MovieMenuItem> pair = it.next();
            
            movie      = pair.getValue().getMovie();
            times      = pair.getValue().getSchedule().get(defaultDate).getTimes();
			button     = createMenuButton(movie, times);
			movieMenuContentPanel.add(button);
        }
        
        movieMenuContentPanel.validate();
        movieMenuContentPanel.repaint();
        customerViewPanel.validate();
        customerViewPanel.repaint(); 
    }
    
    
    
    private JButton createMenuButton(Movie movie, List<MovieScheduleItem> times) {
    	
    	String  buttonText = createMenuButtonText(movie, times);
    	JButton button = new JButton();
		button.setMargin(new Insets(0,0,0,0));
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setAlignmentY(TOP_ALIGNMENT);
//		button.setActionCommand("ChooseMovie_" + key);
		button.setActionCommand("OpenMovie_" + movie.getTitle());
		button.addActionListener(this);
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		    InputStream input = classLoader.getResourceAsStream("resources\\" + movie.getImage());
		    // URL input = classLoader.getResource("image.png"); // <-- You can use URL class too.
		    bufferedImage = ImageIO.read(input);

		    button.setIcon(new ImageIcon(bufferedImage));
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
		
		button.setText("<html>" + buttonText.replaceAll("\\n", "<br>") + "</html>");
		button.setPreferredSize(TicketPOSGUI.SIZE_150_300);
		button.setSize(TicketPOSGUI.SIZE_150_300);
    	
    	return button;
    }
    
    
    private String createMenuButtonText(Movie movie, List<MovieScheduleItem> times) {
    	
    	String  buttonText = "";
    	buttonText += movie.getTitle().toUpperCase() + "\n" + "\n";
    	buttonText += "\n";
    	buttonText += "Duration: " + movie.getDuration() + " mins \n" + "\n";
    	buttonText += "\n";
    	for (int j = 0; j < movie.genres.size(); j++) {
    		buttonText += movie.genres.get(j).name.toUpperCase();
    		if(j != (movie.genres.size() - 1)) {
    			buttonText += ", ";
    		}
		}
    	buttonText += "\n" + "\n";
    	
    	for (int j = 0; j < times.size(); j++) {
    		buttonText += times.get(j).getMovieTime().getTimeString().toUpperCase();
    		if(j != (times.size() - 1)) {
    			buttonText += ", ";
    		}
		}
    	buttonText += "\n";
    	
    	return buttonText;
    }

    
    /**
     * Validate purchase form
     * 
     * @return String with error message, empty String if no error
     */
    private String validateForm() {
    	
		String errorMessage = "";
    	
		if (orderTicketsNumberTicketsSelectorBox.getSelectedItem().toString().equalsIgnoreCase("Select Number Tickets")) {
			errorMessage += "Please select number of tickets." + "\n";
		} else {
			int numberTickets   = Integer.parseInt(orderTicketsNumberTicketsSelectorBox.getSelectedItem().toString());
			if(numberTickets == 0) {
				errorMessage += "Please select number of tickets." + "\n";
			}
		}
		
		String selectedTime = String.valueOf(orderTicketsTimeSelectorBox.getSelectedItem());
		if(selectedTime.equalsIgnoreCase("Select Time")) {
			errorMessage += "Please select time." + "\n";
		}
		
    	// Validate  if input empty
    	if(customerFirstNameTextField.getText().isEmpty()) {
    		errorMessage += "Please enter first name." + "\n";
    	}
    	if(customerLastNameTextField.getText().isEmpty()) {
    		errorMessage += "Please enter last name." + "\n";
    	}
    	if(customerEmailTextField.getText().isEmpty()) {
    		errorMessage += "Please enter email address." + "\n";
    	}
    	if(cardNumberTextField.getText().isEmpty()) {
    		errorMessage += "Please enter card number." + "\n";
    	}
    	if(cardExpMonthTextField.getText().isEmpty()) {
    		errorMessage += "Please enter expiration month (ex.: 12)." + "\n";
    	}
    	if(cardExpYearTextField.getText().isEmpty()) {
    		errorMessage += "Please enter expiration year (ex.: 22)." + "\n";
    	}
    	if(cardZipTextField.getText().isEmpty()) {
    		errorMessage += "Please enter zip code." + "\n";
    	}
    	
    	return errorMessage;
    	
    }
    
    
    
    private void updateRemaningSeats() {
    	
//    	System.out.println("test change listener");
    	
    	String selectedDate = String.valueOf(orderTicketsDateSelectorBox.getSelectedItem()).substring(0, 10);
    	int selectedTimeIndex = orderTicketsTimeSelectorBox.getSelectedIndex();
    	// to support "Select Time option"
    	selectedTimeIndex = selectedTimeIndex <= 0 ? 1 : selectedTimeIndex;
    	System.out.println("selectedTimeIndex: " + selectedTimeIndex);
    	System.out.println("Chosen Movie: " + chosenMovieIndex);
    	System.out.println("selectedDate: " + selectedDate);
    	
    	MovieMenuItem  movieMenuItem = movieMenu.getMenuItems().get(chosenMovieIndex);
    	int availableTickets = movieMenuItem.getSchedule().get(selectedDate).getTimes().get(selectedTimeIndex-1).getRemainingSeats();
    	
    	System.out.println(selectedTimeIndex);
    	System.out.println(selectedDate);
    	System.out.println(availableTickets);
    	
    	
    	if(availableTickets == 0) {
    		movieTicketsLeftLabel.setText("No seats left");
    	} else {
    		movieTicketsLeftLabel.setText("Only " + String.valueOf(availableTickets) + " seats left!");
    	}
    }
    
    
    public void showMovie(String movieTitle) {
    	
    	MovieMenuItem           movieMenuItem = movieMenu.getMenuItems().get(movieTitle);
    	List<MovieScheduleItem> times         = movieMenuItem.getSchedule().get(defaultDate).getTimes();
    	Movie                   movie         = movieMenu.getMenuItems().get(movieTitle).getMovie();
    	int                  availableTickets = movieMenuItem.getSchedule().get(defaultDate).getTimes().get(0).getRemainingSeats();
    	
    	if(availableTickets == 0) {
    		movieTicketsLeftLabel.setText("No seats left");
    	} else {
    		movieTicketsLeftLabel.setText("Only " + String.valueOf(availableTickets) + " seats left!");
    	}
    	movieTicketsPriceLabel.setText("(" + USD.format(movieTicketPrice) + ")");
    			
    	try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		    InputStream input = classLoader.getResourceAsStream("resources\\" + movie.getImage());
		    // URL input = classLoader.getResource("image.png"); // <-- You can use URL class too.
		    bufferedImage = ImageIO.read(input);
		  } catch (Exception ex) {
			System.out.println("resources\\" + movie.getImage());  
		    System.out.println(ex);
		  }
        
        ImageIcon icon = new ImageIcon(bufferedImage);
        movieIconLabel.setIcon(icon);
        
        movieTitleLabel.setText(movie.getTitle());
        movieDescriptionLabel.setMaximumSize(new Dimension(200,200));
        
        final String s = movie.getDescription();
        final String html = "<html><body style='width: %1spx'>%1s";
        final String formattedDescription = String.format(html, 200, s);
        movieDescriptionLabel.setText(formattedDescription);
        
        String movieTimes = "";
        //times
        for (int j = 0; j < times.size(); j++) {
        	movieTimes += times.get(j).getMovieTime().getTimeString().toUpperCase();
    		if(j != (times.size() - 1)) {
    			movieTimes += ", ";
    		}
		}
        movieTimesLabel.setText(movieTimes);
        
        orderTicketsTimeSelectorBox.removeAllItems();
        orderTicketsTimeSelectorBox.addItem("Select Time");
        for (int i = 0; i < times.toArray().length; i++) {
			orderTicketsTimeSelectorBox.addItem(times.get(i).getMovieTime().getTimeString());
		}
        
    	String movieGenres = "";
    	for (int j = 0; j < movie.genres.size(); j++) {
    		movieGenres += movie.genres.get(j).getGenreName().toUpperCase();
    		if(j != (movie.genres.size() - 1)) {
    			movieGenres += ", ";
    		}
		}    	
        movieGenresLabel.setText(movieGenres);
        
        orderPageMainPanel.validate();
		orderPageMainPanel.repaint(); 
		chosenMovieIndex = movieTitle;
    }
    
    
    /**
     * Check if user is Admin
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
		loginMainPanel.setVisible(false);
		orderPageMainPanel.setVisible(false);
		confirmationPageMainPanel.setVisible(false);
		
		adminMainPanel.setVisible(false);
		adminReservationsPanel.setVisible(false);
		adminSchedulePanel.setVisible(false);
		adminSettingsPanel.setVisible(false);
	}
    
    /*
    * Helper function to reset Ticket Form
    */
   public void orderResetForm() {
		orderTicketsTimeSelectorBox.setSelectedIndex(0);
		orderTicketsNumberTicketsSelectorBox.setSelectedIndex(0);
		
		customerFirstNameTextField.setText("");
		customerLastNameTextField.setText("");
		customerEmailTextField.setText("");
		
		cardNumberTextField.setText("");
		cardExpMonthTextField.setText("");
		cardExpYearTextField.setText("");
		cardZipTextField.setText("");
	}
   
   
   	/*
    * Populate Order Form With Test Values
    */
   	public void orderAddTestValues() {
   		orderTicketsTimeSelectorBox.setSelectedIndex(1);
   		orderTicketsNumberTicketsSelectorBox.setSelectedIndex(1);
		
		customerFirstNameTextField.setText("John");
		customerLastNameTextField.setText("Doe");
		customerEmailTextField.setText("john.doe@gmail.com");
		
		cardNumberTextField.setText("4111 1111 1111 1111");
		cardExpMonthTextField.setText("11");
		cardExpYearTextField.setText("22");
		cardZipTextField.setText("55101");
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
    	
    	movieMenu.addItem(DefaultData.MENU_ITEM_1);
    	movieMenu.addItem(DefaultData.MENU_ITEM_2);
    	movieMenu.addItem(DefaultData.MENU_ITEM_3);
    	movieMenu.addItem(DefaultData.MENU_ITEM_4);
    	movieMenu.addItem(DefaultData.MENU_ITEM_5);
    	movieMenu.addItem(DefaultData.MENU_ITEM_6);
    	movieMenu.addItem(DefaultData.MENU_ITEM_7);
    	movieMenu.addItem(DefaultData.MENU_ITEM_8);
    	movieMenu.addItem(DefaultData.MENU_ITEM_9);
    	movieMenu.addItem(DefaultData.MENU_ITEM_10);
    	movieMenu.addItem(DefaultData.MENU_ITEM_11);
    	movieMenu.addItem(DefaultData.MENU_ITEM_12);
    	movieMenu.addItem(DefaultData.MENU_ITEM_13);
    	movieMenu.addItem(DefaultData.MENU_ITEM_14);
    	movieMenu.addItem(DefaultData.MENU_ITEM_15);
    	
    	
    	// load movies
    	for (Movie movie : DefaultData.MOVIES) {
//    		movies.put(movie.getTitle(), movie);
    		movies.add(movie);
    	}
    	
    	// load theaters
    	for (Theater theater : DefaultData.THEATERS) {
//    		theaters.put(theater.getName(), theater);
    		theaters.add(theater);
    	}
    	
    	// load genres
    	for (Genre genre : DefaultData.GENRES) {
//    		genres.put(genre.getName(), genre);
    		genres.add(genre);
    	}
    	
//    	System.out.println(genres);
    	
    	// load genres
    	for (String time : DefaultData.TIMES) {
//    		times.put(time, time);
    		times.add(time);
    	}
   	
    }
    
    
    private void searchMovies() {
    	// Get search form inputs
		String searchString = searchMovieTextField.getText();
		String searchGenre  = String.valueOf(genreSelectorBox.getSelectedItem());
		String searchTime   = String.valueOf(timeSelectorBox.getSelectedItem());
		String sortBy       = String.valueOf(sortMoviesSelectorBox.getSelectedItem());
		
		searchString = searchString.equalsIgnoreCase("")      ? "" : searchString;
		searchGenre  = searchGenre.equalsIgnoreCase("Select") ? "" : searchGenre;
		searchTime   = searchTime.equalsIgnoreCase("Select")  ? "" : searchTime;
		
		Map<String, MovieMenuItem> filteredCollection;
		
		if(searchGenre.isEmpty() && searchTime.isEmpty()) {				
			filteredCollection = movieMenu.search(searchString);
		} else if (searchGenre.isEmpty()) {
			MovieTime time = new MovieTime(searchTime);
			System.out.println(searchTime);
			System.out.println(time);
			filteredCollection = movieMenu.search(searchString, time);
			System.out.println(filteredCollection);
		} else if (searchTime.isEmpty()) {
			Genre genre = new Genre(searchGenre);
			filteredCollection = movieMenu.search(searchString, genre);
		} else {
			Genre genre = new Genre(searchGenre);
			MovieTime time = new MovieTime(searchTime);
			filteredCollection = movieMenu.search(searchString, genre, time);
		}
		
		if(sortBy.equalsIgnoreCase("Title")) {        		
    		
			// Create a list from elements of HashMap 
	        List<Map.Entry<String, MovieMenuItem> > list = 
	               new LinkedList<Map.Entry<String, MovieMenuItem> >(filteredCollection.entrySet()); 
	  
	        // Sort the list 
	        Collections.sort(list, new Comparator<Map.Entry<String, MovieMenuItem> >() { 
	            public int compare(Map.Entry<String, MovieMenuItem> o1,  
	                               Map.Entry<String, MovieMenuItem> o2) 
	            { 
	                return (o1.getValue()).compareTo(o2.getValue()); 
	            } 
	        }); 
	          
	        // put data from sorted list to hashmap  
	        Map<String, MovieMenuItem> tempMap = new LinkedHashMap<String, MovieMenuItem>(); 
	        for (Map.Entry<String, MovieMenuItem> aa : list) { 
	            tempMap.put(aa.getKey(), aa.getValue()); 
	        } 
	        
	        if(tempMap.size() > 0) {  
	        	updateMovieMenu(tempMap);
	        }	
	        
        } else if(sortBy.equalsIgnoreCase("Title DESC")) {        		
        		
			// Create a list from elements of HashMap 
	        List<Map.Entry<String, MovieMenuItem> > list = 
	               new LinkedList<Map.Entry<String, MovieMenuItem> >(filteredCollection.entrySet()); 
	  
	        // Sort the list 
	        Collections.sort(list, new Comparator<Map.Entry<String, MovieMenuItem> >() { 
	            public int compare(Map.Entry<String, MovieMenuItem> o1,  
	                               Map.Entry<String, MovieMenuItem> o2) 
	            { 
	                return -(o1.getValue()).compareTo(o2.getValue()); 
	            } 
	        }); 
	          
	        // put data from sorted list to hashmap  
	        Map<String, MovieMenuItem> tempMap = new LinkedHashMap<String, MovieMenuItem>(); 
	        for (Map.Entry<String, MovieMenuItem> aa : list) { 
	            tempMap.put(aa.getKey(), aa.getValue()); 
	        } 
	        
	        if(tempMap.size() > 0) {  
	        	updateMovieMenu(tempMap);
	        }
		
		} else if(sortBy.equalsIgnoreCase("Duration")) {
			
			
			// Create a list from elements of HashMap 
	        List<Map.Entry<String, MovieMenuItem> > list = 
	               new LinkedList<Map.Entry<String, MovieMenuItem> >(filteredCollection.entrySet()); 
	  
	        // Sort the list 
	        Collections.sort(list, new Comparator<Map.Entry<String, MovieMenuItem> >() { 
	            public int compare(Map.Entry<String, MovieMenuItem> o1,  
	                               Map.Entry<String, MovieMenuItem> o2) 
	            { 
	            	return (o1.getValue().getMovie().getDuration() - o2.getValue().getMovie().getDuration()); 
	            } 
	        }); 
	          
	        // put data from sorted list to hashmap  
	        Map<String, MovieMenuItem> tempMap = new LinkedHashMap<String, MovieMenuItem>(); 
	        for (Map.Entry<String, MovieMenuItem> aa : list) { 
	            tempMap.put(aa.getKey(), aa.getValue()); 
	        } 
	        
	        if(tempMap.size() > 0) {  
	        	updateMovieMenu(tempMap);
	        }
	        
		} else if(sortBy.equalsIgnoreCase("Duration DESC")) {
			
			
			// Create a list from elements of HashMap 
	        List<Map.Entry<String, MovieMenuItem> > list = 
	               new LinkedList<Map.Entry<String, MovieMenuItem> >(filteredCollection.entrySet()); 
	  
	        // Sort the list 
	        Collections.sort(list, new Comparator<Map.Entry<String, MovieMenuItem> >() { 
	            public int compare(Map.Entry<String, MovieMenuItem> o1,  
	                               Map.Entry<String, MovieMenuItem> o2) 
	            { 
	            	return -(o1.getValue().getMovie().getDuration() - o2.getValue().getMovie().getDuration()); 
	            } 
	        }); 
	        
	        // put data from sorted list to hashmap  
	        Map<String, MovieMenuItem> tempMap = new LinkedHashMap<String, MovieMenuItem>(); 
	        for (Map.Entry<String, MovieMenuItem> aa : list) { 
	            tempMap.put(aa.getKey(), aa.getValue()); 
	        } 
	        
	        if(tempMap.size() > 0) {  
	        	updateMovieMenu(tempMap);
	        }
			
    	} else {        
    		if(filteredCollection.size() > 0) {        			
    			updateMovieMenu(filteredCollection);	
    		}
    	}
		
		
		if (filteredCollection.size() == 0) {
			String message = "Oops. Couldn't find movies. Please try something else." + "\n";
			message += "Search String: '" + searchString + "'" + "\n";
			message += "Selected Genre: " + searchGenre  + "\n";
			message += "Selected Time: "  + searchTime   + "\n";
			
			alert(message, "Info");
		}
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
        
        menuAdminFindResrvationItem = new JMenuItem(MENU_ADMIN_FIND_RESERVATION_VIEW);
        menuAdminFindResrvationItem.addActionListener(this);
        menuAdmin.add(menuAdminFindResrvationItem);
        
        menuAdminReservationsItem = new JMenuItem(MENU_ADMIN_RESERVATIONS_VIEW);
        menuAdminReservationsItem.addActionListener(this);
        menuAdmin.add(menuAdminReservationsItem);
        
//        menuAdminScheduleItem = new JMenuItem(MENU_ADMIN_SCHEDULE_VIEW);
//        menuAdminScheduleItem.addActionListener(this);
//        menuAdmin.add(menuAdminScheduleItem);
        
        menuAdminSettingsItem = new JMenuItem(MENU_ADMIN_SETTINGS_VIEW);
        menuAdminSettingsItem.addActionListener(this);
        menuAdmin.add(menuAdminSettingsItem);
        
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
