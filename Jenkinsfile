pipeline {
    agent any
    triggers {
        pollSCM('H/5 * * * *')
    }
    stages {
        stage('Récupération du code source') {
            steps {
                git 'https://github.com/hatembensalh/abbesimen.git'
            }
        }
        stage('Affichage de la date système') {
            steps {
                sh 'date'
            }
        }
    }
}
