package com.example.musicwiki.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Tracks {

    @SerializedName("track")
    @Expose
    private List<Track> track;
    @SerializedName("@attr")
    @Expose
    private AlbumAttributes attr;

    public Tracks() {
    }

    public Tracks(List<Track> track, AlbumAttributes attr) {
        super();
        this.track = track;
        this.attr = attr;
    }

    public List<Track> getTrack() {
        return track;
    }

    public void setTrack(List<Track> track) {
        this.track = track;
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
        sb.append(Tracks.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("track");
        sb.append('=');
        sb.append(((this.track == null)?"<null>":this.track));
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
