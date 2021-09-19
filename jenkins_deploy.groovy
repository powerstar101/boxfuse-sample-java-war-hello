pipeline{
    agent any
    stages{
        stage{
            steps{
               sh' ssh -i dev_mum.pem ec2-user@$serverip "bash tomcatinstall.sh"'
            }
        }
    }
}