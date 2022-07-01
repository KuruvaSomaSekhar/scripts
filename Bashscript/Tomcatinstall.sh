#!/bin/bash

#Install tomcat web server
sudo yum -y install java-1.8.0-openjdk-devel
sudo yum install tomcat -y
sudo yum install tomcat-webapps tomcat-admin-webapps tomcat-docs-webapp tomcat-javadoc -y
sudo chmod 777 /var/lib/tomcat/webapps
sudo systemctl start tomcat
sudo systemctl restart tomcat
chkconfig tomcat on


