// The parameters directive provides a list of parameters that a user should provide when triggering the Pipeline
// The values for these user-specified parameters are made available to Pipeline steps via the params object, refer to the Parameters
// available parameters (string, text, booleanParam, choice, password and credentials)
Pipeline {
    agent any
    parameters {
        string{name: 'PERSON', defaultValue: 'prasad', description: "Enter your name:"}
    }
    stages {
        stage {
            steps {
                echo "welcome to ${params.PERSON}" // ${params.key}
            }
        }
    }
}


 // below  is the  pipeline we are  using all paramerters
 pipeline {
    agent any
    paramerters {
        string(name: 'CHG_TKT', defaultValue: 'CHG12345', description: 'Enter change ticket  number:')
        booleanParam(name: 'APPROVAL', defaultValue: true, description: '')
        choice(name: 'CHOICES', choices: ['DEV', 'STAGE', 'PROD'], description: 'Enter the environemnt to deploy:')
        password(name: 'PASSWORD', defaultValue: 'SECRET', description: 'A secret password')
        credentials(name: 'MY_CREDS' defaultValue: '' description: 'docker credentials') // this parameter is removed from document
    }
    stages {
        stage {
            steps {
                echo "Your change ticket number# ${params.CHG_TKT}"
                echo "SRE approval is ${params.APPROVAL}"
                echo "Your choice is ${params.CHOICES}"
                echo "Password entered is: ${params.PASSWORD}"
                echo "  The  credentials are ${params.MY_CREDS}"
            }
        }
    }
 }