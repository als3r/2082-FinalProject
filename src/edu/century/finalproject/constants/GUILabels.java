package edu.century.finalproject.constants;

import javax.swing.JLabel;

public interface GUILabels {
	
	//define form labels
    
    // Search Form
	public static final JLabel SEARCH_FORM_LABEL           = new JLabel("Search");
	public static final JLabel GENRE_LABEL                 = new JLabel("Filter By Genre");
	public static final JLabel TIMES_LABEL                 = new JLabel("Time");
	public static final JLabel SORT_LABEL                  = new JLabel("Sort By");
	
	// Select Tickets Form
	public static final JLabel SELECT_TICKETS_LABEL        = new JLabel("SELECT TICKETS ($5.00)");
	public static final JLabel TICKETS_AVAILABLE_LABEL     = new JLabel("Tickets:");
	public static final JLabel SELECT_TICKETS_DATE_LABEL   = new JLabel("Date:");
	public static final JLabel SELECT_TICKETS_TIME_LABEL   = new JLabel("Time:");
	public static final JLabel SELECT_TICKETS_NUMBER_LABEL = new JLabel("Tickets:");
    
    // Customer Form
	public static final JLabel PAYMENT_FORM_LABEL          = new JLabel("PAYMENT FORM");
	public static final JLabel CUSTOMER_FIRST_NAME_LABEL   = new JLabel("First Name");
	public static final JLabel CUSTOMER_LAST_NAME_LABEL    = new JLabel("Last Name");
	public static final JLabel CUSTOMER_EMAIL_LABEL        = new JLabel("Email");    
	
    // Payment Form
	public static final JLabel CARD_NUMBER_LABEL           = new JLabel("Card Number:");
	public static final JLabel CARD_EXP_MONTH_LABEL        = new JLabel("Exp. Month:");
	public static final JLabel CARD_EXP_YEAR_LABEL         = new JLabel("Exp. Year:");
    public static final JLabel CARD_ZIP_LABEL              = new JLabel("Zip:");

    // Login Form
    public static final JLabel LOGIN_FORM_LABEL            = new JLabel("Please Sign In:");
    public static final JLabel LOGIN_USERNAME_LABEL        = new JLabel("Username:");
    public static final JLabel LOGIN_PASSWORD_LABEL        = new JLabel("Password:");
    
    // Confirmation
    public static final JLabel CONFIRMATION_TITLE_LABEL          = new JLabel("CONFIRMATION");
    public static final JLabel CONFIRMATION_NUMBER_LABEL         = new JLabel("Reservation Number:");
    public static final JLabel CONFIRMATION_NAME_LABEL           = new JLabel("Name:");
    public static final JLabel CONFIRMATION_EMAIL_LABEL          = new JLabel("Email:");
    public static final JLabel CONFIRMATION_MOVIE_LABEL          = new JLabel("Movie:");
    public static final JLabel CONFIRMATION_TIME_LABEL           = new JLabel("Time:");
    public static final JLabel CONFIRMATION_DATE_LABEL           = new JLabel("Date:");
    public static final JLabel CONFIRMATION_THEATER_LABEL        = new JLabel("Theater:");
    public static final JLabel CONFIRMATION_NUMBER_TICKETS_LABEL = new JLabel("Number of Tickets:");
    public static final JLabel CONFIRMATION_TOTAL_LABEL          = new JLabel("Total:");
    
    public static final JLabel ADMIN_SEARCH_RESERVATION_LABEL    = new JLabel("Search Reservation By Number: ");
    
    
    public static final JLabel ADMIN_SETTINGS_LABEL              = new JLabel("SETTINGS");
    public static final JLabel ADMIN_SET_PRICE_LABEL             = new JLabel("Price: ");
    public static final JLabel ADMIN_SET_EMAIL_SENDING_LABEL     = new JLabel("Email Senging (0-disabled, 1-enabled)");
    public static final JLabel ADMIN_SET_LOGIN_LABEL             = new JLabel("Login: ");
    public static final JLabel ADMIN_SET_PASSWORD_LABEL          = new JLabel("Password: ");
    
}
