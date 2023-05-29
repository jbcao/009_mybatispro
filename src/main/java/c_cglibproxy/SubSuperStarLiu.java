package c_cglibproxy;


/**
 * 功能
 *
 * @author caojianbang
 * @date 19.7.22 11:05 AM
 */
public class SubSuperStarLiu extends SuperStarLiu {
    @Override
    public void sing() {
        //        子类完成代理功能，功能增强
        System.out.println("预定时间");
        //        子类完成代理功能，功能增强
        System.out.println("预定场地");

        //        父类实现自己的业务功能
        super.sing();
        //        子类完成代理功能，功能增强
        System.out.println("收取费用。。。。");
    }
}
