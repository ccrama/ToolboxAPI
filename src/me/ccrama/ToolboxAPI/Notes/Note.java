package me.ccrama.ToolboxAPI.Notes;

import me.ccrama.ToolboxAPI.Warnings;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by carlo_000 on 8/13/2015.
 */
public class Note {
    private String note;
    private String link;
    private int time;
    private int modIndex;
    private String modFromIndex;
    private Warnings warningFromIndex;
    private int warningIndex;

    public String getNote() {
        return note;
    }

    public String getLink() {
        return link;
    }

    public int getTime() {
        return time;
    }

    public String getMod() {
        return modFromIndex;
    }

    public Warnings getWarning() {
        return warningFromIndex;
    }

    public Note(JSONObject rawJsonObject, NoteDatabase parent){
        try {
            note = rawJsonObject.getString("n");

            link = rawJsonObject.getString("l");
            time = rawJsonObject.getInt("t");
            modIndex = rawJsonObject.getInt("m");
            modFromIndex = parent.mods[modIndex];
            warningIndex = rawJsonObject.getInt("w");
            warningFromIndex=Warnings.getFromString(parent.warnings[warningIndex]);
        } catch (JSONException e) {
            e.printStackTrace();
            //Something went wrong here...
        }
    }
}
