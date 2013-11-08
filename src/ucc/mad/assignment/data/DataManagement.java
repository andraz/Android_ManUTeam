package ucc.mad.assignment.data;

import java.io.InputStream;
import java.util.List;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import android.content.Context;
import android.util.Log;

public class DataManagement {
	private List<Player> players;
	
	public List<Player> getPlayers(Context c) throws Exception{
		Serializer serializer = new Persister();
		try {
			InputStream source = c.getAssets().open("players.xml");
			Dataroot root = serializer.read(Dataroot.class, source);
			players = root.getPlayers();
		} catch (Exception e) {
			throw new Exception("Error in parsing XML data.");
		}
		return players;
	}

}
