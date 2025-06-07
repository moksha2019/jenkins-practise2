// this option will  discards the  old  builds  on the condition  in the agent node.
// Manage Jenkins >> Configure System >> Global Build Discarders

pipeline {
    agent any
    options {
        buildDiscarder(logRotator(numToKeepStr: '2')) }
    }
    stages {
        stage ('Build stage'){
            steps {
                echo "Build completd  successfully:"
            }
        }
    }
}