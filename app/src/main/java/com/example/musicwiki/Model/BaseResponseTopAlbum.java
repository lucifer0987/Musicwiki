package com.example.musicwiki.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseResponseTopAlbum {

    @SerializedName("albums")
    @Expose
    private Albums albums;

    public BaseResponseTopAlbum() {
    }

    public BaseResponseTopAlbum(Albums albums) {
        super();
        this.albums = albums;
    }

    public Albums getAlbums() {
        return albums;
    }

    public void setAlbums(Albums albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BaseResponseTopAlbum.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("albums");
        sb.append('=');
        sb.append(((this.albums == null)?"<null>":this.albums));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
