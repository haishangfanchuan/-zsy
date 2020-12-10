package Design_patterns.proxy;

/**
 * @author zhangsy
 * @date 2020/9/10 15:15
 *
 * 静态代理
 *      1、在不改变原有功能的基础上，在代理对象中增强原有方法
 *      2、代理对象和目标对象必须继承同一个接口
 */
public class StaticProxyDemo {

    public static void main(String[] args) {
        StaticTeacherProxy proxy = new StaticTeacherProxy(new TeacherDao());
        proxy.teach();
    }
}

interface ITeacherDao{
   public void teach();
}

//目标对象
class TeacherDao implements  ITeacherDao{

    @Override
    public void teach() {
        System.out.println("teaching....");
    }
}

//代理对象
class StaticTeacherProxy implements ITeacherDao{

    private ITeacherDao teacherDao;

    public StaticTeacherProxy(ITeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public void teach() {
        System.out.println("增强方法。。。");
        teacherDao.teach();
        System.out.println("end...");
    }
}
