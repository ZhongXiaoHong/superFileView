package com.silang.superfileview;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by 12457 on 2017/8/21.
 */

public interface LoadFileApi {

    @GET
    Call<ResponseBody> loadPdfFile(@Url String fileUrl);

}
