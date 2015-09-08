package com.khalidtawil.criminalintent;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 * This class handles the saving and loading of local JSON data
 */
public class CriminalIntentJSONSerializer {
    private Context mContext;
    private String mFileName;

    public CriminalIntentJSONSerializer(Context c, String f) {
        mContext = c;
        mFileName = f;
    }

    public void saveCrimes(ArrayList<Crime> mCrimes) throws JSONException, IOException {
        // Build a JSON array
        JSONArray array = new JSONArray();
        for (Crime c : mCrimes)
            array.put(c.toJSON());

        // Write file to disk
        Writer writer = null;
        try {
            OutputStream out = mContext.openFileOutput(mFileName, Context.MODE_PRIVATE);
            writer = new OutputStreamWriter(out);
            writer.write(array.toString());
        }
        finally {
            if (writer != null)
                writer.close();
        }
    }
}
