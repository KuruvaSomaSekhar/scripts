pipeline {
    agent any
    parameters { string(name: 'PROJECT_NAME', defaultValue: 'build-pipeline', description: '') 
                 string(name: 'SOURCE_CODE_BRANCH', defaultValue: 'develop', description: '')
                 string(name: 'BUILD_NUMBER', defaultValue: '10', description: '')
    
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
    }
}