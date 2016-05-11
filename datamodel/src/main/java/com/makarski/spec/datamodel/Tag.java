package com.makarski.spec.datamodel;

import java.util.List;
import javax.persistence.*;


@Entity
public class Tag extends AbstractModel {

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags")
	private List<Part> parts;

	@Column
	private String tagName;

	public List<Part> getParts() {
		return parts;
	}

	public void setParts(List<Part> parts) {
		this.parts = parts;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

}
