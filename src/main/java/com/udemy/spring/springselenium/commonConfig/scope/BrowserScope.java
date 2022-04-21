package com.udemy.spring.springselenium.commonConfig.scope;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.SimpleThreadScope;

import java.util.Objects;

public class BrowserScope extends SimpleThreadScope {

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object object = super.get(name, objectFactory);
        SessionId sessionId = ((RemoteWebDriver) object).getSessionId();
        if (Objects.isNull(sessionId)) {
            remove(name);
            object = get(name, objectFactory);
        }
        return object;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
    }
}
