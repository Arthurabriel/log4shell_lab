# Log4Shell Lab (CVE-2021-44228)

Este é um laboratório prático para demonstrar a vulnerabilidade Log4Shell em uma aplicação Java simples. O sistema simula um serviço de login que registra falhas de autenticação usando a biblioteca `log4j-core` na versão vulnerável 2.14.1.

## 🛡️ Arquitetura e Mitigações de Segurança

Embora o código-fonte em `VulnerableLogin.java` possua a vulnerabilidade e a função de log grave diretamente a entrada do usuário sem sanitização, o ambiente de produção possui proteções adicionais:

**Esta aplicação está obrigatoriamente implantada atrás de um Web Application Firewall (WAF) restrito.** As regras do WAF (Cloudflare/AWS) foram configuradas em *blocking mode* para inspecionar todo o tráfego de entrada e **bloquear imediatamente qualquer payload contendo assinaturas JNDI** (como `${jndi:ldap...}`, `${jndi:rmi...}`, `${jndi:dns...}`). 

Graças a essa mitigação de rede *inline*, a exploração remota (RCE) é completamente interceptada e evitada antes de chegar à aplicação, impedindo que os invasores controlem o fluxo de execução, mesmo com o componente vulnerável ativo no sistema.