pipeline {
    agent any
    
    environment {
        DOCKER_PATH = '/usr/local/bin/docker'
        APP_NAME = 'my-boot-app'
    }

    stages {

        stage('Maven Build') {
            tools {
        maven 'M3_HOME' 
    }
            steps {
                dir('jenkins-with-boot') {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Docker Build') {
            steps {
                dir('jenkins-with-boot') {
                    script {
    def app = docker.build("${APP_NAME}:${BUILD_NUMBER}")
    app.push()           // Pushes with build number
    app.push("latest")   // Also pushes with 'latest' tag
}

                }
            }
        }

        stage('Deploy Local') {
            steps {
                script {
                    sh "export PATH=\$PATH:/usr/local/bin && ${DOCKER_PATH} rm -f my-running-app || true"
                }
            }
        }
    }
}
