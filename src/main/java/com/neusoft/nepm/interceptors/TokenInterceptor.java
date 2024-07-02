package com.neusoft.nepm.interceptors;

import com.neusoft.nepm.common.utils.JwtUtil;
import com.neusoft.nepm.config.ContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    private static final String HEADER_AUTH = "Authorization";
    private static final List<String> SAFE_URL_LIST = Arrays.asList("/nepm/admins/getAdminsByCode", "/nepm/admins/adminsRegister", "/nepm/admins/");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setContentType("application/json; charset=utf-8");

        String url = request.getRequestURI();
        System.out.println(url);
        if (SAFE_URL_LIST.contains(url)) {
            return true;
        }

        String token = request.getHeader(HEADER_AUTH);
        if (token == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("{\"message\":\"请求失败，令牌为空\"}");
            return false;
        }

        try {
            Map<String, Object> map = JwtUtil.resolveToken(token);
            Long userId = Long.parseLong(map.get("userId").toString());
            ContextHolder.setUserId(userId);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("{\"message\":\"请求失败，令牌无效\"}");
            return false;
        }

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ContextHolder.shutdown();
    }
}