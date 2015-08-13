package me.ccrama.ToolboxAPI;

import me.ccrama.ToolboxAPI.Notes.NoteDatabase;
import org.json.JSONObject;

public class ToolboxWrapper {

    public NoteDatabase getDatabaseFromString(String rawData){
        JSONObject o = new JSONObject(rawData);
        return new NoteDatabase(o);
    }

}
