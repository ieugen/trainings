Training-uri
============

### Target Audience:
  - Java Application Programmers

### Prerequisits:

Experience with developing Java applications.

Attendees should bring a workstation/notebook with: 
  - Apache Maven 3.0.5+
  - OracleJDK/OpenJDK 7
  - a prefered IDE (Eclipse, Netbeans, Intelij Idea, etc.) - I'll be using Idea and the command line
  - whitboard and markers

Access Maven Central Repository is mandatory (access to internet is ideal).
I will provide: presentation slides with code project examples (with Maven). 


## Dependency Injection with SpringFramework

Duration: 8h, 50% lecture, 50% hands on lab

Objectives: 

 - Know what is dependency injection and how to use dependency injection with Spring and other popular DI framework. 
 - Use the Spring Framework to develop Java applications
 - Use dependency injection to set up and configure applications
 - Test Spring-based applications
 - Set up Spring configuration using XML, annotations, and Java configuration
 - Use aspect-oriented programming (AOP) to add behavior to objects

1. Introduction to Dependency Injection with Spring
================================================
 - Setup
 [done] - What is Dependency injection
 [done]- Popular DI implementations: Spring, Guice, CDI, Blueprint
 [done]- XML configuration and the Spring application context
 [done]- Best practices: constructor versus setter injection
 [done]- Working with multiple configuration files
 [done]- Bean scope and factory beans

### Advanced XML Dependency Injection
 [done]- Most popular namespaces
 [done]- Best practices when working with namespaces
 [done]- Externalizing constant values into properties files
 [done]- Working with a high number of configuration files
 [done]- Bean definition inheritance

### Annotation-Based Dependency Injection
 [done]- Autowiring and component scanning
 [done]- Component scanning: how to do it right
 [done]- XML versus annotations: when to use what
 [done]- Life cycle annotations: @PostConstruct and @PreDestroy
 [done]- Stereotypes and meta-annotations

### Java-Based Dependency Injection
 [done]- @Configuration and @Bean annotations
 [done]- Where is the magic? Inheritance-based proxies
 [done]- Equivalent to XML namespaces: @Enable annotations
 [done]- When to use Java configuration

### Bean Life Cycle: How Does Spring Work Internally?
 [done]- The init phase: available interceptors
 [done]- The init phase: what is the difference between XML, annotations, and Java configuration?
 [done]- What happens during bean post processing
 [done]- Use and destruction phases

### Testing a Spring-Based Application
 - Spring and test-driven development
 - @ContextConfiguration and @RunWith annotations
 - Application context caching and the @DirtiesContext annotation
 [done]- Environment abstraction and bean definition profiles

### Aspect-Oriented Programming
 - What problems does AOP solve?
 - Differences between Spring AOP and AspectJ
 - Defining pointcut expressions
 - Implementing an advice: @Around, @Before, @After, and so on

### Custom namespaces in Spring/Blueprint
 - what are custom XML namespaces and how to use them

2. Data access and persistence
==============================

Duration: 8h, 50% lecture, 50% hands on lab

Objectives: 
 - Understand data persistence 
 - Understand JDBC standard and it's role
 - Use JPA to map database tables to object entities
 - Understad how transactions and what are the different types of transactions management strategies available
 - Use JPA/Hibernate and JDBC with Spring to access relational databases
 - Use Spring support for transactions
 - Use advanced frameworks for data access: Spring Data and Apache Deltaspike

### Introduction to data persistence 
 - What is data persistence
 - Serialization/Deserialization
 - Objectual/Relational impedance
 - What are the persistence technologies available to Java developers: JDBC, JPA/Hibernate, MyBatis, JOOQ, JCR, NoSQL

### Data Access and JDBC
 - How Spring integrates with existing data access technologies
 - DataAccessException hierarchy
 - Implementing caching using @Cacheable
 - jdbc namespace and the Spring JdbcTemplate

### Database Transactions (with Spring)
 - Understanding transactions 
 - Transaction management strategies: connection management, programatic transaction management, declarative transaction management
 - @Transactional annotation
 - Transactions configuration: XML versus annotations
 - Isolation levels, transaction propagation, and rollback rules
 - Transactions and integration testing
 - Should you use read-only transactions?

###  Introduction to JPA
 - Introduction to Java Persistence API
 - Entity mapping: XML vs Annotations
 - Relationships
 - Inheritance: Singel Table, Joined Table, Class per table
 - Caching

### Integrating Spring with JPA and Hibernate
 - Quick introduction to ORM with JPA
 - Benefits of using Spring with JPA
 - JPA configuration in Spring
 - PersistenceException versus the Spring DataAccessException

### Advanced persistence frameworks
 - Spring Data (JPA)
 - Apache Deltaspike

3. OSGi
=======

Duration: 8h

OSGi is a 'framework' for developing modular applications in Java. It has been gainig populariry over the past few years and is found in a lot of products like: web application servers (Glassfish, Jboss AS8, Apache Karaf, etc), IDEs lieke Eclipse, embedded systems, etc.

 
#### Agenda
 - Bundle classloading and lifecycle
 - The service registry and service factories
 - Declarative Services
 - Tooling for OSGi development: BND, maven-bundle-plugin, etc
 - OSGi frameworks - Apache Karaf
 - Enterprise OSGi: JPA, Transactions

#### Objectives

After completing this class, you will be able to:
 - Undesrtand class-path related issues and how to solve them
 - Develop application bundles and deploy them inside an OSGi environment
 - Expose and consume OSGi services from the framework
 - Be familiar with best practices in developing OSGi enterprise applications 

4. Apache Camel
===============

Duration: 8h

Apache Camel is an integration framework. It makes it easier to route messages between different systems and application components, It makes it easy to send messages to systems or components using multiple transports, languages, and data formats.
Its built around, and support Enterprise Integration Patterns (EIPs) makes it simple to implement many different publisher-subscriber models with minimum coding.

#### Agenda
 - Apache Camel Overview
 - Routing
 - Beans
 - Error Handling
 - Testing
 - Components
 - Concurrency
 - Running Camel
 - Deploying Camel
 - Managing and Monitoring Camel

#### Objectives

After completing this class, you will be able to:

 - Briefly describe the role Camel plays in a Service Oriented Architecture.
 - Control the routing of messages from a data generator to a data consumer.
 - Control the exchange of messages between two systems, services, or application components using both a transactional model and a non-transactional model.
 - Use Camel components to connect to a variety of endpoints: CXF for web services, ActiveMQ/JMS, JDBC data sources, file and FTP.
 - Extend the Camel type converter system for new message types.
 - Specify Camel routes using Java and Spring Domain Specific Language.
 - Implement Camel Test for unit and integration testing.
 - Set up an error hander and exception policy to manage communication problems.
 - Monitor and test Camel operations to ensure it is working successfully.
