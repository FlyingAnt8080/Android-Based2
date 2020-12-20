package com.suse.criminalintent;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author liujing
 * @version 1.0
 * @date 2020/12/18 16:12
 */
public class CrimeLab {
    private static volatile CrimeLab sCrimeLab;
    private List<Crime> mCrimes;
    public static CrimeLab get(Context context) {
        if (sCrimeLab == null){
            synchronized (CrimeLab.class){
                if (sCrimeLab == null){
                    sCrimeLab = new CrimeLab(context);
                }
            }
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context){
        mCrimes = new ArrayList<>();
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id){
        for (Crime crime : mCrimes){
            if (crime.getId().equals(id)){
                return crime;
            }
        }
        return null;
    }

    public void addCrime(Crime crime){
        mCrimes.add(crime);
    }
}
