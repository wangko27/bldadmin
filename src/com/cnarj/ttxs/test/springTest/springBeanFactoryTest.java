package com.cnarj.ttxs.test.springTest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: liz
 * Date: 13-7-29
 * Time: A.M.3:59
 * To change this template use File | Settings | File Templates.
 */
public class springBeanFactoryTest {
    @Test
    public void test(){
        ApplicationContext ac= new ClassPathXmlApplicationContext(new String[]{"applicationContext-admin-adv.xml"
                ,"applicationContext.xml"});
        Object object= ac.getBean("locationInfoServiceImpl");
        System.out.println("...");
    }
}
