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
    }
}