package rxjava.bwei.com.renzhijun20180108.entity;

import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rxjava.bwei.com.renzhijun20180108.bean.CartBean;
import rxjava.bwei.com.renzhijun20180108.bean.GoodsShowBean;
import rxjava.bwei.com.renzhijun20180108.bean.MessageBean;

/**
 * Created by Zhijun on 2018/1/8.
 */

public interface ApiService {//请求接口
    @GET("product/getProductDetail")//商品详情
    Flowable<MessageBean<GoodsShowBean>> getNews(@QueryMap Map<String,String> map);

    @GET("product/getCarts")//查询购物车
    Flowable<MessageBean<List<CartBean>>> getCart(@QueryMap Map<String,String> map);

    @GET("product/deleteCart")//删除购物车
    Flowable<MessageBean<List<CartBean>>> getDel(@QueryMap Map<String,String> map);

    @GET("product/addCart")//添加购物车
    Flowable<MessageBean<List<CartBean>>> getAdd(@QueryMap Map<String,String> map);
}
