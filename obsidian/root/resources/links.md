
Java

Date / Time:
https://blogs.oracle.com/javamagazine/post/java-timezone-part-1
https://blogs.oracle.com/javamagazine/post/java-timezone-part-2

Constructor super:
https://www.programiz.com/java-programming/super-keyword

Liskov Substitution Principle (LSP):
https://reflectoring.io/lsp-explained/ (code - https://github.com/thombergs/code-examples/tree/master/solid/lsp)

Visitor pattern:
DefinitionVisitor.java:219)\n\t\tat `org.springframework.beans.factory.config.BeanDefinitionVisitor.visitPropertyValues(BeanDefinitionVisitor.java:147)`

JSON serialization (jackson / gson):
https://stackoverflow.com/questions/71158760/how-can-i-produce-jsonincludevalue-jsoninclude-include-non-null-for-particu

CompletableFuture:
https://kalpads.medium.com/fantastic-completablefuture-allof-and-how-to-handle-errors-27e8a97144a0
https://www.baeldung.com/java-completablefuture-list-convert
https://github.com/spring-projects/spring-framework/pull/22476#issuecomment-547768188

InterruptedException:
https://dzone.com/articles/how-to-handle-the-interruptedexception

Lambdas:
Effectively final:
https://www.baeldung.com/java-lambda-effectively-final-local-variables

Scoping / lexical scoping / closures:
https://blogs.oracle.com/javamagazine/post/functional-programming-in-java-part-2-lambda-reuse-lexical-scoping-and-closures-and-reduce


slf4j / MDC:
https://www.baeldung.com/mdc-in-log4j-2-logback


Generics:
https://stackoverflow.com/questions/2776975/how-can-i-add-to-list-extends-number-data-structures
https://openjdk.org/projects/valhalla/design-notes/in-defense-of-erasure
https://eli.thegreenplace.net/2018/type-erasure-and-reification/
https://stackoverflow.com/questions/879855/what-are-reified-generics-how-do-they-solve-type-erasure-problems-and-why-cant
https://gafter.blogspot.com/2006/11/reified-generics-for-java.html


Profiling:
```
java -XX:+UnlockCommercialFeatures -XX:+FlightRecorder 
  -XX:StartFlightRecording=duration=200s,filename=flight.jfr path-to-class-file

jcmd 1234 JFR.start duration=100s filename=flight.jfr
```

```
java -jar ap-loader-all.jar profiler -e cpu -d 10 -f fds.jfr 86236

java -jar ap-loader-all.jar converter jfr2flame fds.jfr fds-flame.html

```


JFR:
https://docs.oracle.com/javase/8/docs/technotes/guides/troubleshoot/memleaks001.html
https://support.dremio.com/hc/en-us/articles/29109284293403-Steps-to-collect-a-Java-Flight-Recorder-JFR
https://bell-sw.com/announcements/2020/09/02/Hunting-down-memory-issues-with-JDK-Flight-Recorder/
```
java -jar ap-loader-all.jar profiler -e cpu -d 10 -f fds.jfr 86236

java -jar ap-loader-all.jar converter jfr2flame fds.jfr fds-flame.html
```


Hikari connection pool:
https://github.com/brettwooldridge/HikariCP/wiki/About-Pool-Sizing

Java built-in classloaders:
https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/ClassLoader.html#builtinLoaders
https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-5.html


Garbage collection:
https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/gc01/index.html


https://javaalmanac.io/



------------------------------------------------------------------------------------------

Spring

MockMvc:
https://stackoverflow.com/questions/69012206/incorrect-serialization-of-zoneddatetime-in-junit-tests-date-returns-as-double

DB connection pool:
https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#data.sql.datasource.connection-pool

Spring Security:
https://www.marcobehler.com/guides/spring-security

mvn spring-boot:run:
https://www.baeldung.com/spring-debugging
```
mvn spring-boot:run -Dspring-boot.run.profiles=local,local-postgresql -Dspring-boot.run.jvmArguments="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005"
```

`@Transactional`:
https://docs.spring.io/spring-framework/reference/data-access/transaction/declarative/annotations.html
https://medium.com/@jkha7371/is-transactional-readonly-true-a-silver-bullet-1dbf130c97f8

JPA / Hibernate SQL logging:
```
logging:  
  level:
    org.hibernate.SQL: DEBUG
    org.hibernate.orm.jdbc.bind: TRACE
```

