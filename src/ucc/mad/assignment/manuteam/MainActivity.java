package ucc.mad.assignment.manuteam;


import ucc.mad.assignment.adapters.CustomAdapter;
import ucc.mad.assignment.data.DataManagement;

import com.example.manuteam.R;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView playerList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		playerList = (ListView)findViewById(R.id.list);
		DataManagement dm = new DataManagement();
		
		CustomAdapter adapter;
		try {
			adapter = new CustomAdapter(this,dm.getPlayers(this));
			playerList.setAdapter(adapter);
		} catch (Exception e) {
			Log.e("MainActivity","Error reading data file");
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

}
