# calldrink
Order your drink easily

# MySQL
docker run --name mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -e MYSQL_DATABASE=calldrink -p 6603:3306 -d mysql/mysql-server
mysql --host=192.168.99.100 --port=6603 --user=root --password=calldrink

# Tomcat 8
docker run --name tomcat -p 8888:8080 -d tomcat:8.0
http://192.168.99.100:8888/

# Jenkins
docker run --name jenkins -p 8080:8080 -p 50000:50000 -v /Users/silvionetto/var/jenkins_home/:/var/jenkins_home -d silvionetto/docker_jenkins
http://192.168.99.100:8080/