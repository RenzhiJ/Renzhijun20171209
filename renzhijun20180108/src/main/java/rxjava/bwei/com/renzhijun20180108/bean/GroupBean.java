package rxjava.bwei.com.renzhijun20180108.bean;

/**
 * Created by Zhijun on 2018/1/8.
 */

public class GroupBean {
    private String sellerName;
    private boolean gropuCb;

    public GroupBean(String sellerName, boolean gropuCb) {
        this.sellerName = sellerName;
        this.gropuCb = gropuCb;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public boolean isGropuCb() {
        return gropuCb;
    }

    public void setGropuCb(boolean gropuCb) {
        this.gropuCb = gropuCb;
    }

    @Override
    public String toString() {
        return "GroupBean{" +
                "sellerName='" + sellerName + '\'' +
                ", gropuCb=" + gropuCb +
                '}';
    }
}
