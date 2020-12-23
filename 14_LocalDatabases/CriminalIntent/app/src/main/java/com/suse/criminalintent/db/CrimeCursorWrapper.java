package com.suse.criminalintent.db;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.suse.criminalintent.Crime;
import com.suse.criminalintent.db.CrimeDBSchema.CrimeTable;

import java.util.Date;
import java.util.UUID;

/**
 * @author liujing
 * @version 1.0
 * @date 2020/12/20 23:53
 */
public class CrimeCursorWrapper extends CursorWrapper {
    public CrimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }
    
    public Crime getCrime(){
        String uuidString = getString(getColumnIndex(CrimeTable.Cols.UUID));
        String title = getString(getColumnIndex(CrimeTable.Cols.TITLE));
        long date = getLong(getColumnIndex(CrimeTable.Cols.DATE));
        int isSolved = getInt(getColumnIndex(CrimeTable.Cols.SOLVED));
        Crime crime = new Crime(UUID.fromString(uuidString));
        crime.setTitle(title);
        crime.setDate(new Date(date));
        crime.setSolved(isSolved != 0);
        return crime;
    }
}
