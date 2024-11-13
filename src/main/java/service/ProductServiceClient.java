package service;

import com.example.ProductGrpc;
import com.example.ProductOuterClass;
import io.grpc.stub.StreamObserver;

public class ProductServiceClient extends ProductGrpc.ProductImplBase
{
  @Override
  public void GetAllPigIdsFromProduct(
      ProductOuterClass.GetAllPigIdsFromProductRequest request, StreamObserver<ProductOuterClass.PigsResponse> responseObserver)
  {

  }

}
