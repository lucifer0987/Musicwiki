package com.example.musicwiki.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseResponseTopArtist {

    @SerializedName("topartists")
    @Expose
    private Topartists topartists;

    public BaseResponseTopArtist() {
    }

    public BaseResponseTopArtist(Topartists topartists) {
        super();
        this.topartists = topartists;
    }

    public Topartists getTopartists() {
        return topartists;
    }

    public void setTopartists(Topartists topartists) {
        this.topartists = topartists;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BaseResponseTopArtist.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("topartists");
        sb.append('=');
        sb.append(((this.topartists == null)?"<null>":this.topartists));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }


}
