package com.udemy.spring.springselenium.props;

import com.udemy.spring.springselenium.SpringBaseTestNG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class PropsTest extends SpringBaseTestNG {

    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    public void propTest() throws IOException {
        Properties properties = PropertiesLoaderUtils.loadProperties(resourceLoader.getResource("data/my.properties"));
        System.out.println(properties);
    }
}
