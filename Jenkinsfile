pipeline {
    agent any
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn compile'
            }
        }
         stage('Test') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t sithes/spring-boot-cicd:$BUILD_NUMBER .'
            }
        }
        stage('Docker Container'){
            steps{
              withCredentials([usernameColonPassword(credentialsId: 'docker_dileep_creds', variable: 'DOCKER_PASS')]) {
              sh 'docker push dileep95/dileep-spring:$BUILD_NUMBER'
        	  sh 'docker run -d -p 8050:8050 --name SpringbootApp dileep95/dileep-spring:$BUILD_NUMBER'
              }
            }
        }
    }
    post {
        always {
    	mail bcc: '', body: "<br>Project: ${env.JOB_NAME} <br>Build Number: ${env.BUILD_NUMBER} <br>URL: ${env.BUILD_URL}", cc: '', charset: 'UTF-8', from: 'sithes.nmc@gmail.com', mimeType: 'text/html', replyTo: '', subject: "Success: Project name -> ${env.JOB_NAME}", to: "sithes.nmc@gmail.com";
        }
        failure {
    	sh 'echo "This will run only if build failed"'
          mail bcc: '', body: "<br>Project: ${env.JOB_NAME} <br>Build Number: ${env.BUILD_NUMBER} <br>URL: ${env.BUILD_URL}", cc: '', charset: 'UTF-8', from: 'sithes.nmc@gmail.com', mimeType: 'text/html', replyTo: '', subject: "ERROR: Project name -> ${env.JOB_NAME}", to: "sithes.nmc@gmail.com";
        }
    }
}