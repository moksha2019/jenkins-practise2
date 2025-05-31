//pipeline for retry
pipeline {
    agent any
    stages {
        stage ("build pahse:"){
            steps {
                echo "**************i am  on build  block *************"
                retry (3) {
                    echo "welcome to d4"
                    error "testing the retry block"
                }
                echo "after retries: "
            }
        }
    }
}