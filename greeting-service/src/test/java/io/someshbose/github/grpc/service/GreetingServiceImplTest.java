package io.someshbose.github.grpc.service;

import io.grpc.stub.StreamObserver;
import io.grpc.stub.StreamObservers;
import io.someshbose.github.grpc.GreetingRequest;
import io.someshbose.github.grpc.GreetingResponse;
import io.someshbose.github.grpc.GreetingServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GreetingServiceImplTest {

  @GrpcClient("Test")
  private GreetingServiceGrpc.GreetingServiceBlockingStub greetingService;

  @Test
  @Disabled
  void testGreeting(){
    GreetingRequest request = GreetingRequest.newBuilder().setMessage("Test").build();

    GreetingResponse response = greetingService.greeting(request);

    Assertions.assertNotNull(response);
  }

}
