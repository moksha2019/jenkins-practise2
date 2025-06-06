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


// writing a  multi stage  pipeline
pipeline {
    agent any
    stages {
        stage ("Build the application:"){
            steps {
                echo " building the  application  completed:"
            }
        }
        stage ("quality test:"){
            steps {
                echo " code quality  completed:"
            }
        }
        stage ("pushing the  image to repo"){
            steps {
                echo " pushing the image  completed:"
            }
        }
        stage ("Deploy to dev:"){
            steps {
                echo " Deploy to  dev environment  completed:"
            }
        stage ("Deploy to test"){
            when {
                branch 'release/*'
            }
            steps {
                echo " Deploy to test  completed:"
            }
        stage ("Deploy to stage"){
            steps {
                echo " Deploy to stage completed"
            }
        stage ("Deploy to prod:"){
            when {
                // we should deploy the  application to production we should  with only TAG
                // V1.1.1
                // tag pattern: "release-\\d+", comparator: "REGEXP"
                tag pattern: "v\\d{1,2}\\.\\d{1,2}\\.\\d{1,2}\\", comparator: "REGEXP"
            }
            steps {
                echo " Deploy to production completed:"
            }
        }
        }
        }
        }
    }
}
