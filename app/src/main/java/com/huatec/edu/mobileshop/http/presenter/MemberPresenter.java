package com.huatec.edu.mobileshop.http.presenter;

import com.huatec.edu.mobileshop.http.HttpMethods;
import com.huatec.edu.mobileshop.http.entity.MemberEnity;

import rx.Observable;
import rx.Subscriber;

public class MemberPresenter extends HttpMethods {
    //用户注册
    public static void register(Subscriber<MemberEnity>subscriber, String username, String email, String password){
        Observable observable = memberService.register(username,password,email)
                .map(new HttpResultFunc<MemberEnity>());
        toSubscribe(observable,subscriber);
    }

    //用户登录
    public static void login(Subscriber<MemberEnity>subscriber,String username,String password){
        Observable observable = memberService.login2(username,password)
                .map(new HttpResultFunc<MemberEnity>());
        toSubscribe(observable,subscriber);
    }

    //修改密码
    public static void changePassword(Subscriber subscriber,String memberId,String old_pwd,String new_pwd){
        Observable observable = memberService.changePassword(memberId,old_pwd,new_pwd);
        toSubscribe(observable,subscriber);
    }
}
