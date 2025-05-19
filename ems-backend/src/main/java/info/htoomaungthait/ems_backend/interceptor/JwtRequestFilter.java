package info.htoomaungthait.ems_backend.interceptor;

import info.htoomaungthait.ems_backend.service.impl.UserDetailServiceImpl;
import info.htoomaungthait.ems_backend.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    private final UserDetailServiceImpl userDetailService;



    public JwtRequestFilter (JwtUtil jwtUtil, UserDetailServiceImpl userDetailService){
        this.jwtUtil = jwtUtil;
        this.userDetailService = userDetailService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String path = request.getRequestURI();

        System.out.println("URI path " + path);

        // Skip JWT validation for /auth/**
        if (path.startsWith("/auth/")) {
            filterChain.doFilter(request, response);
            return;
        }


        final String authHeader = request.getHeader("Authorization");

        String username = null;
        String jwt = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            jwt = authHeader.substring(7);
            username = jwtUtil.extractUsername(jwt);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            var userDetails = userDetailService.loadUserByUsername(username);
            if (jwtUtil.validateToken(jwt)) {
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
