package com.example.musicwiki.Network;

import com.example.musicwiki.Model.BaseResponseAlbumDetails;
import com.example.musicwiki.Model.BaseResponseTopAlbum;
import com.example.musicwiki.Model.BaseResponseTopArtist;
import com.example.musicwiki.Model.BaseResponseTopTags;
import com.example.musicwiki.Model.BaseResponseTopTracks;
import com.example.musicwiki.Model.TagDetails;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET(".")
    Call<BaseResponseTopTags> getTopTags(@Query("method") String method,
                                         @Query("api_key") String api_key,
                                         @Query("format") String format,
                                         @Query("num_res") Integer num_res,
                                         @Query("offset") Integer offset);

    @GET(".")
    Call<TagDetails> getTagDetails(@Query("method") String method,
                                   @Query("tag") String tag,
                                   @Query("api_key") String api_key,
                                   @Query("format") String format);

    @GET(".")
    Call<BaseResponseTopAlbum> getAlbumListByTag(@Query("method") String method,
                                   @Query("tag") String tag,
                                   @Query("api_key") String api_key,
                                   @Query("limit") Integer limit,
                                   @Query("format") String format);

    @GET(".")
    Call<BaseResponseTopArtist> getArtistListByTag(@Query("method") String method,
                                                   @Query("tag") String tag,
                                                   @Query("api_key") String api_key,
                                                   @Query("limit") Integer limit,
                                                   @Query("format") String format);

    @GET(".")
    Call<BaseResponseTopTracks> getTrackListByTag(@Query("method") String method,
                                                  @Query("tag") String tag,
                                                  @Query("api_key") String api_key,
                                                  @Query("limit") Integer limit,
                                                  @Query("format") String format);

    @GET(".")
    Call<BaseResponseAlbumDetails> getAlbumDetails(@Query("method") String method,
                                                   @Query("artist") String artist,
                                                   @Query("album") String album,
                                                   @Query("api_key") String api_key,
                                                   @Query("format") String format);

}
