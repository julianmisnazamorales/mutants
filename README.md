# Mutants application

This application was done to complete the contest of MELI. Itś related to finding mutants or humans based on their protein strings

## Version 1

* Built on Java 8 using Spring framework.
* Uses a relational database.

## Assumptions

This application was created using:

* Java 8
* Maven 3
* Spring Boot
* Ubuntu 18.4 

## Prerequisites

1) Install Java, follow this [link](https://www.digitalocean.com/community/tutorials/how-to-install-java-with-apt-on-ubuntu-18-04).
2) Install Maven, follow this [link](https://linuxize.com/post/how-to-install-apache-maven-on-ubuntu-18-04/).
3) Install Git, follow this [link](https://www.liquidweb.com/kb/install-git-ubuntu-16-04-lts/)

## Instructions

1) Configure these environment variables:

|Environment variable|Example|Description|
|-|-|-|
|`MUTANTS_DATASOURCE_URL`|jdbc:mysql://localhost:3306/mutantsdb|The database connection|
|`MUTANTS_DATASOURCE_USERNAME`|root|The database user|
|`MUTANTS_DATASOURCE_PASSWORD`|12345|The database password|

### Execution

1) To validate a protein string

http://mutants-env-1.eba-vu2jrcgj.us-east-2.elasticbeanstalk.com//mutant
|`PAYLOAD TEST` {"dna": ["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCACTA","TCAAAC"]}

2) To retrieve the stats
| http://mutants-env-1.eba-vu2jrcgj.us-east-2.elasticbeanstalk.com/stats