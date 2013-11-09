package ucc.mad.assignment.data;

import java.io.Serializable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="description")
public class PersonDescription implements Serializable {

	private static final long serialVersionUID = -1828513129243295059L;
	
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
