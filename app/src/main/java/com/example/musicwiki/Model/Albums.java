package com.example.musicwiki.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Albums {

    @SerializedName("album")
    @Expose
    private List<Album> album;
    @SerializedName("@attr")
    @Expose
    private AlbumAttributes attr;

    public Albums() {
    }

    public Albums(List<Album> album, AlbumAttributes attr) {
        super();
        this.album = album;
        this.attr = attr;
    }

    public List<Album> getAlbum() {
        return album;
    }

    public void setAlbum(List<Album> album) {
        this.album = album;
    }

    public AlbumAttributes getAttr() {
        return attr;
    }

    public void setAttr(AlbumAttributes attr) {
        this.attr = attr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Albums.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("album");
        sb.append('=');
        sb.append(((this.album == null)?"<null>":this.album));
        sb.append(',');
        sb.append("attr");
        sb.append('=');
        sb.append(((this.attr == null)?"<null>":this.attr));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
