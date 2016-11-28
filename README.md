# cloud-hashmap
## Instructions:
1. Provide PCF connection details in pom.xml properties section (target, org, space, username, password)
2. Run mvn cf:push
3. Login to PCF: cf login -a https://api.local.pcfdev.io --skip-ssl-validation
4. Register service broker: cf csb hashmap admin admin http://hashmap-service-broker.local.pcfdev.io
5. Enable access to service broker: cf enable-service-access hashmap
6. Create service instance: cf cs hashmap default hashmap-instance

PS. I was getting errors when creating service instance with maven cf create-services, so end up with manual creation
