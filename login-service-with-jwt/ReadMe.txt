1.Copy and Rename the Project login-service 
2.Add the JWT dependency in the build file (pom.xml or build.gradle)
	<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-api</artifactId>
			<version>0.11.5</version>
		</dependency>
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-impl</artifactId>
			<version>0.11.5</version>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-jackson</artifactId>
			<version>0.11.5</version>
			<scope>runtime</scope>
		</dependency>

		3. Create a Controller with one Point which will be accessed with jwt token
		4. Create a @Configuration class and Register BcryptpasswordEncode and AuthentictionManager
		5.Create a @Service Annotated class JwtFilter and JwtGeneratorUtil
		6. Inject the JwtFilter to SecurityFilter Class 
		4.Update the Security Configuration to use JWT Authentication Filter
		5. Create a JWT Utility class to generate and validate JWT tokens
		