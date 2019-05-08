package demo.design.responsibility.inf;

import demo.design.responsibility.imp.FilterChain;
import demo.design.responsibility.imp.Request;
import demo.design.responsibility.imp.Response;

public interface Filter {
    void doFilter(Request request, Response response, FilterChain chain);
}
