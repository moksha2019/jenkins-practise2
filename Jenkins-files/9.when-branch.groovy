// default env variables defined by  jenkins  for MBP 
pipeline {
    agent any
    stages {
        stage {
            when {
                expression { BRANCH_NAME ==~ /production|staging}
            }
            steps {
                echo "deployed to production:"
            }
        }
    }
}

// Multi conditional based
// anyof
// the  below  pipeline  will get executed bcz  if any one  of the  conditon  is  satisifed
// allOf --> all the conditions need to return true to execute the stage

pipeline {
    agent any
    environemnt {
        DEPLOY_TO = 'production' // just an  environemnt  table
    }
    stages {
        stage {
            when {
                anyOf {
                expression { BRANCH_NAME ==~ /production|staging}  // condition1
                environment name: 'DEPLOY_TO', value: 'production' // condition2
                }
            }
            steps {

                echo "deployed to production compleetd: "
            }
        }
    }
}
}

