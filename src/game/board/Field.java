package game.board;

import game.placables.Placeable;
import json.JSONjava.src.main.java.org.json.JSONObject;

public class Field {
    Placeable occupation;
    Boolean polluted;

    public Placeable getOccupation() {
        return occupation;
    }

    public Boolean getPolluted() {
        return polluted;
    }

    public void setOccupation(Placeable occupation) {
        this.occupation = occupation;
    }

    public void pollut() {
        this.polluted = true;
    }
    public JSONObject getField() {
        JSONObject field = new JSONObject();
        field.put("occupation",occupation.getClass());
        field.put("polluted",polluted);
        return field;
    }
}
