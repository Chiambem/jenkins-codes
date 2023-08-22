terraform {
  required_providers {
    jenkins = {
      source = "kingsoftgames/jenkins"
      version = "0.0.4"
    }
  }
}

provider "jenkins" {
    node = "agent"
}