#!/bin/bash
$JAVA_HOME/bin/keytool -delete -alias tomcat -keystore ~/.keystore -storepass changeit
$JAVA_HOME/bin/keytool -genkey -alias tomcat -keyalg RSA -keystore ~/.keystore -storepass changeit
$JAVA_HOME/bin/keytool -export -alias tomcat -file tomcat.crt -keystore ~/.keystore -storepass changeit
$JAVA_HOME/bin/keytool -import -trustcacerts -file tomcat.crt -alias tomcat -keystore $JAVA_HOME/jre/lib/security/cacerts -storepass changeitrm tomcat.crt
