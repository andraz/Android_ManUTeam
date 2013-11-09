package ucc.mad.assignment.adapters;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.example.manuteam.R;

import ucc.mad.assignment.data.DataManagement;
import ucc.mad.assignment.data.Dataroot;
import ucc.mad.assignment.data.Player;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<Player> {

	private Activity c;
	private List<Player> data;
	
	public CustomAdapter(Activity context,List<Player> data){
		super(context,R.layout.row, data);
		c = context;
		this.data = data;
		Collections.sort(this.data);
	}
	
	public View getView(int position, View v, ViewGroup group){
		//get current player
		Player player = data.get(position);
		// inflate
		LayoutInflater inflater = c.getLayoutInflater();
		View row = inflater.inflate(R.layout.row, null);
		// Populate the view
		ImageView icon = (ImageView)row.findViewById(R.id.icon);
		TextView number = (TextView)row.findViewById(R.id.number);
		TextView title = (TextView)row.findViewById(R.id.title);
		TextView subTitle = (TextView)row.findViewById(R.id.subtitle);
		number.setText(player.getNumber()+". ");
		title.setText(player.getName());
		subTitle.setText(player.getPosition());
		
		int drawableResourceId = c.getResources().getIdentifier(player.getProfileimage(), "drawable", c.getPackageName());
		icon.setImageResource(drawableResourceId);
		icon.setAdjustViewBounds(true);
		//return the view
		
		return row;
	}
	
}
