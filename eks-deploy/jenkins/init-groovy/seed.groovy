import jenkins.model.*
import javaposse.jobdsl.plugin.*

def job = Jenkins.instance.createProject(org.jenkinsci.plugins.workflow.job.WorkflowJob, "seed-job")
job.setDefinition(new org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition("""
pipeline {
  agent any
  stages {
    stage('Generate Jobs') {
      steps {
        jobDsl targets: 'jobs/**/*.groovy', removedJobAction: 'DELETE'
      }
    }
  }
}
""", true))
job.save()