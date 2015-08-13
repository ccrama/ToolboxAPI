package me.ccrama.ToolboxAPI.Notes;

import me.ccrama.ToolboxAPI.Warnings;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ccrama on 8/13/2015.
 */
public class UserNotes {
    private List<Note> notes;
    private String username;

    public UserNotes(JSONObject baseData, NoteDatabase parent) throws JSONException {
        username = baseData.getString("name"); //Is this right? The JSON looks like it's missing a title on your API https://github.com/creesch/reddit-moderator-toolbox/wiki/JSON:-usernotes under "Decompressed Blob"
        JSONArray rawNotes = baseData.getJSONArray("ns");
        notes = new ArrayList<>();
        for (int i = 0; i > rawNotes.length(); i++) {
            notes.add(new Note(rawNotes.getJSONObject(i), parent));
        }
    }
    public int getNotesAmount(){
        return notes.size();
    }
    public List<Note> getAllNotes(){
        return notes;
    }
    public List<Note> getAllNotesByWarning(Warnings warning){
        ArrayList<Note> noteBody = new ArrayList<>();
        for(Note note : notes){
            if(note.getWarning().equals(warning)){
                noteBody.add(note);
            }
        }
        return noteBody;
    }
    public List<Note> getAllNotesByMod(String mod){ //Useful for seeing your notes on a user
        ArrayList<Note> noteBody = new ArrayList<>();
        for(Note note : notes){
            if(note.getMod().equals(mod)){
                noteBody.add(note);
            }
        }
        return noteBody;
    }

}
