package com.khalidtawil.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * This class is a singleton representing a list of crimes
 */
public class CrimeLab {
    private ArrayList<Crime> mCrimes;

    private static CrimeLab sCrimeLab;
    private Context mAppContext;

    private CrimeLab(Context appContext){
        mAppContext = appContext;
        mCrimes = new ArrayList<>();
    }

    public static CrimeLab get(Context c){
        if (sCrimeLab == null){
            sCrimeLab = new CrimeLab(c.getApplicationContext());
        }
        return sCrimeLab;
    }

    public ArrayList<Crime> getCrimes(){
        return mCrimes;
    }

    public Crime getCrime(UUID id){
        for (Crime c : mCrimes){
            if (c.getID().equals(id))
                return c;
        }
        return null;
    }

    public void addCrime(Crime c) {
        mCrimes.add(c);
    }
}
