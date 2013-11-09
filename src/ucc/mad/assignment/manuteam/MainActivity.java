package ucc.mad.assignment.manuteam;


import java.util.List;

import ucc.mad.assignment.adapters.CustomAdapter;
import ucc.mad.assignment.data.DataManagement;
import ucc.mad.assignment.data.Player;

import com.example.manuteam.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

	private ListView playerList;
	private List<Player> data;
	private final Context c = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		playerList = (ListView)findViewById(R.id.list);
		DataManagement dm = new DataManagement();
		
		CustomAdapter adapter;
		try {
			data = dm.getPlayers(this);
			
		} catch (Exception e) {
			Log.e("MainActivity","Error reading data file");
		}
		adapter = new CustomAdapter(this,data);
		playerList.setAdapter(adapter);
		playerList.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				Player selectedPlayer = data.get(position);
				Intent intent = new Intent(c,PlayerDetailsActivity.class);
				
				Bundle myData = new Bundle();
				myData.putSerializable("player", selectedPlayer);
				intent.putExtras(myData);
				
				startActivityForResult(intent, 1);
			}
			
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		  if (requestCode == 1) {
	
			     if(resultCode == RESULT_OK){      
			         Log.i("Main Activity","Result from playerDetailsActivity");         
			     }
			     if (resultCode == RESULT_CANCELED) {    
			         //Write your code if there's no result
			     }
		  }
	}

}
