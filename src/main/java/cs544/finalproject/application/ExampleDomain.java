package cs544.finalproject.application;

import javax.persistence.*;
/**
 * @author suman
 * Description: Example domain.
 */
@Entity
@Table(name="Example")
public class ExampleDomain {
	@Id
	@GeneratedValue
	private int id;
	private String example_name;
	private String example_value;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getExample_name() {
		return example_name;
	}
	public void setExample_name(String example_name) {
		this.example_name = example_name;
	}
	public String getExample_value() {
		return example_value;
	}
	public void setExample_value(String example_value) {
		this.example_value = example_value;
	}
}
