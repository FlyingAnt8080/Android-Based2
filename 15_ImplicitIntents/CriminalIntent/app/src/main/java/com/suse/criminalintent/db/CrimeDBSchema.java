package com.suse.criminalintent.db;

/**
 * @author liujing
 * @version 1.0
 * @date 2020/12/20 22:58
 */
public class CrimeDBSchema {
    public static final class CrimeTable{
        public static final String NAME = "crimes";public static final class Cols{
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String SOLVED = "solved";
            public static final String SUSPECT = "suspect";
        }
    }
}
