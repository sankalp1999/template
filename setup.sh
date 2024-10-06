
#!/bin/bash

# Construct and execute curl command to download Spring Boot project
curl -G "https://start.spring.io/starter.zip" \
  --data-urlencode "type=maven-project" \
  --data-urlencode "language=java" \
  --data-urlencode "bootVersion=3.2.10" \
  --data-urlencode "packaging=jar" \
  --data-urlencode "javaVersion=17" \
  --data-urlencode "groupId=com.example" \
  --data-urlencode "artifactId=restaurantapp" \
  --data-urlencode "name=restaurantapp" \
  --data-urlencode "description=CRUD Operations with Java Spring Boot for Restaurant Management" \
  --data-urlencode "packageName=com.example.restaurantapp" \
  --data-urlencode "dependencies=web,data-jpa,h2" \
  -o spring-project.zip

# Wait for download to complete
while [ ! -f spring-project.zip ]; do
  sleep 1
done

# Create project folder
mkdir -p output_spring_boot_crud_rest

# Unzip the downloaded file into the project folder
unzip spring-project.zip -d output_spring_boot_crud_rest

# Clean up the zip file
rm spring-project.zip

echo "Spring Boot project created successfully in output_spring_boot_crud_rest folder."
