properties([
    parameters([
        string(defaultValue: '', description: 'Provide node IP', name: 'node', trim: true)
        ])
    ])

node {
    stage("Pull Repo"){
        sh "rm -rf ansible-melodi && git clone https://github.com/ikambarov/ansible-melodi.git"
    }

    stage("Install Melodi"){
        ansiblePlaybook become: true, colorized: true, credentialsId: 'jenkinsmaster', disableHostKeyChecking: true, inventory: '178.128.149.190', limit: 'all', playbook: 'ansible-melodi/main.yml'   
        
    }    
}

