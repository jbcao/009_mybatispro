package b_jdkproxy.impl;

import b_jdkproxy.Service;

/**
 * 功能:目标对象 周润发
 *
 * @author caojianbang
 * @date 17.7.22 5:50 PM
 */
public class SuperStarZhou implements Service {
    @Override
    public String show(int age) {
        System.out.println("周润发在演唱"+age);
        return "zhou";
    }

    @Override
    public void sing() {
        System.out.println("我是后润发，我来唱歌");
    }
}
