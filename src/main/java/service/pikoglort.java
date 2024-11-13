package service;

import com.example.ProductGrpc;
import com.example.ProductOuterClass;
import com.example.animalmanagement.entities.Product;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Component;

@Component
public class pikoglort
{

  private ProductGrpc.ProductBlockingStub getProductApiStub()
  {
    ManagedChannel managedChannel = ManagedChannelBuilder.forAddress(
            "localhost", 9092) //Station3 is port 9092
        .usePlaintext().build();

    return ProductGrpc.newBlockingStub(managedChannel);
  }

  public ProductOuterClass.PigsResponse getProductById(Long id){
    ProductGrpc.ProductBlockingStub productStub = this.getProductApiStub();

    ProductOuterClass.GetAllPigIdsFromProductRequest request = ProductOuterClass.GetAllPigIdsFromProductRequest.newBuilder().setProductId(id)
        .build();

    ProductOuterClass.PigsResponse response = productStub.getAllPigIdsFromProduct(request);
    return response;
  }

}
