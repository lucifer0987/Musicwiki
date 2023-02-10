package com.example.musicwiki.Model;

import android.media.Image;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class AlbumDetails {

    @SerializedName("artist")
    @Expose
    private String artist;
    @SerializedName("mbid")
    @Expose
    private String mbid;
    @SerializedName("tags")
    @Expose
    private TopTags tags;
    @SerializedName("playcount")
    @Expose
    private String playcount;
    @SerializedName("image")
    @Expose
    private List<AlbumImage> image;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("listeners")
    @Expose
    private String listeners;
    @SerializedName("wiki")
    @Expose
    private Wiki wiki;

    public AlbumDetails() {
    }

    public AlbumDetails(String artist, String mbid, TopTags tags, String playcount, List<AlbumImage> image, String url, String name, String listeners, Wiki wiki) {
        super();
        this.artist = artist;
        this.mbid = mbid;
        this.tags = tags;
        this.playcount = playcount;
        this.image = image;
        this.url = url;
        this.name = name;
        this.listeners = listeners;
        this.wiki = wiki;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public TopTags getTags() {
        return tags;
    }

    public void setTags(TopTags tags) {
        this.tags = tags;
    }

    public String getPlaycount() {
        return playcount;
    }

    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    public List<AlbumImage> getImage() {
        return image;
    }

    public void setImage(List<AlbumImage> image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public Wiki getWiki() {
        return wiki;
    }

    public void setWiki(Wiki wiki) {
        this.wiki = wiki;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AlbumDetails.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("artist");
        sb.append('=');
        sb.append(((this.artist == null)?"<null>":this.artist));
        sb.append(',');
        sb.append("mbid");
        sb.append('=');
        sb.append(((this.mbid == null)?"<null>":this.mbid));
        sb.append(',');
        sb.append("tags");
        sb.append('=');
        sb.append(((this.tags == null)?"<null>":this.tags));
        sb.append(',');
        sb.append("playcount");
        sb.append('=');
        sb.append(((this.playcount == null)?"<null>":this.playcount));
        sb.append(',');
        sb.append("image");
        sb.append('=');
        sb.append(((this.image == null)?"<null>":this.image));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("listeners");
        sb.append('=');
        sb.append(((this.listeners == null)?"<null>":this.listeners));
        sb.append(',');
        sb.append("wiki");
        sb.append('=');
        sb.append(((this.wiki == null)?"<null>":this.wiki));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }


}
