package com.launchcenter.data.webService;


import com.launchcenter.models.ServiceModel;
import com.launchcenter.models.company.CompanyModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by K. A. ANUSHKA MADUSANKA on 7/4/2018.
 */
public interface SocialMediaDataService {

    @DELETE("newsfeed/deletepost/")
    Observable<AccountResponse.Value> deletePost(@Query("postid") int postid);

    @FormUrlEncoded
    @POST("Comment/addComment")
    Observable<AccountResponse.Value> addComment(@Field("UserId")String  UserId,
                                                 @Field("PostId")int PostId,
                                                 @Field("Content")String Content);

    @FormUrlEncoded
    @DELETE("comment/deleteComment/")
    Observable<AccountResponse.Value> deleteComment(@Query("Commentid") int postid);

    @FormUrlEncoded
    @POST("likepost/deletelike")//change Url......?
    Observable<AccountResponse.Value> AddLike(@Field("UserId")String  UserId,
                                              @Field("PostId")int PostId);

    @FormUrlEncoded
    @DELETE("likepost/deletelike")
    Observable<AccountResponse.Value> deleteLike(@Query("PostsLikeId") int postid);

    @FormUrlEncoded
    @POST("NewsFeed/Addnewpost")
    Observable<AccountResponse.Value> AddNewPost(@Field("UserId")String  UserId,
                                                 @Field("Content")String Content,
                                                 @Field("imgurl")String imgurl);
}
