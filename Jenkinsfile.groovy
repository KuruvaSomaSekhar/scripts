//Scripted
//Declarative

pipeline {
    agent any
    stages{
        stage("Stage1"){
            steps {
                println "Im in the first stage"
                echo "I'm writing with echo command"
            }
        }
        stage("Stage2"){
            steps {
                println "Im in the Second stage"
                echo "I'm writing with echo command"
            }
        }
        stage("Stage3"){
            steps {
                println "Im in the third stage"
                echo "I'm writing with echo command"
            }
        }
    }
}