pipeline {
    agent { docker { image 'maven:3.6-jdk-8' } }
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}