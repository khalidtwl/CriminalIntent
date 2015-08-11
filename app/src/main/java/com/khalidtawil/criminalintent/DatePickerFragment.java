package com.khalidtawil.criminalintent;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    public static final String EXTRA_DATE = "com.khalidtawil.criminalintent.date_extra";
    private Date mDate;

    // Method Constructor
    public static DatePickerFragment newInstance(Date date) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_DATE, date);

        DatePickerFragment newfragment = new DatePickerFragment();
        newfragment.setArguments(args);

        return newfragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle onSavedInstanceState) {
        // Sets default date to crime date
        mDate = (Date) getArguments().getSerializable(EXTRA_DATE);

        final Calendar c = Calendar.getInstance();
        if (mDate != null)
            c.setTime(mDate);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    private void sendResult(int resultCode) {
        if (getTargetFragment() == null)
            return;
        Intent i = new Intent();
        i.putExtra(EXTRA_DATE, mDate);
        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, i);
    }

    // Required to implement OnDateSetListener
    public void onDateSet(DatePicker view, int year, int month, int day) {
       mDate = new GregorianCalendar(year, month, day).getTime();
        sendResult(Activity.RESULT_OK);
    }
}
