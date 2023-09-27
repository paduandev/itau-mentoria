package br.gama.jwtexample.configuration;

public class SecurityConstraints {
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final int EXPIRATION_TIME_MINUTES = 1;
    public static final String HEADER_STRING = "Authorization";
}
