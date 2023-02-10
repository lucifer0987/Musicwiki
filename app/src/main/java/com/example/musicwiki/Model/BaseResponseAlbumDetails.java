package com.example.musicwiki.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseResponseAlbumDetails {

    @SerializedName("album")
    @Expose
    private AlbumDetails album;

    public BaseResponseAlbumDetails() {
    }

    public BaseResponseAlbumDetails(AlbumDetails album) {
        super();
        this.album = album;
    }

    public AlbumDetails getAlbum() {
        return album;
    }

    public void setAlbum(AlbumDetails album) {
        this.album = album;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BaseResponseAlbumDetails.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("album");
        sb.append('=');
        sb.append(((this.album == null)?"<null>":this.album));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }


}
