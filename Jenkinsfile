pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: 'imen']], userRemoteConfigs: [[url: 'https://github.com/abbesimen/DevOps02.git']]])
            }
        }
        stage('Clean checkout et Contenu repetoire ') {
            steps {
              checkout([$class: 'GitSCM', 
                branches: [[name: '*/imen']],
                doGenerateSubmoduleConfigurations: false,
                extensions: [[$class: 'CleanCheckout']],
                submoduleCfg: [], 
                userRemoteConfigs: [[url: 'https://github.com/abbesimen/DevOps02.git']]])
              sh "ls -ltr"
          }
        }
           stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Unit Tests') {
            steps {
                sh 'mvn test'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn sonar:sonar'
                }
            }
        }
        stage('Nexus Deployment') {
            steps {
                sh 'mvn deploy'
            }
        }
        stage('Spring Build') {
            steps {
                sh 'docker build -t my-app .'
            }
        }
        stage('Spring Package') {
            steps {
                sh 'docker build -f Dockerfile -t my-app .'
            }
        }
        stage('DockerHub Push') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker-hub', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    sh 'docker login -u $USERNAME -p $PASSWORD'
                    sh 'docker push my-app'
                }
            }
        }
        stage('Docker Compose') {
            steps {
                sh 'docker-compose up -d'
            }
        }
        stage('Angular Testing') {
            steps {
                sh 'ng test'
            }
        }
    }
}
