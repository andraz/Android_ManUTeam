package ucc.mad.assignment.manuteam;

import java.util.List;

import ucc.mad.assignment.data.DataManagement;
import ucc.mad.assignment.data.Player;

import com.example.manuteam.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv;
	
	private List<Player> playersList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv = (TextView) findViewById(R.id.helloWorld);
		readData();
		
		String listText = "";
		for(Player p:playersList){
			listText += p.getName()+"\n";
		}
		tv.setText(listText);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void readData(){
		try {
			DataManagement dm = new DataManagement();
			playersList = dm.getPlayers(this);
		} catch (Exception e) {
			tv.setText(e.getMessage());
		}
	}

}
