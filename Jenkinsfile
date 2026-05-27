pipeline {
    agent any

    environment {
        DOCKERHUB_USER = 'shauryapandey1101jan'
        IMAGE_NAME     = 'hello-world-java'
        IMAGE_TAG      = 'latest'
    }

    stages {

        stage('Checkout') {
            steps {
                echo '📥 Pulling code from GitHub...'
                checkout scm
            }
        }

        stage('Test') {
            steps {
                echo '🧪 Running JUnit tests...'
                sh 'mvn test -Dsurefire.useFile=false'
            }
        }

        stage('Build JAR') {
            steps {
                echo '📦 Building JAR...'
                sh 'mvn package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                echo '🐳 Building Docker image...'
                sh "docker build -t ${DOCKERHUB_USER}/${IMAGE_NAME}:${IMAGE_TAG} ."
            }
        }

        stage('Docker Push') {
            steps {
                echo '🚀 Pushing to Docker Hub...'
                withCredentials([usernamePassword(
                    credentialsId: 'dockerlogin',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh "echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin"
                    sh "docker push ${DOCKERHUB_USER}/${IMAGE_NAME}:${IMAGE_TAG}"
                }
            }
        }

    }

    post {
        success {
            echo '✅ Pipeline succeeded! Image is live on Docker Hub.'
        }
        failure {
            echo '❌ Pipeline failed. Check the logs above.'
        }
    }
}