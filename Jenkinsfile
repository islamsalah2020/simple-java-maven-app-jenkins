pipeline {
    agent {
    docker {
      image 'maven:3.5.4-jdk-8'
      args '-v /root/.m2:/root/.m2'
    }
    }
    environment {
        registry = "islamsalah2020/simple-java-maven-app-jenkins"
        DATE = new Date().format('yy.M')
        TAG = "${DATE}.${BUILD_NUMBER}"
        IMAGE = "sample-image"
        
        nexus_creds = 'jenkins-nexus-creds'
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
       // stage('Test') {
        //    steps {
         //       sh 'mvn test'
          //  }    
        // }
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
        stage('Docker Build image') {
            agent {
                docker {  image 'docker:latest' 
                           reuseNode true
                           args '-v /var/run/docker.sock:/var/run/docker.sock' 
                           args '-v /home/cloud_user/.docker/:/.docker/'}
            }
           
            steps {
               
               
               
                sh 'docker build -t 172.31.17.39:9001/$IMAGE:latest -t 172.31.17.39:9001/$IMAGE:$TAG .'
              
                withCredentials([usernamePassword(credentialsId: 'nexus-cred', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
               
                sh 'echo $PASSWORD | docker login 172.31.17.39:9001 -u $USERNAME --password-stdin ' }
                
                sh 'docker push 172.31.17.39:9001/$IMAGE:$TAG '
                
                sh 'docker logout'
            }
        }
        
    }
       
            post{
		always {
			
            emailext body: '''${SCRIPT, template="groovy-html.template"}''',
			subject: 'Test Subject',
			to: 'islam.salah@qeema.net'

					

        }

	}

        
        
        
          
                    
                
            
        }
  
