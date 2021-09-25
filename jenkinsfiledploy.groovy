pipeline{
    agent any
    parameters{
        choice(name: 'Environments', choices:['dev','qa','perf','uat','prod'],description:'')
        choice(name: 'serverip', choices:[''],description:'')
        choice(name: 'bucketname', choices:['Khalisi'],description:'')
        choice(name: 'jobname', choices:[''],description:'')
        choice(name: 'branch', choices:[''],description:'')
        choice(name: 'buildnumber',choices[''],description:'')
    }
    stages{
        stage('deploy'){
            steps{
                sh """ ssh -i /tmp/dev_mum.pem ec2-user@$serverip "aws s3 cp s3://$bucketname/$jobname/$branch/$buildnumber/hello-*.war"
            }
        }
    }
}