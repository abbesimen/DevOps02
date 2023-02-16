pipeline {
        
        agent any
        stages {
            stage('CHECKOUT GIT') {
                
                steps{
                    echo 'Pulling...';
                    git branch: 'main',
                    url: 'https://github.com/abbesimen/DevOps02.git',
                    credentialsId: 'bb840cc3-050a-46bf-9192-5b10b5e2fc36';
                }
            }
            stage('BUILD') {
                steps{
                    sh 'mvn -version'
                    sh 'mvn clean install'
                }
            }
        }
    }