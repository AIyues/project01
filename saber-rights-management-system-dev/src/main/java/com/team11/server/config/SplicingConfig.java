package com.team11.server.config;

import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 将list拼接成字符串
 */
@Configuration
public class SplicingConfig {
    public static String Splicing(List list) {
        String resultString = "";
        if (list == null && list.size() == 0) {
            System.out.println("list中的内容为空！");
        } else {
            String[] strArrStrings = new String[list.size()];
            for (int i = 0; i <= list.size() - 1; i++) {
                strArrStrings[i] = (String) list.get(i);
            }
            for (int j = 0; j <= strArrStrings.length - 1; j++) {
                if (j < strArrStrings.length - 1) {
                    resultString += strArrStrings[j] + ",";
                } else {
                    resultString += strArrStrings[j];
                }
            }

        }
        return resultString;
    }
}
