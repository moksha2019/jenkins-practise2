// pipeline has  different tasks and  they are  built  in different stages
// on top level we have  agent and  it  has  different options(any, none, label, node)
pipeline {
    agent  any
    {
      stages {
        stage ("Demo stage: "){
            steps {
               echo "demo is successfull: !!"
            }
        }
      }
    }
}