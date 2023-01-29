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
        TAG = "23.1.124"
        IMAGE = "sample-image"
    }
    

    stages {
    stage('Docker deploy image') {
        agent {
            docker {  image 'docker:latest' 
                       reuseNode true
                       args '-v /var/run/docker.sock:/var/run/docker.sock' 
                       args '-v /home/cloud_user/.docker/:/.docker/'}
        }
       
        steps {
            
            // sh 'CONTAINER_ID=`docker ps -a | grep $IMAGE | cut -c 1-12` '
            // sh 'echo $CONTAINER_ID'
            // sh 'docker stop $'
            // sh 'docker rm $CONTAINER_ID'
            withCredentials([usernamePassword(credentialsId: 'nexus-cred', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
           
            sh 'echo $PASSWORD | docker login 172.31.17.39:9001 -u $USERNAME --password-stdin ' }
           
            sh 'docker pull 172.31.17.39:9001/$IMAGE:$TAG '
            sh 'docker run 172.31.17.39:9001/$IMAGE:$TAG ' 
        }
    }
        
       
    }
}
       
        
 
