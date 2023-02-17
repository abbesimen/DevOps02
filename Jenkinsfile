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
         stage('maven version') {
            steps {
                sh 'mvn -version'
            }
        }
         stage('Maven Clean') {
            steps {
                sh 'mvn clean'
            }
        }
         stage('Maven Compile') {
            steps {
                sh 'mvn clean package'
            }
        }
         stage('Construction du livrable') {
            steps {
                sh 'mvn compiler:compile '
            }
        }
          stage('Run Tests') {
            steps {
                sh 'mvn test -DskipTests=false'
            }
        }
        stage('Maven SONARQUBE') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=8008da11b8e30f30c81af31aa112b4160bf2f294 -Dsonar.ws.timeout=9000000'
            }
        }
    }
}
