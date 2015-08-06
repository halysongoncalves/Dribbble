package br.goncalves.dribbble.model.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by halysongoncalves on 22/03/15.
 */
public class Player implements Serializable{
    private static final long serialVersionUID = -3581176923965575886L;
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("location")
    private String location;
    @SerializedName("followers_count")
    private int followersCount;
    @SerializedName("draftees_count")
    private int draftessCount;
    @SerializedName("likes_count")
    private int likesCount;
    @SerializedName("likes_received_count")
    private int likesReceivedCount;
    @SerializedName("comments_count")
    private int commentsCount;
    @SerializedName("comments_received_count")
    private int commentReceivedCount;
    @SerializedName("rebounds_count")
    private int reboundsCount;
    @SerializedName("rebounds_received_count")
    private int reboundsReceivedCount;
    @SerializedName("url")
    private String url;
    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("username")
    private String username;
    @SerializedName("website_url")
    private String webSite;
    @SerializedName("twitter_screen_name")
    private String twitterScreenName;
    @SerializedName("drafted_by_player_id")
    private int draftedPlayerId;
    @SerializedName("shots_count")
    private int shotsCount;
    @SerializedName("following_count")
    private int followingCount;
    @SerializedName("created_at")
    private String createdAt;

    public Player(int id, String name, String location, int followersCount, int draftessCount, int likesCount, int likesReceivedCount, int commentsCount, int commentReceivedCount, int reboundsCount, int reboundsReceivedCount, String url, String avatarUrl, String username, String webSite, String twitterScreenName, int draftedPlayerId, int shotsCount, int followingCount, String createdAt) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.followersCount = followersCount;
        this.draftessCount = draftessCount;
        this.likesCount = likesCount;
        this.likesReceivedCount = likesReceivedCount;
        this.commentsCount = commentsCount;
        this.commentReceivedCount = commentReceivedCount;
        this.reboundsCount = reboundsCount;
        this.reboundsReceivedCount = reboundsReceivedCount;
        this.url = url;
        this.avatarUrl = avatarUrl;
        this.username = username;
        this.webSite = webSite;
        this.twitterScreenName = twitterScreenName;
        this.draftedPlayerId = draftedPlayerId;
        this.shotsCount = shotsCount;
        this.followingCount = followingCount;
        this.createdAt = createdAt;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public int getDraftessCount() {
        return draftessCount;
    }

    public void setDraftessCount(int draftessCount) {
        this.draftessCount = draftessCount;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public int getLikesReceivedCount() {
        return likesReceivedCount;
    }

    public void setLikesReceivedCount(int likesReceivedCount) {
        this.likesReceivedCount = likesReceivedCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public int getCommentReceivedCount() {
        return commentReceivedCount;
    }

    public void setCommentReceivedCount(int commentReceivedCount) {
        this.commentReceivedCount = commentReceivedCount;
    }

    public int getReboundsCount() {
        return reboundsCount;
    }

    public void setReboundsCount(int reboundsCount) {
        this.reboundsCount = reboundsCount;
    }

    public int getReboundsReceivedCount() {
        return reboundsReceivedCount;
    }

    public void setReboundsReceivedCount(int reboundsReceivedCount) {
        this.reboundsReceivedCount = reboundsReceivedCount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getTwitterScreenName() {
        return twitterScreenName;
    }

    public void setTwitterScreenName(String twitterScreenName) {
        this.twitterScreenName = twitterScreenName;
    }

    public int getDraftedPlayerId() {
        return draftedPlayerId;
    }

    public void setDraftedPlayerId(int draftedPlayerId) {
        this.draftedPlayerId = draftedPlayerId;
    }

    public int getShotsCount() {
        return shotsCount;
    }

    public void setShotsCount(int shotsCount) {
        this.shotsCount = shotsCount;
    }

    public int getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(int followingCount) {
        this.followingCount = followingCount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
