package me.ccrama.ToolboxAPI;

/**
 * Created by ccrama on 8/13/2015.
 */
public class WikiBackendConstants {

    public static String REPLACE_SUB = "$$$$$";
    public static String USERNOTE_SAVE_LOCATION = "http://www.reddit.com/r/$$$$$/wiki/usernotes";
    public static String TOOLBOX_CONFIG_LOCATION = "http://www.reddit.com/r/$$$$$/wiki/toolbox";


    public String getUsernoteSaveLocation(String subreddit){
        return USERNOTE_SAVE_LOCATION.replace(REPLACE_SUB, subreddit);
    }
    public String getToolboxConfigLocation(String subreddit){
        return TOOLBOX_CONFIG_LOCATION.replace(REPLACE_SUB, subreddit);
    }
}
