package org.pensions.md.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "percentages")
@XmlRootElement
public class Percentage {

	private Integer id;
	private Integer years;
	private Integer months;
	private Integer reduced;
	private Integer unreduced;
	private Integer upperLimit;
	private Integer lowerLimit;
	private String type;
	private String offeredTo;
	private String post;
	private String circular;
	
	public Percentage() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	@Column(name = "years")
	public Integer getYears() {
		return years;
	}

	@Column(name = "months")
	public Integer getMonths() {
		return months;
	}

	@Column(name = "reduced")
	public Integer getReduced() {
		return reduced;
	}

	@Column(name = "unreduced")
	public Integer getUnreduced() {
		return unreduced;
	}

	@Column(name = "upperlimit")
	public Integer getUpperLimit() {
		return upperLimit;
	}

	@Column(name = "lowerlimit")
	public Integer getLowerLimit() {
		return lowerLimit;
	}

	@Column(name = "type", length = 25)
	public String getType() {
		return type;
	}

	@Column(name = "offered_to", length = 20)
	public String getOfferedTo() {
		return offeredTo;
	}
	
	@Column(name = "post", length = 20)
	public String getPost() {
		return post;
	}

	@Column(name = "circular", length = 5)
	public String getCircular() {
		return circular;
	}

	public void setCircular(String circular) {
		this.circular = circular;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setOfferedTo(String offeredTo) {
		this.offeredTo = offeredTo;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setYears(Integer years) {
		this.years = years;
	}

	public void setMonths(Integer months) {
		this.months = months;
	}

	public void setReduced(Integer reduced) {
		this.reduced = reduced;
	}

	public void setUnreduced(Integer unreduced) {
		this.unreduced = unreduced;
	}

	public void setUpperLimit(Integer upperLimit) {
		this.upperLimit = upperLimit;
	}

	public void setLowerLimit(Integer lowerLimit) {
		this.lowerLimit = lowerLimit;
	}
	
	
	
}
