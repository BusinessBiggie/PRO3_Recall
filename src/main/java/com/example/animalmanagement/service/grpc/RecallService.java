package com.example.animalmanagement.service.grpc;

import com.example.ProductOuterClass;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.recall.RecallServiceGrpc;
import com.example.recall.*;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class RecallService extends RecallServiceGrpc.RecallServiceImplBase {

  @Autowired
  private ProductService productServiceClient;

  @Override
  public void getAnimalInProduct(RecallRequest request, StreamObserver<RecallResponse> responseObserver) {
    // Call station 3's service to get the product
    ProductOuterClass.PigsResponse pigs = productServiceClient.getAllPigsFromProductId(Long.parseLong(request.getProductId()));
    if (pigs == null) {
      responseObserver.onError(new RuntimeException("Product not found"));
      return;
    }

    // Collect all pig IDs associated with this product
    RecallResponse.Builder responseBuilder = RecallResponse.newBuilder();
    pigs.getPigsList().forEach(pig -> responseBuilder.addPigIds(Long.toString(pig.getId())));
    //product.getPigParts().forEach(pigPart -> responseBuilder.addPigIds(String.valueOf(pigPart.getPig().getAnimalId())));

    // Send response
    responseObserver.onNext(responseBuilder.build());
    responseObserver.onCompleted();
  }

  @Override
  public void getProductsForAnimal(PigRequest request, StreamObserver<ProductResponse> responseObserver) {

    ProductOuterClass.ProductListResponse productIds = productServiceClient.getProductsByPigId(Long.parseLong(request.getPigId()));
    if (productIds == null) {
      responseObserver.onError(new RuntimeException("Id not found"));
      return;
    }


    ProductResponse.Builder responseBuilder = ProductResponse.newBuilder();
    productIds.getProductIdList().forEach(id -> responseBuilder.addProductIds(Long.toString(id)));
    //product.getPigParts().forEach(pigPart -> responseBuilder.addPigIds(String.valueOf(pigPart.getPig().getAnimalId())));

    // Send response
    responseObserver.onNext(responseBuilder.build());
    responseObserver.onCompleted();
  }

  /*private final ProductServiceClient productServiceClient;  // To communicate with station 3
  private final PigServiceClient pigServiceClient;          // To communicate with station 1

  public RecallServiceImpl(ProductServiceClient productServiceClient, PigServiceClient pigServiceClient) {
    this.productServiceClient = productServiceClient;
    this.pigServiceClient = pigServiceClient;
  }

  @Override
  public void getAnimalInProduct(RecallRequest request, StreamObserver<RecallResponse> responseObserver) {
    // Call station 3's service to get the product
    Product product = productServiceClient.getProductById(Long.parseLong(request.getProductId()));
    if (product == null) {
      responseObserver.onError(new RuntimeException("Product not found"));
      return;
    }

    // Collect all pig IDs associated with this product
    RecallResponse.Builder responseBuilder = RecallResponse.newBuilder();
    product.getPigParts().forEach(pigPart -> responseBuilder.addPigIds(String.valueOf(pigPart.getPig().getAnimalId())));

    // Send response
    responseObserver.onNext(responseBuilder.build());
    responseObserver.onCompleted();
  }

  @Override
  public void getProductsForAnimal(PigRequest request, StreamObserver<ProductResponse> responseObserver) {
    // Call station 1's service to get the pig by ID
    Pig pig = pigServiceClient.getPigById(Long.parseLong(request.getPigId()));
    if (pig == null) {
      responseObserver.onError(new RuntimeException("Pig not found"));
      return;
    }

    // Call station 3's service to get all products that the pig is involved in
    ProductResponse.Builder responseBuilder = ProductResponse.newBuilder();
    productServiceClient.getProductsForPig(pig.getAnimalId()).forEach(product -> {
      responseBuilder.addProductIds(String.valueOf(product.getId()));
    });

    // Send response
    responseObserver.onNext(responseBuilder.build());
    responseObserver.onCompleted();
  }*/
}
