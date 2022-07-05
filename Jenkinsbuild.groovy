//Declarative pipeline
pipeline {
    agent any
    parameters { string(name: 'SOURCE_CODE_BRANCH', defaultValue: 'develop', description: 'Provide source code branch from which you want to build') }
    stages{
        stage("Checkout SCM") {
        steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/${SOURCE_CODE_BRANCH}']], doGenerateSubmoduleConfigurations: false, userRemoteConfigs: [[credentialsId: 'github-auth', url: 'https://github.com/KuruvaSomaSekhar/june-private.git']]])
                sh "ls -lart ./*"
            }
        }
        stage("Build Code"){
            steps {
                sh "mvn clean package"
                sh "ls -l target/"
            }
        }
        stage("Upload artifacts"){
            steps {
                sh "aws s3 cp target/hello-${BUILD_NUMBER}.war s3://june22artifacts/${env.JOB_NAME}/${SOURCE_CODE_BRANCH}/${BUILD_NUMBER}/"
                sh "aws s3 ls s3://june22artifacts/${env.JOB_NAME}/${SOURCE_CODE_BRANCH}/${BUILD_NUMBER}/ "
            }
        }
    }
}