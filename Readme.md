# Architecture Technique du Projet – Gestion de Conférences

## 1. Vue globale

L'application est basée sur une **architecture micro-services** avec les composants suivants :  

Angular Frontend
|
v
Gateway Service (Spring Cloud Gateway)
|
+----------------+
|                |
Discovery Service    Config Service
(Eureka Server)      (Spring Cloud Config)
|
+----------------------------+
|                            |
Keynote Service                  Conference Service
(REST API, Swagger, Resilience4J)  (REST API, Reviews, Feign Client)
|
Database (H2/PostgreSQL)


## Test conference-service 
![img.png](img.png)
![img_1.png](img_1.png)

## Test keynote-service
![img_2.png](img_2.png)




