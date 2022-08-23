package design_patterns._02_structural_patterns._12_proxy._03_java;

import design_patterns._02_structural_patterns._12_proxy._02_after.DefaultGameService;
import design_patterns._02_structural_patterns._12_proxy._02_after.GameService;

import java.lang.reflect.Proxy;

public class ProxyInJava {

    public static void main(String[] args) {
        ProxyInJava proxyInJava = new ProxyInJava();
        proxyInJava.dynamicProxy();
    }

    private void dynamicProxy() {
        design_patterns._02_structural_patterns._12_proxy._02_after.GameService gameServiceProxy = getGameServiceProxy(new DefaultGameService());
        gameServiceProxy.startGame();
    }

    private design_patterns._02_structural_patterns._12_proxy._02_after.GameService getGameServiceProxy(design_patterns._02_structural_patterns._12_proxy._02_after.GameService target) {
        return  (design_patterns._02_structural_patterns._12_proxy._02_after.GameService) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{GameService.class}, (proxy, method, args) -> {
                    System.out.println("O");
                    method.invoke(target, args);
                    System.out.println("ㅁ");
                    return null;
                });
    }
}
