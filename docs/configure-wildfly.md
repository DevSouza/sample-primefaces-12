### Add PostgreSQL driver
In [WILDFLY_HOME]/modules create the directory: ```/org/postgresql/main``` and copy the jdbc file.

#### Create the module
In ```/org/postgresql/main``` create the module.xml file
```xml
<?xml version='1.0' encoding='UTF-8'?>
<module xmlns="urn:jboss:module:1.1" name="org.postgresql">
  <resources>
    <!--the name of your driver --> 
    <resource-root path="postgresql-42.6.0.jar"/>
  </resources>

  <dependencies>
    <module name="javax.api"/>
    <module name="javax.transaction.api"/>
  </dependencies>
</module>
```
#### Add the datasource
In our case we use the standalone instance of WildFly.
- Open ```[WILDFLY_HOME]/standalone/configuration/standalone.xml```
- Locate the existing datasources, probably you have an instance of H2 already configured:
  ```xml
  <subsystem xmlns="urn:jboss:domain:datasources:6.0"> 
    <datasources> 
  ```
- Add in the section ```<datasources><drivers>```:
```xml
<driver name="postgresql" module="org.postgresql"> 
  <!-- 1. choose your connection driver --> 
  <driver-class>org.postgresql.Driver</driver-class> 
</driver> 
```
