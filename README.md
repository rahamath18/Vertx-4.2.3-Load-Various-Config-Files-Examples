## Example using Vertx 4.2.3 to Load Various Config Files such as json, properties, macros, hocon, Yaml, Git, Kubernetes Configmap, Redis, Zookeeper, Consul, Spring Config Server, Vault, and etc...


### Used technology stack in this example

	1  Vertx 4.2.3
	2  Vertx Config 4.2.3
	3  Vertx Config Hocon 4.2.3
	4  Vertx Config Yaml 4.2.3
	5  Vertx Config Git 4.2.3
	6  Vertx Config Kubernetes Configmap 4.2.3
	7  Vertx Config Redis 4.2.3
	8  Vertx Config Zookeeper 4.2.3
	9  Vertx Config Consul 4.2.3
	10 Vertx Config Spring Config Server 4.2.3
	11 Vertx Config Vault 4.2.3  
	12 Vertx 4.2.3 Hazel Cast
	13 OpenJDK 17
	14 Apache Maven 3.8.3
	

### Maven initial setup

	$ mvn dependency:tree
	$ mvn eclipse:eclipse


### Build application jar or war

	$ mvn clean package
		

### Run the following java programes

	$ LoadVariousConfigFiles.java

### The supported file formats

	JSON
	Properties
	Hocon (The Hocon configuration format supports includes, json, properties, macros…)
	Yaml
	Git
	Kubernetes Config Map
	Redis
	Zookeeper
	Consul
	Spring Config Server
	Vault