pipeline{
    agent any
    parameters{
        choice(name: 'Environments', :['dev','qa','perf','uat','prod'],description:'')
        string(name: 'serverip', choices:[''],description:'')
        string(name: 'bucketname', choices:['Khalisi'],description:'')
        string(name: 'jobname', choices:[''],description:'')
        string(name: 'branch', choices:[''],description:'')
        string(name: 'buildnumber',choices[''],description:'')
    }
    stages{
        stage('deploy'){
            steps{
                sh """ ssh -i /tmp/dev_mum.pem ec2-user@$serverip "aws s3 cp s3://$bucketname/$jobname/$branch/$buildnumber/hello-*.war" """
            }
        }
        }
}
    
