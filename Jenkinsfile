pipeline {
    agent {
        docker {
      image 'docker'
      args '-v /var/run/docker.sock:/var/run/docker.sock'
    }
    }
   
    environment {
        NEXUS_VERSION = "nexus3"
        NEXUS_PROTOCOL = "http"
        NEXUS_URL = "18.118.200.234:8081"
        NEXUS_REPOSITORY = "maven-nexus-repo"
        NEXUS_CREDENTIAL_ID = "nexus-user-credentials"
        TAG = "23.1.124"
        IMAGE = "sample-image"
    }
    stages {
        
        stage("Maven Build") {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'nexus-cred', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    sh " echo $PASSWORD | docker login 172.31.17.39:9001 -u $USERNAME --password-stdin "
                    sh "echo hello"
                    // sh "docker build -t ${REGISTRY}/${REPOSITORY}/${IMAGE}:${TAG} ."
                    // sh "docker push git.qeema.io:5050/qeema-platform/${IMAGE}:${TAG}"
                    
                    withCredentials([usernamePassword(credentialsId: 'nexus-cred', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) 
                    sh 'echo $PASSWORD | docker login 172.31.17.39:9001 -u $USERNAME --password-stdin ' }
                    sh 'docker pull 172.31.17.39:9001/$IMAGE:$TAG '
                    sh 'docker run 172.31.17.39:9001/$IMAGE:$TAG '
                        
                        sh "docker logout"
                    }
                }
            }
        }
       
        
    }
}
