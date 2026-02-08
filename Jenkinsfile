pipeline {
    agent any
    
<<<<<<< HEAD
    environment {
        DOCKER_PATH = '/usr/local/bin/docker'
        APP_NAME = 'my-boot-app'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com'
            }
        }

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
=======
    // Triggers block added here
    triggers {
        // Option A: Build every hour regardless of changes
        // cron('H * * * *') 
        
        // Option B: Check GitHub every 5 mins; build ONLY if code changed
        pollSCM('H/5 * * * *')
    }
    
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
                        sh "export PATH=\$PATH:/usr/local/bin && ${DOCKER_PATH} build -t ${APP_NAME}:${BUILD_NUMBER} -t ${APP_NAME}:latest ."
                    }
                }
            }
        }

        stage('Deploy Local') {
            steps {
                script {
                    echo "App is Built and Tagged as ${APP_NAME}:latest"
>>>>>>> branch 'master' of https://github.com/vatsanTraining/training_jan_2026.git
                }
            }
        }
    }
}
