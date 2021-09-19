pipeline{
    agent any
    stages{
        stage("installing tomcat"){
            steps{
               sh' ssh -i dev_mum.pem ec2-user@$serverip "bash tomcatinstall.sh"'
            }
        }
    }
}