pipeline{
    agent any
        stages{
            stage('Cloning'){
                steps{
                git url:'https://github.com/tyrion9999/boxfuse-sample-java-war-hello.git'
                }
                        }
             stage('Build'){
                steps{
                 sh 'mvn clean package '
                }
                }
                stage('deploy'){
                steps{
                 sh 'scp -o StrictHostKeyChecking=no -i /tmp/dev-virginia.pem target/*.war ec2-user@3.90.185.215:/tmp'
                        }
                        }
                        stage('production'){
                steps{
                 sh ' ssh -i StrictHostKeyChecking=no -i /tmp/dev-virginia.pem ec2-user@3.90.185.215 "sudo cp /tmp/*.war /var/lib/tomcat/webapps" '
                        }
                        }
              
    }    }
    