Multi-module project:
https://spring.io/guides/gs/multi-module

Command-line arguments:
https://stackoverflow.com/questions/31038250/setting-active-profile-and-config-location-from-command-line-in-spring-boot
```
java -jar -Dspring.profiles.active=prod application.jar

java -jar application.jar --spring.profiles.active=prod --spring.config.location=c:\config

java -cp target/temp/ -Dspring.profiles.active=local,local-postgresql -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 org.springframework.boot.loader.JarLauncher
```

Spring package as standard jar (not BOOT-INF/classes)
https://stackoverflow.com/questions/40089443/how-to-add-a-dependency-to-a-spring-boot-jar-in-another-project
```
<plugin>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-maven-plugin</artifactId>
  <version>1.4.1.RELEASE</version>
  <executions>
    <execution>
      <goals>
        <goal>repackage</goal>
      </goals>
      <configuration>
        <classifier>exec</classifier>
      </configuration>
    </execution>
  </executions>
</plugin>
```


Reference git repositories:
https://github.com/thombergs/code-examples
https://github.com/piomin
https://github.com/eugenp/tutorials/tree/master/spring-boot-modules/spring-boot-properties-2


awsspring:
https://docs.awspring.io/spring-cloud-aws/docs/3.0.3/reference/html/index.html#spring-cloud-aws-parameter-store


resilience4j:
CircuitBreaker:
https://github.com/resilience4j/resilience4j/issues/1666


Distributed locking (redis / postgresql):
https://spring.academy/guides/spring-spring-distributed-lock


Profiles:
There are two ways of activating a Spring profile:
1) Set system property `spring.profiles.active`, OR
2) `@ActiveProfiles(..)`
`FundingSourceRepositoryUnitTest` uses #2.


Spring transaction / JPA logging:
https://stackoverflow.com/questions/1965454/showing-a-spring-transaction-in-log
```
org.hibernate.SQL: DEBUG  
org.hibernate.orm.jdbc.bind: TRACE  
org.springframework.orm.jpa: DEBUG  
org.springframework.transaction: DEBUG
org.springframework.transaction.interceptor: TRACE
```


@SpringBootTest
https://stackoverflow.com/questions/70810306/how-to-run-the-springboottest-with-only-a-single-bean-and-with-included-resilien
https://stackoverflow.com/questions/48747421/configuring-base-package-for-component-scan-in-spring-boot-test
https://www.baeldung.com/spring-boot-exclude-auto-configuration-test
https://www.baeldung.com/spring-data-disable-auto-config


kafka integration:
https://github.com/spring-projects/spring-integration-samples/blob/main/basic/kafka/README.md
https://docs.spring.io/spring-kafka/reference/kafka/annotation-error-handling.html
https://stackoverflow.com/questions/72982961/spring-kafka-exception-is-causing-manual-immediate-acknowledgment-to-be-rolled
error handling:
https://docs.spring.io/spring-kafka/reference/3.1/kafka/annotation-error-handling.html
https://www.baeldung.com/spring-retry-kafka-consumer
https://stackoverflow.com/questions/63236346/better-way-of-error-handling-in-kafka-consumer
https://stackoverflow.com/questions/55001718/is-it-possible-to-have-both-the-listener-and-container-error-handlers (both listener and container error handler)
https://stackoverflow.com/questions/69997305/spring-kafka-consumer-kafkalistenererrorhandler-vs-errorhandler-what-is-the-dif
https://stackoverflow.com/questions/72982961/spring-kafka-exception-is-causing-manual-immediate-acknowledgment-to-be-rolled
https://stackoverflow.com/questions/64012396/what-is-a-listener-container-in-spring-for-apache-kafka
retryabletopic:
https://medium.com/jamf-engineering/retryable-topics-with-spring-kafka-946360f2d644
https://github.com/eugene-khyst/spring-kafka-non-blocking-retries-and-dlt/blob/main/src/main/java/com/example/kafka/nonblockingretries/RetryableKafkaListener.java
https://www.lydtechconsulting.com/blog-kafka-spring-retry-topics.html





------------------------------------------------------------------------------------------

Redis

embedded-redis:
https://github.com/kstyrc/embedded-redis/issues/51

------------------------------------------------------------------------------------------

Kafka
https://www.redhat.com/en/blog/apache-kafka-10-essential-terms-and-concepts-explained

