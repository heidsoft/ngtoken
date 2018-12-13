package cn.ngtoken.logs.mdc;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.MDC;

/**
 * @author heidsoft
 */
@Component
public class UniqueTrackingNumberFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
                    throws ServletException, IOException {
        // presumably this is extracted from the request (or defaulted, if not supplied)
        int uniqueTrackingNumber = 0;
        MDC.put("uniqueTrackingNumber", String.valueOf(uniqueTrackingNumber));
    }
}