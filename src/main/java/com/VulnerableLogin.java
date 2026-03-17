package com;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VulnerableLogin {
    private static final Logger logger = LogManager.getLogger(VulnerableLogin.class);

    public static void main(String[] args) {
        System.out.println("Sistema de Login Iniciado...");

        String userInput = args.length > 0 ? args[0] : "usuario_anonimo";

        logger.error("Falha de autenticacao para o usuario: " + userInput);
    }
}