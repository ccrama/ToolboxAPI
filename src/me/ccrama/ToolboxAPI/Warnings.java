package me.ccrama.ToolboxAPI;

/**
 * Created by carlo_000 on 8/13/2015.
 */
public enum Warnings {
        NONE("none"),
        SPAM_WATCH("spamwatch"),
        SPAM_WARNING("spamwarning"),
        ABUSE_WARNING("abusewarning"),
        BAN("ban"),
        PERMANENT_BAN("permanentban"),
        BOT_BAN("botban"),
        GOOD_CONTRIBUTOR("goodcontributor");

    public String getName() {
        return name;
    }

    private String name;

    Warnings(String s){
            this.name=s;
        }

    public static Warnings getFromString(String name){
        switch (name){
            case "none": return NONE;
            case "spamwatch": return SPAM_WATCH;
            case "spamwarning": return SPAM_WARNING;
            case "abusewarning": return ABUSE_WARNING;
            case "ban": return BAN;
            case "permanentban": return PERMANENT_BAN;
            case "botban": return BOT_BAN;
            case "goodcontributor": return GOOD_CONTRIBUTOR;

            default: return NONE;
        }
    }



}
