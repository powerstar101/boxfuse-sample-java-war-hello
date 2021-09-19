#!/bin/bash
jobname=$1
branchname=$2
build_number=$3
aws s3 cp s3://khalisi/artifacts/${jobname}/${branch_name}/${build_number} /tmp/
sudo cp /tmp/hello-*.war /var/lib/tomcat/webapps