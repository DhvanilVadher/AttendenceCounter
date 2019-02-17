package com.example.dhvanil.attendencecounter.adaptersClasses;

import android.widget.LinearLayout;

public class List {
    private String Day;
    private boolean attended;
    private boolean absecent;
    private boolean holiday;

    public List( String day, boolean attended, boolean absecent, boolean holiday ) {
        Day = day;
        this.attended = attended;
        this.absecent = absecent;
        this.holiday = holiday;
    }
    public List(){}

    public String getDay() {
        return Day;
    }

    public void setDay( String day ) {
        Day = day;
    }

    public boolean isAttended() {
        return attended;
    }

    public void setAttended( boolean attended ) {
        this.attended = attended;
    }

    public boolean isAbsecent() {
        return absecent;
    }

    public void setAbsecent( boolean absecent ) {
        this.absecent = absecent;
    }

    public boolean isHoliday() {
        return holiday;
    }

    public void setHoliday( boolean holiday ) {
        this.holiday = holiday;
    }
}
