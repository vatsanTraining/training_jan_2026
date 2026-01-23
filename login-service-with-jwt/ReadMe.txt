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

		3. Create a Controller with one EndPoint which will be accessed with jwt token
		4. Create a @Configuration class and Register BcryptpasswordEncode and AuthentictionManager
		5.Create a @Service Annotated class JwtGeneratorUtil
		6. Add Method to extractUserName(),extractPassword(),init() , isTokenExpire and isTokenValid methods
		7.Create a @Service annotated class JwtAuthenticationFilter extending OncePerRequestFilter
		8 Inject UserDetailService and JwtUtil override the doFilterInternal
		9. Inject the JwtFilter to SecurityFilter Class 
		10.Update the Security Configuration to use JWT Authentication Filter
		11  Inject passwordendcoder,jwtauthFilter and userDetailsService
		12. Add Login method to authController class and call 
		
		