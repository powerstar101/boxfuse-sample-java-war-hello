pipeline{
    agent any
    parameters{
        choice(name: 'Environments', choices:['dev','qa','perf','uat','prod'],description:'')
        string(name: 'serverip', Default Value:[''],description:'')
        string(name: 'bucketname', Default Value:['Khalisi'],description:'')
        string(name: 'jobname', Default Value:['deploy'],description:'')
        string(name: 'branch', Default Value:['heeman'],description:'')
        string(name: 'buildnumber',Default Value['20'],description:'')
    }
    stages{
        stage('deploy'){
            steps{
                sh """ ssh -i /tmp/dev_mum.pem ec2-user@$serverip "aws s3 cp s3://$bucketname/$jobname/$branch/$buildnumber/hello-*.war" """
            }
        }
        }
}
    
