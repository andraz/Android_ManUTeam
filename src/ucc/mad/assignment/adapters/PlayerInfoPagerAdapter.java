package ucc.mad.assignment.adapters;

import ucc.mad.assignment.data.Player;
import ucc.mad.assignment.fragments.PlayerInfoFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PlayerInfoPagerAdapter extends FragmentPagerAdapter {
	
	private Player player;
	public PlayerInfoPagerAdapter(FragmentManager fm, Player p) {
		super(fm);
		player = p;
	}


	final int PAGE_COUNT = 3;

	

	/** This method will be invoked when a page is requested to create */
	@Override
	public Fragment getItem(int arg0) {
		Fragment myFragment = null;
		if(arg0 == 0){
			myFragment = new PlayerInfoFragment(player);
		}
		else if(arg0 == 1){
			myFragment = new PlayerInfoFragment(player);
		}
		else if(arg0 == 2){
			myFragment = new PlayerInfoFragment(player);
		}
		return myFragment;
	}

	/** Returns the number of pages */
	@Override
	public int getCount() {
		return PAGE_COUNT;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		switch (position) {
		case 0:
			return "Player Stats";
		case 1:
			return "Description";
		case 2:
			return "Web page";
		default:
			return "";	
		}
	}

}
