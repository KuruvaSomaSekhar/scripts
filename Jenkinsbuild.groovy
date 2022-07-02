//Declarative pipeline
pipeline {
    agent any
    stages{
        stage("Checkout SCM") {
        steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/develop']], doGenerateSubmoduleConfigurations: false, userRemoteConfigs: [[credentialsId: 'github-auth', url: 'https://github.com/KuruvaSomaSekhar/june-private.git']]])
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
                sh "aws s3 cp target/hello-$BUILD_NUMBER.war s3://june22artifacts/${env.JOB_NAME}/develop/$BUILD_NUMBER/"
                sh "aws s3 ls s3://june22artifacts/${env.JOB_NAME}/develop/$BUILD_NUMBER/ "
            }
        }
    }
}