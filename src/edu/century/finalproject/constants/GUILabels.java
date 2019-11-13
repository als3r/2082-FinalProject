package edu.century.finalproject.constants;

import javax.swing.JLabel;

public interface GUILabels {
	
	//define form labels
    
    // Search Form
	public static final JLabel SEARCH_FORM_LABEL         = new JLabel("Search By Title");
	public static final JLabel GENRE_LABEL               = new JLabel("Filter By Genre");
	public static final JLabel TIMES_LABEL               = new JLabel("Filter By Time");
    
    // Customer Form
	public static final JLabel CUSTOMER_FIRST_NAME_LABEL = new JLabel("First Name");
	public static final JLabel CUSTOMER_LAST_NAME_LABEL  = new JLabel("Last Name");
	public static final JLabel CUSTOMER_EMAIL_LABEL      = new JLabel("Email");
    
    // Payment Form
	public static final JLabel CARD_NUMBER_LABEL         = new JLabel("Card Number:");
	public static final JLabel CARD_EXP_MONTH_LABEL      = new JLabel("Expiration Month:");
	public static final JLabel CARD_EXP_YEAR_LABEL       = new JLabel("Expiration Year:");
    public static final JLabel CARD_ZIP_LABEL            = new JLabel("Zip Code:");

    // Login Form
    public static final JLabel LOGIN_FORM_LABEL          = new JLabel("Please Sign In:");
    public static final JLabel LOGIN_USERNAME_LABEL      = new JLabel("Username:");
    public static final JLabel LOGIN_PASSWORD_LABEL      = new JLabel("Password:");
}
