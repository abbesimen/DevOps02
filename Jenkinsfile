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
                sh 'mvn sonar:sonar -Dsonar.login=07e4177ab9a79dcd0f36c7bcd0df09f5b045c936 -Dsonar.ws.timeout=900000'
            }
        }
    }
}
