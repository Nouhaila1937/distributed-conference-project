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
![img_3.png](img_3.png)

## Test discovery-service + gateway-service
![img_4.png](img_4.png)
![img_5.png](img_5.png)
![img_6.png](img_6.png)


## Test Feign coté conference
![img_7.png](img_7.png)


## Test de config-server
![img_8.png](img_8.png)
![img_9.png](img_9.png)