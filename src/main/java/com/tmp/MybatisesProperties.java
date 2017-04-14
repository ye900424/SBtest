/*
 *    Copyright 2010-2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.tmp;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Configuration properties for Mybatis.
 *
 * @author Eddú Meléndez
 */
@Component
@Data @ToString(callSuper = true)
@ConfigurationProperties(
    prefix = MybatisProperties.MYBATIS_PREFIX
)
public class MybatisesProperties extends MybatisPT{
//    Map<String,List<MybatisProperties>> mybatises = null;
    public List<MybatisPT> list ;

    public List<MybatisPT> getList() {
        return list;
    }

    public void setList(List<MybatisPT> list) {
        this.list = list;
    }
}