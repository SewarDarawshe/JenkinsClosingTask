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
                dir('./') {
                    sh "chmod +x gradlew"
                    sh './gradlew build'
                }
                
            }
        }
         stage('run the app') {
            steps {
                sh 'jps | grep demo-0.0.1 | awk \'{print "kill -9 "$1}\' | bash -x'
                
            }
            
             post {
                //in case of success : send a success message to my channel in slack
                success {
                        slackSend channel: '#hw', color: '#217a36', message: 'The process was built successfully...'}

                //in case of failure : send a failure message to my channel in slack
                failure {
                        slackSend channel: '#hw', color: '#ed3424', message: 'Failure in the build process...'}
            }
            
        
        
}
}
}
