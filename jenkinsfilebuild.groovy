pipeline{
    agent any
     stages{
         stage('git clone'){
             steps{
              git url:' https://github.com/tyrion9999/boxfuse-sample-java-war-hello.git'
             }
         }
             stage('Build'){
                 steps{
                     sh """ mvn clean package """
                 }
             }
              stage('upload artifacts'){
                 steps{
                     sh """ aws s3 cp target/hello-*.war  s3://khalisi/$jobname/$branch/$build_number/"""
                 }
             }
             
             
         }
     }
