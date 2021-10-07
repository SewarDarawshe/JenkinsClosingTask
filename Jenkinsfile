pipeline {
    agent {label 'slave'}


    stages {
        stage('Cloning Git') {
            steps {
                git 'https://github.com/SewarDrawhe/JenkinsClosingTask.git'
            }
        }
        
        stage('Build') {
            steps {
                dir('src/main/') {
                    sh "chmod +x gradlew"
                    sh './gradlew build'
                }
                
            }
        }
        
        
}
}
