package com.ineptech.magicmirror.modules;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.text.Html;
import android.text.Spanned;
import android.util.Log;

import com.ineptech.magicmirror.Utils;

public class DayModule extends Module {
	
	public DayModule() {
		super("Day of week");
		desc = "Shows what day of the week and month it is.";
		defaultTextSize = 64;
		sampleString = "Wednesday the 27th";
	}
	
    public void update() {
        SimpleDateFormat formatDayOfMonth = new SimpleDateFormat("EEEE", Locale.getDefault());
        Calendar now = Calendar.getInstance();
        int dayOfMonth = now.get(Calendar.DAY_OF_MONTH);
        Log.e("dom",Integer.toString(dayOfMonth));
        
        Spanned span;
        if (Locale.getDefault().getLanguage().compareTo(Locale.US.getLanguage()) == 0) { 
        	span = Html.fromHtml(formatDayOfMonth.format(now.getTime()) + " " + dayOfMonth + "<sup><small>"
        				+ Utils.getDayOfMonthSuffix(dayOfMonth) + "</small></sup>");
            Log.e("dom1",span.toString());

        } else {
            Log.e("dom2","here");
            Locale loc = Locale.getDefault();
   //     	DateTimeFormatter formatter_tr_TR = DateTimeFormatter.ofLocalizedDateTime( FormatStyle.FULL ).withLocale( loc );
            span = Html.fromHtml(formatDayOfMonth.format(now.getTime()) + " " + dayOfMonth + "<sup><small>"
                    + Utils.getDayOfMonthSuffix(dayOfMonth) + "</small></sup>");
            Log.e("dom2",span.toString());
        }
        tv.setText(span);
    }

    

}
