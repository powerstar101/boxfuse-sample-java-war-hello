pipeline{
    agent any
    stages{
        stage("installing tomcat"){
            steps{
                sh ' sudo scp -i /tmp/dev_mum.pem tomcatinstall.sh ec2-user@$serverip:/tmp'
               sh' sudo ssh -i /tmp/dev_mum.pem ec2-user@$serverip "chmod +x /tmp/tomcatinstall.sh && bash /tmp/tomcatinstall.sh"'
            }
        }
    }
}