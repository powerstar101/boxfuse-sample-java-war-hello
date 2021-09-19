#!/bin/bash
jobname=$1
branchname=$2
build_number=$3
echo " ${jobname}"
aws s3 cp s3://khalisi/artifacts/${jobname}/${branch_name}/hello-${build_number}.war /tmp/
sudo cp /tmp/hello-${build_number}.war /var/lib/tomcat/webapps