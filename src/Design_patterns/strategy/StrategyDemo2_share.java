package Design_patterns.strategy;

import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zhangsy
 * @date 2020/9/11 16:23
 */
public class StrategyDemo2_share {
    public static void main(String[] args) {

        new Share(new ShareToWX()).share();

    }
}

//策略接口，所有策略需要实现这个接口
interface  ShareStrategy{
    void share();
}

//分享到QQ
class ShareToQQ implements ShareStrategy{

    @Override
    public void share() {
        System.out.println("分享到了QQ...");
    }
}

//分享到微信
class ShareToWX implements ShareStrategy{

    @Override
    public void share() {
        System.out.println("分享到了微信...");
    }
}

//客户端调用分享接口
class Share{
    //内部聚合分享策略
    public ShareStrategy shareStrategy;

    public Share(ShareStrategy shareStrategy) {
        this.shareStrategy = shareStrategy;
    }

    public void share(){
        if(shareStrategy!=null){
            shareStrategy.share();
        }else {
            System.out.println("error...");
        }
    }
}

class Test{
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        
    }
}
