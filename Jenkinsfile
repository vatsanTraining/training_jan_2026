pipeline {
    agent any
    
    environment {
        DOCKER_PATH = '/usr/local/bin/docker'
        APP_NAME = 'my-boot-app'
    }

    stages {

        stage('Maven Build') {
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
                        sh "export PATH=\$PATH:/usr/local/bin && ${DOCKER_PATH} build -t ${APP_NAME}:${BUILD_NUMBER} ."
                        sh "export PATH=\$PATH:/usr/local/bin && ${DOCKER_PATH} tag ${APP_NAME}:${BUILD_NUMBER} ${APP_NAME}:latest"
                    }
                }
            }
        }

        stage('Deploy Local') {
            steps {
                script {
                    sh "export PATH=\$PATH:/usr/local/bin && ${DOCKER_PATH} rm -f my-running-app || true"
                    sh "export PATH=\$PATH:/usr/local/bin && ${DOCKER_PATH} run -d -p 8080:8080 --name my-running-app ${APP_NAME}:latest"
                }
            }
        }
    }
}
