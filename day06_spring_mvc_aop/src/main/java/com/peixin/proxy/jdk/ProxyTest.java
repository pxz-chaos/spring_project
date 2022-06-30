package com.peixin.proxy.jdk;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    /*
    public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h){

    }
     */

    public static void main(String[] args) {

        //创建目标对象
        final Target target = new Target();
        //获得增强对象
        final Advice enhance = new Advice();

        //返回值 就是动态生成的代理对象
        //对象target和proxy相对于兄弟关系，所以强转需要向上转，也就是他们的爹TargetInterface
        com.peixin.proxy.jdk.TargetInterface proxy = (com.peixin.proxy.jdk.TargetInterface) Proxy.newProxyInstance(
                target.getClass().getClassLoader(), //目标对象类加载器
                target.getClass().getInterfaces(),//目标对象相同的接口字节码对象数组
                //上面两行都是固定写法

                //调用代理对象的任何方法 实质执行的都是invoke方法
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //前置增强
                        enhance.before();

                        //执行目标方法
                        Object obj = method.invoke(target, args);

                        //后置增强
                        enhance.after();

                        return obj;
                    }
                }
        );
        proxy.save();
    }
}
