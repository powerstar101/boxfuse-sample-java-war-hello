pipeline{
    agent any
    parameters{
        choice(name: 'Environments', choices:['dev','qa','perf','uat','prod'],description:'')
        string(name: 'serverip', defaultValue:"127.0.0.1",description:'servers')
        string(name: 'bucketname', defaultValue:'Khalisi',description:'bucket names')
        string(name: 'jobname', defaultValue:'deploy',description:'buildjob name')
        string(name: 'branch', defaultValue:'heeman',description:'branch name')
        string(name: 'buildnumber',defaultValue:'20',description:'build number')
    }
    stages{
        stage('deploy'){
            steps{
                sh """ ssh -i /tmp/dev_mum.pem ec2-user@$serverip "aws s3 cp s3://$bucketname/$jobname/$branch/$buildnumber/hello-*.war /tmp/" """
            }
        }
        }
}
    
