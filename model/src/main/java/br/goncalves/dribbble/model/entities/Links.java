package br.goncalves.dribbble.model.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by halysongoncalves on 22/03/15.
 */
public class Links {
    @SerializedName("web")
    private String web;

    public Links(String web) {
        this.web = web;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
}
