package com.common.SessionShare;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * Created by caoyang on 2017/5/23.
 */
public class SessionInitializer extends AbstractHttpSessionApplicationInitializer {
    public SessionInitializer() {
        super(SessionConfig.class);
    }
}
