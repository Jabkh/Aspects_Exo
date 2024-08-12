package org.example.aspects_exo.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class RequestLoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialisation du filtre si nécessaire
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        // Capturer les détails de la requête
        String uri = httpRequest.getRequestURI();
        String method = httpRequest.getMethod();
        String clientIp = request.getRemoteAddr();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        // Journaliser les détails de la requête
        System.out.println("Requête reçue :");
        System.out.println("URI : " + uri);
        System.out.println("Méthode : " + method);
        System.out.println("Timestamp : " + timestamp);
        System.out.println("Adresse IP du client : " + clientIp);

        // Continuer la chaîne de filtres
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Nettoyage du filtre si nécessaire
    }
}
