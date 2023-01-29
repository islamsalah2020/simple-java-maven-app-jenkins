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
    }
    stages {
        
        stage("Maven Build") {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'nexus-cred', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    sh " echo $PASSWORD | docker login 3.144.31.33:8081 -u $USERNAME --password-stdin "
                    
                    // sh "docker build -t ${REGISTRY}/${REPOSITORY}/${IMAGE}:${TAG} ."
                    // sh "docker push git.qeema.io:5050/qeema-platform/${IMAGE}:${TAG}"
                    
                    sh 'docker pull 3.144.31.33:9001/sample-image:latest '
                    sh 'docker run 3.144.31.33:9001/sample-image:latest '    
                    }
                }
            }
        }
       
        
    }
}
