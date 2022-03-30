package main;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.someshbose.github.grpc.GreetingRequest;
import io.someshbose.github.grpc.GreetingResponse;
import io.someshbose.github.grpc.GreetingServiceGrpc;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(MainApplication.class,args);
  }

  @Override public void run(String... args) throws Exception {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",9090).usePlaintext().build();

    GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);

    GreetingRequest request = GreetingRequest.newBuilder().setMessage("Somesh calling").build();

    GreetingResponse response = stub.greeting(request);

    System.out.println(response.getMessage());
  }
}
