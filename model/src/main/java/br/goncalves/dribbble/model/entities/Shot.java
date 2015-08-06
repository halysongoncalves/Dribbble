package br.goncalves.dribbble.model.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by halysongoncalves on 22/03/15.
 */
public class Shot implements Serializable{
    private static final long serialVersionUID = -2119956232202115326L;
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("height")
    private int height;
    @SerializedName("width")
    private int width;
    @SerializedName("likes_count")
    private int likesCount;
    @SerializedName("comments_count")
    private int commentsCount;
    @SerializedName("rebounds_count")
    private int reboundsCount;
    @SerializedName("url")
    private String url;
    @SerializedName("short_url")
    private String shortUrl;
    @SerializedName("views_count")
    private int viewsCount;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("image_teaser_url")
    private String imageTeaserUrl;
    @SerializedName("image_400_url")
    private String image400Url;
    @SerializedName("player")
    private Player player;
    @SerializedName("created_at")
    private String createdAt;


    public Shot(int id, String title, String description, int height, int width, int likesCount, int commentsCount, int reboundsCount, String url, String shortUrl, int viewsCount, String imageUrl, String imageTeaserUrl, String image400Url, Player player, String createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.height = height;
        this.width = width;
        this.likesCount = likesCount;
        this.commentsCount = commentsCount;
        this.reboundsCount = reboundsCount;
        this.url = url;
        this.shortUrl = shortUrl;
        this.viewsCount = viewsCount;
        this.imageUrl = imageUrl;
        this.imageTeaserUrl = imageTeaserUrl;
        this.image400Url = image400Url;
        this.player = player;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public int getReboundsCount() {
        return reboundsCount;
    }

    public void setReboundsCount(int reboundsCount) {
        this.reboundsCount = reboundsCount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public int getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(int viewsCount) {
        this.viewsCount = viewsCount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageTeaserUrl() {
        return imageTeaserUrl;
    }

    public void setImageTeaserUrl(String imageTeaserUrl) {
        this.imageTeaserUrl = imageTeaserUrl;
    }

    public String getImage400Url() {
        return image400Url;
    }

    public void setImage400Url(String image400Url) {
        this.image400Url = image400Url;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
