package ucc.mad.assignment.manuteam;

import ucc.mad.assignment.data.Player;

import com.example.manuteam.R;
import com.example.manuteam.R.layout;
import com.example.manuteam.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.support.v4.app.NavUtils;

public class PlayerWebViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player_web_view);
		// Show the Up button in the action bar.
		setupActionBar();
		
		Intent myLocalIntent = getIntent();
		Bundle myBundle = myLocalIntent.getExtras();
		String webPage = myBundle.getString("webpage");
		
		WebView webView = (WebView)findViewById(R.id.playerWebPage);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl(webPage);
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.player_web_view, menu);
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
