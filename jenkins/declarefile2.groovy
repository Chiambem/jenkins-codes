pipeline{
    agent{
        node{
            label'Node1'
        }    
    }
    stages{
        stage('ContinuousDownload'){
            steps{
                script
                {
                   try
                   {
                      git 'https://github.com/selenium-saikrishna/maven.git'
                   }
                   catch(Exception e)
                   {
                       mail bcc: '', body: 'Jenkins is unable to download from git hub', cc: '', from: '', replyTo: '', subject: 'Jenkins facing isse with Git', to: 'gitadmin@outlook.com'
                      exit(1)
                   }
                }
            }
        }
        
        stage('ContinuousBuild')
        {
            steps
            {
                script
                {
                   try
                   {
                      sh label: '', script: 'mvn package'
                   }
                   catch(Exception e)
                   {
                      mail bcc: '', body: 'Jenkins is unable to create an artifact', cc: '', from: '', replyTo: '', subject: 'Build issue', to: 'developers@outlook.com'
                   }
                }
            }
        }
        
    }
 }