https://www.confluent.io/blog/put-several-event-types-kafka-topic/

https://martin.kleppmann.com/2018/01/18/event-types-in-kafka-topic.html

Topic <-> schema:
https://www.confluent.io/blog/put-several-event-types-kafka-topic/

Message priority:
https://www.confluent.io/blog/prioritize-messages-in-kafka/

Client connectivity / ports:
https://www.confluent.io/en-gb/blog/kafka-client-cannot-connect-to-broker-on-aws-on-docker-etc/?session_ref=https%3A%2F%2Fwww.google.com%2F

Set up local kafka cluster:
https://www.sohamkamani.com/install-and-run-kafka-locally/

Kafka internals book:
https://books.japila.pl/kafka-internals/consumer-groups/GroupCoordinator/


------------------------------------------------------------------------------------------

Maven
https://fossa.com/blog/overriding-dependency-versions-using-version-ranges-maven/

Multi-module project:
https://books.sonatype.com/mvnex-book/reference/multimodule.html
https://maven.apache.org/guides/mini/guide-multiple-modules-4.html

Classpath:
https://stackoverflow.com/questions/16655010/in-maven-how-output-the-classpath-being-used
```
mvn dependency:build-classpath -Dmdep.outputFile=cp.txt
```

Only resolve dependencies:
```
mvn dependency:resolve
```

Archetypes:
```
mvn archetype:generate "-DarchetypeGroupId=org.apache.maven.archetypes" "-DarchetypeArtifactId=maven-archetype-quickstart" "-DarchetypeVersion=1.5"
```

```
mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-webapp -DarchetypeVersion=1.5
```

------------------------------------------------------------------------------------------

Feign
https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/

https://reflectoring.io/create-openfeign-http-client/

https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-feign.html

https://stackoverflow.com/questions/61103415/custom-object-mapper-bean-changing-the-default-properties-of-open-feign-client

Response interceptor:
https://github.com/Sundsvallskommun/api-comfact-facade/blob/25ae74d72be9a1795a27ecb9293a5918c636cbad/src/main/java/se/sundsvall/comfactfacade/integration/comfact/configuration/FeignClientInterceptor.java#L17
https://github.com/Sundsvallskommun/api-comfact-facade/blob/main/src/test/java/se/sundsvall/comfactfacade/integration/comfact/configuration/FeignClientInterceptorTest.java#L44

Feign retry:
https://github.com/spring-cloud/spring-cloud-netflix/issues/3227


------------------------------------------------------------------------------------------

tree command in MacOS
https://gitlab.com/OldManProgrammer/unix-tree

https://oldmanprogrammer.net/source.php?dir=projects/tree

https://andre-als.blogspot.com/2012/02/how-to-install-command-tree-for-mac.html

------------------------------------------------------------------------------------------

Docker

Docker on Mac - https://news.ycombinator.com/item?id=11352594
https://www.cncf.io/blog/2023/02/02/docker-on-macos-is-slow-and-how-to-fix-it/
https://github.com/machyve/xhyve

------------------------------------------------------------------------------------------

AWS

Regions and Availability Zones:
https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-regions-availability-zones.html

Infrastructure choices - https://cep.dev/posts/every-infrastructure-decision-i-endorse-or-regret-after-4-years-running-infrastructure-at-a-startup/

ECS:
https://medium.com/boltops/gentle-introduction-to-how-aws-ecs-works-with-example-tutorial-cea3d27ce63d

Microservices:
https://aws.amazon.com/blogs/mt/find-your-business-domains-to-start-refactoring-monolithic-applications/

Builders' library:
https://aws.amazon.com/builders-library/
https://aws.amazon.com/builders-library/fairness-in-multi-tenant-systems/
https://aws.amazon.com/builders-library/using-load-shedding-to-avoid-overload/

Cloud Practitioner:
1. Course- https://explore.skillbuilder.aws/learn/course/134/play/62437/aws-cloud-practitioner-essentials
2. Practice test- https://app.pluralsight.com/library/courses/aws-cloud-practitioner-exam-prep/table-of-contents
3. Cheat sheet- https://digitalcloud.training/category/aws-cheat-sheets/aws-cloud-practitioner/
4. https://confluence.prod.aws.jpmchase.net/confluence/display/DPENG/AWS+Certified+Cloud+Practitioner

