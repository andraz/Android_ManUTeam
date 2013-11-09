package ucc.mad.assignment.fragments;


import ucc.mad.assignment.data.Player;

import com.example.manuteam.R;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class PlayerInfoFragment extends Fragment{
	public Player player;
	
	
	
	public PlayerInfoFragment() {
		super();
	}

	public PlayerInfoFragment(Player player) {
		super();
		this.player = player;
	}

	 @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {
	    View view = inflater.inflate(R.layout.player_info_fragment,
	        container, false);
	    
	    TextView position = (TextView)view.findViewById(R.id.position);
	    TextView appearances = (TextView)view.findViewById(R.id.appearances);
	    TextView goals = (TextView)view.findViewById(R.id.goals);
	    
	    position.setText(player.getPosition());
	    appearances.setText(player.getAppearances());
	    goals.setText(player.getGoals());
	    
	    return view;
	  }
}
