package com.bread.study.gateway.filter;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 登录拦截器
 */
@Component
@Slf4j
public class LoginFilter implements GlobalFilter {

    //filter：这是过滤器的核心方法。它接收两个参数：
    //ServerWebExchange exchange：封装了 HTTP 请求和响应的对象，代表当前正在处理的请求。
    //GatewayFilterChain chain：过滤链，表示多个过滤器可以依次处理请求，chain.filter(exchange) 会将请求传递给下一个过滤器。
    @Override
    @SneakyThrows
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        ServerHttpRequest.Builder mutate = request.mutate();
        String url = request.getURI().getPath();
        log.info("LoginFilter.filter.url:{}", url);
        if (url.equals("/user/doLogin")) {
            return chain.filter(exchange);
        }
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        log.info("LoginFilter.filter.url:{}", new Gson().toJson(tokenInfo));
        String loginId = (String) tokenInfo.getLoginId();
        //将提取到的 loginId 添加到请求头中，使用 mutate.header("loginId", loginId) 来修改请求头，
        // 以便下游服务可以获取到当前登录用户的信息。
        mutate.header("loginId", loginId);
        //通过 exchange.mutate().request(mutate.build()).build() 构建一个新的 ServerWebExchange，它包含了
        // 修改后的请求（带有 loginId 的请求头），然后通过 chain.filter 将这个修改后的请求传递给下一个过滤器
        return chain.filter(exchange.mutate().request(mutate.build()).build());
    }

}
