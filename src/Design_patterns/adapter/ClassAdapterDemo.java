package Design_patterns.adapter;

/**
 * @author zhangsy
 * @date 2020/9/10 19:44
 *
 * 类适配器
 */
public class ClassAdapterDemo {
    public static void main(String[] args) {

        Phone phone = new Phone();
        phone.charging(new VoltageAdapter().outPut5v());
    }
}

class Voltage220V{
    public int outPut220V(){
        System.out.println("输入220V电压");
        return 220;
    }
}

interface Voltage5V{
    int outPut5v();
}

class VoltageAdapter extends Voltage220V implements Voltage5V {

    @Override
    public int outPut5v() {
        int i = super.outPut220V();
        int dst = i / 40;
        System.out.println("输出电压" + dst);
        return dst;
    }
}

class Phone{


    public void charging(int voltage){
        if(voltage > 5){
            System.out.println("boom~~");
            return;
        }
        System.out.println("phone is charging~");
    }
}
