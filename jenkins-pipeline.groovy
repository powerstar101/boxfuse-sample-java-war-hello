pipeline{
    agent any
    stages{
        stage("build job"){
           sh' mvn clean package'
            echo "building of job is done"
           
        }
        stage("upload artifacts"){
         aws s3 cp target/hello-*.war s3://khalisi/artifacts/${jobname}/${branch_name}/${build_number}
        }
    }
}