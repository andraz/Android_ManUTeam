package ucc.mad.assignment.data;

import java.io.Serializable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Player implements Serializable, Comparable<Player> {

	private static final long serialVersionUID = -1484539900099981115L;
	
	
	@Element
	private String name;
	@Element
	private String number;
	@Element
	private String appearances;
	@Element
	private String goals;
	@Element
	private String profileimage;
	@Element
	private String mainimage;
	@Element
	private String url;
	@Element
	private String position;
	@Element
	private PersonDescription description;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAppearances() {
		return appearances;
	}
	public void setAppearances(String appearances) {
		this.appearances = appearances;
	}
	public String getGoals() {
		return goals;
	}
	public void setGoals(String goals) {
		this.goals = goals;
	}
	public String getProfileimage() {
		return profileimage;
	}
	public void setProfileimage(String profileimage) {
		this.profileimage = profileimage;
	}
	public String getMainimage() {
		return mainimage;
	}
	public void setMainimage(String mainimage) {
		this.mainimage = mainimage;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public PersonDescription getDescription() {
		return description;
	}
	public void setDescription(PersonDescription description) {
		this.description = description;
	}
	@Override
	public int compareTo(Player another) {
		if(Integer.valueOf(this.getNumber()) < Integer.valueOf(another.getNumber())){
			return -1;
		}
		else if(Integer.valueOf(this.getNumber()) > Integer.valueOf(another.getNumber())){
			return 1;
		}
		return 0;
	}
	
	
	
}

