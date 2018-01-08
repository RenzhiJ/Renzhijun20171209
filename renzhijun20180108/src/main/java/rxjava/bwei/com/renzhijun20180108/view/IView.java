package rxjava.bwei.com.renzhijun20180108.view;

/**
 * Created by Zhijun on 2018/1/8.
 */

public interface IView {//成功失败接口
    void OnSuccess(Object o,String tag);
    void OnFailed(Exception e,String tag);
}
