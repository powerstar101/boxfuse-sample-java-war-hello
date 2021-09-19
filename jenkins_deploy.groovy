pipeline{
    agent any
    stages{
        stage("installing tomcat"){
            steps{
               sh' sudo ssh -i /tmp/dev_mum.pem ec2-user@$serverip "chmod +x tomcatinstall.sh && bash tomcatinstall.sh"'
            }
        }
    }
}