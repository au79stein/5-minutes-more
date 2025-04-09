import jenkins.model.*
import hudson.security.*
import javaposse.jobdsl.plugin.*

def instance = Jenkins.getInstance()

// Seed job setup
def seedJobName = "seed-job"
def seedJob = instance.getItem(seedJobName)

if (seedJob == null) {
    def job = instance.createProject(org.jenkinsci.plugins.workflow.job.WorkflowJob, seedJobName)
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
}