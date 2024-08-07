package com.neusoft.nepm.gateway.config;

public class ContextHolder {
    public static ThreadLocal<Long> context = new ThreadLocal<>();

    public static void setUserId(Long userId) {
        context.set(userId);
    }

    public static Long getUserId() {
        return context.get();
    }

    public static void shutdown() {
        context.remove();
    }
}