In House tool-
https://certassist.test.aws.jpmchase.net/home


------------------------------------------------------------------------------------------


PostgreSQL

Isolation levels:
https://stackoverflow.com/questions/63959619/understanding-postgres-serializable-isolation-level
https://medium.com/@darora8/transaction-isolation-in-postgres-ec4d34a65462
https://stackoverflow.com/questions/66789782/serializable-isolation-level-confusion-write-skew-postgres
```
drop table if exists funding.isolation_level_test;
create table funding.isolation_level_test
(
	id character varying (3),
	val int
);

insert into funding.isolation_level_test (id, val) values ('1', 2);
insert into funding.isolation_level_test (id, val) values ('1', 2);
insert into funding.isolation_level_test (id, val) values ('1', 2);
insert into funding.isolation_level_test (id, val) values ('2', 5);

SERIALIZABLE:
> psql terminal 1:
psql -h localhost -p 5432 -U postgres -d fundingsvcdbdev
fundingsvcdbdev=# begin transaction isolation level serializable;
BEGIN
fundingsvcdbdev=*# update funding.isolation_level_test
set val = t.result
from (select sum(val) as result from funding.isolation_level_test where id = '1') as t
where id = '1';
UPDATE 3
fundingsvcdbdev=*# commit;
COMMIT

> psql terminal 2:
fundingsvcdbdev=# begin transaction isolation level serializable;
BEGIN
fundingsvcdbdev=*# update funding.isolation_level_test
set val = t.result
from (select sum(val) as result from funding.isolation_level_test) as t
where id = '2';
UPDATE 1
fundingsvcdbdev=*# commit;
ERROR:  could not serialize access due to read/write dependencies among transactions
DETAIL:  Reason code: Canceled on identification as a pivot, during commit attempt.
HINT:  The transaction might succeed if retried.

READ COMMITTED:
> psql terminal 1:
begin transaction isolation level read committed;
BEGIN
fundingsvcdbdev=*# update funding.isolation_level_test
set val = t.result
from (select sum(val) as result from funding.isolation_level_test where id = '1') as t
where id = '1';
UPDATE 3
fundingsvcdbdev=*# commit;
COMMIT

> psql terminal 2:
begin transaction isolation level read committed;
BEGIN
fundingsvcdbdev=*# update funding.isolation_level_test
set val = t.result
from (select sum(val) as result from funding.isolation_level_test) as t
where id = '2';
UPDATE 1
fundingsvcdbdev=*# commit;
COMMIT

Data gets messed up:
select * from funding.isolation_level_test;
 id | val
----+-----
 1  |   6
 1  |   6
 1  |   6
 2  |  11
(4 rows)

```

Serializable / FOR UPDATE / Row lock:
https://stackoverflow.com/questions/75761088/in-postgres-is-there-a-need-to-lock-a-row-in-a-table-using-for-update-if-the-qu
https://www.postgresql.org/message-id/CAKFQuwbHFiXPxCksi9OKx4bZe5%2BX_noNLsvV589T-fDwUNMqrQ%40mail.gmail.com
https://dba.stackexchange.com/questions/26905/how-do-i-implement-insert-if-not-found-for-transactions-at-serializable-isolatio

Partitioning:
https://stackoverflow.com/questions/71610180/postgresql-partition-table-unique-index-problem

More locking:
https://stackoverflow.com/questions/46831831/is-insert-select-an-atomic-transaction
https://stackoverflow.com/questions/6955566/have-select-for-update-block-on-nonrexisting-rows
https://stackoverflow.com/questions/18176932/staleobjectstateexception-vs-optimisticlockexception
https://vladmihalcea.com/how-to-prevent-optimisticlockexception-using-hibernate-versionless-optimistic-locking/
https://dba.stackexchange.com/questions/244415/how-to-handle-concurrency-during-an-insert-select-cycle
https://devblogs.microsoft.com/azure-sql/the-insert-if-not-exists-challenge-a-solution/
https://stackoverflow.com/questions/4417597/mysql-insert-if-not-exists-concurrent-sessions


Aurora / RDS / Terraform / multiple databases:
https://minhajuddin.com/2020/05/09/how-to-use-a-single-aurora-cluster-for-multiple-databases-each-with-its-own-restricted-user/
https://registry.terraform.io/providers/cyrilgdn/postgresql/latest/docs
https://hector-reyesaleman.medium.com/how-to-terraform-the-creation-of-multiple-postgresql-databases-roles-and-grants-on-an-aws-rds-221e3c80d5f4
https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Overview.DBInstance.html




