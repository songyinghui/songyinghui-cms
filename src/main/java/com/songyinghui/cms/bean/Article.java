package com.songyinghui.cms.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName: Article
 * @Description: TODO 文章实体类
 * @author: YH
 * @date: 2020年3月3日 上午11:36:37
 */
public class Article implements Serializable {
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;// 主键
	private String title;// 标题
	private String summary;// 文章摘要
	private String content;// 文章内容
	private String picture;// 文章标题图片
	private Integer channelId;// 所属栏目Id
	private Integer categoryId;// 所属分类Id
	private Integer userId;// 发布者id
	private Integer hits;// 点击量
	private Integer hot;// 是否热门文章 1:热门 0:一般
	private Integer status;// 审核状态 0:待审 1:审核通过 -1:驳回
	private Integer deleted;// 删除状态 0:正常 1:逻辑删除
	private Date created;// 文章发布时间
	private Date updated;// 文章修改时间
	private Channel channel;
	private Category category;
	private User user;
	private Integer commentNum;

	public Integer getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}

	public Article(Integer id, String title, String summary, String content, String picture, Integer channelId,
			Integer categoryId, Integer userId, Integer hits, Integer hot, Integer status, Integer deleted,
			Date created, Date updated, Channel channel, Category category, User user) {
		super();
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.content = content;
		this.picture = picture;
		this.channelId = channelId;
		this.categoryId = categoryId;
		this.userId = userId;
		this.hits = hits;
		this.hot = hot;
		this.status = status;
		this.deleted = deleted;
		this.created = created;
		this.updated = updated;
		this.channel = channel;
		this.category = category;
		this.user = user;
	}

	public Article() {
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

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getHits() {
		return hits;
	}

	public void setHits(Integer hits) {
		this.hits = hits;
	}

	public Integer getHot() {
		return hot;
	}

	public void setHot(Integer hot) {
		this.hot = hot;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", summary=" + summary + ", content=" + content + ", picture="
				+ picture + ", channelId=" + channelId + ", categoryId=" + categoryId + ", userId=" + userId + ", hits="
				+ hits + ", hot=" + hot + ", status=" + status + ", deleted=" + deleted + ", created=" + created
				+ ", updated=" + updated + ", channel=" + channel + ", category=" + category + ", user=" + user + "]";
	}

}
