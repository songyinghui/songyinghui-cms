package com.songyinghui.cms.bean;

import java.io.Serializable;

/**
 * 
 * @ClassName: Slide
 * @Description: 广告
 * @author: YH
 * @date: 2020年3月3日 上午11:36:25
 */
public class Slide implements Serializable {
	private Integer id;// 主键
	private String title;// 广告的文字说明
	private String picture;// 广告的坐标地址
	private String url;// 点击广告进入的广告详情

	public Slide(Integer id, String title, String picture, String url) {
		super();
		this.id = id;
		this.title = title;
		this.picture = picture;
		this.url = url;
	}

	public Slide() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Slide [id=" + id + ", title=" + title + ", picture=" + picture + ", url=" + url + "]";
	}

}
