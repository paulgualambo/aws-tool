def getRegions(def enviroment) {
  def REGIONS = [
    dev:'eu-west-1',
    pre:'us-west-2',
    pre1a:'us-west-2',
    prod:'us-east-1'
  ]
  return REGIONS[enviroment]
}

def configs(def enviroment) {

  return enviroment
}

def install_dependencies(def config) {
  withEnv(config) {
    sh 'make clean'
    sh 'make install'
  }
}

def unit_test(def config) {
  withEnv(config) {
    sh 'make unit.test'
  }
}

def build_application(def config) {
  withEnv(config) {
    sh 'make build'
    sh 'make create.zip'
  }
}

def stack_deploy(def config) {
  withEnv(config) {
    sh 'make upload.function'
    sh 'make stack.deploy'
  }
}

def update_function(def config) {
  withEnv(config) {
    sh 'make upload.function'
    sh 'make update.function'
  }
}

def create_sns_mail(def config) {
  withEnv(config) {
    sh 'make sns.create'
  }
}

def create_sqs_mail(def config, def priority)  {
  config.add("PRIORITY=${priority}")
  withEnv(config) {
        sh 'make sqs.create'
  }
}

return this