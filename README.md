# Call Drink
Order your drink easily.

## Release Notes
#### 1.0.1 - 19-08-2016
. JSF 2.2 - Working  
. I18n - Default language en

# MySQL
### Create Machine
docker run --name mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -e MYSQL_DATABASE=calldrink -p 6603:3306 -d mysql/mysql-server  
mysql --host=192.168.99.100 --port=6603 --user=root --password=calldrink  

### Start Machine
docker start mysql

# Tomcat 8
### Create Machine
docker run --name tomcat -p 8888:8080 -d tomcat:8.0  
### Access Machine
docker exec -it tomcat /bin/bash

http://192.168.99.100:8888/

### Start Machine
docker start tomcat

# Jenkins
### Create Machine
docker run --name jenkins -p 8080:8080 -p 50000:50000 -d jenkins  
docker run --name jenkins -p 8080:8080 -p 50000:50000 -v /Users/silvionetto/var/jenkins_home/:/var/jenkins_home -d jenkins  

http://192.168.99.100:8080/

### Start Machine
docker start jenkins
