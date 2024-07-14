package com.neusoft.nepm.gateway.interceptors;

import com.neusoft.nepm.common.utils.JwtUtil;
import com.neusoft.nepm.gateway.config.ContextHolder;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class TokenFilter implements GlobalFilter, Ordered {

    private static final String HEADER_AUTH = "Authorization";
    private static final List<String> SAFE_URL_LIST = Arrays.asList(
            "/admins/getAdminsByCode",
            "/admins/adminsRegister",
            "/admins/getCaptcha",
            "/admins/checkCaptcha",
            "/captcha/getCaptcha",
            "/captcha/checkCaptcha",
            "/gridMember/gridMemberRegister",
            "/gridMember/getGridMemberByCodeByPass",
            "/supervisor/saveSupervisor",
            "/supervisor/getSupervisorByIdByPass",
            "/mq/mail",
            "/mq/sms"
//            "/aqiFeedback/**",
//            "/statistics/listProvinceItemTotalStatis",
//            "/supervisor/modifyInfo"
    );

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String url = exchange.getRequest().getURI().getPath();
        if (SAFE_URL_LIST.contains(url)) {
            return chain.filter(exchange);
        }

        String token = exchange.getRequest().getHeaders().getFirst(HEADER_AUTH);
        if (token == null || token.isEmpty()) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        try {
            Map<String, Object> map = JwtUtil.resolveToken(token);
            Long userId = Long.parseLong(map.get("userId").toString());
            ContextHolder.setUserId(userId);
        } catch (Exception e) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        return chain.filter(exchange).doFinally(signalType -> ContextHolder.shutdown());
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
