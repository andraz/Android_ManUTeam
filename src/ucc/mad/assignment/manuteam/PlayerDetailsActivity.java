package ucc.mad.assignment.manuteam;

import ucc.mad.assignment.data.Player;

import com.example.manuteam.R;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class PlayerDetailsActivity extends Activity {
	TextView playerNumber;
	TextView playerName;
	ImageView mainImage;
	TextView playerPosition;
	
	private Player player;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player_details);
		// Show the Up button in the action bar.
		setupActionBar();
		
		playerNumber = (TextView)findViewById(R.id.playerNumber);
		playerName = (TextView)findViewById(R.id.playerName);
		playerPosition = (TextView)findViewById(R.id.playerPosition);
		mainImage = (ImageView)findViewById(R.id.playerImage);
		
		Intent myLocalIntent = getIntent();
		Bundle myBundle = myLocalIntent.getExtras();
		player = (Player)myBundle.getSerializable("player");
		
		playerName.setText(player.getName());
		playerNumber.setText(player.getNumber()+". ");
		playerPosition.setText(player.getPosition());
		
		int drawableResourceId = this.getResources().getIdentifier(player.getMainimage(), "drawable", this.getPackageName());
		mainImage.setImageResource(drawableResourceId);
		mainImage.setAdjustViewBounds(true);
		
		
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
		
		MenuItem moreInfoItem = menu.add(1,1,1,"More info");
		moreInfoItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_WITH_TEXT | MenuItem.SHOW_AS_ACTION_IF_ROOM);
		
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
		case 1:
			if(player != null){
				Intent intent = new Intent(this,PlayerMoreInfoActivity.class);
				
				Bundle myData = new Bundle();
				myData.putSerializable("player", player);
				intent.putExtras(myData);
				
				startActivityForResult(intent, 1);
			}
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		  if (requestCode == 1) {
	
			     if(resultCode == RESULT_OK){      
			         Log.i("PlayerDetailsActivity","Result");         
			     }
			     if (resultCode == RESULT_CANCELED) {    
			         //Write your code if there's no result
			     }
		  }
	}
	

}
