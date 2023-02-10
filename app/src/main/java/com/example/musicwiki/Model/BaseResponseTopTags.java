package com.example.musicwiki.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseResponseTopTags {

    @SerializedName("toptags")
    @Expose
    private TopTags toptags;

    public BaseResponseTopTags() {
    }

    public BaseResponseTopTags(TopTags toptags) {
        super();
        this.toptags = toptags;
    }

    public TopTags getToptags() {
        return toptags;
    }

    public void setToptags(TopTags toptags) {
        this.toptags = toptags;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BaseResponseTopTags.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("toptags");
        sb.append('=');
        sb.append(((this.toptags == null)?"<null>":this.toptags));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }


}
