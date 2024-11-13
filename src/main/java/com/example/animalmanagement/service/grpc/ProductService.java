package com.example.animalmanagement.service.grpc;

import com.example.ProductGrpc;
import com.example.ProductOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Component;

@Component
public class ProductService
{

  private ProductGrpc.ProductBlockingStub getProductApiStub()
  {
    ManagedChannel managedChannel = ManagedChannelBuilder.forAddress(
            "localhost", 9092) //Station3 is port 9092
        .usePlaintext().build();

    return ProductGrpc.newBlockingStub(managedChannel);
  }

  public ProductOuterClass.PigsResponse getAllPigsFromProductId(Long id){
    ProductGrpc.ProductBlockingStub productStub = this.getProductApiStub();

    ProductOuterClass.GetAllPigIdsFromProductRequest request = ProductOuterClass.GetAllPigIdsFromProductRequest.newBuilder().setProductId(id)
        .build();

    ProductOuterClass.PigsResponse response = productStub.getAllPigIdsFromProduct(request);
    return response;
  }

  public ProductOuterClass.ProductListResponse getProductsByPigId(long id){
    ProductGrpc.ProductBlockingStub productStub = this.getProductApiStub();

    ProductOuterClass.GetAllProductsFromPigIdRequest request = ProductOuterClass.GetAllProductsFromPigIdRequest.newBuilder().setPigId(id)
        .build();

    ProductOuterClass.ProductListResponse response = productStub.getAllProductsFromPigId(request);
    return response;

  }

}
