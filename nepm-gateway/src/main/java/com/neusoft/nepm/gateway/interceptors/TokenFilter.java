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
import java.util.regex.Pattern;

@Component
public class TokenFilter implements GlobalFilter, Ordered {

    private static final String HEADER_AUTH = "Authorization";
    private static final List<Pattern> SAFE_URL_PATTERNS = Arrays.asList(
            // 匹配所有路径
            Pattern.compile(".*"),
            Pattern.compile("/admins/login/\\w+/\\w+"),
            Pattern.compile("/admins/adminsRegister"),
            Pattern.compile("/admins/getCaptcha"),
            Pattern.compile("/admins/checkCaptcha"),
            Pattern.compile("/captcha/getCaptcha"),
            Pattern.compile("/captcha/checkCaptcha"),
            Pattern.compile("/gridMember/gridMemberRegister"),
            Pattern.compile("/gridMember/getGridMemberByCodeByPass"),
            Pattern.compile("/supervisor/saveSupervisor"),
            Pattern.compile("/supervisor/getSupervisorByIdByPass"),
            Pattern.compile("/mq/mail"),
            Pattern.compile("/mq/sms"),
            Pattern.compile("/statistics/totalCount"),
            Pattern.compile("/statistics/statisticsDistribution"),
            Pattern.compile("/statistics/aqiLevelByMonth")
    );

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String url = exchange.getRequest().getURI().getPath();
        if (isSafeUrl(url)) {
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

    private boolean isSafeUrl(String url) {
        return SAFE_URL_PATTERNS.stream().anyMatch(pattern -> pattern.matcher(url).matches());
    }
}