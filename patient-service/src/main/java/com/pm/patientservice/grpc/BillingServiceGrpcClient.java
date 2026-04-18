package com.pm.patientservice.grpc;

import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BillingServiceGrpcClient {
    private static final Logger log = LoggerFactory.getLogger(BillingServiceGrpcClient.class);
    private final BillingServiceGrpc.BillingServiceBlockingStub blockingStub;

    public BillingServiceGrpcClient(
            @Value("${billing.service.address:localhost}") String ServerAddress,
            @Value("${billing.service.grpc.port:9001}") int servicePort
    ) {
      log.info("Connecting to Billing Service Grpc service at {}:{}",ServerAddress,servicePort);

      ManagedChannel channel = ManagedChannelBuilder.forAddress(ServerAddress,servicePort).usePlaintext().build();
      blockingStub = BillingServiceGrpc.newBlockingStub(channel);


    }
    public BillingResponse createBillingAccount(String patientId, String name, String email)
    {
        BillingRequest request = BillingRequest.newBuilder()
                .setPatientId(patientId).setName(name).setEmail(email).build();
        BillingResponse response = blockingStub.createBillingAccount(request);
        log.info("Create billing account request response:{}",response);
        return response;

    }

}
