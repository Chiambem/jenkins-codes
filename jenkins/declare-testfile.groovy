pipeline {
  agent any

  stages {
    stage('Build') {
      steps {
        // Perform build steps
        sh 'mvn clean install'
      }
    }

    stage('Test') {
      steps {
        // Perform test steps
        sh 'mvn test'
      }
    }

    stage('Deploy') {
      steps {
        // Perform deployment steps
        sh 'mvn deploy'
      }
    }
  }
}
