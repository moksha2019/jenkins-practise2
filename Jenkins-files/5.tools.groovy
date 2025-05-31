// we use tools to auto install packages or define path of the  package
//we can  add tool section under pipeline or  under the  stages
// tools unser stage  will override
pipeline {
    agent any
    tools {
        maven 'Maven_new' // this name  should  match in the  tool section in jenkins
    }
    stages {
        stage ('stage with default version:'){
            steps {
                sh 'mvn --version'
            }
        }
        stage('stage with specific version:'){
            tools {
                jdk 'JDK_17'
            }
            steps {
                echo "mave n version with my  custom java: "
                sh 'mvn --version'
            }
        }
    }
}