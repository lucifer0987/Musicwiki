package com.example.musicwiki.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TopTags {

    @SerializedName("@attr")
    @Expose
    private TopTagsAttr attr;
    @SerializedName("tag")
    @Expose
    private List<Tags> tag;

    public TopTags() {
    }

    public TopTags(TopTagsAttr attr, List<Tags> tag) {
        super();
        this.attr = attr;
        this.tag = tag;
    }

    public TopTagsAttr getAttr() {
        return attr;
    }

    public void setAttr(TopTagsAttr attr) {
        this.attr = attr;
    }

    public List<Tags> getTag() {
        return tag;
    }

    public void setTag(List<Tags> tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TopTags.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("attr");
        sb.append('=');
        sb.append(((this.attr == null)?"<null>":this.attr));
        sb.append(',');
        sb.append("tag");
        sb.append('=');
        sb.append(((this.tag == null)?"<null>":this.tag));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }


}
