package ucc.mad.assignment.manuteam;

import ucc.mad.assignment.adapters.PlayerInfoPagerAdapter;
import ucc.mad.assignment.data.Player;

import com.example.manuteam.R;
import com.example.manuteam.R.layout;
import com.example.manuteam.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class PlayerMoreInfoActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_palayer_more_info);
		setupActionBar();
		
		Intent myLocalIntent = getIntent();
		Bundle myBundle = myLocalIntent.getExtras();
		Player player = (Player)myBundle.getSerializable("player");
		
		TextView number = (TextView)findViewById(R.id.playerNumber);
		TextView name = (TextView)findViewById(R.id.playerName);
		
		number.setText(player.getNumber()+". ");
		name.setText(player.getName());
		
		ViewPager pager = (ViewPager) findViewById(R.id.pager);
		 
        /** Getting fragment manager */
        FragmentManager fm = getSupportFragmentManager();
 
        /** Instantiating FragmentPagerAdapter */
        PlayerInfoPagerAdapter pagerAdapter = new PlayerInfoPagerAdapter(fm,player);
 
        
        /** Setting the pagerAdapter to the pager object */
        pager.setAdapter(pagerAdapter);
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.palayer_more_info, menu);
		return true;
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
			Intent returnIntent = new Intent();
			setResult(RESULT_CANCELED, returnIntent);        
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
