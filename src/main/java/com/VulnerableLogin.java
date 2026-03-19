package com;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VulnerableLogin {
    private static final Logger logger = LogManager.getLogger(VulnerableLogin.class);

    private VulnerableLogin() {
    }

    public static void logFailedAuthentication(String userInput) {
        String normalizedUser = (userInput == null || userInput.isBlank()) ? "usuario_anonimo" : userInput;
        logger.error("Falha de autenticacao para o usuario: " + normalizedUser);
    }
}