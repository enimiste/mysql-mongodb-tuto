## Using Mysql and Mongodb in the same project
### Technologies :
- Java 11
- Spring boot
- Mongodb starter
- Spring Data Jpa starter
- Spring Web starter
- lombok

### Hints :
- Never make relations between mongodb documents and JPA entities.
- Linking should be done using Ids
- Maybe we can save extras data for reading or caching purposes


### Maven configuration to use the QueryDSl (Keep the versions)
```
        <dependency>
			<groupId>com.querydsl</groupId>
			<artifactId>querydsl-core</artifactId>
			<version>4.3.1</version>
		</dependency>

		<dependency>
			<groupId>com.querydsl</groupId>
			<artifactId>querydsl-apt</artifactId>
			<version>4.3.1</version>
			<scope>provided</scope>
		</dependency>

		<dependency>
			<groupId>com.querydsl</groupId>
			<artifactId>querydsl-mongodb</artifactId>
			<version>4.3.1</version>
			<exclusions>
				<exclusion>
					<groupId>org.mongodb</groupId>
					<artifactId>mongo-java-driver</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
```
Add this plugin :
```
    <plugin>
        <groupId>com.mysema.maven</groupId>
        <artifactId>apt-maven-plugin</artifactId>
        <version>1.1.3</version>
        <executions>
            <execution>
                <id>jpa</id>
                <goals>
                    <goal>process</goal>
                </goals>
                <configuration>
                    <outputDirectory>target/generated-sources/java</outputDirectory>
                    <processor>com.querydsl.apt.jpa.JPAAnnotationProcessor</processor>
                </configuration>
            </execution>
            <execution>
                <id>mongodb</id>
                <goals>
                    <goal>process</goal>
                </goals>
                <configuration>
                    <outputDirectory>target/generated-sources/java</outputDirectory>
                    <processor>org.springframework.data.mongodb.repository.support.MongoAnnotationProcessor</processor>
                </configuration>
            </execution>
        </executions>
    </plugin>
```
To generate query classes `QEntity` use this maven command : `mvn clean:clean package`

## Run the project
You should run the project using `mvn spring-boot:run` to avoid maven dependencies issues with querydsl lib.