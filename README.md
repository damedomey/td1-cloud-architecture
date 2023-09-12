# TD1 cloud architecture

The goal of this project is to deploy a king of solution as PaaS, CaaS and FaaS in clever cloud.
The full description of project is available in **subject.pdf**

Releases will be created for each version

## v1 without database
The version v1 without database is available on branch **v1-stateless**. 
### Requirements
Your must set a minimal configuration in clever cloud. Set a environment variables :

- CC_JAVA_VERSION=17
- MAVEN_DEPLOY_GOAL=spring-boot:run
