package service;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.io.IOException;

@Configuration
public class GrpcServerConfig {

  @Bean
  public Server grpcServer(RecallServiceImpl recallService) throws IOException {
    return ServerBuilder
        .forPort(9090)
        .addService(recallService)
        .build()
        .start();
  }
}

