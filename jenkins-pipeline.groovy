pipeline{
    agent any
    stages{
        stage(git clone){
            git url:https://github.com/tyrion9999/boxfuse-sample-java-war-hello.git
        }
        stage(build job){
            mvn clean package
           
        }
        stage(upload artifacts){
         aws s3 /target/hello-*.war s3://khalisi/artifacts/${jobname}/${branch_name}/${build_number}
        }
    }
}