package com.github.biyanwen.json2sql.impl;

import com.github.biyanwen.json2sql.api.BeanProcessor;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: <br>
 *
 * @author byw
 * @create 2020/9/29
 */
public class DefaultBeanProcessor implements BeanProcessor<Map<String, Object>> {
    /**
     * @param map javabean类型
     * @return
     */
    @Override
    public Map<String, String> processor(Map<String, Object> map) {
        Map<String, String> result = new HashMap<>();
        for (Map.Entry<String, Object> stringObjectEntry : map.entrySet()) {
            result.put(stringObjectEntry.getKey(), stringObjectEntry.getValue().toString());
        }
        return result;
    }
}
