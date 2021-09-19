pipeline{
    agent any
    stages{
        stage("installing tomcat"){
            steps{
               sh' ssh -o StrictHostKeyChecking no-i dev_mum.pem ec2-user@$serverip "chmod +x tomcatinstall.sh && bash tomcatinstall.sh"'
            }
        }
    }
}