package com.sqs.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Set;

/**
 * @Author : kaka
 * @Date: 2022-08-18 17:55
 */

public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String language = request.getParameter("l");
        //如果没有就是用默认的
        Locale locale = Locale.getDefault();
        //如果请求有参数
        if (!StringUtils.isEmpty(language)) {
            //zh_CN
            String[] split = language.split("_");
            //国家地区
            locale = new Locale(split[0], split[1]);

        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
