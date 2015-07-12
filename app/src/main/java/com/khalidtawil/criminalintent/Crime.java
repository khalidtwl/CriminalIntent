package com.khalidtawil.criminalintent;

import java.util.UUID;

/**
 * Created by khalidtawil on 7/12/15.
 */
public class Crime {
    private UUID mID;
    private String mTitle;

    public Crime(){
        // Generates a unique identifier
        mID = UUID.randomUUID();
    }

    public UUID getID() {
        return mID;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
