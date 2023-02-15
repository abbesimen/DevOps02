pipeline {
    agent any
     triggers {
        pollSCM('H/5 * * * *')
    }
    stages {
        stage('checkout GIT') {
            steps {
                echo 'Pulling ...'
                git branch: 'main', url: 'https://github.com/abbesimen/DevOps02.git'
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
                sh 'mvn sonar:sonar -Dsonar.login=e791fee191218e32ca7221fa4d8058de8a8cf336'
            }
        }
    }
}
