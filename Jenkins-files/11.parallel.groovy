// sometime we need to run the  jobs parallely 
// Stages in Declarative Pipeline may have a parallel section containing a list of nested stages to be run in parallel

pipeline {
    agent any
    stages {
        stage ('Build stage') {
            parallel {
                stage ('stage1') {
                    steps {
                        echo "stage1  completed"
                    }
                }
                stage ('stage2') {
                    steps {
                        echo "stage2 completed:"
                    }
                }
            }
        }
        stage ('sonar scan') {
            steps {
                echo "sanning  completed: "
            }
        }
    }
}