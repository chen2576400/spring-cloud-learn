package com.cn.FeginService;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @Author nchen
 * @Date 2021/5/26 16:29
 * @Version 1.0
 * @Description
 */
@Component
public class FeginUserServieImpl implements FeginUserServie{
    @Override
    public List findAllUser() {
        return Arrays.asList("自定义返回");
    }
}
