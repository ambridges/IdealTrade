package com.hfad.idealtrade.utilities;

/**
 *
 * Created by Alex on 06/08/2016.
 */
public class Globals {
    private static Globals instance;

    // Global variables
    public static final int PROFILE = 100000;
    public static final int SKILL = 100001;
    public static final int ITEM = 100010;
    public static final int REQUEST = 100011;
    public static final int INBOX = 100100;
    public static final int CONTACTS = 100101;
    public static final int PRIVACYSETTINGS = 100110;
    public static final int VIDEOSHARING = 100111;
    public static final int FILESHARING = 101000;
    public static final int TRADES = 101001;
    public static final int FAVOURITELISTINGS = 101010;
    public static final int MYLISTINGS = 101011;
    public static final int FEEDBACK = 101100;
    public static final int VERIFYACCOUNT = 101101;
    public static final int COMMENTS = 101110;
    public static final int INVITEFRIENDS = 101111;
    public static final int SUGGESTIONBOX = 110000;
    public static final int COMPLAINTS = 110001;
    public static final int DONATIONS = 110010;
    public static final int QUERIES = 110011;
    public static final int LANDING = 110100;

    //Restrict constructor from being instantiated
    private Globals(){}

    public static synchronized Globals getInstance(){
        if(instance==null){
            instance=new Globals();
        }
        return instance;
    }
}
