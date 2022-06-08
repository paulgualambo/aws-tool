def fnSteps = evaluate readTrusted("jenkinsfiles/steps.groovy")

pipeline {
  agent any
  parameters {
    choice(
      name: 'REGION',
      choices: ['ap-northeast-1']
    )
    choice(
      name: 'EXECUTE',
      choices: ['DEFAULT'
      , 'Item1'
      , 'Item2'
      ]
    )
  }
  stages {
    stage('Set Config') {
      steps {
        script {
          config = fnSteps.configs(params.ENVIRONMENT)
        }
      }
    }
    // stage('Install Dependencies') {
    //   steps {
    //     script {
    //       fnSteps.install_dependencies(config)
    //     }
    //   }
    // }
    // stage('Unit test') {
    //   steps {
    //     script {
    //       fnSteps.unit_test(config)
    //     }
    //   }
    //   post {
    //     always {
    //       junit 'app/junit.xml'
    //     }
    //   }
    // }

  }
  post {
    always {
      cleanWs()
    }
  }
}