package com.songyinghui.cms.bean;

import java.io.Serializable;

/**
 * 
 * @ClassName: Channel
 * @Description:栏目表实体类
 * @author: YH
 * @date: 2020年3月3日 上午11:21:47
 */

public class Channel {
	private Integer id;
	private String name;// 栏目名称
	private String description;// 描述
	private String icon;// 图标
	private String sorted;// 排序

	public Channel(Integer id, String name, String description, String icon, String sorted) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.icon = icon;
		this.sorted = sorted;
	}

	public Channel() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getSorted() {
		return sorted;
	}

	public void setSorted(String sorted) {
		this.sorted = sorted;
	}

	@Override
	public String toString() {
		return "Channel [id=" + id + ", name=" + name + ", description=" + description + ", icon=" + icon + ", sorted="
				+ sorted + "]";
	}

}
