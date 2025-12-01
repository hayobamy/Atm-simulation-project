pipeline {
    agent any
    tools {
        maven 'Maven3.9.6'
    }

    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', url: 'https://github.com/hayobamy/Atm-simulation-project.git'
            }
        }

        stage('Test & Build') {
            steps {
                dir('atm-simulation-project') {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Upload to Nexus') {
            steps {
                dir('atm-simulation-project') {
                    sh 'mvn deploy'
                }
            }
        }

       stage('Deploy to Tomcat') {
    steps {
        deploy adapters: [tomcat9(credentialsId: 'tomcat-jenkins', path: '', url: 'http://your-tomcat-server:8080/manager/text')],
               contextPath: '/',
               war: 'atm-simulation-project/target/atm-simulation-1.0.0.war'
    }
}

    }
}
