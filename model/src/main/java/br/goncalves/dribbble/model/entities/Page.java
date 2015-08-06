package br.goncalves.dribbble.model.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by halysongoncalves on 21/03/15.
 */
public class Page implements Serializable{
    private static final long serialVersionUID = 7173305676197730002L;
    @SerializedName("page")
    private String page;
    @SerializedName("per_page")
    private int perPage;
    @SerializedName("pages")
    private int pages;
    @SerializedName("total")
    private int total;
    @SerializedName("shots")
    private List<Shot> shotList;

    public Page(String page, int perPage, int pages, int total, List<Shot> shotList) {
        this.page = page;
        this.perPage = perPage;
        this.pages = pages;
        this.total = total;
        this.shotList = shotList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Shot> getShotList() {
        return shotList;
    }

    public void setShotList(List<Shot> shotList) {
        this.shotList = shotList;
    }
}
