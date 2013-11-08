package ucc.mad.assignment.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="description")
public class PersonDescription {
	@Element(name="summary",required=false)
	private String summary;
	@Element(name="description",required=false)
	private String description;
	
	
	
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
