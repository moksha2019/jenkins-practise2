//this file  for  timeout
pipeline {
    agent any
    stages {
        stage {
            steps {
                timeout(unit: 5, unit: 'SECONDS'){
                    echo "sleepig for 10 seconds:"
                    sleep 60
                }
            }
        }
    }
}