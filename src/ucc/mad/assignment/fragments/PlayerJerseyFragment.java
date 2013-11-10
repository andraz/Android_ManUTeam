package ucc.mad.assignment.fragments;

import ucc.mad.assignment.data.Player;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manuteam.R;

public class PlayerJerseyFragment extends Fragment{
	public Player player;
	
	
	
	public PlayerJerseyFragment() {
		super();
	}

	public PlayerJerseyFragment(Player p) {
		super();
		this.player = p;
	}

	 @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {
	    View view = inflater.inflate(R.layout.player_jersey_fragment,
	        container, false);
	    
	    ImageView jersey = (ImageView)view.findViewById(R.id.playerJersey);

	    int drawableResourceId = this.getResources().getIdentifier(player.getJerseyimage(), "drawable", this.getActivity().getPackageName());
	    jersey.setImageResource(drawableResourceId);
	    
	    return view;
	  }
}
