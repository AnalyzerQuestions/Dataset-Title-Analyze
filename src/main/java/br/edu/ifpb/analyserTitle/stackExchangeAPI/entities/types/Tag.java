package br.edu.ifpb.analyserTitle.stackExchangeAPI.entities.types;

public class Tag {

	private Integer count;
	private String name;
	private boolean required;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	@Override
	public String toString() {
		return "Tag [count=" + count + ", name=" + name + ", required="
				+ required + "]";
	}

}
