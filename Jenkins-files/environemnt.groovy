pipeline {
    agent any
    environemnt {
        course = 'docker & kubernetes'
        name = 'prasad'
        myjen_creds = credentials('jenkins_creds')
    }
    stages {
        stage ('Reading  the env variables') {
            steps {
             echo "welcome to $course"
             echo "you are enrolled for $name"
            }

        }
        stage('Reading the  jenkins crdentials'){
            steps {
                echo " the  username is ${myjen_creds_USR}"
                echo " the password is ${myjen_creds_PSW}"
                echo "credentials  are ${myjen_creds}"
            }
        }

    }
}