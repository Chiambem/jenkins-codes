pipeline{
    agent{
        node{
            label'Node2'
        }
    }   
    stages{
        stage('codedownload'){
            steps{
                git 'https://github.com/mankinimbom/maven.git'
            }
        }
        stage('codebuid'){
            steps{
                sh 'mvn package'
            }
        }
        stage('codedeploy'){
            steps{
                deploy adapters: [tomcat9(credentialsId: '60217e80-59eb-4701-9870-bd412a8c2d58', path: '', url: 'http://18.206.114.203:8080/')], contextPath: 'padagis', war: '**/*.war'
            }
        }
        stage('codetest'){
            steps{
                git 'https://github.com/mankinimbom/testingproject.git'
                sh 'java -jar /home/ubuntu/workspace/workspace/Testproject2/testing.jar'
            }
        }
        stage('codedeployprod') {
            steps{ 
                deploy adapters: [tomcat9(credentialsId: 'eee3ef84-cb92-4248-bbfc-e05883053857', path: '', url: 'http://3.94.115.115:8080')], contextPath: 'Prod', war: '**/*.war'
            }
        }
    }        
}
