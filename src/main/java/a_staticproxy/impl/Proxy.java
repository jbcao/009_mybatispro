package a_staticproxy.impl;

import a_staticproxy.Service;

/**
 * 功能
 *
 * @author caojianbang
 * @date 15.7.22 4:47 PM
 */
public class Proxy implements Service {
    public Service target;

    public Proxy(Service target) {
        this.target = target;
    }

    @Override
    public void sing() {
        System.out.println("预定时间");
        System.out.println("约定场地");
//        切记切记：业务功能必须由目标对象亲自实现
        target.sing();
        System.out.println("收款");
    }
}