------------------------------------------------------------------------------------------

Zero downtime deployments / database changes / migrations:

https://reflectoring.io/zero-downtime-deployments-with-feature-flags/
https://spring.io/blog/2016/05/31/zero-downtime-deployment-with-a-database
https://news.ycombinator.com/item?id=16665447

------------------------------------------------------------------------------------------

HTTP RFC
https://www.rfc-editor.org/rfc/rfc7231


------------------------------------------------------------------------------------------


temporal

Local deployment:
https://docs.temporal.io/self-hosted-guide/deployment
https://github.com/temporalio/temporal/releases/
https://github.com/temporalio/ui-server/releases
https://docs.temporal.io/self-hosted-guide/visibility#postgresql
https://github.com/temporalio/temporal/tree/main/schema/postgresql/v12/visibility
https://docs.temporal.io/self-hosted-guide/upgrade-server#upgrade-server

Local server startup:
+ Start PostgreSQL server.
+ In pgAdmin, log in as postgres, and execute scripts in 1-databases.sql.
+ In terminal, execute 2-setup-schema.sh.
Note - The folder `schema` was copied over from temporal source code.
cd ~/development/software/temporal/temporal-server
./temporal-server --config ./config --env development-postgres12 start

Local ui startup:
~/development/software/temporal/temporal-ui
./ui-server --env development start

For ui, also tried:
cd ~/development/git-repos/temporal/ui-server
make build
./ui-server start
(somehow worked after intial failures)
http://localhost:8081/namespaces/default/workflows




With newer version of Docker Desktop, the following also works:
https://bitbucketdc-cluster03.jpmchase.net/projects/PHOTON/repos/proof-of-concepts/browse/temporal-poc
cd ~/jpmc/photon/proof-of-concepts/temporal-poc/docker-compose
docker compose up
http://localhost:8080/namespaces/default/workflows




------------------------------------------------------------------------------------------

Library Vs. Service

https://medium.com/trendyol-tech/how-to-write-a-spring-boot-library-project-7064e831b63b
https://www.baeldung.com/spring-boot-custom-auto-configuration



------------------------------------------------------------------------------------------

HTTP

Idempotency / idempotent:
https://datatracker.ietf.org/doc/draft-ietf-httpapi-idempotency-key-header/


------------------------------------------------------------------------------------------

OpenTelemetry

https://github.com/Wrdle/kafka-springboot-open-telemetry-agent
https://github.com/open-telemetry/opentelemetry-java-instrumentation


------------------------------------------------------------------------------------------

Prometheus

https://www.innoq.com/en/blog/2019/05/prometheus-counters/
https://stackoverflow.com/questions/37548412/prometheus-how-to-handle-counters-on-server
https://stackoverflow.com/questions/47138461/get-total-requests-in-a-period-of-time
https://stackoverflow.com/questions/55928079/single-stat-after-big-counter-reset
https://stackoverflow.com/questions/77698965/calculate-sum-of-the-prometheus-counters-values-even-if-application-restarted
https://stackoverflow.com/questions/77700508/display-sum-of-counter-over-time-period-in-a-grafana-table-view
https://github.com/prometheus/prometheus/issues/12967


cd ~/development/git-repos/examples/prometheus

prometheus.yml:
```
scrape_configs:  
  - job_name: 'spring-boot-application'  
    metrics_path: '/actuator/prometheus'  
    scrape_interval: 10s  
    static_configs:  
      - targets: ['host.docker.internal:8080']
```
`docker compose up`

http://localhost:9090

query:
- custom_requests_count_total
- increase(custom_requests_count_total[1m])
- sum by (label) (increase(custom_requests_count_total[1m])) - still does not look right
- sum(increase(custom_requests_count_total[30m])) - seems close but shows decimal value

grafana:
cd ~/development/software/grafana/grafana-v11.5.1/bin
./grafana server
http://localhost:3000
- custom_requests_count_total
- sum(increase(custom_requests_count_total[24h]))
- sum(rate(custom_requests_count_total[$__range]))
- sum(increase(custom_requests_count_total[$__range]))
- sum by (label) (increase(custom_requests_count_total[1m]))




------------------------------------------------------------------------------------------













