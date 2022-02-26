package com.javatechie.lambda;
/*
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
*/
public class TraverseFile {

/*
    public static final String SKIP = "SKIP";

    public static void main(String [] args) {
        try {

            Executor executor = Executors.newFixedThreadPool(1500, new ThreadFactoryBuilder()
                    .setNameFormat("process-%d")
                    .setDaemon(true)
                    .build());

            RestTemplate restTemplate = new RestTemplate();
            String inputFilename = "";
            String outputFilename = "";
            new Traverser().traverse(inputFilename, outputFilename, restTemplate, executor);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    void traverse(String inputFileName, String outputFileName, RestTemplate restTemplate, Executor executor) throws Exception {
        //We use a try-with-resources block to enable safe, after-use de-allocation of all file resources.
        try (//Our input resource to read newline-separated records
             BufferedReader inputBR = Files.newBufferedReader(Paths.get(inputFileName), StandardCharsets.UTF_8);

             //Our output resource to store translated, newline-separated records
             BufferedWriter outputBW = Files.newBufferedWriter(Paths.get(outputFileName), StandardCharsets.UTF_8,
                     StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

             BufferedWriter noSubscriptionsBW = Files.newBufferedWriter(Paths.get(outputFileName+"no-subscription-json"), StandardCharsets.UTF_8,
                     StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);


             //Our output resource to store error/untranslatable, newline-separated input records and error details
             BufferedWriter errorBW = Files.newBufferedWriter(Paths.get(outputFileName + "-errors.newline-json"), StandardCharsets.UTF_8,
                     StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {

            //For our statistics counters, we use atomicLong to bypass immutability restrictions within lambdas
            AtomicLong traversedCount = new AtomicLong(), successCount = new AtomicLong(), skipCount = new AtomicLong() , failedCount = new AtomicLong();
            System.out.println("Beginning translation work...");
            inputBR.lines().forEach(inputLine -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                traversedCount.incrementAndGet();
                try {
                    String status = processInputLine(inputLine, outputBW, noSubscriptionsBW, restTemplate, executor);
                    if(SKIP.equals(status)){
                        skipCount.incrementAndGet();
                    }else{
                        successCount.incrementAndGet();
                    }
                }
                catch (Exception processingException) {
                    handleProcessingException(inputLine, processingException, errorBW);
                    failedCount.incrementAndGet();
                }
            });
            System.out.println("Translation work concluded successfully.");
            //We are done. Log some metrics.
            System.out.println("traversedCount={}:"+traversedCount+" successCount={}:"+successCount+"  skipCount={}:"+skipCount+" failedCount={}:"+failedCount);
        }
    }


    private String processInputLine(String inputLine, BufferedWriter outputBW, BufferedWriter noSubscriptionsBW,
                                    RestTemplate restTemplate, Executor executor) throws Exception {
        String status = "SUCCESS";
        String outputLine = null;
        if(inputLine == null || inputLine.length() < 1){
            noSubscriptionsBW.write(String.format("%s\n", inputLine));
            status = "SKIP";
        }else {
            try {
                //DO BUSSINESSS LOGIC HERE
                CompletableFuture.runAsync(() -> {
                    publishToSOAPService(restTemplate, inputLine);
                }, executor);

                outputLine = inputLine;
            }catch(Exception e){
                e.printStackTrace();
                throw new RuntimeException("Error with Publishing Event");
            }
            outputBW.write(String.format("%s\n", outputLine));
        }

        return status;
    }


    private void handleProcessingException(String inputLine, Exception processingException, BufferedWriter errorBW) {
        try {
            errorBW.write(String.format("%s\n\t%s - %s\n",
                    inputLine, processingException.getClass().getSimpleName(), processingException.getMessage()));
        }
        catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }


    public void publishToSOAPService(RestTemplate restTemplate, String  inputLine)
    {


    }

    
 */
}

