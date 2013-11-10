package ucc.mad.assignment.fragments;

import ucc.mad.assignment.data.Player;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.manuteam.R;

public class PlayerDescriptionFragment extends Fragment{
	public Player player;
	
	
	
	public PlayerDescriptionFragment() {
		super();
	}

	public PlayerDescriptionFragment(Player player) {
		super();
		this.player = player;
	}

	 @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {
	    View view = inflater.inflate(R.layout.plater_description_fragment,
	        container, false);
	    
	    TextView summary = (TextView)view.findViewById(R.id.summary);
	    TextView description = (TextView)view.findViewById(R.id.description);
	    
	    summary.setText(player.getDescription().getSummary());
	    description.setText(player.getDescription().getDescription());
	    
	    return view;
	  }
}
