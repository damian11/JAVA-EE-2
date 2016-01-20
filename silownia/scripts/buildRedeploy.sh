#!/bin/sh

echo "************ UNDEPLOYING *******************"
asadmin undeploy silownia
echo "************ BUILDING **********************"
mvn package
echo "************ DEPLOYING *********************"
asadmin deploy target/silownia.war
