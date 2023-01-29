pipeline {
    agent {
        docker {
      image 'maven:3.5.4-jdk-8'
      args '-v /root/.m2:/root/.m2'
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
                    withCredentials([usernamePassword(credentialsId: 'gitlab-cred', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    sh " echo $PASSWORD | docker login https://git.qeema.io:5050 -u $USERNAME --password-stdin "
                    sh "docker build -t ${REGISTRY}/${REPOSITORY}/${IMAGE}:${TAG} ."
                    sh "docker push git.qeema.io:5050/qeema-platform/${IMAGE}:${TAG}"
                    }
                }
            }
        }
       
        
    }
}
