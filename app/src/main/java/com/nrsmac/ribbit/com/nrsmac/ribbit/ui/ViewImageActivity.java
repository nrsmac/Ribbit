package com.nrsmac.ribbit.com.nrsmac.ribbit.ui;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.nrsmac.ribbit.R;
import com.squareup.picasso.Picasso;

public class ViewImageActivity extends Activity {

    protected ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);

        mProgressBar = (ProgressBar) findViewById(R.id.imageLoadProgressBar);
        mProgressBar.setVisibility(View.INVISIBLE);
        // Show the Up button in the action bar.
        setupActionBar();

        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        mProgressBar.setVisibility(View.VISIBLE);

        Uri imageUri = getIntent().getData();
        Log.i("TAG", imageUri.toString());


        Picasso.with(this).load(imageUri.toString()).into(imageView);
        mProgressBar.setVisibility(View.INVISIBLE);


    }

    /**
     * Set up the {@link android.app.ActionBar}.
     */
    private void setupActionBar() {

        getActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // This ID represents the Home or Up button. In the case of this
                // activity, the Up button is shown. Use NavUtils to allow users
                // to navigate up one level in the application structure. For
                // more details, see the Navigation pattern on Android Design:
                //
                // http://developer.android.com/design/patterns/navigation.html#up-vs-back
                //
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
