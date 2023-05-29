package b_jdkproxy.impl;

import b_jdkproxy.Service;

/**
 * 功能:目标对象刘德华
 *
 * @author caojianbang
 * @date 17.7.22 5:47 PM
 */
public class SuperStarLiu implements Service {
    @Override
    public String show(int age) {
        System.out.println("刘德华在演唱"+age);
        return "liu";
    }

    @Override
    public void sing() {
        System.out.println("我是刘德华，我唱歌");

    }
    public void one() {
        System.out.println("非接口中的方法不可以被代理");

    }

}
