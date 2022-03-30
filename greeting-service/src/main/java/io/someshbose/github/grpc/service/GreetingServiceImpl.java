package io.someshbose.github.grpc.service;

import io.grpc.stub.StreamObserver;
import io.someshbose.github.grpc.GreetingRequest;
import io.someshbose.github.grpc.GreetingResponse;
import io.someshbose.github.grpc.GreetingServiceGrpc;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
    @Override
    public void greeting(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
        String message = request.getMessage();
        System.out.println("Received Message: " + message);


        GreetingResponse greetingResponse = GreetingResponse.newBuilder()
                .setMessage("Received your " + message + ". Hello From Server. ")
                .build();

        responseObserver.onNext(greetingResponse);
        responseObserver.onCompleted();
    }
}
