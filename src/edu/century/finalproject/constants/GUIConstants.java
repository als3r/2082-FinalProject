package edu.century.finalproject.constants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public interface GUIConstants {
	
	/**
	 * Program Name
	 */
	public static final String PROGRAM_NAME = "Cinema Theater POS v0.01";
	
	/**
	 * Admin Username
	 */
	public static final String SECRET_USERNAME = "admin";
	
	/**
	 * Admin Password
	 */
	public static final String SECRET_PASSWORD = "12345";
	
	/**
	 * Version
	 */
	public static final long serialVersionUID = 1;
	
	/**
	 * Window's width
	 */
	public static final int WINDOW_WIDTH  = 1200;
	
	/**
	 * Window's height
	 */
	public static final int WINDOW_HEIGHT = 768;
	
	/**
	 * Console text area's "width" in number of characters
	 */
	public static final int TEXTAREA_NUMBER_OF_CHAR = 180;
	
	/**
	 * Console text area's "height" in number of lines
	 */
	public static final int TEXTAREA_NUMBER_OF_LINES = 32;
	
	/**
	 * Number of character for input text fields
	 */
	public static final int NUMBER_OF_CHAR_INPUT_SMALL  = 5;
	public static final int NUMBER_OF_CHAR_INPUT_MEDIUM = 10;
	public static final int NUMBER_OF_CHAR_INPUT_LARGE  = 20;
	public static final int NUMBER_OF_CHAR_INPUT_LARGE2 = 30;
	public static final int NUMBER_OF_CHAR_INPUT_LARGE3 = 40;
	
	/**
	 * Movie Genres
	 */
	public static final String[] GENRES_ARRAY = 
	{
		"Select Genre", "Adventure", "Comedy", "Drama", "Fantasy", "Horror", "Science Fiction", "Thriller"
	};
	
	/**
	 * Movie Times
	 */
	public static final String[] TIMES_ARRAY = 
	{
		"Select Time", "9 AM", "11 AM", "12 PM", "1 PM", "2 PM", "3 PM", "5 PM", "6 PM", "7 PM", "9 PM", "11 PM"
	};
		
	
	/**
	 * Button Sizes
	 */
	public static final Dimension SIZE_250_30  = new Dimension(250, 30);
	public static final Dimension SIZE_150_300 = new Dimension(150, 300);
	public static final Dimension SIZE_200_300 = new Dimension(200, 300);
	public static final Dimension SIZE_250_300 = new Dimension(250, 300);
	public static final Dimension SIZE_250_400 = new Dimension(250, 400);
	public static final Dimension SIZE_220_400 = new Dimension(200, 400);
	public static final Dimension SIZE_800_400 = new Dimension(800, 400);
	
	
    /**
     * Layout Padding
     */
	public static final int LAYOUT_PADDING_1  = 10; 
    public static final int LAYOUT_PADDING_2  = 50;
    public static final int LAYOUT_PADDING_3  = 100;
    public static final int LAYOUT_PADDING_4  = 150;
    public static final int LAYOUT_PADDING_5  = 200;
    public static final int LAYOUT_PADDING_6  = 250;
    public static final int LAYOUT_PADDING_7  = 300;
    public static final int LAYOUT_PADDING_8  = 350;
    public static final int LAYOUT_PADDING_9  = 400;
    public static final int LAYOUT_PADDING_10 = 450;
    
    /**
     * Layout Row Height
     */
    public static final int LAYOUT_HEIGHT_1   = 10;
    public static final int LAYOUT_HEIGHT_2   = 40;
    public static final int LAYOUT_HEIGHT_3   = 70;
    public static final int LAYOUT_HEIGHT_4   = 100;
    public static final int LAYOUT_HEIGHT_5   = 130;
    public static final int LAYOUT_HEIGHT_6   = 160;
    public static final int LAYOUT_HEIGHT_7   = 190;
}


