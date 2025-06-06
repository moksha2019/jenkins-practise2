// when directive allows the Pipeline to determine whether the stage should be executed depending on the given condition
// nesting conditions: not, allOf, or anyOf
// if  more than one  condition is specified  all conditions must return true  for the  stage  to be executed
pipeline {
    agent any
    environment {
        DEPLOY_TO = 'production' // just an  environemnt  table
    }
    stages {
        stage {
            when {
                environment name: 'DEPLOY_TO', value: 'production'
            }
            echo "Deployment  to production  completed: "
        }
    }
}