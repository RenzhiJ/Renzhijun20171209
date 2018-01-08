package rxjava.bwei.com.renzhijun20180108.entity;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Zhijun on 2018/1/8.
 */

public class RetrofitUtils {
    private static volatile RetrofitUtils instance;
    private final Retrofit retrofit;

    private RetrofitUtils(){
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Logger()).build();

        retrofit = new Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://120.27.23.105/")
                .build();
    }

   public static RetrofitUtils getInstance(){
        if (instance==null){
            synchronized (RetrofitUtils.class){
                if (instance==null){
                    instance=new RetrofitUtils();
                }
            }
        }
        return instance;
   }


    public ApiService getApiService(){
        ApiService apiService = retrofit.create(ApiService.class);
        return apiService;
    }

    class Logger implements Interceptor {//自定义拦截器
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request original = chain.request();
            HttpUrl url=original.url().newBuilder()//添加公共参数
                    .addQueryParameter("source","android")
                    .build();
            //添加到请求头
            Request request = original.newBuilder()
                    .url(url)
                    .build();
            return chain.proceed(request);
        }
    }
}
