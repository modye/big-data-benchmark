package com.modye.bigdatabenchmark.batch.listener;

import org.apache.log4j.Logger;
import org.springframework.batch.core.*;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

/**
 * Created by modye on 29/10/2015.
 */
public class StepCompletionNotificationListener implements StepExecutionListener {

    private static Logger log;

    public StepCompletionNotificationListener(String profile) {
        log = Logger.getLogger(profile);
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.info("Start of "+stepExecution.getStepName());
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {

        log.info(stepExecution.getExitStatus().getExitCode());
        log.info(stepExecution.getReadCount() + " read items");
        log.warn(stepExecution.getReadSkipCount() + " skipped on read items");
        log.warn(stepExecution.getWriteSkipCount() + " skipped on write items");
        log.info(stepExecution.getWriteCount() + " written items");
        log.warn(stepExecution.getProcessSkipCount() + " skipped on process items");
        log.info(stepExecution.getCommitCount() + " commit(s) done");
        log.info("End of "+stepExecution.getStepName());

        return stepExecution.getExitStatus();
    }
}