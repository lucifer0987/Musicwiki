package com.example.musicwiki.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopTagsAttr {

    @SerializedName("offset")
    @Expose
    private int offset;
    @SerializedName("num_res")
    @Expose
    private int numRes;
    @SerializedName("total")
    @Expose
    private int total;

    public TopTagsAttr() {
    }

    public TopTagsAttr(int offset, int numRes, int total) {
        super();
        this.offset = offset;
        this.numRes = numRes;
        this.total = total;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getNumRes() {
        return numRes;
    }

    public void setNumRes(int numRes) {
        this.numRes = numRes;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TopTagsAttr.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("offset");
        sb.append('=');
        sb.append(this.offset);
        sb.append(',');
        sb.append("numRes");
        sb.append('=');
        sb.append(this.numRes);
        sb.append(',');
        sb.append("total");
        sb.append('=');
        sb.append(this.total);
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }


}
