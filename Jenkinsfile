pipeline {
    agent any

    tools {
        maven 'Maven-3'   // MUST match Jenkins config
        jdk 'Java'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/dharmishthakothari/AutomationTestProject.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
