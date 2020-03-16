package com.songyinghui.cms.bean;

import java.util.Date;

public class Collect {
	private Integer id;
	private String text;
	private String url;
	private Integer user_id;
	private Date created;

	public Collect(Integer id, String text, String url, Integer user_id, Date created) {
		super();
		this.id = id;
		this.text = text;
		this.url = url;
		this.user_id = user_id;
		this.created = created;
	}

	public Collect() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "Collect [id=" + id + ", text=" + text + ", url=" + url + ", user_id=" + user_id + ", created=" + created
				+ "]";
	}

}
