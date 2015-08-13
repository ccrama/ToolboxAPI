package me.ccrama.ToolboxAPI.Notes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlo_000 on 8/13/2015.
 */
public class NoteDatabase {
    public int version;
    public String[] mods;
    public String[] warnings;
    public JSONArray rawNoteData; //for v6 and above
    public String compressedBlob;
    public List<UserNotes> userNoteses;

    public NoteDatabase(JSONObject baseNoteObject) {
        try {
            version = baseNoteObject.getInt("ver");

            JSONObject constants = baseNoteObject.getJSONObject("constants");

            JSONArray modsArray = constants.getJSONArray("users");
            mods = new String[modsArray.length()];
            for (int i = 0; i < modsArray.length(); i++) {
                mods[i] = modsArray.getString(i);
            }

            JSONArray warningsArray = constants.getJSONArray("warnings");
            warnings = new String[warningsArray.length()];
            for (int i = 0; i < warningsArray.length(); i++) {
                warnings[i] = warningsArray.getString(i);


            }

            if (version == 6) {
                compressedBlob = baseNoteObject.getString("blob");
                rawNoteData = decompressBlob();
            } else { //Skip decompression of v5 or before
                rawNoteData = baseNoteObject.getJSONArray("blob"); //TODO Someone please confirm this is the json array title in v5
            }
        } catch (JSONException e) {
            e.printStackTrace();
            //Something went wrong
            //TODO create a fallback if something went wrong
        }
        userNoteses = new ArrayList<>();
        for(int i = 0; i < rawNoteData.length(); i++){
            try {
                userNoteses.add(new UserNotes(rawNoteData.getJSONObject(i), this));
            } catch (JSONException e) {
                e.printStackTrace();
                //Something went wrong retrieving notes. Perhaps there aren't any?
            }
        }
    }

    public List<UserNotes> getAllNotes(){
        return userNoteses;
    }

    public JSONArray decompressBlob() {
        //TODO: Write decompression code
        return null;
    }
}
