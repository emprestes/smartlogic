smartlogic
==========

Projeto para sistema de logística.

Dependência entre mádulos:

webservice-jax-ws >> service-api
webservice-jax-ws >> service-impl
webservice-jax-ws >> repository-spring-data-jpa
webservice-jax-ws >> core

service-impl >> core
service-impl >> service-api

service-api >> core

repository-spring-data-jpa >> core

Frameworks utilizados:

Spring (DI)
Spring Data (Persistência)
HSQLDB (Banco de dados)
JAX-WS (Webservices)

Para rodar os webservices:

1. cd <raiz>
2. mvn clean install
3. cd webservice-jax-ws
4. mvn jetty:run

Para rodar o client:

1. cd <raiz>
2. mvn clean install
3. cd client-ws
4. mvn exec:java
