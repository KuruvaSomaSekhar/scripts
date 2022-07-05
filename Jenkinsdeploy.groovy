pipeline {
    agent any
    parameters { string(name: 'PROJECT_NAME', defaultValue: 'build-pipeline', description: '') 
                 string(name: 'SOURCE_CODE_BRANCH', defaultValue: 'develop', description: '')
                 string(name: 'BUILD_NUMBER', defaultValue: '10', description: '')
                 string(name: 'SERVERS', defaultValue: '10', description: '')
                 choice(name: 'ENVIRONMENT', choices: ['172.31.23.231', '172.31.31.74'], description: 'ENVIRONMENT')
    
    }
    stages {
        stage("Download artifacts") {
            steps {
                sh '''
                 aws s3 ls s3://june22artifacts/${PROJECT_NAME}/${SOURCE_CODE_BRANCH}/${BUILD_NUMBER}/
                 aws s3 cp s3://june22artifacts/${PROJECT_NAME}/${SOURCE_CODE_BRANCH}/${BUILD_NUMBER}/hello-${BUILD_NUMBER}.war .
                 ls -l
                 '''
            }
        }
        stage("Deploy artifacts"){
            steps {
                sh """
                    scp -i /tmp/june22_ohio.pem hello-${BUILD_NUMBER}.war ec2-user@${ENVIRONMENT}:/tmp/
                    ssh -i /tmp/june22_ohio.pem ec2-user@${ENVIRONMENT} "sudo cp /tmp/hello-${BUILD_NUMBER}.war /var/lib/tomcat/webapps/"
                    """
            }
        }
    }
}