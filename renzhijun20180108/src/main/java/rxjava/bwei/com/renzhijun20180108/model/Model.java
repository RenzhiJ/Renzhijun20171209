package rxjava.bwei.com.renzhijun20180108.model;

import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;
import rxjava.bwei.com.renzhijun20180108.bean.CartBean;
import rxjava.bwei.com.renzhijun20180108.bean.GoodsShowBean;
import rxjava.bwei.com.renzhijun20180108.bean.MessageBean;
import rxjava.bwei.com.renzhijun20180108.entity.RetrofitUtils;
import rxjava.bwei.com.renzhijun20180108.presenter.NewsPresenter;

/**
 * Created by Zhijun on 2018/1/8.
 */

public class Model implements IModel {
    private NewsPresenter presenter;
    public Model(NewsPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getData(Map<String, String> map, String tag) {
        if(tag.equals("cart")){
            Flowable<MessageBean<List<CartBean>>> flowable = RetrofitUtils.getInstance().getApiService().getCart(map);
            presenter.get2(flowable,tag);
        }else if(tag.equals("goods")){
            Flowable<MessageBean<GoodsShowBean>> flowable = RetrofitUtils.getInstance().getApiService().getNews(map);
            presenter.get(flowable,tag);
        }else if(tag.equals("del")){
            Flowable<MessageBean<List<CartBean>>> flowable = RetrofitUtils.getInstance().getApiService().getDel(map);
            presenter.get3(flowable,tag);
        }else if(tag.equals("add")){
            Flowable<MessageBean<List<CartBean>>> flowable = RetrofitUtils.getInstance().getApiService().getAdd(map);
            presenter.get4(flowable,tag);
        }

    }
}
