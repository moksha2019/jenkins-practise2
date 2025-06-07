// The input directive on a stage allows you to prompt for input, using the input step
// The stage will pause after any options have been applied, and before entering the agent block for that stage or evaluating the when condition of the stage
// If the input is approved, the stage will then continue

pipeline {
    agent any
    stages {
        stage('Build  stage'){
            steps {
                echo "Build  completed"
            }
        }
        stage('scan  stage'){
            steps {
                echo "scan  completed"
            }
        }
        stage('deploy to dev'){
            steps {
                echo "Deploy to dev completed"
            }
        }
        stage('deploy to stage'){
            steps {
                echo "Deploy to stage completed"
            }
        }
        stage('deploy to prod'){
            input {
                message "approval  for prod deployment"
                ok "YES"
                submitter "moksha, dev"
            }
            steps {
                echo "Deploy to prod completed"
            }
        }
    }
}