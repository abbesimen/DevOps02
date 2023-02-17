pipeline {
    agent any
     triggers {
        pollSCM('0 4 * * *')
    }
    stages {
       stage('checkout GIT') {
            steps {
                echo 'Pulling ...'
                git branch: 'hatem', url: 'https://github.com/abbesimen/DevOps02.git'
            }
        }
        
         stage('Maven Clean') {
            steps {
                sh 'mvn clean'
            }
        }
         stage('Maven Install') {
            steps {
                sh 'mvn install'
            }
        }
     
         stage('Compile') {
            steps {
                sh 'mvn compiler:compile '
            }
        }
         stage('Construction du livrable') {
            steps {
                sh 'mvn package '
            }
        }
         stage('Run Tests') {
            steps {
                sh 'mvn test -DskipTests=false'
            }
        }
        stage('Maven SONARQUBE') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=cbdd1558e9de68ea4c69908461e3447cfc0819af -Dsonar.ws.timeout=900000'
            }
        }
    }
}
