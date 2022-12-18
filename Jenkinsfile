pipeline {
    agent {
    docker {
      image 'maven:3.5.4-jdk-8'
      args '-v /root/.m2:/root/.m2'
    }
    }
    environment {
        DATE = new Date().format('yy.M')
        TAG = "${DATE}.${BUILD_NUMBER}"
        token = ""
    }
    
    stages {
    stage('hello test') {
      steps {  
        sh "echo hello"   
      }
    }
    stage('Build') {
            steps {
                sh 'mvn clean'
            }
        }
        stage('Compile') {
            steps {
                sh 'mvn compile'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }    
        }
        stage('package') {
            steps {
                sh 'mvn package'
            }    
        }
        stage('list') {
            steps {
                sh 'ls target/'
            }    
        }
        stage('Docker Build') {
            steps {
                script {
                    docker.build("islamsalah2020/simple-java-maven-app:${TAG}")
                }
            }
        }
        stage('Pushing Docker Image to Dockerhub') {
            steps {
                script {
                    sh " echo $token | docker login ghcr.io -u islamsalah2020 --password-stdin  "
                     sh "echo login success"
                    sh "docker push ghcr.io/islamsalah2020/simple-java-maven-app:latest"
                    
                }
            }
        }
    }
}
