pipeline{
    agent any
     stages{
         stage("git clone"){
             steps{
              git url: https://github.com/tyrion9999/boxfuse-sample-java-war-hello.git
             }
             stage("Build"){
                 steps{
                     sh """ mvn clean package """
                 }
             }
             
         }
     }
}