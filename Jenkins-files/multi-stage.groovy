// This  pipeline for multiple stages  defined
pipeline {
    agent any
    stages {
        stage {
            steps ('Build stage'){
                echo "completed  building the  building the  image:"
            }
        }
        stage ('Sonar stage'){
            steps {
                echo "completed scanning the image: "
            }
        }
        stage ('Deploy to dev'){
            steps {
                echo "Deploy to dev successfully completed: "
            }
        }
        stage ('Deploy to stage'){
            steps {
                echo "deploy to  stage  completed"
            }
        }
        stage('Deploy to preprod'){
            steps {
                echo "deploy to prod2  completed:"
            }
        }
        stage ('deploy to prodlive'){
            steps {
                echo "deploy to prodlive  completed:"
            }
        }

    }
}