# AcademicManagerV1
First version of the Academic Manager WebApp


1) JNDI DATABASE SETUP WITH TOMCAT 9.0
  In order for the Database connection to work in the web app you need to do the following:
    A) In the file C:\Program Files\Apache Software Foundation\Tomcat 9.0\conf\context.xml you need to add the following lines
       inside the Context element:
            	<Resource   name="jdbc/AcademicManagerDB"
                  global="jdbc/AcademicManagerDB"
                  auth="Container"
                  driverClassName="com.mysql.jdbc.Driver"
                  factory="org.apache.tomcat.jdbc.pool.DataSourceFactory"
                  type="javax.sql.DataSource"
                  username="root"
                  password=""
                  description="JNDI jdbc connection to AcademicManagerDB"
                  url="jdbc:mysql://localhost:3306/academicmanagerdb"
                  maxTotal="20"
                  maxIdle="20"
                  maxWaitMillis="10000"
                  removeAbandonedTimeout="300"
                  defaultAutoCommit="true" />
      B) Download the MySQL connector jar file (mysql-connector-java-5.1.40-bin.jar) and add it in the lib folder of your Tomcat
        installation (C:\Program Files\Apache Software Foundation\Tomcat 9.0\lib\)
                  
