package com.amy.demo;


import com.amy.driver.beans.ConfigEntity;
import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class DemoYaml {
    public static void main(String[] args) {
        System.out.println(Configure.getConfig().getChrome().getOptions().get("acceptInsecureCerts"));

/*        InputStream is = DemoYaml.class.getClassLoader().getResourceAsStream("demo.yml");
        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader(is, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        YamlReader yamlReader = new YamlReader(isr);
        while (true){
            MyBean bean = null;
            try {
                bean = yamlReader.read(MyBean.class);
            } catch (YamlException e) {
                e.printStackTrace();
            }
            if (bean == null) break;
            System.out.println(bean);
        }*/


/*        try {
            @SuppressWarnings("uncheck")
            Map<String, ?> map = (Map<String, ?>) yamlReader.read();
            for(Map.Entry<String, ?> entry : map.entrySet()){
                System.out.println(entry.getKey());
                System.out.println(entry.getValue());

            }

        } catch (YamlException e) {
            e.printStackTrace();
        }*/

    }
}
