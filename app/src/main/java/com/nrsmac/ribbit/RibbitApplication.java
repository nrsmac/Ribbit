package com.nrsmac.ribbit;

import android.app.Application;

import com.nrsmac.ribbit.com.nrsmac.ribbit.com.nrsmac.ribbit.utils.ParseConstants;
import com.nrsmac.ribbit.com.nrsmac.ribbit.ui.MainActivity;
import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.PushService;

public class RibbitApplication extends Application {
	
	@Override
	public void onCreate() { 
		super.onCreate();
        Parse.initialize(this, "UljXpQxLpSq539H75KU4dbDi83PZYqDr4uQKY5ry", "eTnG5s96iDI94qqDBSRcK1QyNDojdC9NSGKcgWbZ");

        //PushService.setDefaultPushCallback(this, MainActivity.class);
        PushService.setDefaultPushCallback(this, MainActivity.class,
                R.drawable.ic_stat_ic_launcher);
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }

    public static void updateParseInstallation(ParseUser user) {
        ParseInstallation installation = ParseInstallation.getCurrentInstallation();
        installation.put(ParseConstants.KEY_USER_ID, user.getObjectId());
        installation.saveInBackground();
    };
}
